import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import PackageforExtraClasses.ReusableMethods;
import PackageforExtraClasses.payloads;

import static io.restassured.RestAssured.*;

public class Basic {

	public static void main(String[] args) {
		
		// Post Address and details

 RestAssured.baseURI = "https://rahulshettyacademy.com";
 String getDetails = given().log().all().header("Content-Type","application/json").queryParam("Key","qaclick123").body(payloads.AddPlace()).when().post("/maps/api/place/add/json").
then().log().all().assertThat().statusCode(200).extract().response().asString();

System.out.println(getDetails);

JsonPath js = new JsonPath(getDetails);
String placeid = js.getString("place_id");
System.out.println(placeid);

// Update the address

String newaddress="CST, USA";

given().queryParam("Key","qaclick123").header("Content-Type","application/json").
body("{\r\n"
		+ "\"place_id\":\""+placeid+"\",\r\n"
		+ "\"address\":\""+newaddress+"\",\r\n"
		+ "\"key\":\"qaclick123\"\r\n"
		+ "}")
.when().put("/maps/api/place/update/json").then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));


String getadd = given().queryParam("key","qaclick123").queryParam("place_id",placeid).when().get("/maps/api/place/get/json").then().assertThat().statusCode(200).extract()
.response().asString();

JsonPath js2 = ReusableMethods.RawToJsons(getadd);
String actualaddress = js2.getString("address");
Assert.assertEquals(newaddress, actualaddress);


//System.out.println(actualaddress);


	}
	
	

}
