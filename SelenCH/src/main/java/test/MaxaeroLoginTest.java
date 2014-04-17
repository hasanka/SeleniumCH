package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MaxaeroLoginTest {

	@Test(description="log and test page title")
	public void testLoginAndTitle(){
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://maxaero.cmb.isaaviations.com/maxaero-web/sessionTimeout.html");
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		WebElement submitButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnLogin")));
		WebElement userName = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("j_password"));
		userName.sendKeys("SYSTEM");
		password.sendKeys("password");
		submitButton.click();
		Assert.assertEquals(driver.getTitle(), "MaxAero");
		driver.quit();
	}
	
	
	@Test(description="log and test loged user")	
	public void testLogin(){
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://maxaero.cmb.isaaviations.com/maxaero-web/sessionTimeout.html");
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		WebElement submitButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnLogin")));
		WebElement userName = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("j_password"));
		userName.sendKeys("SYSTEM");
		password.sendKeys("password");
		submitButton.click();
		WebElement userLink = driver.findElement(By.xpath("//*[@id=\"lblLoggedInUser\"]/a"));
		Assert.assertEquals(userLink.getText(), "SYSTEM");
		driver.quit();
	}
	
	
}
