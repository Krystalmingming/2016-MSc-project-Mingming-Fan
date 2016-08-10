import googlemaps
from datetime import datetime
import csv

def processData():
    #get the client key
    gmaps = googlemaps.Client(key='AIzaSyCTds1pqsppntk1Ly8XdLLt4P13ULjZUpc')
    gmaps = googlemaps.Client(key='AIzaSyCE3pWap3fJcnEKn5P_SyPibhZNCvMtW_U')

    ride_per_day_testFile = open("/Users/Krystal/Documents/MSc project/intermediate data results for rideshare/bike_15_03", "w")
    trip_data_file = open("/Users/Krystal/Documents/MSc project/dataset/dataset from NYC website /bike/201501-citibike-tripdata.csv","rb")#edit here for different months
    reader = csv.reader(trip_data_file)
    print("successfully open the file")

    for line in reader:
        if line[0]!="tripduration":
            lat = line[5]
            long = line[6]
            position = lat + ',' + long
            reverse_geocode_result = gmaps.reverse_geocode(position)
            street_name = reverse_geocode_result[0]['formatted_address'].split(',')[0]
            print street_name
            ride_per_day_testFile.write(street_name+'\n')
if __name__ == '__main__':
	processData()