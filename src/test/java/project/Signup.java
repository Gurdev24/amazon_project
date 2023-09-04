package project;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup {

	public static void main(String[] args) 

		throws IOException {

			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			
			//navigate to amazon
			driver.navigate().to("https://www.amazon.ca/");
			
			
			//verify amazon.ca
			boolean display = driver.findElement(By.cssSelector("#nav-logo-sprites")).isEnabled();
			System.out.println(display);
			
			//take screenshot
			File srcfile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile1, new File ("D://amazon project/amazon-homepage.jpg"));
			
		
			//Open Sign up page		
			Actions action=new Actions(driver);
			action.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"))).build().perform();
			new WebDriverWait(driver, Duration.ofSeconds(5));
			driver.findElement(By.linkText("Start here.")).click();
			
			//wait for page to load
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ap_register_form > div > div > h1")));
			
			
			//add incorrect details
			driver.findElement(By.id("ap_customer_name")).sendKeys("");
			driver.findElement(By.id("ap_email")).sendKeys("gs@gmail.com");
			driver.findElement(By.id("ap_password")).sendKeys("Password");
			driver.findElement(By.id("ap_password_check")).sendKeys("pass");
			driver.findElement(By.id("continue")).click();
			
			//take screenshot
			File srcfile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile2, new File ("D://amazon project/signuperror.jpg"));
			
			
			//refresh page
			driver.navigate().refresh();
			
			
			
			//add correct details
			driver.findElement(By.id("ap_customer_name")).sendKeys("GS");
			driver.findElement(By.id("ap_email")).sendKeys("gurdevsingh0395@gmail.com");
			driver.findElement(By.id("ap_password")).sendKeys("Password");
			driver.findElement(By.id("ap_password_check")).sendKeys("Password");
			driver.findElement(By.id("continue")).click();
			
			//Existing Customer page
			driver.findElement(By.cssSelector("#authportal-main-section > div:nth-child(2) > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > a")).click();
			
			//take screenshot
			File srcfile3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile3, new File ("D://amazon project/existingcustomer.jpg"));
			
			
			driver.findElement(By.id("ap_email")).sendKeys("gurdevsingh0395@gmail.com");
			driver.findElement(By.id("continue")).click();
			
			//enter password and select the Keep me Signed in option
			driver.findElement(By.id("ap_password")).sendKeys("Welcome@123");
			driver.findElement(By.cssSelector("#authportal-main-section > div:nth-child(2) > div > div:nth-child(2) > div > form > div > div:nth-child(7) > div > div > label > div > label > input[type=checkbox]")).click();

			//take screenshot
			File srcfile4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile4, new File ("D://amazon project/keepmesingin.jpg"));
			

			driver.findElement(By.id("signInSubmit")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			
			//Open Your Account page
			Actions action2=new Actions(driver);
			action2.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).build().perform();
			new WebDriverWait(driver, Duration.ofSeconds(5));
			driver.findElement(By.linkText("Your Account")).click();
			
			//take screenshot
			File srcfile5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile5, new File ("D://amazon project/account home.jpg"));
			
					
			//Select Your Order
			driver.findElement(By.className("ya-card__whole-card-link")).click();
			
			//take screenshot
			File srcfile6 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile6, new File ("D://amazon project/yourorder.jpg"));
			
			
			//Your Payments
			driver.navigate().back();
			new WebDriverWait(driver, Duration.ofSeconds(5));
			driver.findElement(By.cssSelector("#a-page > div.a-container > div > div:nth-child(2) > div:nth-child(2) > a")).click();

			//take screenshot
			File srcfile7 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile7, new File ("D://amazon project/yourpayment.jpg"));
			
			
			//Search bar
			driver.findElement(By.id("nav-logo-sprites")).click();
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("shirt");
			driver.findElement(By.id("nav-search-submit-button")).click();
			new WebDriverWait(driver, Duration.ofSeconds(5));
			Select obj1 = new Select(driver.findElement(By.id("s-result-sort-select")));
			obj1.selectByVisibleText("Newest arrivals");

			//take screenshot
			File srcfile8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile8, new File ("D://amazon project/searchhome.jpg"));
				
			
			//scroll to my cart
			driver.findElement(By.id("nav-cart")).click();
			new WebDriverWait(driver, Duration.ofSeconds(5));

			//take screenshot
			File srcfile9 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile9, new File ("D://amazon project/cart.jpg"));
			
			
			//closing the browser
			driver.close();
	}
	
	
}
