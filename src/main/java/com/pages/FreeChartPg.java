package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.basepage.BasePage;

public class FreeChartPg extends BasePage {

	public static WebElement freeChartLink() {
		WebElement fcl = xpath("//a[text()='Free Chart']");
		return fcl;
	}

	public static WebElement freeChartHeading() {
		WebElement fch = xpath("//h3[@class='charthubhead gmCardTitle']");
		return fch;
	}

	public static WebElement firstName() {
		WebElement fn = id("f_name");
		return fn;
	}

	public static WebElement lastName() {
		WebElement ln = id("l_name");
		return ln;
	}

	public static WebElement birthDate() {
		WebElement bd = id("birthdate");
		return bd;
	}

	public static WebElement calendarBirthDate() {
		WebElement bdc = id("fd-but-birthdate");
		return bdc;
	}

	public static WebElement calendarYear() {
		WebElement yr = id("birthdate-prev-year-but");
		return yr;
	}

	public static WebElement calendarMonth() {
		WebElement mo = id("birthdate-prev-month-but");
		return mo;
	}

	public static WebElement calendarDays(int day) {
		WebElement mo = xpath("//tbody/tr/td[contains(@title," + "'" + day + "'" + ")]");
		return mo;
	}

	public static WebElement birthTime() {
		WebElement bt = id("birthtime");
		return bt;
	}

	public static WebElement helpBirthTime() {
		WebElement bdt = xpath("//button[@class='ui-datepicker-trigger']");
		return bdt;
	}

	public static WebElement nowBtn() {
		WebElement nwbt = xpath("//button[text()='Now']");
		return nwbt;
	}

	public static WebElement doneBtn() {
		WebElement dnbt = xpath("//button[text()='Done']");
		return dnbt;
	}

	public static WebElement country() {
		WebElement con = id("select2-country_new-container");
		return con;
	}

	public static List<WebElement> countryOptions() {
		List<WebElement> con = elements("//ul[@id='select2-country_new-results']/li");
		return con;
	}

	public static WebElement city() {
		WebElement city = xpath("//input[@name='city']");
		return city;
	}

	public static WebElement state() {
		WebElement state = id("state_new");
		return state;
	}

	public static WebElement createBtn() {
		WebElement Crbt = name("_sumit_free_chart");
		return Crbt;
	}

	public static WebElement createChartheading() {
		WebElement crHead = xpath("//*[text()='Foundation Chart']");
		return crHead;
	}

	public static WebElement fullDetails() {
		WebElement fd = id("data_section");
		return fd;
	}

	public static WebElement savePDFBtn() {
		WebElement pdf = xpath("//a[text()='Save PDF']");
		return pdf;
	}

	public static WebElement resetChartBtn() {
		WebElement reset = xpath("//a[text()='Reset Chart']");
		return reset;
	}

	public static WebElement closeBtn() {
		List<WebElement> cb = elements("//i[@id = 'close-icon']");
		return cb.get(0);
	}
	
	public static WebElement hpLogo() {
		WebElement logo = id("gmlogo");
		return logo;
	}

}