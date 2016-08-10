package bike_station_analysis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Random_chosing_150_old_station_IDs {
	public static void main(String[]args) throws IOException{
		File writename = new File("randomly_chosen_82_stations.txt");
		writename.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(writename)); 
		
		
		File document_file = new File("old_bike_station_ID.txt");
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
		//System.out.println(docList.size());
		
		//Generate 150 random numbers
		ArrayList<Integer> random_number_list = new ArrayList<Integer>();
		for (int j=0;j<82;j++){
			int max = 333;
			int min = 0;
			int num = min + (int)(Math.random() * (max-min+1));
			random_number_list.add(num);
		}
		//System.out.println(random_number_list);
		
		//get the 158 old station IDs
		ArrayList<String> Generate_ID_list = new ArrayList<String>();
		for(int k=0;k<random_number_list.size();k++){
			int random_num = random_number_list.get(k);
			String Station_ID = docList.get(random_num);
			Generate_ID_list.add(Station_ID);
		}
		//System.out.println(Generate_ID_list);
		
		//print out the randomly chosen old station IDs
		try{             
			for (int m=0;m<Generate_ID_list.size();m++){
				System.out.println(Generate_ID_list.get(m));
				writer.write(Generate_ID_list.get(m)+"\n");
			}
	        writer.flush(); 
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
		writer.close();
		
		
	}

}
