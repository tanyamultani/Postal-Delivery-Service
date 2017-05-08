/**
 * A class that throws an exception for three different scenarios
 * 1. When the array "Package" is full in class truck
 * 2. If an unknown package is trying to be loaded in the truck
 * 3. If a package is too heavy
 */
public class PackageException extends Exception{
/**
 * default message printed out when exception is thrown
 */
	public PackageException(){
        super("Error");
    }
	/**
	 * custom message printed out when exception is thrown
	 * @param message
	 */
	public PackageException(String message){
        super(message);
    }
}
