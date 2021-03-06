import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parent_child_traverse_xpath {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Minnuz\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		/*
		 * when no attribute is unique in the tagfield, the parent child method applies.
		 * write xpath for parent, which has unique attribute. then traverse to our
		 * field using '/' tag.
		 */

		driver.findElement(By.xpath("//div[@class='RNNXgb']/div/div[2]/input")).sendKeys("hello");
		driver.findElement(By.xpath("//div[@class='LX3sZb']/div/div/div/div/div[2]/a")).click();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.xpath("//body/div/div[2]/fieldset/input")).sendKeys("abc");
		// absolute xpath

		driver.findElement(By.xpath("//button[contains(text(),'Home')]/parent::a")).click();
		// child to parent traverse

		driver.navigate().back();

		driver.findElement(By.xpath("//a[text()='Open Tab']")).click();
		// text based x path, which is the easiest way

		driver.findElement(By.xpath("//button[contains(text(),'Open Window')]")).click();
		// xpath taken using chropath plugin

		driver.findElement(By.xpath("//input[@id='alertbtn']/following-sibling::input")).click();
		// siblings traverse
	}

}
