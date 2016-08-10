package bike_station_analysis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class extract_new_added_bike_station_postion {
	public static void main(String[]args) throws IOException{
		
		File writename = new File("old_bike_stations_in_201508_position.txt");
		writename.createNewFile(); 
		BufferedWriter writer = new BufferedWriter(new FileWriter(writename)); 
		
		
		File document_file = new File("/Users/Krystal/Documents/MSc project/intermediate data results for rideshare/old_bike_stations_in_201508_position.txt");
		File document_file1 = new File("randomly_chosen_82_stations.txt");
		
		BufferedReader reader_doc = null;
		ArrayList<String> docList = new ArrayList<String>();//positions
		ArrayList<String> docList1 = new ArrayList<String>();
		
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
		//System.out.println(docList);
		
		try {
			reader_doc = new BufferedReader(new FileReader(document_file1));
			String tempString_doc = null;
			//read one line at a time for doc
			while ((tempString_doc = reader_doc.readLine()) != null) {
				docList1.add(tempString_doc);
				}
			reader_doc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		//System.out.println(docList1);
		
		HashMap<String,String> position_map = new HashMap<String,String>();
		for (int i=0;i<docList.size();i++){
			String key = docList.get(i).split("\t")[0];
			String latitude = docList.get(i).split("\t")[1];
			String longitude = docList.get(i).split("\t")[2];
			String value = latitude + "\t" + longitude;
			if (position_map.containsKey(key)){
				position_map.put(key, value);					
			}else{
				position_map.put(key,value);
			}
		}
		//for test
		//System.out.println(position_map);
		
		try{             
			for(int i=0;i<docList1.size();i++){
				String ID = docList1.get(i);
				if (position_map.containsKey(ID)){
					System.out.println(ID + "\t" + position_map.get(ID));
					writer.write(ID + "\t" + position_map.get(ID));
					writer.write("\n");
				}
			}
	        writer.flush(); 
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
		writer.close();
		
		
		
		
	}

}
