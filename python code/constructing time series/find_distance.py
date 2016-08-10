#the result is in km(kilometer)

lon1 = -77.037852
lat1 = 38.898556
lon2 = -77.043934
lat2 = 38.897147

from math import cos, asin, sqrt
def distance(lat1, lon1, lat2, lon2):
    p = 0.017453292519943295
    a = 0.5 - cos((lat1 - lat2) * p)/2 + cos(lat1 * p) * cos(lat2 * p) * (1 - cos((lon1 - lon2) * p)) / 2
    print 12742 * asin(sqrt(a))
    return 12742 * asin(sqrt(a))

if __name__ == '__main__':
	distance(lat1,lon1,lat2,lon2)


