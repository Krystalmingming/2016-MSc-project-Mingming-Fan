import googlemaps
import re
from datetime import datetime

gmaps = googlemaps.Client(key='AIzaSyCTds1pqsppntk1Ly8XdLLt4P13ULjZUpc')
gmaps = googlemaps.Client(key='AIzaSyCE3pWap3fJcnEKn5P_SyPibhZNCvMtW_U')


# Request directions via public transit
now = datetime.now()
directions_result = gmaps.directions((40.72771835,-74.00305176),
                                     (40.76396942,-73.97603607),
                                     mode="driving",
                                     departure_time=now)
reverse_geocode_result = gmaps.reverse_geocode((40.714224, -73.961452))
print reverse_geocode_result

result_len = len(directions_result[0]['legs'][0]['steps'])

for i in range (0,result_len):
    #print directions_result[0]['legs'][0]['steps'][i]['html_instructions'] # this is to get the specific route between two locations
    #print directions_result[0]['legs'][0]['steps'][i]['distance']#this is to get the distance between two locations
    line = directions_result[0]['legs'][0]['steps'][i]['html_instructions']
    #print(line)
    list = line.split("</b>")
    #print list
    for j in range (0,len(list)):
        line1 = list[j]
        list1 = line1.split("<b>")
        if len(list1)>1:
            if list1[len(list1)-1]!="right" and list1[len(list1)-1]!="left" and list1[len(list1)-1]!="southwest" and list1[len(list1)-1]!="west" and list1[len(list1)-1]!="southeast" and list1[len(list1)-1]!="northwest" and list1[len(list1)-1]!="southeast" and list1[len(list1)-1]!="south" and list1[len(list1)-1]!="north" and list1[len(list1)-1]!="east":
                print list1[len(list1)-1]


