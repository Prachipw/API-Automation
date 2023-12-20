import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;


public class sumValidation {
	
	@Test
	public void sumOfCourses()
	{
		JsonPath js2=new JsonPath(payload.coursePrice());
		int count =js2.get("courses.size()");
	
		for(int i=0;i<count;i++) {
			
			
			int pri=js2.get("courses["+i+"].price");
			int cops=js2.get("courses["+i+"].copies");
			int amt=pri*cops;
			System.out.println(amt);
			
		}
	}
}
