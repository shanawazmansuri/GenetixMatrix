package com.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.basepage.BasePage;
import com.functions.LanguageFunc;
import com.functions.PlansFeaturesFunc;

public class PlansFeatureTest extends BasePage {
	
	PlansFeaturesFunc pff = new PlansFeaturesFunc();
	
	@Test(priority = 1)
	public void verifyLanguage() throws IOException
	{
		pff.contentPlansFeatures();
		pff.contentsButtons();
	}


}
