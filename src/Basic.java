import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.payload;
import files.reusableMethods;

public class Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String resp= given().log().all().queryParam("key ", "qaclick123").header("Content-Type","application/json")
		.body(payload.addPlace()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();
		
	
		JsonPath js =new JsonPath(resp);
		String placeId=js.getString("place_id");
		System.out.println("---,"+placeId);
		
		//update API
		
		
		String updateAddress="71 Summer walk, USA";
		given().log().all().queryParam("key ", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+updateAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "").when().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//get
	String respUpdated=	given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200)
		.extract().response().asString();
	
	
	JsonPath js1=reusableMethods.rawToJson(respUpdated);
	String actualAddress=js1.getString("address");
	System.out.println(actualAddress);
	Assert.assertEquals(actualAddress, "71 Summer walk, USA");
		
	}

}
