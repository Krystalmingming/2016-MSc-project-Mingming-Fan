package bike_station_analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Analyze_bike_rides_new_added_stations {
	public static void main(String[]args) throws IOException{
		File document_file = new File("/Users/Krystal/Documents/MSc project/intermediate data results for rideshare/bike_ride_number_per_day_new_added_station_10");
		File document_file1 = new File("/Users/Krystal/Documents/MSc project/dataset/dataset from NYC website /bike/old_bike_stations_in_201508_without_position.txt");
		BufferedReader reader_doc = null;
		ArrayList<String> docList = new ArrayList<String>();
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
		//for test
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
		//for test
		//System.out.println(docList1.size());
		
		
		HashMap<String,Double> ID_map = new HashMap<String,Double>();
		for (int i=0;i<docList1.size();i++){
			String key = docList1.get(i);		
			if (ID_map.containsKey(key)){
				double value = ID_map.get(key);
				value = value + 1;
				ID_map.put(key, value);					
			}else{
				ID_map.put(key,1.0);
			}
		}
		//System.out.println(ID_map.size());
		
		HashMap<String,Double> map = new HashMap<String,Double>();
		for (int i=0;i<docList.size();i++){
			String key = docList.get(i).split("\t")[0];//the key for the map is the date
			String ID_value = docList.get(i).split("\t")[1];
			//for test
			//System.out.println(ID_value);
			//只有符合条件的是新增加的station ID才能放进map里面
			if(ID_map.containsKey(ID_value)){
				if(map.containsKey(key)){
					double value = map.get(key);
					value = value + 1;
					map.put(key, value);	
				}else{
					map.put(key, 1.0);
				}
			}
			
		}
		//System.out.println(map);
		for (String key : map.keySet()){
			System.out.println(key + "\t" + map.get(key) + "\n");
		}
	}
}
