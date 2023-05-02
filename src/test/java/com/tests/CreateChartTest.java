package com.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.basepage.BasePage;
import com.functions.CreateChartFunc;
import com.functions.FreeChartFunc;
import com.utilities.ExcelUtils;

public class CreateChartTest extends BasePage {
	
	@DataProvider(name = "CreateChart")
	public Object[][] createChartData() {
		Object[][] data = ExcelUtils.excelData(".\\ExcelData\\GM.xls", "CreateChart");
		return data;
	}

	

	@Test(dataProvider = "CreateChart", description = "Validating by Creating Chart", priority = 1, enabled = true)
	public void creatingChart(String person,String firstName, String lastName, String dob, String tob,
			String country, String city, String folder) {
		CreateChartFunc cc = new CreateChartFunc(person,firstName, lastName, dob, tob, country, city,folder);
		try {
			cc.createChart();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
