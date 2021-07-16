package org.testing.testcases;

import java.io.IOException;
import java.util.Properties;

import org.testing.utilities.ExtentReportGeneration;
import org.testing.utilities.PropertiesFile;
import org.testing.utilities.RandomString;
import org.testing.utilities.ValidateResponse;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TC11_PostTwittOnTwitter {
	
	@Test
	public void eleventhTestCase() throws IOException
	{
		ExtentReports extent = ExtentReportGeneration.reportGenerate();
		ExtentTest test = extent.startTest("Eleventh Test", "Post twitt");
		
		String random=RandomString.generateRandomString(5);
		
		Properties uri=PropertiesFile.readProperties("../APIFramework/URI.properties");
		RestAssured.baseURI=uri.getProperty("Twitter_URI");
		
		Properties config=PropertiesFile.readProperties("../APIFramework/Config.properties");
	    Response rs= given()
					  .contentType(ContentType.JSON)
					  .auth()
					  .oauth(config.getProperty("consumer_key"), config.getProperty("Consumer_Secret"), 
							config.getProperty("Access_token"), config.getProperty("token_secret"))
					  .queryParam("status","This is my tweet via api: "+random)
			          .when()
			          .post("/update.json");
		
	    System.out.println("----------------------------------------------");		
		boolean b=ValidateResponse.statusCodeValidate(rs, 200);
		if(b)
			test.log(LogStatus.PASS, "Status code of Post twitt req is coming as expected");
		else
			test.log(LogStatus.FAIL, "Status code of Post twitt Req: expected 200 but actual is "+rs.statusCode());
		extent.endTest(test);
		extent.flush();
		
		
		
	}

}
