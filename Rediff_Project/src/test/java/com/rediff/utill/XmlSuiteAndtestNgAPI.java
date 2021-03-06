package com.rediff.utill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.testng.ITestContext;
import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class XmlSuiteAndtestNgAPI {
	
	
	public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setSuiteThreadPoolSize(3);
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(createSuite("Sylvester Stallone", "Rambo", 20));
       // suites.add(createSuite("Jim Carrey", "The Mask", 10));
        testNG.setXmlSuites(suites);

        testNG.run();

    }
	
	
	
	
	
	
	
	public static XmlSuite createSuite(String suiteName, String testName,int iteration){
		
		
		XmlSuite suite = new XmlSuite();
		suite.setName(suiteName);
		suite.setParallel(XmlSuite.PARALLEL_NONE);
		Map<String,String> parameters = new HashMap<String,String>();
		parameters.put("iterations",Integer.toString(iteration));
		
		
		XmlTest test = new XmlTest(suite);
		test.setName(testName);
		test.addParameter("iterations",Integer.toString(iteration));
		
		List<XmlClass> clazzes = new ArrayList<XmlClass>();
		XmlClass clazz = new XmlClass(MyTestClass.class);
		clazzes.add(clazz);
		test.setClasses(clazzes);
		
		
		List<XmlTest> tests = new ArrayList<XmlTest>();
		tests.add(test);
		suite.setTests(tests);		
		
		
		return suite;
		
	}
	
	public static class MyTestClass {
        private String className;

        @BeforeClass
        public void setupClassName(ITestContext context) {
            String testName = context.getCurrentXmlTest().getName();
            String suiteName = context.getCurrentXmlTest().getSuite().getName();
            this.className = "[" + suiteName + "," + testName + "]";
        }

        @Test(dataProvider = "dp")
        public void testMethod(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.className);
            sb.append(", Thread ID = ");
            sb.append(Thread.currentThread().getId());
            sb.append(",Value got was ");
            sb.append(i);
            System.out.println(sb.toString());
        }

        @DataProvider(name = "dp")
        public Object[][] generateTestData(ITestContext context) {
            String iterations = context.getCurrentXmlTest().getLocalParameters().get("iterations");
            int count = 5;
            try {
                count = Integer.parseInt(iterations);
            } catch (NumberFormatException e) {
                // do nothing with the exception.
                // exception would be generated, when the parameter iterations is not passed
                // or when it cannot be read as an int. In those situations default to the value of 5
            }
            Object[][] objectToReturn = new Object[count][1];
            for (Object[] iter : objectToReturn) {
                iter[0] = new Random().nextInt();
            }
            return objectToReturn;

        }
    }
	
	
}
