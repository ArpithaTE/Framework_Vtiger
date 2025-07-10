package own.framework.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility_Own {

	public String getDataFromPropertiesFile(String key) throws Exception {
		FileInputStream fis = new FileInputStream("./src/main/resources/commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		return data;
	}

}
