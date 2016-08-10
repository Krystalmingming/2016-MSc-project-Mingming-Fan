import csv

def processData():
    ride_per_day_testFile = open("/Users/Krystal/Documents/MSc project/intermediate data results for rideshare/positions_01", "w")
    trip_data_file = open("/Users/Krystal/Documents/MSc project/dataset/dataset from NYC website /yellow_tripdata_2015-01.csv","rb")#edit here for different months
    print("successfully open the file")
    reader = csv.reader(trip_data_file)

    for line in reader:
        line1 = line[5] #pickup longitude
        line2 = line[6] #pickup latitude
        line3 = line[1] #pickup date and time
        line4 = line[9] #dropoff longitude
        line5 = line[10] # dropoff latitude

        if line1 != "pickup_longitude" and line1 != "0":
            line6 = line3.split()[1].split(":")[0]
            line7 = line3.split()[1].split(":")[1]
            line8 = line3.split()[0]
            if line8 == "2015-01-15" and line6 == "14" and line7 == "00":#只要是2015年1月15日14:00:00-14:00:59的trip都提取出来
                print(line3 + '\t' + line1+'\t'+line2+'\t'+line4+'\t'+line5+'\n')
                ride_per_day_testFile.write(line1+'\t'+line2+'\t'+line4+'\t'+line5+'\n')

if __name__ == '__main__':
	processData()