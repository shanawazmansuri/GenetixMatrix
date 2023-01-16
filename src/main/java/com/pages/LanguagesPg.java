package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.basepage.BasePage;

public class LanguagesPg extends BasePage {
	
	public static WebElement languageDropDown() {
		WebElement lan = xpath("//a[@data-toggle='dropdown']");
		return lan;
	}
	
	public static List<WebElement> languageOption() {
		List<WebElement> lo = elements("//a[@class='dropdown-item']");
		return lo;
	}

}
