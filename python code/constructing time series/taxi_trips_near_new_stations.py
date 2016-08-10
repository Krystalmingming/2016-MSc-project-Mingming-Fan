import csv
from math import cos, asin, sqrt

def processData():
    ride_per_day_testFile = open("/Users/Krystal/Documents/MSc project/intermediate data results for rideshare/taxi_trip_201512_near_new_stations", "w")
    station_ID_file = open("/Users/Krystal/Documents/MSc project/dataset/dataset from NYC website /bike/new_added_bike_stations_in_201508.txt")
    trip_data_file = open("/Users/Krystal/Documents/MSc project/dataset/dataset from NYC website /yellow_tripdata_2015-12.csv","rb")#edit here for different months
    reader = csv.reader(trip_data_file)
    print("successfully open the file")
    distance_max = 0.6

    for line1 in station_ID_file:
        station_ID = line1.split("\t")[0]
        latitude_bike = float(line1.split("\t")[1])
        longitude_bike = float(line1.split("\t")[2])
        #print (latitude_bike*longitude_bike)
        for line2 in reader:
            if line2[0]!="VendorID":
                date = line2[1].split(" ")[0]
                latitude_taxi = float(line2[6])
                longitude_taxi = float(line2[5])

                p = 0.017453292519943295
                a = 0.5 - cos((latitude_bike - latitude_taxi) * p)/2 + cos(latitude_bike * p) * cos(latitude_taxi * p) * (1 - cos((longitude_bike - longitude_taxi) * p)) / 2
                distance =  12742 * asin(sqrt(a))

                if distance <= distance_max:
                    print(date + "\t" + str(distance)+"\n")
                    ride_per_day_testFile.write(date+"\n")


if __name__ == '__main__':
	processData()