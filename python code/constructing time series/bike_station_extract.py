#this piece of code is to extract the bike station IDs appears for different months
import googlemaps
from datetime import datetime
import csv

def processData():

    ride_per_day_testFile = open("/Users/Krystal/Documents/MSc project/intermediate data results for rideshare/bike_start_station_16_06", "w")
    trip_data_file = open("/Users/Krystal/Documents/MSc project/dataset/dataset from NYC website /bike/201606-citibike-tripdata.csv","rb")#edit here for different months
    reader = csv.reader(trip_data_file)
    print("successfully open the file")

    for line in reader:
        if line[0]!="tripduration":
            start_station = line[3]
            print start_station
            ride_per_day_testFile.write(start_station+'\n')


if __name__ == '__main__':
	processData()