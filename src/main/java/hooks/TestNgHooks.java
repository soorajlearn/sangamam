package hooks;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import config.ConfigurationManager;
import pages.AutoWiredPages;
import utils.DataFactory;
import utils.DataSource;
import utils.ReadData;

public class TestNgHooks extends AutoWiredPages {

	public String dataSheetName;
	public DataSource dataSheetSource;

	@DataProvider(name = "fetchData", indices = {0})
	public Object[][] fetchData() throws IOException, ParseException {
		//return ExcelReader.readExcelData(dataSheetName);
		//ReadData dataSource = DataFactory.dataFactory(ConfigurationManager.configuration().dataSource());
		ReadData dataSource = DataFactory.dataFactory(dataSheetSource);
		return dataSource.readData(dataSheetName);
	}	

	@BeforeMethod
	public void beforeMethod() {
		startApp("chrome", ConfigurationManager.configuration().baseUrl());
		setNode();
	}
	

	@AfterMethod
	public void afterMethod() {
		close();
	}













}
