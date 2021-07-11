package org.testing.utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportGeneration {
	
	public static ExtentReports reportGenerate()
	{
		ExtentReports extent = new ExtentReports("../APIFramework/Reports/testReport.html", false);
		return extent;
	}

}
