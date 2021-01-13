package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testBase.DriverFactory;
import testBase.TestBase;

public class AppPageObjects extends TestBase{



	public void NavigateTo(String Section) {
		
		DriverFactory.getInstance().getDriver().findElement(By.id("topnav_section")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+Section+"']")));
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[text()='"+Section+"']")).click();
	}

	

	
	
	

}
