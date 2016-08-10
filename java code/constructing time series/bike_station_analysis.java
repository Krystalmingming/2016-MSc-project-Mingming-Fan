package bike_station_analysis;

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

public class bike_station_analysis {
	
	public static void main(String[]args) throws IOException{
		
		//create the output file
		File writename = new File("new_added_bike_station_ID.txt"); //create a new output file to store BM25 results
		File writename1 = new File("old_bike_station_ID.txt");
		writename.createNewFile(); 
		writename1.createNewFile(); 
		BufferedWriter writer = new BufferedWriter(new FileWriter(writename)); 
		BufferedWriter writer1 = new BufferedWriter(new FileWriter(writename1)); 
		
		
		File document_file = new File("/Users/Krystal/Documents/MSc project/intermediate data results for rideshare/bike_start_station_15_08-16_06");
		File document_file1 = new File("/Users/Krystal/Documents/MSc project/intermediate data results for rideshare/bike_start_station_15_01-07");
		BufferedReader reader_doc = null;
		ArrayList<String> docList = new ArrayList<String>();
		ArrayList<String> docList_new = new ArrayList<String>();
		ArrayList<String> new_station_list = new ArrayList<String>();//this list is to store the new added station IDs
		
		//read the file after adding the new stations
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
		//test
		//System.out.println(docList.get(0));
		
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
		
		HashMap<String,Double> map_new = new HashMap<String,Double>();
		for (int i=0;i<docList_new.size();i++){
			String key = docList_new.get(i);
			if (map_new.containsKey(key)){
				double value = map_new.get(key);
				value = value + 1;
				map_new.put(key, value);					
			}else{
				map_new.put(key,1.0);
			}
		}
		
		//test
		//for (String key : map.keySet()){
			//System.out.println(key + "\t" + map.get(key) + "\n");
			//System.out.println(key+"\n");
		//}
		
		//to find out the keys in map that map_new don't have
		for(String key : map.keySet()){
			if(map_new.containsKey(key)==false){
				new_station_list.add(key);
			}
		}
		//for test
		//System.out.println(new_station_list.size());
		
		//write the new added station names into a file
		try{             
			for (int i =0;i<new_station_list.size();i++){
				System.out.println(new_station_list.get(i));
				writer.write(new_station_list.get(i)+"\n");
			}
	        writer.flush(); 
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
		writer.close();	
		try{             
			for (String key : map_new.keySet()){
			//System.out.println(key + "\t" + map_new.get(key) + "\n");
			System.out.println(key+"\n");
			writer1.write(key+"\n");
		}
	        writer1.flush(); 
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
		writer1.close();
		
	}

}
