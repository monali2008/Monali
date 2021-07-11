package org.testing.testcases;

import java.io.IOException;
import java.util.Properties;

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

import io.restassured.response.Response;

public class TC06_PostReq_Req {
	
	@Test
	public void sixthTestCase() throws IOException
	{
		ExtentReports extent = ExtentReportGeneration.reportGenerate();
		ExtentTest test = extent.startTest("Sixth Test", "Post Req");
		
		Properties pr= PropertiesFile.readProperties("../APIFramework/URI.properties");
		String bodyData=JSONFile.readJson("../APIFramework/src/test/java/org/testing/resources/BodyDataForPost_Req.json");
		bodyData=JSONVariableReplacement.jsonReplace(bodyData, "name", RandomString.generateRandomString(7));
		bodyData=JSONVariableReplacement.jsonReplace(bodyData, "job", RandomString.generateRandomString(4));
		HTTPMethods hr=new HTTPMethods(pr);
		Response rs=hr.postRequest(bodyData, "REQ_URI");
		System.out.println("Status code of post req request ia: "+rs.statusCode());
		System.out.println("Body of post req req is: "+rs.asString());
		System.out.println("----------------------------------------------");
		boolean b=ValidateResponse.statusCodeValidate(rs, 201);
		if(b)
			test.log(LogStatus.PASS, "Status code of Post req is coming as expected");
		else
			test.log(LogStatus.FAIL, "Status code of Post req: expected 201 but actual is "+rs.statusCode());
		extent.endTest(test);
		extent.flush();
	}

}
