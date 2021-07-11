package org.testing.testcases;

import java.io.IOException;
import java.util.Properties;
import io.restassured.response.Response;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.ExtentReportGeneration;
import org.testing.utilities.JSONFile;
import org.testing.utilities.JSONVariableReplacement;
import org.testing.utilities.PropertiesFile;
import org.testing.utilities.RandomString;
import org.testing.utilities.ValidateResponse;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC04_PutReq {
	
	@Test
	public void fourthTestCase() throws IOException
	{
		ExtentReports extent = ExtentReportGeneration.reportGenerate();
		ExtentTest test = extent.startTest("Fourth Test", "Put Req");
		
		String s=RandomString.generateRandomString(6);
		
		Properties pr=PropertiesFile.readProperties("../APIFramework/URI.properties");
		String bodyData=JSONFile.readJson("../APIFramework/src/test/java/org/testing/resources/BodyDataForPut.json");
		bodyData=JSONVariableReplacement.jsonReplace(bodyData, "id",TC01_PostReq.responseIdValue);
		bodyData=JSONVariableReplacement.jsonReplace(bodyData, "firstname",s);
		HTTPMethods hr=new HTTPMethods(pr);
		Response rs=hr.putRequest(bodyData, "QA_URI",TC01_PostReq.responseIdValue);
		System.out.println("Status code of put request ia: "+rs.statusCode());
		System.out.println("Body of put req is: "+rs.asString());
		System.out.println("----------------------------------------------");
		boolean b=ValidateResponse.statusCodeValidate(rs, 200);
		if(b)
			test.log(LogStatus.PASS, "Status code of Put req is coming as expected");
		else
			test.log(LogStatus.FAIL, "Status code of Put Req: expected 200 but actual is "+rs.statusCode());
		extent.endTest(test);
		extent.flush();
		
	}

}
