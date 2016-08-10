import csv
import glob, os
def processData():
    payment_testFile = open("/Users/Krystal/Documents/MSc project/intermediate data results/payment_distribution_12", "w")
    trip_data_file = open("/Users/Krystal/Documents/MSc project/dataset/dataset from NYC website /yellow_tripdata_2015-12.csv","rb")
    print("successfully open the file")
    reader = csv.reader(trip_data_file)

    for line in reader:
        payment = line[18]
        if(payment!="total_amount"):
            print(payment + '\n')
            payment_testFile.write(payment + '\n')

if __name__ == '__main__':
	processData()


