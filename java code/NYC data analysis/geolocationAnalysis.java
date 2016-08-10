import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class geolocationAnalysis {
	public static void main(String[]args) throws IOException{
		
		File writename = new File("geolocation_analysis_output.txt"); //create a new output file to store BM25 results
		writename.createNewFile(); 
		BufferedWriter writer = new BufferedWriter(new FileWriter(writename)); 
		
		File document_file = new File("/Users/Krystal/Documents/MSc project/intermediate data results/address_01");
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
				String[] list = docList.get(i).split(",");
				int len = list.length;
				String postcode = list[len-2];
				//System.out.println(postcode + "\t" + docList.get(i));
				if(map.containsKey(postcode)){
					double value = map.get(postcode) + 1.0;
					map.put(postcode, value);
				}else{
					map.put(postcode,1.0);
				}
		}
		
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
