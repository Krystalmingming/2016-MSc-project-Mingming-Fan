import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class payment_distribution_analysis {
	public static void main(String[]args) throws IOException{
		File document_file = new File("/Users/Krystal/Documents/MSc project/intermediate data results/payment_distribution_12");
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
		map.put("A", 0.0);
		map.put("B", 0.0);
		map.put("C", 0.0);
		map.put("D", 0.0);
		map.put("E", 0.0);
		map.put("F", 0.0);
		map.put("G", 0.0);
		
		for (int i=0;i<docList.size();i++){
			double value = Double.parseDouble(docList.get(i));
			if(value <= 10.0 && value > 0.0){
				double num = map.get("A") + 1;
				map.put("A", num);
			}else if(value >10.0 && value <=20.0){
				double num = map.get("B") + 1;
				map.put("B",num);
			}else if (value >20.0 && value <=30.0){
				double num = map.get("C") + 1;
				map.put("C",num);
			}else if (value >30.0 && value <=40.0){
				double num = map.get("D") + 1;
				map.put("D",num);
			}else if (value >40.0 && value <=50.0){
				double num = map.get("E") + 1;
				map.put("E",num);
			}else if (value > 50.0 && value < 60.0){
				double num = map.get("F") + 1;
				map.put("F",num);
			}else if (value > 60.0){
				double num = map.get("G") + 1;
				map.put("G",num);
			}
		}
		//System.out.println(map);
		for (String key : map.keySet()){
			System.out.println(key + "\t" + map.get(key) + "\n");
		}
	}
}
