import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Minnuz\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.cleartrip.com/");

		Thread.sleep(3500L);
		WebElement staticdropdown = driver
				.findElement(By.xpath("(//div[@id='root']/div/div/div/div/div[2]/div/div[4]/div/div/select) [1]"));
		Select option = new Select(staticdropdown);

		option.selectByIndex(2);
		System.out.println(option.getFirstSelectedOption().getText());

		WebElement staticdropdown2 = driver
				.findElement(By.xpath("(//div[@id='root']/div/div/div/div/div[2]/div/div[4]/div/div/select) [2]"));
		Select option2 = new Select(staticdropdown2);

		option2.selectByValue("2");
		System.out.println(option2.getFirstSelectedOption().getText());

		Thread.sleep(2000L);

		driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div[2]/div/div[3]/div[3]/div")).click();
		driver.findElement(
				By.cssSelector("div.DayPicker-Day.DayPicker-Day--start.DayPicker-Day--selected.DayPicker-Day--today"))
				.click();

		driver.findElement(By.xpath("//strong[contains(text(),'More options:')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Airline name']")).sendKeys("indigo");
		driver.findElement(By.xpath("(//*[text()='Search flights']) [2]")).click();
	}

}
