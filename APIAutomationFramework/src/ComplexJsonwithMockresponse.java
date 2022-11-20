import PackageforExtraClasses.payloads;
import io.restassured.path.json.JsonPath;

public class ComplexJsonwithMockresponse {

	public static void main(String[] args) {
		
		
		JsonPath js = new JsonPath(payloads.mockresponse());
		
		// Print purchase amount
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		//System.out.println(purchaseAmount);
		
		//Print Dashboard Size - counts
		
		int dashboardsize = js.getInt("dashboard.size()");
		//System.out.println(dashboardsize);
		
		//Print Course Size - counts
		int Coursesize = js.getInt("courses.size()");
		System.out.println(Coursesize);
		
		//Print title of specific course
		
		String FirstCourseTitle = js.getString("courses[0].title");
		//System.out.println(FirstCourseTitle);
		
		//Print price of specific course
		int FirstCourseprice = js.getInt("courses[0].price");
		//System.out.println(FirstCourseprice);
		
		// Print all courses with prices
		
		//for (int i=0;i<Coursesize;i++)
		//{
			
		//	System.out.println(js.getString("courses["+i+"].title").toString());
		//	System.out.println(js.get("courses["+i+"].price").toString());
	
	//	}
		
		// Print specific course with respective price
		
		for (int i=0;i<Coursesize;i++)
			
		{
			String abc = js.getString("courses["+i+"].title");
			if (abc.equalsIgnoreCase("Cypress"));
			{
			int copies = js.get("courses["+i+"].copies");
			System.out.println(abc);
			System.out.println(copies);
			}
			
			
		}
	}

}
