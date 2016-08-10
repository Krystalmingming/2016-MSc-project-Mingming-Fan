import csv
import glob, os
from geopy.geocoders import Nominatim
def processData():
    ride_per_day_testFile = open("/Users/Krystal/Documents/MSc project/intermediate data results/geolocation_01", "w")
    trip_data_file = open("/Users/Krystal/Documents/MSc project/dataset/dataset from NYC website /yellow_tripdata_2015-01.csv","rb")#edit here for different months
    print("successfully open the file")
    reader = csv.reader(trip_data_file)
    geolocator = Nominatim()

    for line in reader:
        line1 = line[5]
        line2 = line[6]
        if line1 != "pickup_longitude":
            print(line1+'\t'+line2+'\n')
            ride_per_day_testFile.write(line1+'\t'+line2+'\n')

if __name__ == '__main__':
	processData()
