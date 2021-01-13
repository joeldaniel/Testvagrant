package Tests;

import org.testng.annotations.Test;

import pageObjects.AppPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.MapPageObjects;
import testBase.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class TestCase extends TestBase{

	HomePageObjects homePage = new HomePageObjects();
	AppPageObjects AppPage = new AppPageObjects();
	MapPageObjects MapPage = new MapPageObjects();
	
	@Test
	public void TestCase1() throws Throwable {
		
		homePage.clickOnMenu("APPS");
		AppPage.NavigateTo("Weather");
		String Weather1=MapPage.searchandSelectCity("Bengaluru");
		
		
		//String Weather1="Temp in Degrees: 27";
		System.out.println("Weather 1 : "+Weather1.replaceAll("[^0-9]", "")+"f");
		Float f1=Float.parseFloat(Weather1.replaceAll("[^0-9]", "")+"f");
		
		RestAssured.baseURI= "http://api.openweathermap.org";
		Response res=given().
		
		queryParam("q","Bengaluru").
		queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea").
		queryParam("units", "metric").
		
		when().
		get("/data/2.5/weather").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		extract().response();
		
		String responseString=res.asString();
		//System.out.println(responseString);
		
		JsonPath js= new JsonPath(responseString);
		HashMap<String,String> sets=js.get("main");
		
       // System.out.println(String.valueOf(sets.get("temp"))); 
        String Weather2=String.valueOf(sets.get("temp"));
        System.out.println("Weather 2 : "+Weather2+"f");
        Float f2=Float.parseFloat(Weather2+"f");
        
        diff name = new diff();
        if(name.compare(f1,f2)==0) {
        	System.out.println("FAIL");
        }else {
        	System.out.println("PASS");
        }
        
       
          
		
		
		
		
		
	}
	


}
