package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testBase.DriverFactory;
import testBase.TestBase;

public class HomePageObjects extends TestBase{


	//click on menu bar - by passing name of menu
	public void clickOnMenu(String menu) {
		if(!DriverFactory.getInstance().getDriver().findElements(By.xpath("//a[@class='notnow']")).isEmpty())
			DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@class='notnow']")).click();
		
		String MenuXpath = "//a[text()='"+menu+"']";
		DriverFactory.getInstance().getDriver().findElement(By.xpath(MenuXpath)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='NDTV APPS']")));
	}

	

	
	
	

}
