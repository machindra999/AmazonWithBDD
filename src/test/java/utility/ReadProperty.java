package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	
	
	public static String getPropData(String dataToBeRead) throws IOException {
		String pathOfFile = System.getProperty("user.dir") + "//src//test//resources//config.properties";

		FileInputStream fis = new FileInputStream(pathOfFile);

		Properties prop = new Properties();

		prop.load(fis);

		String value = prop.getProperty(dataToBeRead);

		System.out.println(value);

		return value;

	}

}
