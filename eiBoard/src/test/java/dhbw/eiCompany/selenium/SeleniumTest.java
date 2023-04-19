package dhbw.eiCompany.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {
	
	    @Test
	    public void firstSeleniumTest() {
	    	
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\b41819\\Desktop\\Uni\\SoftwareEng\\SoftwareEngPresentation\\chromedriver.exe");
	    	
	    	ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.addArguments("--remote-allow-origins=*");
	        WebDriver driver = new ChromeDriver(chromeOptions);
	    	
	        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

	        String title = driver.getTitle();
	        assertEquals("Web form", title);

	        WebElement textBox = driver.findElement(By.name("my-text"));
	        textBox.sendKeys("Selenium");
	        //textBox.sendKeys(Keys.TAB);
	        
	        WebElement comboBox = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[1]/select"));
	        Select combo = new Select(comboBox);
	        combo.selectByVisibleText("One");
	        String selectedComboBoxValue = combo.getFirstSelectedOption().getText();
	        assertEquals("One", selectedComboBoxValue);
	        
	        WebElement submitButton = driver.findElement(By.xpath("html/body/main/div/form/div/div[2]/button"));
	        submitButton.click();
	        
	        //implizit
	        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	        
	        //explizit
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
	        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

	        String value = message.getText();
	        assertEquals("Received!", value);

	        driver.quit();
	    }
}