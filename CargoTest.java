import java.util.Scanner;

public class CargoTest {
	
public static int PackageNum;
public static void main(String args[]){
	//creating object Truck
	Truck t = new Truck();
	//Welcome message
	System.out.println("---------------------------------------------------------\n"+
			"      Welcome to Post Canada Truck Delivery Service \n"+
			"---------------------------------------------------------\n");
	Scanner scanner = new Scanner(System.in);
	System.out.println(menu());
	int answer = scanner.nextInt();
    // keeps track of the number of packages
    PackageNum = 0;	
    //set the number of packages allowed in the array to 200
    Package[] pack1 = new Package[200];
	//check if number is amongst the values indicated on the menu
	while(answer>8 || answer<0){
	    System.out.println("Please pick a number that is available in the option list.");
	    answer = scanner.nextInt();
	    }
	while(answer<=7 || answer>=0){
	    switch(answer){	
	    // if answer = 0, quit program
	    case 0:
	    System.out.println("Thank you for using Post Canada service");
	    break;
	    //if answer = 1 print another sub menu 
	    case 1:
	    	System.out.println(menu2());
	    	int answer2 = scanner.nextInt();
		    switch(answer2){
		    //record drivers name then print menu again     
		    case 1:
		    	System.out.println("Please enter the following information.");
		        System.out.println("Driver name:");
		        String driverName = scanner.next();	
		        t.setDriverName(driverName);
		        System.out.println(menu2());	
		        answer2 = scanner.nextInt();
		        //record unloaded weight of truck in kg then print menu again     
		        case 2:
		    	System.out.println("Please enter the following information.");
		    	 System.out.println("Unload weight:(in kg)");
			        int unloadedWeight = scanner.nextInt();
			        t.setUnloadedWeight(unloadedWeight); 
			        System.out.println(menu2());	
			        answer2 = scanner.nextInt();
			//record originating city then print menu again         
		    case 3:
		    	System.out.println("Please enter the following information.");
		    	System.out.println("Originating City:");
		        String originCity = scanner.next();
		        t.setOriginCity(originCity);
		        System.out.println(menu2());	
		        answer2 = scanner.nextInt();
		    case 4:
		    System.out.println("Destination City:");
	        String destinationCity = scanner.next();
	        t.setDestinationCity(destinationCity);
	        System.out.println(menu2());	
	        answer2 = scanner.nextInt();	
		//record additional info then print menu again         
	    case 5:
	    	   System.out.println("Additional Information:");
		        String additionalInfo = scanner.next();
		        t.setAdditionalInfo(additionalInfo);
		        System.out.println(menu2());	
		        answer2 = scanner.nextInt();
		// print out main menu        
	    case 6:
	    	System.out.println(menu());	
	        answer = scanner.nextInt();
		    }   	
		//load packages in the truck    
	    case 2: 
	    //if number of packages is more than 200, call method that prints exception then print menu for next option	
	    if(PackageNum > 200){
	    t.CheckIfTruckFull();
	    System.out.println(menu());	
        answer = scanner.nextInt(); 
	    }
	    //record tracking number, and figure out package according to last digit of tracking number. Then, ask for weight, set the shipping costs and the type, increase the number of packages and print out menu
	    else{
	    System.out.println("What is the tracking number?");
	    int trackingNum = scanner.nextInt();
	    //if package is a letter
	    if(trackingNum%10==0){
	    pack1[PackageNum] = new Letter();	
	    System.out.println("What is the weight?(in oz)");
        int weight = scanner.nextInt();
        pack1[PackageNum].setTrackingNum(trackingNum);;
        pack1[PackageNum].setWeight(weight);
        pack1[PackageNum].setType("Letter");
        pack1[PackageNum].shippingCosts();
        pack1[PackageNum].setShippingCost(pack1[PackageNum].getShippingCost());
        PackageNum++;
        System.out.println(menu());	
        answer = scanner.nextInt(); 	
	    }
	    // if package is a box
	    else if(trackingNum%10==1){
		    pack1[PackageNum] = new Box();	
		    System.out.println("What is the weight?(in lb)");
		    pack1[PackageNum].setTrackingNum(trackingNum);
	        int weight = scanner.nextInt();
	        pack1[PackageNum].setWeight(weight);
	        pack1[PackageNum].setType("Box");
	        pack1[PackageNum].shippingCosts();
	        pack1[PackageNum].setShippingCost(pack1[PackageNum].getShippingCost());
	        PackageNum++;
	        System.out.println(menu());	
	        answer = scanner.nextInt(); 	
	    }
	    // if package is a wood crate
	    else if(trackingNum%10==2){
	    	 pack1[PackageNum] = new WoodCrate();	
	    	 System.out.println("What is the weight?(in lb)");
			    pack1[PackageNum].setTrackingNum(trackingNum);
		        int weight = scanner.nextInt();
		        pack1[PackageNum].setWeight(weight);
		        pack1[PackageNum].setType("Wood Crate");
		        pack1[PackageNum].shippingCosts();
		        pack1[PackageNum].setShippingCost(pack1[PackageNum].getShippingCost());
		        PackageNum++;
		        System.out.println(menu());	
		        answer = scanner.nextInt(); 	
	    }
	    // if package is a metal crate
	    else if(trackingNum%10==3){
	    	 pack1[PackageNum] = new MetalCrate();	
	    	 System.out.println("What is the weight?(in lb)");
			    pack1[PackageNum].setTrackingNum(trackingNum);
		        int weight = scanner.nextInt();
		        pack1[PackageNum].setWeight(weight);
		        pack1[PackageNum].setType("Metal Crate");
		        pack1[PackageNum].shippingCosts();
		        pack1[PackageNum].setShippingCost(pack1[PackageNum].getShippingCost());
		        PackageNum++;
		        System.out.println(menu());	
		        answer = scanner.nextInt();	
	    }
	    // if last number of tracking digit is not 0,1,2 or 3 the package is unknown. Prints exception along with package info
	    else{
	    	System.out.println("What is the weight?(in oz)");
	        double weight = scanner.nextInt();
	        t.CheckIfUnknownPackage(trackingNum,weight);
	        System.out.println(menu());	
	        answer = scanner.nextInt();	
	    }
	    }
	    //unloads packages from truck while printing out the information about package
	    case 3: 
	    	// if there are no packages in the truck to be unloaded
	    	if(PackageNum == 0){
	    		System.out.println("no packages to unload");
	    		System.out.println(menu());	
	    	    answer = scanner.nextInt(); 
	    	}
	    	else{
	    	    for(int i=0; i<= pack1.length; i++){
	    	pack1[i].toString();
	    	System.out.println(menu());	
		    answer = scanner.nextInt(); 
	    	}
	    	}
	    //prints number of packages loaded in truck so far	
	    case 4: 
	    System.out.println("So far, " + PackageNum + " packages have been loaded.");
	    System.out.println(menu());	
	    answer = scanner.nextInt(); 
	    //prints the gross income earned by the shipping costs 
	    case 5: 
	    System.out.println("The gross income earned by the shipping of the cargo is $" + t.grossIncome());
	    System.out.println(menu());	
	    answer = scanner.nextInt(); 
	    //prints the weight of the truck after it is loaded with packages. Weight is printed in kg and pounds
	    case 6: 
	    	 System.out.println("The gross weight of the truck after it is loaded is " + t.grossWeightInPounds() + "lb / " + t.grossWeightInKilograms() + "kg.");
	 	    System.out.println(menu());	
	 	    answer = scanner.nextInt(); 	
	 	//prints message about traveling from originating city to destination    
	    case 7:	
		    System.out.println("The truck is now driving from " + t.getOriginCity() + " to it's destination of " + t.getDestinationCity() + ".");
		    System.out.println(menu());	
		    answer = scanner.nextInt(); 
	
	    }
	}
	scanner.close();
}
// main menu
public static String menu(){
	return "What would you like to do? "
	+ "\n1. Start a cargo"
    + "\n2. Load the truck with packages"
    + "\n3. Unload a package"
    + "\n4. The number of packages loaded"
    + "\n5. The gross income earned by shipping of the cargo"
    + "\n6. Weight of the truck after it has been completely loaded"
    + "\n7. Drive the truck to destination"
    + "\n0. To quit"
    + "\n\nPlease enter your choice and press <Enter>: ";
}
// sub menu for option 1 of main menu
public static String menu2(){
	return  "\n1. Drive name"
		    + "\n2. Unload weight(in kg)"
		    + "\n3. Originating city"
		    + "\n4. Destination city"
		    + "\n5. Additional Information"
		    + "\n6. Return to main menu"
		    + "\n\nPlease enter your choice and press <Enter>: ";
}

}
