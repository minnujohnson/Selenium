import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Minnuz\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//implicit wait
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		

		String[] items = { "Beetroot", "Carrot", "Tomato" };
		String[] veggies = { "Beans", "Brinjal" };

		addOneItem(driver);
		addArrayItems(driver, items);
		addListItems(driver, veggies);
		//if method/utility is declared as static , then directly call method.
		//otherwise create object for the class and call using object.
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		WebDriverWait w=new WebDriverWait(driver,5);//explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
	}

	public static void addOneItem(WebDriver driver)// adding one item to cart
	{

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		// since we are fetching all items to the variable products, declare webelement
		// as list

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getText().contains("Cucumber")) {
				int j = 1;
				while (j < 4) {
					driver.findElements(By.cssSelector("a.increment")).get(i).click();
					j++;
				}

				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
			}
		}
	}

	public static void addArrayItems(WebDriver driver, String[] items)// adding array of items to cart
	{
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));
		for (int k = 0; k < items.length; k++) {
			String name = items[k];
			int c = 0;
			for (int q = 0; q < product.size(); q++) {
				if (product.get(q).getText().contains(name)) {
					c++;
					int j = 1;
					while (j < 4) {
						driver.findElements(By.cssSelector("a.increment")).get(q).click();
						j++;
					}
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(q).click();
					if (c == 3) {
						break;
					}
				}
			}
		}
	}

	public static void addListItems(WebDriver driver, String[] veggies)// using List
	{
		List<WebElement> element = driver.findElements(By.cssSelector("h4.product-name"));

		for (int p = 0; p < element.size(); p++) {
			String[] prod = element.get(p).getText().split("-");
			// split() seperate the text based on the value passed and results an array of
			// two elements
			// one is left part of "-" and other is right part of"-"

			String prod1 = prod[0].trim();
			// trim() fn remove all whitespaces from the text

			List list = Arrays.asList(veggies);// convert array to list
			int b = 0;
			if (list.contains(prod1)) {
				b++;
				int a = 1;
				while (a < 4) {
					driver.findElements(By.cssSelector("a.increment")).get(p).click();
					a++;
				}

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(p).click();
				// button[text()='ADD TO CART'] this xpath gives wrong results, bcz once the
				// item is added to cart
				// is text changing from "ADD TO CART" to "ADDED". hence selenium takes second
				// item's "ADD to CART" as index=0
				// and click on different items.so choosing text in xpath is not suggested.
				if (b == veggies.length) {
					break;
				}

			}

		}

	}
    
}
