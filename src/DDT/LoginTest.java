package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;

	@Test(dataProvider = "SAMLogin")
	public void loginToSAM(String username, String password) throws InterruptedException {

		// Driver Path
		System.setProperty("webdriver.chrome.driver", "/Users/user/Documents/chromedriver");

		// Chrome Driver
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

		Assert.assertTrue(driver.getTitle().contains("Account"), "Login failed");
		System.out.println("Login successful!");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "SAMLogin")

	public Object[][] passData() {

		Object[][] data = new Object[2][2];

		data[0][0] = "alphatest";
		data[0][1] = "test1234";
		data[1][0] = "alpha";
		data[1][1] = "test1234";

		return data;

	}

}
