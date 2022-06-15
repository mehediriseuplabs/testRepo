import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigDriver {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/user/Documents/chromedriver");

		WebDriver driver = new ChromeDriver();

		String url = "https://redgrocer.com";
		String brandsUrl = "https://beta.letuslearn.rultest.com/login";
		String demoUrl = "https://login.salesforce.com/";


		driver.get(demoUrl);
//		driver.navigate().to(brandsUrl);

		driver.manage().window().maximize();
		
		
//		driver.navigate().back();
//		driver.findElement(By.xpath("//strong[contains(text(),'Riseup Labs')]")).click();

		driver.findElement(By.id("username")).sendKeys("01900000001");
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		var errorTest= driver.findElement(By.cssSelector("#error")).getText();

//		var title = driver.getTitle();

		System.out.println(errorTest);
		

		driver.close();

	}

}
