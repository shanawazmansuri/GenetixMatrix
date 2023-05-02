package com.functions;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.basepage.BasePage;
import com.pages.CreateChartPg;
import com.pages.FreeChartPg;
import com.utilities.ExtentReportConf;

public class CreateChartFunc extends BasePage {

	SignInFunc si = new SignInFunc();

	ExtentTest chrt;

	private String personAnimal;
	private String firstName;
	private String lastName;
	private String dob;
	private String tob;
	private String country;
	private String city;
	private String folder;

	public CreateChartFunc(String personAnimal, String firstName, String lastName, String dob, String tob,
			String country, String city, String folder) {
		super();
		this.personAnimal = personAnimal;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.tob = tob;
		this.country = country;
		this.city = city;
		this.folder = folder;
	}

	public void createChart() throws IOException {

		si.validSignIn();

		chrt = ExtentReportConf.createTest("Create Chart");

		click(CreateChartPg.createChartBtn());


		waitToClick(CreateChartPg.personOrAnimalBtn(), 30);
		click(CreateChartPg.personOrAnimalBtn());

		try {
			click(CreateChartPg.closeBtn());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		click(CreateChartPg.persondropDown());
		
		waitToClick(CreateChartPg.search(), 30);
		enterText(CreateChartPg.search(), personAnimal);

		for (WebElement ele : CreateChartPg.personOptions()) {
			String folderTxt = ele.getText();
			if (folderTxt.equals(personAnimal)) {
				ele.click();
			}

		}

		

		if (personAnimal.equals("Person")) {

			waitToClick(FreeChartPg.firstName(), 30);
			enterText(FreeChartPg.firstName(), firstName);
			chrt.pass("Entered First Name as " + firstName);

			enterText(FreeChartPg.lastName(), lastName);
			chrt.pass("Entered Last Name as " + lastName);

		}

		else {
			enterText(FreeChartPg.firstName(), firstName);
			chrt.pass("Entered First Name as " + firstName);

		}

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
		chrt.pass("Entered Country in Search field " + country);

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

		click(CreateChartPg.myFolders());

		waitToClick(CreateChartPg.search(), 30);
		enterText(CreateChartPg.search(), folder);

		for (WebElement ele : CreateChartPg.myFoldersOptions()) {
			String folderTxt = ele.getText();
			if (folderTxt.equals(folder)) {
				ele.click();
				break;
			}

		}

		Wait(10000);
		click(CreateChartPg.createBtn());
		chrt.pass("Clicked on Create Button");

		/*
		 * waitTovisibleElement(FreeChartPg.createChartheading(), 30); String crTxt =
		 * FreeChartPg.createChartheading().getText(); Assert.assertEquals(crTxt,
		 * "Foundation Chart"); chrt.pass("Chart Created Successfully");
		 */

	}

}
