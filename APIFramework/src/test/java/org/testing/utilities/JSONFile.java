package org.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JSONFile {
	
	public static String readJson(String path) throws FileNotFoundException
	{
		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);
		JSONTokener js=new JSONTokener(fis);
		JSONObject ob=new JSONObject(js);
		return ob.toString();
	}

}
