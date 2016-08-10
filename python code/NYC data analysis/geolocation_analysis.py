from geopy.geocoders import Nominatim
geolocator = Nominatim()
location = geolocator.reverse("40.75011063,-73.99389648")
print(location.address)