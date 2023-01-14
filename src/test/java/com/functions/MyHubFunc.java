package com.functions;

import java.io.IOException;

import com.aventstack.extentreports.ExtentTest;
import com.basepage.BasePage;
import com.pages.MyHubPg;
import com.tests.SignInTest;
import com.utilities.ExtentReportConf;
import com.utilities.ScreenShot;

public class MyHubFunc extends BasePage {

	ExtentTest myHub;

	public void verifyMyHub() throws IOException {

		try {

			myHub = ExtentReportConf.createTest("My Hub");

			
			assertEquals(MyHubPg.tabs(), "GM Advanced");
			myHub.pass("Verified Tab Name as "+gettext(MyHubPg.tabs()));
			
			boolean chartVision = isDisplayed(MyHubPg.charts());
			assertTrue(chartVision);
			myHub.pass("Verified Chart is visible on My Hub");

			

		} catch (Exception e) {

			String mh = ScreenShot.screenShotExtentReport(driver, "MyHub");
			myHub.fail(e);
			myHub.addScreenCaptureFromPath(mh);

		}
	}

}
