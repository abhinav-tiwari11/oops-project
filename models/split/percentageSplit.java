package models.split;

import java.util.*;

public class percentageSplit extends Split {

    private ArrayList<Double> splitList = new ArrayList<Double>();
    public HashMap<String, Double> balance = new HashMap<String, Double>();

    public percentageSplit(double amount, String paidby, int noOfPayers, ArrayList<String> listOfPayers,
            ArrayList<Double> splitList) {
        super(amount, paidby, noOfPayers, listOfPayers);

        this.splitList = splitList;

        splitPercentageWise();

    }

    Iterator<String> payers = listOfPayers.iterator();

    public void splitPercentageWise() {

        if (verifyPercent()) {

            for (double i : splitList)
            {
            	double amountPerPerson =  (double) java.lang.Math.round(i * amount *100 / 100)/100;
                balance.put(payers.next(), amountPerPerson);
            }
        } else {
            System.out.println("Invalid Total Percentage.....");
            System.out.println("Enter the Correct Distribution of Expenses");
            

        }
    }

    public boolean verifyPercent() {
        double totalPercent = 0.0;
        for (double i : splitList) {
            totalPercent = totalPercent + i;
        }

        if (totalPercent == 100.00)
            return true;
        else
        {
        	
        	
        	return false;
        }
        
            

    }

    public HashMap<String, Double> getBalance() {
        return this.balance;
    }

}