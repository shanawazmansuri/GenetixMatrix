package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.basepage.BasePage;

public class PlansFeaturesPg extends BasePage {

	public static WebElement plansAndFeaturesLink() {
		WebElement pf = xpath("//a[text()=' Plans & Features']");
		return pf;
	}
	
	public static WebElement plansAndFeaturesCaption() {
		WebElement cap = id("membertitle");
		return cap;
	}

	public static List<WebElement> plansFeturesContent() {
		List<WebElement> pfc = elements("//div[starts-with(@class,'service-content1')]");
		return pfc;
	}

	public static List<WebElement> plansFeaturesButtons() {
		List<WebElement> btns = elements("//*[@data-toggle='modal']");
		return btns;
	}

}
