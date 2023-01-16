package com.functions;

import java.sql.Time;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.basepage.BasePage;
import com.pages.FreeChartPg;
import com.pages.RegisterPg;
import com.utilities.ExtentReportConf;

public class FreeChartFunc extends BasePage {

	ExtentTest chrt;
	ExtentTest pdf;
	ExtentTest reset;
	ExtentTest close;

	private String firstName;
	private String lastName;
	private String dob;
	private String tob;
	private String country;
	private String city;

	public FreeChartFunc(String firstName, String lastName, String dob, String tob, String country, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.tob = tob;
		this.country = country;
		this.city = city;
	}

	public FreeChartFunc() {

	}

	public void freeChartCreationManual() {

		chrt = ExtentReportConf.createTest("Create Chart");

		click(FreeChartPg.freeChartLink());
		chrt.pass("Clicked on Free Chart Link");

		waitTovisibleElement(FreeChartPg.freeChartHeading(), 30);
		String fcheadTxt = FreeChartPg.freeChartHeading().getText().trim();
		Assert.assertEquals(fcheadTxt, "Create Foundation Chart");
		chrt.pass("Landed successfully on Free Chart Page");

		enterText(FreeChartPg.firstName(), firstName);
		chrt.pass("Entered First Name as " + firstName);

		enterText(FreeChartPg.lastName(), lastName);
		chrt.pass("Entered Last Name as " + lastName);

		enterText(FreeChartPg.birthDate(), dob);
		chrt.pass("Entered Date of Birth as " + dob);

		click(FreeChartPg.helpBirthTime());
		click(FreeChartPg.nowBtn());
		click(FreeChartPg.doneBtn());
		chrt.pass("Selected Current Time");

		click(FreeChartPg.country());
		enterText(FreeChartPg.countrySearch(), country);

		for (WebElement ele : FreeChartPg.countryOptions()) {
			String counVal = ele.getText();
			System.out.println(counVal);
			if (counVal.equalsIgnoreCase(country)) {
				ele.click();
				break;
			}

		}
		chrt.pass("Selected Country as " + country);

		enterText(FreeChartPg.city(), city);
		chrt.pass("Entered City as " + city);

		Wait(10000);
		click(FreeChartPg.createBtn());
		chrt.pass("Clicked on Create Button");

		waitTovisibleElement(FreeChartPg.createChartheading(), 30);
		String crTxt = FreeChartPg.createChartheading().getText();
		Assert.assertEquals(crTxt, "Foundation Chart");
		chrt.pass("Chart Created Successfully");
	}

	public void freeChartCreationAuto() {

		chrt = ExtentReportConf.createTest("Create Chart");

		click(FreeChartPg.freeChartLink());
		chrt.pass("Clicked on Free Chart Link");

		waitTovisibleElement(FreeChartPg.freeChartHeading(), 30);
		String fcheadTxt = FreeChartPg.freeChartHeading().getText().trim();
		Assert.assertEquals(fcheadTxt, "Create Foundation Chart");
		chrt.pass("Landed successfully on Free Chart Page");

		enterText(FreeChartPg.firstName(), firstName);
		chrt.pass("Entered First Name as " + firstName);

		enterText(FreeChartPg.lastName(), lastName);
		chrt.pass("Entered Last Name as " + lastName);

		click(FreeChartPg.calendarBirthDate());
		chrt.pass("Clicked on BirthDate Help Calendar");


		// Selecting Month
		int year = 37;
		for (int i = 0; i < year; i++) {
			click(FreeChartPg.calendarYear());
		}

		// Selecting Month
		int month = 4;
		for (int i = 0; i < month; i++) {
			click(FreeChartPg.calendarMonth());
		}

		click(FreeChartPg.calendarDays(18));
		chrt.pass("Selected Birth Date");
		

		click(FreeChartPg.helpBirthTime());
		Actions ac = new Actions(driver);
		ac.dragAndDropBy(FreeChartPg.hourHelp(), 100, 26).perform();
		ac.dragAndDropBy(FreeChartPg.minHelp(), 75, 26).perform();
		ac.dragAndDropBy(FreeChartPg.secHelp(), 50, 26).perform();
		chrt.pass("Clicked on Birth Time");
		

		click(FreeChartPg.doneBtn());
		chrt.pass("Clicked on Done Button");

		click(FreeChartPg.country());
		enterText(FreeChartPg.countrySearch(), country);
		chrt.pass("Entered Country in Search field "+country);

		for (WebElement ele : FreeChartPg.countryOptions()) {
			String counVal = ele.getText();
			System.out.println(counVal);
			if (counVal.equalsIgnoreCase(country)) {
				ele.click();
				break;
			}

		}
		chrt.pass("Selected Country as " + country);

		enterText(FreeChartPg.city(), city);
		FreeChartPg.city().sendKeys(Keys.TAB);
		chrt.pass("Entered City as " + city);

		Wait(10000);
		click(FreeChartPg.createBtn());
		chrt.pass("Clicked on Create Button");

		waitTovisibleElement(FreeChartPg.createChartheading(), 30);
		String crTxt = FreeChartPg.createChartheading().getText();
		Assert.assertEquals(crTxt, "Foundation Chart");
		chrt.pass("Chart Created Successfully");
	}

	public void savePDF() {
		pdf = ExtentReportConf.createTest("Save PDF");
		click(FreeChartPg.savePDFBtn());
		pdf.pass("Clicked on Save PDF button");
		Wait(10000);
		switchtoChildWindow();
		Wait(5000);
		String srcUrlTxt = getCurrentURL();
		Assert.assertTrue(srcUrlTxt.contains(".pdf"));
		pdf.pass("PDF downloaded successfully");
		closeBrowser();
		switchtoParentWindow();
		String titleParentTxt = getTitle();
		System.out.println("Title 2 is " + titleParentTxt);
		Assert.assertTrue(titleParentTxt.contains("Free Foundation Chart"));
		pdf.pass("Closed Child PDF window and Switched to Parent window");

	}

	public void resetChart() {
		reset = ExtentReportConf.createTest("Reset Chart");
		click(FreeChartPg.resetChartBtn());
		reset.pass("Clicked on Reset Chart button");
		
		Assert.assertEquals(getTitle(), "Genetic Matrix – Human Design and Astro HD Services");
		reset.pass("Chart Details has been Resetted Successfully and Switched to Home Page");

	}

	public void chartDetails() {
		boolean chStatus = isDisplayed(FreeChartPg.fullDetails());
		System.out.println("Status is " + chStatus);
		assertTrue(chStatus);
		chrt.pass("Chart Details are displayed successfully");


	}

	public void closeWindow() {
		close = ExtentReportConf.createTest("Closing Window");
		click(FreeChartPg.freeChartLink());
		close.pass("Clicked on Free Chart Link");

		waitTovisibleElement(FreeChartPg.freeChartHeading(), 30);
		String fcheadTxt = FreeChartPg.freeChartHeading().getText().trim();
		Assert.assertEquals(fcheadTxt, "Create Foundation Chart");
		close.pass("Landed successfully on Free Chart Page");

		click(FreeChartPg.closeBtn());
		close.pass("Clicked on Close Button");
		boolean status = isDisplayed(FreeChartPg.hpLogo());
		assertTrue(status);
		close.pass("Successfully closed the window and landed on HomePage");
	}

}