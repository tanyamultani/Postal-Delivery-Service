/**
 * A class that inherits from class Package to create object with same attributes but of type Letter with different methods 
 */
public class Letter extends Package {
/**
 * Default constructor inherited from class Package
 */
	public Letter() {
		super();
	}
	/**
	 * constructor method to create an object of type Letter inherited from class Package 
	 * @param trackingNum
	 * @param weight
	 * @param type
	 * @param shippingCost
	 */

	public Letter(int trackingNum, double weight, String type, double shippingCost) {
		super(trackingNum, weight, type, shippingCost);
	}
	
	/**
	 * Abstract method to calculate shipping cost for package of type Letter overriden from class Package.
	 * If exception is thrown, the package information is printed along with exception message
	 */
	@Override
	public void shippingCosts() {
    try{
    	load(weight);
    }
    catch(PackageException pe){
    	pe.printStackTrace();
    	System.out.println(exceptionString());
    }
	}
	/**
	 * Abstract method to throw exception if weight of letter is higher than 32 ounces
	 * If the weight is less than 32 ounces, the shipping cost is calculated and the weight is converted to pounds
	 * @param weight
	 * @throws PackageException
	 */
	@Override
	public void load(double weight) throws PackageException {
	if(weight > 32)
	throw new PackageException("This package is too heavy");
    shippingCost = weight*0.05;
    setShippingCost(shippingCost);
    toPounds(weight);
    setWeight(weight);
	}
	
}
