package com.rediff.utill;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.text.Utilities;

import org.apache.log4j.Logger;
import org.apache.xpath.compiler.Keywords;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import junit.framework.Assert;

public class AllActions {
	
	
	private static Driver sd = new Driver();
	private static String sessionId;

	

	public static Logger log = Logger.getLogger(AllActions.class.getName());
	
	private static String getExecutionEnv(){
		try {
			return configProperties.pro.getProperty("env");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
/****************************************************************************************************
 * Method: runKeyword
 * Description: 
 * @author ysxg070
 * @return 
 ***************************************************************************************************/    
	private static boolean keywordResult(ArrayList<String> argList, Class<?> className, String methodName) {
		int argListSize = 0;
		if (argList != null)
			argListSize = argList.size();
		boolean keywordResult = false;
		Class<?>[] paramType;
		Object[] methodArguments;
		int methodParameters = 0;
		Constructor<?> constructor = null;
		Method[] methods = className.getDeclaredMethods();
		for (Method meth : methods) {
			if (meth.getName().equalsIgnoreCase(methodName)) {
				methodParameters = meth.getParameters().length;
				methodArguments = new Object[methodParameters + 1];
				paramType = new Class<?>[methodParameters];
				if (argListSize != methodParameters) {
					Assert.fail("method fail");
					return keywordResult;
				}
				try {
					for (int i = 0; i < meth.getParameterTypes().length; i++) {
						paramType[i] = meth.getParameterTypes()[i];
					}
					//methodArguments[0] = constructor.newInstance(arguments);
					if (methodParameters != 0) {
						for (int i = 1; i <= argListSize; i++) {
							methodArguments[i] = (String) argList.get(i - 1);
						}
					}
					MethodHandles.Lookup lookup = MethodHandles.publicLookup();
					MethodType methodType = MethodType.methodType(boolean.class, paramType);
					MethodHandle handle = lookup.findVirtual(className, meth.getName(), methodType);
					keywordResult = (Boolean) handle.invokeWithArguments(methodArguments);
					
					break;
				} catch (Throwable e) {
					log.error("Error with Keyword: " + meth.getName().toUpperCase() + " " + e.getMessage());
					keywordResult = false;
				}
			}
		}

		if (keywordResult || argListSize == 0) {
			return true;
		} else {
			return false;
		}
	}
	
/****************************************************************************************************
 * @Method: getInitialInformationFromXml
 * @Cases: Initial Routines, Initialize Data, Set Global Variables
 * @author
 * @return boolean
 ***************************************************************************************************/
	private static ArrayList<String> getInitialInformationFromXml(Node singleKeyword) {
		ArrayList<String> argumentList = new ArrayList<String>();
		ArrayList<String> returnList = null;
		NodeList nodeArgs;
		
		AssertionAndTestStep.setValue(HashMapConstants.AssertionAndTestStepConstant.KEYWORD,
				singleKeyword.getAttributes().getNamedItem("label").getNodeValue());
		nodeArgs = singleKeyword.getChildNodes();
		if(nodeArgs.getLength() != 0){
			NodeList arguments = nodeArgs.item(1).getChildNodes();
			for(int i=0; i<arguments.getLength();i++){
				Node node = arguments.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					argumentList.add(node.getAttributes().getNamedItem("value").getNodeValue());
				}
			}
		}
		if (!argumentList.isEmpty())
			returnList = Utilities.getParametersValue(argumentList);
		else
			returnList = null;

		try {
			AssertionAndTestStep.setValue(HashMapConstants.AssertionAndTestStepConstant.PARAMETER_VALUES,
					returnList.toString().replace("[", "").replace("]", ""));
		} catch (Exception e) {
			AssertionAndTestStep.setValue(HashMapConstants.AssertionAndTestStepConstant.PARAMETER_VALUES, "");
		}
		return returnList;
	}
	
/****************************************************************************************************
 * @Method: executeKeywords
 * @Cases: Initial Routines, Initialize Data, Set Global Variables
 * @author
 * @return boolean
 ***************************************************************************************************/
	public boolean executeKeywords(NodeList keyWords) {
		if (getExecutionEnv().contains("Remote"))
			sessionId =  sd.getSessionId();
		String strKeyword = "";
		boolean keywordResult = false;
		ArrayList<String> argList = null;
		Keywords kw;

		try {
			for (int i = 0; i < keyWords.getLength(); i++) {
				Node singleKeyword = keyWords.item(i);
				if (singleKeyword.getNodeType() == Node.ELEMENT_NODE) {
					if ((sessionId == null || sessionId.isEmpty()) && getExecutionEnv().contains("Remote"))
						break;
					argList = getInitialInformationFromXml(singleKeyword);
					strKeyword = singleKeyword.getAttributes().getNamedItem("label").getNodeValue().toUpperCase();
					kw = Keywords.getKeyword(strKeyword);
					if (kw != null) {					
							try {
								keywordResult = keywordResult(argList, kw.getClassName(), kw.name());
							} catch (Throwable e) {
								log.error("Localized Message: " + e.getLocalizedMessage() + " Message: "
										+ e.getMessage());
							}
							break;
						}
					} else
						keywordResult = false;

					
			}
		} catch (Exception e) {
			//return Assert.assertFalse("Error parsing keyword: " + e.getMessage(), keywordResult);
		}
		return keywordResult;
	}
	
}
