import org.testng.annotations.Test;

import PackageforExtraClasses.payloads;
import io.restassured.path.json.JsonPath;

public class SumValidatione_example {
	
	@Test
	
	public void sumvalidation ()
	
	{
		
		JsonPath js = new JsonPath (payloads.complexresponse());
		
		int count = js.getInt("courses.size()");
		
		for (int i=0; i<count ; i++)
			
		{   
			
			
		int price=	js.getInt("courses["+i+"].price");
			
		int copies=	js.getInt("courses["+i+"].copies");
		int amount = price * copies;
		
		System.out.println(amount);
			
		}
		
		
		
	}

}
