package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import testBase.DriverFactory;
import testBase.TestBase;

public class MapPageObjects extends TestBase {


	



	public String searchandSelectCity(String city) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("map_canvas")));
		DriverFactory.getInstance().getDriver().findElement(By.cssSelector("input#searchBox.searchBox")).sendKeys(city);
		Thread.sleep(3000);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath("//div[@class='messages']//div[@style='']")).isEmpty(),"City is not listed");
		
		if(!DriverFactory.getInstance().getDriver().findElements(By.xpath("//div[@class='messages']//div//label[@for='"+city+"']//input")).isEmpty() && DriverFactory.getInstance().getDriver().findElements(By.xpath("//div[@class='messages']//div//label[@for='"+city+"']//input[@class='defaultChecked']")).isEmpty()) {
				DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='messages']//div//label[@for='"+city+"']//input")).click();
		}
		Assert.assertTrue(!DriverFactory.getInstance().getDriver().findElements(By.xpath("//div[contains(@class,'icon')]//div[text()='"+city+"']")).isEmpty()," Hard Assert on whether selected City apperead on map");
		
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[contains(@class,'icon')]//div[text()='"+city+"']")).click();
		
		return DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='leaflet-popup-content']//b[starts-with(text(),'Temp in Degrees')]")).getText();
	}
}
