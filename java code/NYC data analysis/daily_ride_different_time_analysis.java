import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class daily_ride_different_time_analysis {
	public static void main(String[]args) throws IOException{
		File writename = new File("daily_ride_different_time_output.txt"); //create a new output file to store BM25 results
		writename.createNewFile(); 
		BufferedWriter writer = new BufferedWriter(new FileWriter(writename)); 
		
		File document_file = new File("/Users/Krystal/Documents/MSc project/intermediate data results/ride_daily_different_timestamp_01");
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
				String[] list = docList.get(i).split(" ");
				String date = list [0];
				String timestamp = list [1];
				//System.out.println(date);
				if (date.equals("2015-01-16")){//edit here for different dates
					String hour = timestamp.split(":") [0];
					//System.out.println("!!!");
					if (map.containsKey(hour)){
						double value = map.get(hour);
						value = value + 1;
						map.put(hour, value);					
					}else{
						map.put(hour,1.0);
					}
				}						
		}
		
		//write the output to a file
		try{             
			for (String key : map.keySet()){
				System.out.println(key + "\t" + map.get(key) + "\n");
				writer.write(key + "\t" + map.get(key) + "\n");
				}
	        writer.flush(); 
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
		writer.close();		
	}
}
