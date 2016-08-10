import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Ride_per_day_monthly {
	public static void main(String[]args) throws IOException{
		File document_file = new File("/Users/Krystal/Documents/MSc project/intermediate data results/ride_per_day_monthly_intermediate_result_13_12");
		BufferedReader reader_doc = null;
		ArrayList<String> docList = new ArrayList<String>();
		try {
			reader_doc = new BufferedReader(new FileReader(document_file));
			String tempString_doc = null;
			//read one line at a time for doc
			while ((tempString_doc = reader_doc.readLine()) != null) {
				docList.add(tempString_doc);
				}
			reader_doc.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		
		
		HashMap<String,Double> map = new HashMap<String,Double>();
		for (int i=0;i<docList.size();i++){
			String key = docList.get(i);
			if (map.containsKey(key)){
				double value = map.get(key);
				value = value + 1;
				map.put(key, value);					
			}else{
				map.put(key,1.0);
			}
		}
		//System.out.println(map);//for test
		for (String key : map.keySet()){
			System.out.println(key + "\t" + map.get(key) + "\n");
		}
		
			
	}
}
