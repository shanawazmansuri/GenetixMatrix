package com.functions;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.basepage.BasePage;
import com.pages.LanguagesPg;
import com.pages.RegisterPg;
import com.utilities.ExtentReportConf;
import com.utilities.ScreenShot;

public class LanguageFunc extends BasePage {

	ExtentTest lang;

	public void selectLanguage() throws IOException {

		try {

			lang = ExtentReportConf.createTest("Verify Languages");
			
			String defLang = gettext(LanguagesPg.languageDropDown());
			lang.pass("Default Language selected as "+defLang);			
			Assert.assertTrue(defLang.contains("English"));

			click(LanguagesPg.languageDropDown());
			lang.pass("Clicked on Language Drop down box");
			waitTovisibleElement(LanguagesPg.languageOption().get(0), 30);

			for (WebElement ele : LanguagesPg.languageOption()) {
				String text = ele.getText();
				lang.pass("Languages displayed are:- " + text);

				String selLang = pro.prop.getProperty("language");
				if (text.contains(selLang)) {
					ele.click();
					lang.pass("Language selected as:- " + selLang);
					break;

				}

			}
			
			defLang = gettext(LanguagesPg.languageDropDown());
			String selectedLang = pro.prop.getProperty("language");
			Assert.assertTrue(defLang.contains(selectedLang));
			lang.pass("Asserted Language selected as:- " + defLang);


		} catch (Exception e) {

			String langu = ScreenShot.screenShotExtentReport(driver, "Language");
			lang.fail(e);
			lang.addScreenCaptureFromPath(langu);

		}

	}

}
