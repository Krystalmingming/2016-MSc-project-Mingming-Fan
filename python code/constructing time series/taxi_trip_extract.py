import csv

def processData():

    ride_per_day_testFile = open("/Users/Krystal/Documents/MSc project/intermediate data results for rideshare/taxi_trip_15_08", "w")
    trip_data_file = open("/Users/Krystal/Documents/MSc project/dataset/dataset from NYC website /yellow_tripdata_2015-08.csv","rb")#edit here for different months
    reader = csv.reader(trip_data_file)
    print("successfully open the file")

    for line in reader:
        if line[0]!="VendorID":
            date = line[1].split(' ')[0]
            latitude = line [6]
            longitude = line[5]
            if latitude!="0":
                print (date + '\t' + latitude + '\t' + longitude + '\t')
                ride_per_day_testFile.write(date + '\t' + latitude + '\t' + longitude + '\t')


if __name__ == '__main__':
	processData()