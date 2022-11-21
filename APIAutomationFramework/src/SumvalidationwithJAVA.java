import org.testng.Assert;

import PackageforExtraClasses.payloads;
import io.restassured.path.json.JsonPath;

public class SumvalidationwithJAVA {

	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(payloads.complexresponse());
		
		int size =js.getInt("courses.size()");
		//System.out.println(size);
		int sum=0;
		//To get the total amount got on books
		
		for (int i=0;i<size;i++)
			
		{
			
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			//System.out.println(price);
			//System.out.println(copies);
			
			int amount = price*copies;
			//System.out.println(amount);
			sum=sum+amount;
		}
			System.out.println(sum);
			int purchaseamount = js.getInt("dashboard.purchaseAmount");
			Assert.assertEquals(sum,purchaseamount );
	}

}
