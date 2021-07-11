package org.testing.testcases;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.ExtentReportGeneration;
import org.testing.utilities.JsonParsingUsingOrgJson;
import org.testing.utilities.PropertiesFile;
import org.testing.utilities.ValidateResponse;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class TC08_GetAllReq_Req {
	
	@Test
	public void eightTestCase() throws IOException
	{
		ExtentReports extent = ExtentReportGeneration.reportGenerate();
		ExtentTest test = extent.startTest("Eightth Test", "Get All Req");
		
		String extractParameter="id";
		
		Properties pr= PropertiesFile.readProperties("../APIFramework/URI.properties");
		HTTPMethods hr=new HTTPMethods(pr);
		Response rs=hr.GetRequestQueryParameter("REQ_URI", "page=2");
		
		System.out.println("Status code of Get all req request ia: "+rs.statusCode());
		System.out.println("Body of Get all req is: "+rs.asString());
		
		List<Object>ob=JsonParsingUsingOrgJson.parseJSONArray(rs, "data", extractParameter);
		for(Object o:ob) {
			System.out.println(extractParameter+" is: "+"'"+o+"'");
		}
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
