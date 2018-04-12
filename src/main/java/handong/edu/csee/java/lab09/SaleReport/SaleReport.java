package handong.edu.csee.java.lab09.SaleReport;// package name for Lab09 SaleReort
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

	private double highestSale;// class variable as private for high sale
	private double averageSale;// class variable as private for average
	private  Salesman[] team;// class variable as private Array
	private int numOfsalesman;// class variable as private int for number of salesMan


	/**
	 * This Constructor name SaleReport
	 * for user input the number of SaleMan
	 */
	public SaleReport() {
		System.out.println("Enter number of sale associate: ");// print out Enter number of sale associate:
		Scanner myScanner = new Scanner(System.in);// constructor 
		numOfsalesman = myScanner.nextInt();//constructor to keyboard

	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SaleReport mySaleReport = new SaleReport();// constructor saleReport class

		mySaleReport.getData();// constructor getDate method
		mySaleReport.calculateAverageSales(); //constructor calculateAverageSales method
		mySaleReport.highestSale();// constructor highestSale method
		mySaleReport.priteOutResult();// constructor priteOutResult() menthod
	}

	/**
	 *getData method 
	 *for store of Name of each saleMan and the price of saleMan had sale
	 */
	public void  getData() {

		team = new Salesman[numOfsalesman]; //constructor array 
		// loop
		for (int i=0;i < numOfsalesman ; i++) { 

			Scanner myScanner = new Scanner(System.in);// make object to Scan

			System.out .println("Enter the data of associate number " + (i+1));// print out Enter the data of associate number

			System.out.print("Enter name of sale associate  :");//print out Enter name of sale associate
			String name = myScanner.nextLine();// input the name of each saleMan

			System.out.print("Enter sassociate's sale : $" );// print out Enter sassociate's sale
			double sale = myScanner.nextDouble();// input the price of each saleMan had sale

			Salesman mySaleman =new Salesman();// constructor  Salesman class 
			mySaleman.setmName(name);// call the setmName from salesman class
			mySaleman.setSales(sale);// call the setSales from salesman class
			team[i] = mySaleman;// mention team[i] = mySaleman
		}
	}

	/**
	 * this highest method
	 *  find the highest of sale man
	 */
	public void highestSale() {

		//loop
		for(int i = 0; i <team.length-1;i++ ) {

			// condition
			if (team[i].getSale() < team[i+1].getSale()) {

				highestSale = team[i+1].getSale();
			}
		}

	}


	/**
	 * calculate method
	 * to find the average of Sale men
	 */
	public void calculateAverageSales() {
		double sum =0; //local variable

		//loop
		for (int  i = 0; i< team.length ; i++) {
			//local variable
			double sales = team[i].getSale()	;
			sum = sum + sales;
		} 

		averageSale = sum / team.length;// Calculate the average
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

		System.out.println(" Average ale per associate is : $" + averageSale);// print out Average ale per associate is : $
		System.out.println("The Hightest sale figure is : $" + highestSale);//print out The Highest sale figure is : $



		System.out.println("\nThe following had the hightest sale: ");// print out The following had the highest sale:
		//loop
		for(int i=0; i<team.length;i++) {

			//condition
			if(highestSale == (team[i].getSale())) {
				System.out.println("Name : " + team[i].getnName());//print out the name highest sale man
				System.out.println("Sale : " + team[i].getSale());// print out the value of highest sale man
				System.out.println("$"+ (  team[i].getSale() - averageSale ) + " above the average\n");// print out how much sale man more than average
			}
		}
		System.out.println("The rest performed as follow ");// print out The rest performed as follow

		// find the sale man who sale below the average
		//loop
		for(int i=0; i<team.length;i++) {
			//condition
			if(highestSale != (team[i].getSale()))  {
				System.out.println("Name : " + team[i].getnName());// print out the name of Sale man who had sale below the average
				System.out.println("Sale : " + team[i].getSale());// print out the value below the average
				if (averageSale > team[i].getSale()) {
					System.out.println("$"+ ( averageSale - team[i].getSale()) + " below the average");// print out ---value --- below the average
				}
				else { 
					// print out the value of sale man who had sale more than average but lest than highest 
					System.out.println("$"+ (  team[i].getSale() - averageSale ) + " above the average");
				}

			}

		}

	}

}
