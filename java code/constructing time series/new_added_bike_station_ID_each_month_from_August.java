package bike_station_analysis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class new_added_bike_station_ID_each_month_from_August {
	public static void main(String[]args) throws IOException{
		File writename = new File("new_added_bike_station_ID_201512.txt"); //create a new output file to store BM25 results
		writename.createNewFile(); 
		BufferedWriter writer = new BufferedWriter(new FileWriter(writename)); 
		
		
		File document_file = new File("/Users/Krystal/Documents/MSc project/dataset/dataset from NYC website /bike/new_added_station_IDs_total.txt");
		File document_file1 = new File("/Users/Krystal/Documents/MSc project/intermediate data results for rideshare/bike_start_station_16_06");
		BufferedReader reader_doc = null;
		ArrayList<String> docList = new ArrayList<String>();
		ArrayList<String> docList_new = new ArrayList<String>();
		ArrayList<String> new_station_list = new ArrayList<String>();//this list is to store the new added station IDs
		
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
		
		//read the file before adding the new stations
		try {
			reader_doc = new BufferedReader(new FileReader(document_file1));
			String tempString_doc = null;
			//read one line at a time for doc
			while ((tempString_doc = reader_doc.readLine()) != null) {
				docList_new.add(tempString_doc);
				}
			reader_doc.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		
		//System.out.println(docList);
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
		//System.out.println(map);
		
		HashMap<String,Double> map_new_station = new HashMap<String,Double>();
		for (int i=0;i<docList_new.size();i++){
			String station_ID = docList_new.get(i);
			if(map.containsKey(station_ID)){
				map_new_station.put(station_ID, 1.0);
			}
		}
		//System.out.println(map_new_station.size());
		try{             
			for (String key : map_new_station.keySet()){
			//System.out.println(key + "\t" + map_new.get(key) + "\n");
			System.out.println(key);
			writer.write(key+"\n");
		}
	        writer.flush(); 
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
		writer.close();
	}

}
