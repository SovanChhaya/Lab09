package handong.edu.csee.java.lab09.SaleReport;// package name for Lab09 SaleReort
import java.util.ArrayList;// import the package of ArrayList
import java.util.Scanner;// import java Scanner to keyboard input 

/**
 * this program going to calculate the
 * highest sale 
 * Average sale
 * and lower of sales man
 * @author SovanEco(Chhaya)
 *
 */
public class SaleReport {

	private double highestSale;// instance variable as private for high sale
	private double averageSale;// instance  variable as private for average
	ArrayList<Salesman> team;// //declare ArrayList





	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SaleReport mySaleReport = new SaleReport();// constructor saleReport class

		mySaleReport.getData();// constructor getDate method
		mySaleReport.calculateAverageSales(); //constructor calculateAverageSales method
		mySaleReport.highestSale();// constructor highestSale method
		mySaleReport.priteOutResult();// constructor priteOutResult() method
	}

	/**
	 *getData method 
	 *for store of Name of each saleMan and the price of saleMan had sale
	 */
	public void  getData() {

		team = new ArrayList<Salesman>();//constructor of ArrayList
		System.out.println ("Enter items for the list, when prompted.");// print out Enter items for the list, when prompted
		boolean done = false;
		// loop
		while(!done) {
			Scanner keyboard = new Scanner (System.in);
			System.out.print("Enter name of sale associate  :");// print out Enter name of sale associate
			String entry = keyboard.nextLine ();

			System.out.print("Enter sassociate's sale : $" );// print out Enter sassociate's sale
			double sale = keyboard.nextDouble();// input the price of each saleMan had sale
			//Salesman mySalesman  = new Salesman();
			Salesman mySaleman = new Salesman();// constructor  Salesman class 
			mySaleman.setmName(entry);// call the setmName from salesman class
			mySaleman.setSales(sale);// call the setSales from salesman class
			team.add(mySaleman);// mention team[i] = mySaleman

			Scanner repeatCheck = new Scanner(System.in);

			System.out.print ("More items for the list? ");//print out More item or the list
			String accept = repeatCheck.nextLine ();

			if (!accept.equalsIgnoreCase ("yes"))// if you type yes you can input more SalesMen 
				done = true;// if you not type "yes" and type anything else it will print the result

		}
	}

	/**
	 * this highest method
	 *  find the highest of sale man
	 */
	public void highestSale() {

		//loop

		for(int i = 0; i < team.size()-1;i++ ) {
			if (team.get(i).getSale() < team.get(i+1).getSale() ){

				highestSale = team.get(i+1).getSale();
			}
		}
	}


	/**
	 * calculate method
	 * to find the average of Sale men
	 */
	public void calculateAverageSales() {
		double sum =0;// local variable

		//loop
		for(int  i = 0 ; i< team.size() ; i++) {
			double sales = team.get(i).getSale();
			sum = sum + sales;
		} 
		//find the average number
		averageSale = sum / team.size();
	}

	/**
	 * 
	 * print out  result method
	 * to print out the result of
	 *  highest sale man
	 *  find the below of sale who had sale under average price
	 * 
	 */
	public void priteOutResult() {

		System.out.println("Average sale per associate is : $" + averageSale);// print out Average ale per associate is : $
		System.out.println("The Hightest sale figure is : $" + highestSale);//print out The Highest sale figure is : $



		System.out.println("\nThe following had the hightest sale: ");// print out The following had the highest sale:
		//loop
		for(int i=0; i<team.size();i++) {
			//condition find the highest salesMen
			if(highestSale == ((team.get(i)).getSale())) {
				System.out.println("Name : " + (team.get(i)).getnName());//print out the name highest sale man
				System.out.println("Sale : " + team.get(i).getSale());// print out the value of highest sale man
				System.out.println("$"+ (  team.get(i).getSale() - averageSale ) + " above the average\n");// print out how much sale man more than average
			}
		}
		System.out.println("The rest performed as follow ");// print out The rest performed as follow

		// find the sale man who sale below the average
		for(int i=0; i<team.size();i++) {
			//condition find the salesMen who has sale below the average
			if(highestSale != (team.get(i).getSale()))  {
				System.out.println("Name : " + team.get(i).getnName());// print out the name of Sale man who had sale below the average
				System.out.println("Sale : " + team.get(i).getSale());// print out the value below the average
				if (averageSale > team.get(i).getSale()) {
					System.out.println("$"+ ( averageSale - team.get(i).getSale()) + " below the average");// print out ---value --- below the average
				}
				else { 
					// this else find the salesMen who has sale above the average 
					System.out.println("$"+ (  team.get(i).getSale() - averageSale ) + " above the average");// print out the value of sale man who had sale more than average but lest than highest 
				}
			}

		}

	}

}


