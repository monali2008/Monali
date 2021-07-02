package org.testing.utilities;

import org.json.JSONObject;

public class JsonParsingUsingOrgJson {
	
	public static String jsoParse(String data,String extractKey)
	{
		if(data.startsWith("{"))
		{
			JSONObject js=new JSONObject(data);
			return js.getString(extractKey);
		}
		return extractKey;
		
	}

}
