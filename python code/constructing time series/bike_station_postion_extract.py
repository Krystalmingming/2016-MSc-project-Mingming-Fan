import csv

def processData():

    ride_per_day_testFile = open("/Users/Krystal/Documents/MSc project/intermediate data results for rideshare/new_added_bike_station_position", "w")
    trip_data_file = open("/Users/Krystal/Documents/MSc project/dataset/dataset from NYC website /bike/201510-citibike-tripdata.csv","rb")#edit here for different months

    reader = csv.reader(trip_data_file)
    print("successfully open the file")

    for line in reader:
        if line[0]!="tripduration":
            start_station = line[3]
            lat = line[5]
            long = line[6]
            print (start_station + '\t'+lat+'\t'+long+'\t'+'\n')
            ride_per_day_testFile.write(start_station + '\t'+lat+'\t'+long+'\t'+'\n')




if __name__ == '__main__':
	processData()