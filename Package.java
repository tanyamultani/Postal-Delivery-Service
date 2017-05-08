/**
 * A class that stores the tracking number, the weight, the type and the shipping cost of a package
 */
public abstract class Package {
/**
 * variable are initialized	
 */
public int trackingNum;
public double weight;
public String type;
public double shippingCost;

/**
 * Default constructor method
 */
public Package(){
	trackingNum = 0;
	weight = 0;
	type = "";
	shippingCost = 0;
}
/**
 * constructor to create an object of type Package
 * @param trackingNum for tracking number of package
 * @param weight for weight of package
 * @param type for type of package
 * @param shippingCost for shipping cost of package
 */
public Package(int trackingNum, double weight, String type, double shippingCost) {
	this.trackingNum = trackingNum;
	this.weight = weight;
	this.type = type;
	this.shippingCost = shippingCost;
}
/**
 * accessor method for the tracking number of the package
 * @return trackingNum
 */
public int getTrackingNum() {
	return trackingNum;
}
/**
 * mutator method for the tracking number of the package
 * @param trackingNum a integer value for the tracking number of the package
 */
public void setTrackingNum(int trackingNum) {
	this.trackingNum = trackingNum;
}
/**
 * accessor method for the weight of the package
 * @return weight
 */
public double getWeight() {
	return weight;
}
/**
 * mutator method for the weight of the package
 * @param weight a double value for the weight of the package
 */
public void setWeight(double weight) {
	this.weight = weight;
}
/**
 * accessor method for the type of the package
 * @return type
 */
public String getType() {
	return type;
}
/**
 * mutator method for the type of package
 * @param type a String for the type of package
 */
public void setType(String type) {
	this.type = type;
}
/**
 * accessor method for the shipping cost of the package
 * @return shippingCost
 */
public double getShippingCost() {
	return shippingCost;
}
/**
 * mutator method for the shipping cost of the package
 * @param shippingCost a double value for the shipping cost of the package
 */
public void setShippingCost(double shippingCost) {
	this.shippingCost = shippingCost;
}
/**
 * abstract method to calculate shipping cost for different types of packages(further used in other classes)
 */
public abstract void shippingCosts();

/**
 * abstract method to throw exception if weight is higher than maximum allowed(further used in other classes)
 * @param weight
 * @throws PackageException
 */
public abstract void load(double weight) throws PackageException;

/**
 * Method which returns a string containing information of the object of class Package
 * @return tracking number, type, weight and shipping cost of package
 */
@Override
public String toString() {
	return "Package:  Type = " + type + ", Tracking Number = " + trackingNum +  ", Weight = " + weight + "lb / " + (weight*16) + "oz , Shipping Cost = "
			+ shippingCost;
}
/**
 * Method which returns a string containing information of the object of class Package for exception handling only
 * @return tracking number, type and weight of package
 */
public String exceptionString(){
	return "Package:  Type = " + type + ", Tracking Number = " + trackingNum +  ", Weight = " + weight;
}
/**
 * Takes in the weight of the package in pounds and converts it to ounces
 * @param weight
 */
public void toOunces(double weight){
	weight = weight * 16;
}
/**
 * Takes in the weight of the package in ounces and converts it to pounds
 * @param weight
 */
public void toPounds(double weight){
	weight = weight/16;
}

}
