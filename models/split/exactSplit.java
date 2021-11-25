package models.split;

import java.util.*;

public class exactSplit extends Split {
	private ArrayList<Double> splitList = new ArrayList<Double>() ;
	public HashMap<String, Double> balance = new HashMap<String,Double>();
    public exactSplit (double amount , String paidby , int noOfPayers , ArrayList<String> listOfPayers,ArrayList<Double > splitList )
    {
    	super(amount , paidby, noOfPayers , listOfPayers);
    	this.splitList  = splitList ;
    	splitExact();
    	
    }
    Iterator<String> payers = listOfPayers.iterator();
    public void splitExact() {
           
 
        if(verifyExact()) {
            for (double i : splitList) {
                balance.put(payers.next(), i);
            }
       
            }
            else{
                System.out.println("Invalid Total Expense.....");
                System.out.println("Enter the Correct Distribution of Expenses");
                
       
            }
    }

    public boolean verifyExact() {
        double totalExactExpense = 0.0;
        for( double i : splitList) {
            totalExactExpense = totalExactExpense + i;
        }
   
        if (totalExactExpense == amount)
            return true;
        else
            return false;    
         
    }

    public HashMap<String, Double> getBalance() {
        return this.balance;
    }

}