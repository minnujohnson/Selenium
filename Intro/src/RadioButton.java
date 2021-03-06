import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RadioButton {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Minnuz\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		/*
		 * System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")
		 * ).isEnabled());
		 * driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']"))
		 * .click();
		 * System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")
		 * ).isEnabled());
		 * 
		 * We are expecting line13 to return false, as the return date calender is
		 * disabled first But its returned false.Here isEnabled function is not working
		 * properly. That is bcz eventhough UI is showing as disabled, the html code has
		 * no change. its same for both disabled and enabled state
		 */

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("is enabled");
			Assert.assertTrue(true);
		} else {
			System.out.println("not enabled");
			Assert.assertTrue(false);
		}
	}

}
