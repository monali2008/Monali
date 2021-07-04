package org.testing.utilities;

import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.*;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.response.Response;


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
	
	public static List<Object>parseJSONArray(Response res,String key,String extractKey)
	{
		
		List<Object>list=new ArrayList<Object>();
		JSONObject js=new JSONObject(res.asString());
		JSONArray arr=js.getJSONArray(key);
		for(int i=0;i<arr.length();i++)
		{
			JSONObject js1=arr.getJSONObject(i);
			Object js2=js1.get(extractKey);
			list.add(js2);
		}
		return list;
		
	}

}
