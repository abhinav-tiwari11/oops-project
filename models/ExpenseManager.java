package models;
import java.util.*;

import models.split.*;
import models.User;



public class ExpenseManager {

    HashMap<String, HashMap<String, Double>> balanceSheet;

    public ExpenseManager() {

        balanceSheet = new HashMap<String, HashMap<String, Double>>();

    }

    public void addUser(User user) {

        balanceSheet.put(user.getId(), new HashMap<String, Double>());
        Iterator <String> it = balanceSheet.keySet().iterator();  
        
        while(it.hasNext())  
        {  
        String key=(String)it.next();  
        balanceSheet.get(user.getId()).put(key,0.0);
        balanceSheet.get(key).put(user.getId(), 0.0);
         
        }  
    }
    public void updateBalanceSheet(String paidby ,HashMap<String ,Double> balance)
    {
       Iterator<String> balanceIterator = balance.keySet().iterator();
       while(balanceIterator.hasNext())
       {  
    	   String key=(String)balanceIterator.next();
        
         balanceSheet.get(paidby).put(key,balanceSheet.get(paidby).get(key) + balance.get(key) );
         
    	  

       }
    }

   public void addExpense(Double amount, String paidby,int noOfPayers, ArrayList<String> listOfPayers, String expense)
   {
   
	  equalSplit split =  new equalSplit(amount, paidby, noOfPayers, listOfPayers );   
  
	  updateBalanceSheet(paidby ,split.balance);
	   
   }
   
   public void addExpense(double amount , String paidby , int noOfPayers ,ArrayList<String > listOfPayer ,String expense , ArrayList<Double> splitList)
   {       
	       if(expense.equals("PERCENT"))
	    		   {
		   percentageSplit split = new percentageSplit(amount , paidby,noOfPayers , listOfPayer, splitList);
		   updateBalanceSheet(paidby ,split.balance);

	    		   }
	       else if (expense.equals("EXACT"))
	       {
	    	    exactSplit split = new exactSplit(amount , paidby,noOfPayers , listOfPayer, splitList);
	    	   updateBalanceSheet(paidby,split.balance);

	       }
		   
	   
   }
   
   
   
   
   
   public void showexpense(String user)
   {
	   double totalExpense = 0;
	  
	   
	   
	   for (HashMap.Entry<String,HashMap<String, Double>> entry : balanceSheet.entrySet())
	   {
             	  totalExpense = totalExpense + entry.getValue().get(user) ;
		    
		   
	   }
	   System.out.println("Total Expense of " + user + "is :" + totalExpense   );
	   
   }
   
   public void showBalcanceOfEveryOne(String user)
   {  
	   HashMap<String , Double> balanceOfOther = new HashMap<String , Double>();
	   Iterator<String> boiiterator = balanceSheet.get(user).keySet().iterator() ;
	   
	   while(boiiterator.hasNext())
	   {   
		   String key =  (String)boiiterator.next();
		   if(key.equals(user))
		   {
			   
		   }
		   else
		   {
			   balanceOfOther.put(key, balanceSheet.get(user).get(key));
		   }
		   
	   }
      System.out.println("Balance Of Other Users with "+ user + " are as follows ");
      System.out.println(balanceOfOther);
	   
   }
   
   
   
   public void showBalanceOf(String user)
   {
	   
	   Iterator<String> bwoiterator = balanceSheet.keySet().iterator() ;
	   int hasBalance = 0 ;
	   while(bwoiterator.hasNext())
	   {
		   String key = (String)bwoiterator.next();
		   if(key.equals(user))
		   {
			   
		   }
		   else
		   {   
			   if(balanceSheet.get(key).get(user)==0.0)
			   {
				   
			   }
			   else
			   {	   
			   hasBalance = 1;
			   System.out.println(user + " owes " + key +": " + balanceSheet.get(key).get(user));
			   }
		   }
		   
		 }
	   if(hasBalance == 1)
	   {
		   
	   }
	   else
	   {
		   System.out.println(user + " has no balance ");
	   }
	   
   }
   
   public void showBalance()
   {   HashMap<String ,HashMap<String , Double>> balancesOfAllUsers = new HashMap<String ,HashMap<String , Double>>();
       Iterator<String> boauiterator = balanceSheet.keySet().iterator() ;
       
      int hasRecord = 0;
	   while(boauiterator.hasNext())
	   {
		  String key = (String)boauiterator.next();
		  HashMap<String,Double> usermap = new HashMap<String , Double>();
		  Iterator<String> usermapiterator = balanceSheet.get(key).keySet().iterator() ;
		  
		  while(usermapiterator.hasNext())
		  {
		    String userMapKey = (String)usermapiterator.next();
		    if(key.equals(userMapKey))
		    {
		    	
		    }
		    else
		    {
		    	if(balanceSheet.get(key).get(userMapKey)==0.0)
		    	{
		    		
		    	}
		    	else {
		    	 hasRecord = 1;	
		    	 System.out.println(userMapKey + " owes "+ key + ": "+ balanceSheet.get(key).get(userMapKey)  );
		    	}
		    	usermap.put(userMapKey, balanceSheet.get(key).get(userMapKey));
		    	
		    }
			  
		  }
		  
		  

	   }
	   if(hasRecord==1) {}
	   else {
		   System.out.println("No Record Found");
	   }
	   
	    
   }
   

}