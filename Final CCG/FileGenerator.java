package ccg;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileGenerator {
	
	public static void list_to_file(String FileName, ArrayList<String> list) throws IOException {
		FileWriter writer = new FileWriter(FileName); 

		for(int i=0; i<list.size(); i++) {
			String str = (String)list.get(i);
			writer.write(str);
			
			if(i<list.size()-1)
				writer.write("\n");
		}
		writer.close();
	}

}