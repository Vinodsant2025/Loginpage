package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadData {

	
	public static String readpropertyFile(String value) throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\eclipse\\OctoberBatch20025\\src\\main\\java\\config\\Config.properties");
		prop.load(file);
		
		return prop.getProperty(value);
		
	}
	
	
	
	
	
	
	
	
}
