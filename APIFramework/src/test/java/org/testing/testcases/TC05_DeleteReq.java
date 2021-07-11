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

public class TC05_DeleteReq {
	
	@Test
	public void fifthTestCase() throws IOException
	{
		ExtentReports extent = ExtentReportGeneration.reportGenerate();
		ExtentTest test = extent.startTest("Fifth Test", "Delete Req");
		
		Properties pr= PropertiesFile.readProperties("../APIFramework/URI.properties");
		HTTPMethods hr=new HTTPMethods(pr);
		Response rs=hr.DeleteRequest("QA_URI", TC01_PostReq.responseIdValue);
		System.out.println("Status code of Delete request is: "+rs.statusCode());
		System.out.println("----------------------------------------------");
		boolean b=ValidateResponse.statusCodeValidate(rs, 200);
		if(b)
			test.log(LogStatus.PASS, "Status code of Delete req is coming as expected");
		else
			test.log(LogStatus.FAIL, "Status code of Delete Req: expected 200 but actual is "+rs.statusCode());
		extent.endTest(test);
		extent.flush();
	}

}
