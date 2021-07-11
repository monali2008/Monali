package org.testing.testcases;

import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.ExtentReportGeneration;
import org.testing.utilities.PropertiesFile;
import org.testing.utilities.ValidateResponse;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class TC03_GetAllReq {
	
	@Test
	public void thirdTestCase() throws IOException
	{
		ExtentReports extent = ExtentReportGeneration.reportGenerate();
		ExtentTest test = extent.startTest("Third Test", "Get All Req");
		
		Properties pr= PropertiesFile.readProperties("../APIFramework/URI.properties");
		HTTPMethods hr=new HTTPMethods(pr);
		Response rs=hr.GetRequest("QA_URI");
		System.out.println("Status code of Get All request ia: "+rs.statusCode());
		System.out.println("Body of Get All req is: "+rs.asString());
		System.out.println("----------------------------------------------");
		boolean b=ValidateResponse.statusCodeValidate(rs, 200);
		if(b)
			test.log(LogStatus.PASS, "Status code of Get All req is coming as expected");
		else
			test.log(LogStatus.FAIL, "Status code of Get All Req: expected 200 but actual is "+rs.statusCode());
		extent.endTest(test);
		extent.flush();
	}

}
