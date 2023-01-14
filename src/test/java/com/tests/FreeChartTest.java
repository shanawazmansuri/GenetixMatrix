package com.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.basepage.BasePage;
import com.functions.FreeChartFunc;
import com.utilities.ExcelUtils;

public class FreeChartTest extends BasePage {

	FreeChartFunc fc = new FreeChartFunc();
	{
	}

	@DataProvider(name = "FreeChart")
	public Object[][] freeChartData() {
		Object[][] data = ExcelUtils.excelData(".\\ExcelData\\GM.xls", "FreeChart");
		return data;
	}

	@Test(dataProvider = "FreeChart", description = "Validating by Creating Free Chart by entering values", priority = 0, enabled = false)
	public void freeChartCreationByEnteringText(String firstName, String lastName, String dob, String tob,
			String country, String city) {
		FreeChartFunc fcm = new FreeChartFunc(firstName, lastName, dob, tob, country, city);
		try {
			fcm.freeChartCreationManual();
			fcm.chartDetails();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "FreeChart", description = "Validating by Creating Free Chart by selecting values from calendar", priority = 1, enabled = false)
	public void freeChartCreationVerificationBySelectingVal(String firstName, String lastName, String dob, String tob,
			String country, String city) {
		FreeChartFunc fca = new FreeChartFunc(firstName, lastName, dob, tob, country, city);
		try {
			fca.freeChartCreationAuto();
			fca.chartDetails();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "FreeChart", description = "Downloading the Free Chart PDF", priority = 3, enabled = false)
	public void freeChartSavePDF(String firstName, String lastName, String dob, String tob, String country,
			String city) {

		FreeChartFunc pdf = new FreeChartFunc(firstName, lastName, dob, tob, country, city);

		try {

			pdf.freeChartCreationAuto();
			pdf.savePDF();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "FreeChart", description = "Resetting Free Chart ", priority = 4, enabled = false)
	public void freeChartReset(String firstName, String lastName, String dob, String tob, String country, String city) {

		FreeChartFunc res = new FreeChartFunc(firstName, lastName, dob, tob, country, city);

		try {

			res.freeChartCreationAuto();
			res.resetChart();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(description = "Closing Free Chart Window", priority = 5, enabled = true)
	public void freeChartCloseWindow() {

		try {
			fc.closeWindow();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
