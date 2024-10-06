package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {


		FileReader fr = new FileReader("C:\\Users\\a817056\\eclipse-workspace\\TodosAutomation\\src\\test\\resources\\configfiles\\Config.properties");
		
		Properties p = new Properties();
		
		p.load(fr);
		

	}

}
