package org.testing.utilities;

import io.restassured.response.Response;

public class JsonParseUsingJsonPath {
	
	//It will return the value corresponding to JsonPath which we are giving to this method
	public static String jsonParsing(Response res,String jsonPath)
	{
		return res.jsonPath().getString(jsonPath);
	}

}
