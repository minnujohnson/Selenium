import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaAlerts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Minnuz\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String text = "Minnu";
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.cssSelector("#name")).sendKeys(text);
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();

		Thread.sleep(3000L);
		System.out.println(driver.switchTo().alert().getText());
		// alert box is not part of webui, its javascript, hence it should be handled by
		// switchTo().alert() method

		driver.switchTo().alert().accept();

		Thread.sleep(3000L);
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();

	}

}
