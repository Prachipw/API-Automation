import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;


public class sumValidation {
	
	@Test
	public void sumOfCourses()
	{
		JsonPath js2=new JsonPath(payload.coursePrice());
		int count =js2.get("courses.size()");
	int sum=0;
		for(int i=0;i<count;i++) {
			
			
			int pri=js2.get("courses["+i+"].price");
			int cops=js2.get("courses["+i+"].copies");
			int amt=pri*cops;
			sum=sum+amt;
		//	System.out.println(sum);
			
		}
		
		System.out.println(sum);
		
		int purAmt=js2.get("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purAmt);
	}
}
