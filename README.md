# ATMBranchLocator
Implemented ATM/ Branch Locator for Chase Bank using their public API


######  The app includes the following features:
- Implemented MVP design pattern for FindATM activity.
- Used LocationManager and LocationListener to get user's current location. 
- Implemented run time permission for Location access
- Used Retrofit-2 as HTTP client to make REST calls to the API.
- RecyclerView to show branch/atm list
- Used Google Maps API to show maps with marker for the brnach location.\
- BranchDetailsActivity features two fragments; mapsFragment and branchDetailsFragment
- Used Espresso for Instrumentation tests


######  To do: 
- Add current location overlay in Maps in BranchDetailsActivity
- Implement search fragment to ask the user to enter the zip code and get branch list accordingly
- Add more test cases
