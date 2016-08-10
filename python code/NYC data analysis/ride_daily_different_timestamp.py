import csv
import glob, os
def processData():
	ride_per_day_testFile = open("/Users/Krystal/Documents/MSc project/intermediate data results/ride_daily_different_timestamp_01", "w")
	trip_data_file = open("/Users/Krystal/Documents/MSc project/dataset/dataset from NYC website /yellow_tripdata_2015-01.csv","rb")#edit here for different months
	print("successfully open the file")
	reader = csv.reader(trip_data_file)

	for line in reader:
		line1 = line[1]
		if(line1!="tpep_pickup_datetime"):
			print(line1+'\n')
			ride_per_day_testFile.write(line1 + '\n')

if __name__ == '__main__':
	processData()