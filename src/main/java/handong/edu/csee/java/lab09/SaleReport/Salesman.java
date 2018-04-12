package handong.edu.csee.java.lab09.SaleReport;// package name for Lab09 SaleReort
/**
 * this  class for store
 * the name of sale Man by user input
 * Sale price from user input
 * @author SovanEco(Chhaya)
 *
 */
public class Salesman {
	private String mName ;// class variable
	private double Sales;// class variable
	// method 
	public String getnName() {
		return mName;// return the class variable

	}
	// method
	public void setmName(String mName1) {
		mName = mName1;// return class variable to parameter variable
	}
	//method
	public double getSale() {
		return Sales;// return Sales Class variable
	}

	//method
	public void setSales(double sale) {
		Sales = sale; // return the class variable to parameter variable
	}

}
