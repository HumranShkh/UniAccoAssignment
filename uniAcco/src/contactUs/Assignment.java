package contactUs;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {

	@Test
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test\\OneDrive\\Desktop\\UniAcco\\WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://unicreds.com/contact-us");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(90000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='onesignal-slidedown-cancel-button']"))).click();
		
		
		WebElement notification = driver.findElement(By.xpath("//button[@class='close']"));
		notification.click();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
		firstName.sendKeys("Mohammad Humran Shaikh");
		
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		email.sendKeys("mdhumran@gmail.com");
		
		WebElement country = driver.findElement(By.xpath("//select[@class='p-2 pl-4 pr-4 m-2 mt-2 mb-2 form-control form-control-md']"));
		Select select = new Select(country);
		select.selectByValue("91");
		
		WebElement Phone = driver.findElement(By.xpath("//input[@placeholder='Phone']"));
		Phone.sendKeys("9923894918");
		
		WebElement Message = driver.findElement(By.xpath("//*[@id=\"message\"]"));
		Message.sendKeys("This message is written by an automated test script");
		
		WebElement Submit = driver.findElement(By.xpath("//button[@id='contactButton']"));
		Submit.click();
		
		String affirm = "Message sent successfully!";
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0, 250)");
		
		WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Message sent successfully!']")));
		String confirm = success.getText();
		if(confirm.equals(affirm))
		{
			System.out.println("Test Completed");
		}
		driver.close();
}
}
