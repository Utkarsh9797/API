import org.testng.Assert;
import org.testng.annotations.Test;

import PackageforExtraClasses.payloads;
import io.restassured.path.json.JsonPath;

public class SumValidatione_exampleWithTestNG {
	
	@Test
	
	public void sumvalidation ()
	
	{
		int sum = 0;
		JsonPath js = new JsonPath (payloads.complexresponse());
		
		int count = js.getInt("courses.size()");
		
		for (int i=0; i<count ; i++)
			
		{   
			
			
		int price=	js.getInt("courses["+i+"].price");
			
		int copies=	js.getInt("courses["+i+"].copies");
		int amount = price * copies;
		System.out.println(amount);
		 sum = sum + amount;
			
		}
		
		System.out.println(sum);
		int purchaseamt = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseamt);
		
	}

}
