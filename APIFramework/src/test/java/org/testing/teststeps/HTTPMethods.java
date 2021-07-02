package org.testing.teststeps;
import static io.restassured.RestAssured.*;

import java.util.Properties;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HTTPMethods {
	Properties pr;
	
	public HTTPMethods(Properties pr)
	{
		this.pr=pr;
	}
	
	public Response postRequest(String bodyData,String URIKey)
	{
		Response rs= given().contentType(ContentType.JSON).body(bodyData)
					 .when().post(pr.getProperty(URIKey));
		return rs;
	}
	
	public Response GetRequest(String URIKey,String pathparameter)
	{
		String uri=pr.getProperty(URIKey)+"/"+pathparameter;
		
		System.out.println("URI of Get request is: "+uri);
		
		Response rs= given().contentType(ContentType.JSON)
					 .when().get(uri);
		return rs;
	}
	
	public Response GetRequest(String URIKey)
	{
		
		Response rs= given().contentType(ContentType.JSON)
					 .when().get(pr.getProperty(URIKey));
		
		return rs;
	}
	
	public Response GetRequestQueryParameter(String URIKey,String queryparameter)
	{
		String uri=pr.getProperty(URIKey)+"?"+queryparameter;
		
		System.out.println("URI of Get all req request is: "+uri);
		
		Response rs= given().contentType(ContentType.JSON)
					 .when().get(uri);
		return rs;
	}
	
	public Response putRequest(String bodyData,String URIKey,String pathparameter)
	{
		String uri=pr.getProperty(URIKey)+"/"+pathparameter;
		Response rs= given().contentType(ContentType.JSON).body(bodyData)
					 .when().put(uri);
		
		System.out.println("URI of put request is: "+uri);
		return rs;
	}
	
	public Response DeleteRequest(String URIKey,String pathparameter)
	{
		String uri=pr.getProperty(URIKey)+"/"+pathparameter;
		
		Response rs= given().contentType(ContentType.JSON)
					 .when().delete(uri);
		
		System.out.println("URI of Delete request ia: "+uri);
		return rs;
	}

}
