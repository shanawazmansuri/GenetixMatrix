package com.functions;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.basepage.BasePage;
import com.pages.LanguagesPg;
import com.pages.PlansFeaturesPg;
import com.utilities.ExtentReportConf;
import com.utilities.ScreenShot;

public class PlansFeaturesFunc extends BasePage {

	ExtentTest pf;

	public void contentPlansFeatures() throws IOException {

		try {

			pf = ExtentReportConf.createTest("Plans & Features");

			click(PlansFeaturesPg.plansAndFeaturesLink());
			pf.pass("Clicked on Plans and Features Link");

			String caption = gettext(PlansFeaturesPg.plansAndFeaturesCaption());
			Assert.assertEquals(caption, "Plans & Features");

			for (WebElement ele : PlansFeaturesPg.plansFeturesContent()) {
				boolean stat = ele.isDisplayed();
				assertTrue(stat);

			}
			
			pf.pass("All 4 contents are visible");


		}

		catch (Exception e) {

			String cont = ScreenShot.screenShotExtentReport(driver, "Contents");
			pf.fail(e);
			pf.addScreenCaptureFromPath(cont);

		}
	}

	public void contentsButtons() {
		for (int i = 3; i <= PlansFeaturesPg.plansFeaturesButtons().size(); i++) {
			if (i == 11) {
				break;
			}
			WebElement link = PlansFeaturesPg.plansFeaturesButtons().get(i);
			String links = PlansFeaturesPg.plansFeaturesButtons().get(i).getAttribute("data-target");
			link.click();
			pf.pass("Clicked on link:- " + links);
			navigate("https://www.geneticmatrix.com/plans-features/");

		}
	}

}
