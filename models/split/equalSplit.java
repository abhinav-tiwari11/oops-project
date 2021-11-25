package models.split;
import java.util.*;


public class equalSplit extends Split{ 
    
        private Double amountPerPerson =  (double) java.lang.Math.round(amount*100 / noOfPayers)/100;
       
        
        public HashMap<String, Double> balance = new HashMap<String,Double>();
        
        
        Iterator<String> it = listOfPayers.iterator();
    
        public equalSplit(double amount, String paidby, int noOfPayers, ArrayList<String> listOfPayers) {
            super(amount, paidby, noOfPayers, listOfPayers);
            splitEqual();
        }
    
        public void splitEqual() {
            while (it.hasNext()) {
                balance.put(it.next(), amountPerPerson);
            }
        }

        public HashMap<String, Double> getBalance() {
            return this.balance;
        }
    
    
}
