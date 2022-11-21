import PackageforExtraClasses.payloads;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class ComplesJsonPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath (payloads.complexresponse());
		
		int coursecount = js.getInt("courses.size()");
		//System.out.println(coursecount);
		
		
		for (int i=0; i<coursecount; i++)
			
		{
			
			String coursetitle = js.getString("courses["+i+"].title");
			
			if (coursetitle.contains("Cypress"))
			
			{
				
				int copy= js.getInt("courses["+i+"].copies");
				System.out.println(copy);
			}
			
		}

	}
	
}
