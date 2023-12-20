import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class jira {
	
	@Test
	public void addComment()
	{
		
		RestAssured.baseURI="http://localhost:8080";
		
		//login api
	SessionFilter sf=new SessionFilter();	
	String response=	given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"username\": \"prachipw\",\r\n"
				+ "    \"password\": \"Prachi@93\"\r\n"
				+ "}").log().all().filter(sf).when().post("/rest/auth/1/session").then().log().all().extract().response().asString();
		
	
	String exptdmsg= "Holaaa"	;
		//add comment
		String addCommentResponse=given().log().all().pathParam("id", 10001).header("Content-Type","application/json").body("{\r\n"
				+ "    \"body\": \""+exptdmsg+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(sf).when().post("/rest/api/2/issue/{id}/comment")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		
		JsonPath js2=new JsonPath(addCommentResponse);
		String commentId=js2.get("id");
		
		//add attachment
		given().header("Content-Type","multipart/form-data").header("X-Atlassian-Token","no-check")
		.log().all().pathParam("id", 10001).filter(sf)
		.multiPart("file",new File("C:\\Users\\prach\\OneDrive\\Pictures\\DemoProject\\DemoProject\\src\\files\\jira.txt"))
		.when().post("rest/api/2/issue/{id}/attachments")
		.then().log().all().assertThat().statusCode(200);
		
		//get issue details
		
		String issueDetails=given().header("Content-Type","application/json").header("X-Atlassian-Token","no-check")
		.log().all().pathParam("id", 10001)
		.queryParams("fields", "comment")
		.filter(sf).when().get("rest/api/2/issue/{id}")
		.then().log().all().extract().response().asString();
		
		System.out.println("----,"+issueDetails);
		
		JsonPath js1= new JsonPath(issueDetails);
		int commentsCount=js1.get("fields.comment.comments.size()");
		
		for(int i=0;i<commentsCount;i++)
		{
			String cmtId= js1.get("fields.comment.comments["+i+"].id").toString();
			if(commentId.equalsIgnoreCase(cmtId))
			{
				String msg=js1.get("fields.comment.comments["+i+"].body").toString();
				System.out.println("*********,"+msg);
				
				Assert.assertEquals(msg, exptdmsg);
			
			}
		
		}
		
		
	}

}
