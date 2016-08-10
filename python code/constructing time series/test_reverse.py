import googlemaps
import re
from datetime import datetime

gmaps = googlemaps.Client(key='AIzaSyCTds1pqsppntk1Ly8XdLLt4P13ULjZUpc')
gmaps = googlemaps.Client(key='AIzaSyCE3pWap3fJcnEKn5P_SyPibhZNCvMtW_U')

reverse_geocode_result = gmaps.reverse_geocode((40.75323098,-73.97032517))

list_addr = reverse_geocode_result[0]['formatted_address'].split(',')
list_len = len(list_addr)
print(list_len)
list_zip = list_addr[list_len - 2].split(' ')[2]
print(list_zip)
print reverse_geocode_result[0]['formatted_address'].split(',')#get the real address given the lat and long
print reverse_geocode_result[0]['formatted_address'].split(',')[0] # get the street name of the given lat and long