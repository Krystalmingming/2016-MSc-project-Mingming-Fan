import csv

def processData():

    ride_per_day_testFile = open("/Users/Krystal/Documents/MSc project/intermediate data results for rideshare/bike_ride_number_per_day_new_added_station_08", "w")
    trip_data_file = open("/Users/Krystal/Documents/MSc project/dataset/dataset from NYC website /bike/201508-citibike-tripdata.csv","rb")#edit here for different months
    new_added_station_file = open("/Users/Krystal/Documents/MSc project/dataset/dataset from NYC website /bike/new_added_bike_station_ID.txt","rb")
    reader = csv.reader(trip_data_file)
    print("successfully open the file")

    #put all the 158 new added station IDs into a list
    #result = []
    #dict = {}
    #for station_ID in new_added_station_file:
        #dict[station_ID]=1
    #for key, value in dict.iteritems():
    for line in reader:
        if line[0]!="tripduration":
            date = line[1].split(' ')[0]
            station_ID = line [3]
            print(date + '\t'+ station_ID + '\n')
            ride_per_day_testFile.write(date + '\t'+ station_ID + '\n')







if __name__ == '__main__':
	processData()