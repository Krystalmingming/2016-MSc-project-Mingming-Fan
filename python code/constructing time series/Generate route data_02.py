# this code is to write the street names that the trips have passed into a file, as well as the lat and long of there origins
import googlemaps
from datetime import datetime

def processData():
    #get the client key
    gmaps = googlemaps.Client(key='AIzaSyCTds1pqsppntk1Ly8XdLLt4P13ULjZUpc')
    gmaps = googlemaps.Client(key='AIzaSyCE3pWap3fJcnEKn5P_SyPibhZNCvMtW_U')

    ride_per_day_testFile = open("/Users/Krystal/Documents/MSc project/intermediate data results for rideshare/routes_01", "w")
    trip_data_file = open("/Users/Krystal/Documents/MSc project/intermediate data results for rideshare/positions_01","rb")#edit here for different months
    print("successfully open the file")

    for line in trip_data_file:
        list = line.split()
        now = datetime.now()
        directions_result = gmaps.directions((list[1],list[0]),
                                     (list[3],list[2]),
                                     mode="driving",
                                     departure_time=now)

        result_len = len(directions_result[0]['legs'][0]['steps'])
        ride_per_day_testFile.write(list[1] + '\t' + list[0] + '\t')

        for i in range (0,result_len):
            final_result = directions_result[0]['legs'][0]['steps'][i]['html_instructions']
            #print final_result
            #ride_per_day_testFile.write(final_result+'\n')
            list = final_result.split("</b>")
            for j in range (0,len(list)):
                line1 = list[j]
                list1 = line1.split("<b>")
                if len(list1)>1:
                    if list1[len(list1)-1]!="right" and list1[len(list1)-1]!="left" and list1[len(list1)-1]!="southwest" and list1[len(list1)-1]!="west"and list1[len(list1)-1]!="southeast" and list1[len(list1)-1]!="south" and list1[len(list1)-1]!="north" and list1[len(list1)-1]!="east" and list1[len(list1)-1]!="northeast" and list1[len(list1)-1]!="northwest":
                        print list1[len(list1)-1]
                        ride_per_day_testFile.write(list1[len(list1)-1]+'\t')


        ride_per_day_testFile.write('\n')
        print("\n")


if __name__ == '__main__':
	processData()