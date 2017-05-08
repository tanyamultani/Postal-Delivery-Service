
public class Truck {
/**
 * initializing variables
 */
public String driverName;
public String destinationCity;
public String originCity;
public double grossWeight;
public double unloadedWeight;
public String additionalInfo;
Package[] pack;
/**
 * Default constructor 
 */
public Truck(){
	driverName = "";
	destinationCity = "----------";
    originCity = "-----------";
	grossWeight = 0;
	unloadedWeight = 0;
	additionalInfo = "";
	pack = null;
}
/**
 * constructor to create an object of type Truck
 * @param driverName
 * @param destinationCity
 * @param originCity
 * @param grossWeight
 * @param unloadedWeight
 * @param additionalInfo
 * @param pack
 */
public Truck(String driverName, String destinationCity, String originCity, double grossWeight, double unloadedWeight,
		String additionalInfo, Package[] pack) {
	this.driverName = driverName;
	this.destinationCity = destinationCity;
	this.originCity = originCity;
	this.grossWeight = grossWeight;
	this.unloadedWeight = unloadedWeight;
	this.additionalInfo = additionalInfo;
	this.pack = pack;
}
/**
 * accessor method for the name of the truck driver
 * @return driverName
 */
public String getDriverName() {
	return driverName;
}
/**
 * mutator method for the name of the truck driver
 * @param driverName
 */
public void setDriverName(String driverName) {
	this.driverName = driverName;
}
/**
 * accessor method for the destination of the truck 
 * @return destinationCity
 */
public String getDestinationCity() {
	return destinationCity;
}
/**
 * mutator method for the destination of the truck
 * @param destinationCity 
 */
public void setDestinationCity(String destinationCity) {
	this.destinationCity = destinationCity;
}
/**
 * accessor method for the originating city of the truck 
 * @return originCity
 */
public String getOriginCity() {
	return originCity;
}
/**
 * mutator method for the originating city of the truck
 * @param originCity 
 */
public void setOriginCity(String originCity) {
	this.originCity = originCity;
}
/**
 * accessor method for the gross weight of the truck 
 * @return grossWeight
 */
public double getGrossWeight() {
	return grossWeight;
}
/**
 * mutator method for the gross weight of the truck
 * @param grossWeight
 */
public void setGrossWeight(double grossWeight) {
	this.grossWeight = grossWeight;
}
/**
 * accessor method for the unloaded weight of the truck 
 * @return unloadedWeight
 */
public double getUnloadedWeight() {
	return unloadedWeight;
}
/**
 * mutator method for the unloaded weight of the package
 * @param unloadedWeight
 */
public void setUnloadedWeight(double unloadedWeight) {
	this.unloadedWeight = unloadedWeight;
}
/**
 * accessor method for additional information about the truck 
 * @return additionalInfo
 */
public String getAdditionalInfo() {
	return additionalInfo;
}
/**
 * mutator method for additional information about the truck
 * @param additionalInfo
 */
public void setAdditionalInfo(String additionalInfo) {
	this.additionalInfo = additionalInfo;
}
/**
 * accessor method for a package of the truck 
 * @return pack
 */
public Package[] getPack() {
	return pack;
}
/**
 * mutator method for a package of the truck
 * @param pack
 */
public void setPack(Package[] pack) {
	this.pack = pack;
}
/**
 * method to calculate the gross income earned by shipping costs for the packages
 * @return GrossIncome
 */
public double grossIncome(){
	int GrossIncome = 0;
	for(int i = 0; i<= pack.length; i++){
		double totalCost = pack[i].getShippingCost(); 
		GrossIncome += totalCost;
	}
	return GrossIncome;
}
/**
 * method to calculate gross weight of the truck with the packages in pounds
 * @return GrossWeight
 */
public double grossWeightInPounds(){
	double GrossWeight = getUnloadedWeight();
	toPounds(GrossWeight);
	for(int i =0; i<=pack.length; i++){
		double totalWeight = pack[i].getWeight();
		GrossWeight += totalWeight;
	}
	return GrossWeight;
}
/**
 * method to calculate gross weight of the truck with the packages in kilograms
 * @return GrossWeight
 */
public double grossWeightInKilograms(){
	double GrossWeight = grossWeightInPounds();
	toPounds(GrossWeight);
	return GrossWeight;
}
/**
 * Takes in the weight of the truck in pounds and converts it to kilograms
 * @param w
 */
public void toKilograms(double w){
	w = w * 0.453592;
}
/**
 * Takes in the weight of the truck in kilograms and converts it to pounds
 * @param w
 */
public void toPounds(double w){
	w = w*2.20462;
}
/**
 * Method to check if tracking number of package is unkwown or not. 
 * If exception is thrown, the package information is printed along with exception message
 * @param trackingNum
 * @param weight
 */
public void CheckIfUnknownPackage(int trackingNum, double weight){
	try{
		UnknownPackage(trackingNum,weight);
	}
	catch(PackageException pe){
	System.out.println("Package: Type = unknown package, Weight = " + weight + ", Tracking Number = " + trackingNum);	
	}
}
/**
 * Method to throw exception if tracking number of package is unknown
 * If the the tracking number is not unknown the program will continue normally
 * @param trackingNum
 * @param weight
 * @throws PackageException
 */
public void UnknownPackage(int trackingNum, double weight) throws PackageException {
	if(trackingNum != 0 && trackingNum != 1 && trackingNum != 2 && trackingNum != 3)
	throw new PackageException("This is an unknown package");
}
/**
 * Method to check if the number of packages loaded in the truck is more than 200 
 * If exception is thrown, the package information is printed along with exception message
 */
public void CheckIfTruckFull(){
	try{
		truckFull();
	}
	catch(PackageException pe){	
		pe.printStackTrace();
	}
}
/**
 * Method to throw exception if the number of packages loaded in the truck is more than 200.
 * If the the number of packages is less than or equal to 200 the program will continue normally
 * @throws PackageException
 */
public void truckFull() throws PackageException {
	if(CargoTest.PackageNum < 200)
	throw new PackageException("There is no space left in the truck for another package");
}
}
