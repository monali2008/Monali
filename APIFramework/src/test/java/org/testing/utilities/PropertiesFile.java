package org.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesFile {
	
	public static Properties readProperties(String path) throws IOException
	{
		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);
		Properties pr=new Properties();
		pr.load(fis);
		return pr;
	}

}
