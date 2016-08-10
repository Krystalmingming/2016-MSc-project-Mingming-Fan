import glob, os
from geopy.geocoders import Nominatim
def processData():
    ride_per_day_testFile = open("/Users/Krystal/Documents/MSc project/intermediate data results/address_01", "r+a")
    trip_data_file = open("/Users/Krystal/Documents/MSc project/intermediate data results/geolocation_01","rb")#edit here for different months
    print("successfully open the file")
    geolocator = Nominatim()

    while trip_data_file.readline() != None:
        line = trip_data_file.readline().split()
        longitude = line [0]
        latitude = line [1]
        postition = latitude + ',' + longitude
        #print (longitude + '\t' + latitude + '\n')
        location = geolocator.reverse(postition)
        print(location.address)
        ride_per_day_testFile.write(location.address + '\n')


if __name__ == '__main__':
	processData()