import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.payload;
import files.reusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import files.payload;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class DynamicJson {
		
	@Test(dataProvider="AddBooks")
	public void AddBooks(String isbn,String aisle) {
	
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String respo1=given().header("Content-Type","application/json")
		.body(payload.addBook(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		RestAssured.useRelaxedHTTPSValidation();
		JsonPath js=reusableMethods.rawToJson(respo1);
		String id=js.get("ID");
		System.out.println(id);
		
		
		//delete book
		
		given().log().all().header("Content-Type","application/json").body(payload.deleteBook(id))
		.when().delete("/Library/DeleteBook.php")
		.then().log().all().assertThat().statusCode(200);
		
	}
	
@DataProvider(name="AddBooks")
public Object[][] getData()
{
	return new Object[][] {{"sadssd","55447"},{"sdawe","34553"},{"sadksd","86w565"}};
}
	

}
