package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excleFile.DataConfig;

public class LoginTestWithExcelData {

	WebDriver driver;

	@Test(dataProvider = "SAMLogin")
	public void loginToSAM(String username, String password) throws InterruptedException {

		// Driver Path
		System.setProperty("webdriver.chrome.driver",
				"/Users/user/eclipse-workspace/Demo/chromeDriverFile/chromedriver");

		// ChromeDriver
		driver = new ChromeDriver();

		// URL
		String url = "https://sam.rultest2.com/account/";

		driver.get(url);
		driver.manage().window().fullscreen();

		driver.findElement(By.name("login")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/div[@id='main']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/form[1]/div[1]/div[1]/a[1]"))
				.click();

		Thread.sleep(3000);

		Assert.assertTrue(driver.getTitle().contains("Account &#8211; Sam Training"), "Login failed");
		System.out.println("Login successful!");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "SAMLogin")

	public Object[][] passData() {

		DataConfig excelConfig = new DataConfig("/Users/user/eclipse-workspace/Demo/excelDataFiles/testdata.xlsx");

		int rows = excelConfig.getRowCounts(0);

		Object[][] data = new Object[rows][2];

		for (int i = 0; i < rows; i++) {

			data[i][0] = excelConfig.getData(0, i, 0);
			data[i][1] = excelConfig.getData(0, i, 1);

		}

		return data;

	}

}
