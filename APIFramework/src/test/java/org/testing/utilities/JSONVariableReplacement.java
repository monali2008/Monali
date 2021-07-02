package org.testing.utilities;

import java.util.regex.Pattern;

public class JSONVariableReplacement {
	
	public static String jsonReplace(String data,String variableName,String variableValue)
	{
		data= data.replaceAll(Pattern.quote("{{"+variableName+"}}"), variableValue);
		return data;
	}

}
