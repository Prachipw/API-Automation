import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.GetCourse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PAuth0 {

	@Test
	public void auth0() {
		
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
//		driver.findElement(By.xpath("(//div[@class='Xb9hP']/input)[1]")).sendKeys("prachiwalvekar93");
//		driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[2]")).click();
//		driver.findElement(By.xpath("(//div[@class='Xb9hP']/input)[2]")).sendKeys("Dustbin@789");
//		driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[2]")).click();
//		String currURL=driver.getCurrentUrl();
//		System.out.println("----,"+currURL);
		
//		String currURL="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AfJohXmCI2Tblvo0tVVU-emfoGE2HEapuuxw8jrLuuCEyssGTENfPM9P48oJSTu1C8ruRg&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent";
//		String currURL1=currURL.split("code=")[1];
//		System.out.println("-----------,"+currURL1);
//		String finaluRL=currURL1.split("&scope")[0];
//		System.out.println("-----------,"+finaluRL);
//		
//		
//		
//		//getAccessToken
//		
//	String accessTokenResponse=	given()
//			.urlEncodingEnabled(false)
//			.queryParam("code", "4%2F0AfJohXmCI2Tblvo0tVVU-emfoGE2HEapuuxw8jrLuuCEyssGTENfPM9P48oJSTu1C8ruRg&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent")
//		.queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
//		.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
//		.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
//		.queryParam("grant_type", "authorization_code")
//		.header("Content-Type","application/json")
//		.when().log().all()
//		.post("https://www.googleapis.com/oauth2/v4/token").asString();
//		JsonPath js= new JsonPath(accessTokenResponse);
//		String accessToken=js.getString("access_token");
//		
//		
//		
//		
		
//		
		//main api
		GetCourse gc=given().queryParam("access_token","ya29.a0AfB_byC6eFdUhwiuD2UfnY4BB-BCTp9y7aGEbwRAUHqX_RSZzsbIqdQuFgT16_43gJeCVPzlwgBDCBbo47XA0dMDvDDzrSK6nQCmN-WaINOe-lz8AYKEbzj14z_6JDTY09kP_tuf-VaSywVBYf55_ColJDmDx6G5GAaCgYKAXYSARMSFQHGX2MiQ8mtL3HepBcClu7mj0JvlQ0169")
		.expect().defaultParser(Parser.JSON).when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
		
	System.out.println(gc.getLinkedIn());
	
	System.out.println(gc.getInstuctor());
//System.out.println(response);
	}	

}
