package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties= new Properties();

	 static {
		 try (InputStream input = ConfigReader.class
	                .getClassLoader()
	                .getResourceAsStream("config.properties")) {

	            if (input == null) {
	                throw new RuntimeException("config.properties not found in resources folder!");
	            }
	            properties.load(input);

	        }  catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to load config.properties file.");
	        }
	    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
