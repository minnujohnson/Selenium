import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Minnuz\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement staticdropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		//create an object for webelemnt for storing the desired field.
		
		Select dropdown = new Select(staticdropdown);
		/*Select is a class used for handling the static dropdowns. That means wherever
		there is a <select> tag in html this class can be used.
		create an object for it and pass the webelemnt's object as argument.
		access the methods using Select's object */
		
		
		dropdown.selectByIndex(3);//select the option using index 
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByValue("AED");//select the option by defined value in html
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByVisibleText("INR");//select the option by visible text in UI
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		

	}

}
