package PackageforExtraClasses;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
	
	public static JsonPath RawToJsons (String getadd )
	{
		
	JsonPath js2 = new JsonPath(getadd);
	
	return js2;
	
	
	
	}

}
