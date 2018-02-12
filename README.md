# ATMBranchLocator
Implemented ATM/ Branch Locator for Chase Bank using their public API


######## The app includes the following features:
- a. Implemented MVP design pattern for FindATM activity.
- b. Used LocationManager and LocationListener to get user's current location. 
- c. Implemented run time permission for Location access
- d. Used Retrofit-2 as HTTP client to make REST calls to the API.
- e. RecyclerView to show branch/atm list
- f. Used Google Maps API to show maps with marker for the brnach location.\
- g. BranchDetailsActivity features two fragments; mapsFragment and branchDetailsFragment


####### To do: 
- a. Add current location overlay in Maps in BranchDetailsActivity
- b. Implement search fragment to ask the user to enter the zip code and get branch list accordingly
