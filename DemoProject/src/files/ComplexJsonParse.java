package files;

import io.restassured.path.json.JsonPath;
import files.payload;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js2=new JsonPath(payload.coursePrice());
		
		//print number of courses
		
		int count =js2.get("courses.size()");
		System.out.println(count);
		int totalAmount=js2.get("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		String titleFirstCourse=js2.get("courses[0].title");
		System.out.println(titleFirstCourse);
		
		for(int i=0;i<count;i++)
		{
			int price=js2.get("courses["+i+"].price");
			String Courses=js2.get("courses["+i+"].title");
			System.out.println(price);
			System.out.println(Courses);
		}
		
		for(int i=0;i<count;i++)
		{
			
			String Courses=js2.get("courses["+i+"].title");
			if(Courses.equalsIgnoreCase("RPA"))
			{
				int copies=js2.get("courses["+i+"].copies");
				System.out.println(copies);
				break;
			}
			
		}
		
			for(int i=0;i<count;i++) {
				
				
				int pri=js2.get("courses["+i+"].price");
				int cops=js2.get("courses["+i+"].copies");
				int amt=pri*cops;
				System.out.println(amt);
				
			}
			
			}
}
