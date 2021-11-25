package split ;

import java.util.*;
 import models.*;
import models.User;


class SplitWise {

	public static void main(String[] args) {

		ExpenseManager em = new ExpenseManager();

		em.addUser(new User("u1", "abhinav"));
		em.addUser(new User("u2", "nischal"));
		em.addUser(new User("u3", "aman"));
		em.addUser(new User("u4", "garvit"));

		Scanner scanner = new Scanner(System.in);
		
        
		while (true) {
			String command = scanner.nextLine();
			String[] commands = command.split(" ");
			String requireType = commands[0];

			switch (requireType) {
			case "SHOW":
				if (commands.length == 1) {
					em.showBalance();
				} 
				if (commands.length == 2) {
					String showType = commands[1];
					switch (showType) {
						case "ALL":
							em.showBalance();
							break;
					
						default:
						em.showBalanceOf(showType);
							break;
					}
					// if (showType == "ALL") {
					// 	em.showBalance();
					// }

					// else em.showBalanceOf(commands[1]);
				}
				
				break;
				

			case "EXPENSE":
				String paidBy = commands[1];
				Double amount = Double.parseDouble(commands[2]);
				int noOfUsers = Integer.parseInt(commands[3]);
				String expenseType = commands[4 + noOfUsers];
				ArrayList<String> listOfPayers = new ArrayList<>();
				ArrayList<Double> splitList = new ArrayList<>();

				switch (expenseType) {
				case "EQUAL":
					listOfPayers.clear();
					for (int i = 0; i < noOfUsers; i++) {
						listOfPayers.add(commands[4 + i]);
					}

					em.addExpense(amount, paidBy, noOfUsers, listOfPayers ,"EQUAL");
					break;

				case "EXACT":
					listOfPayers.clear();
					for (int i = 0; i < noOfUsers; i++) {
						listOfPayers.add(commands[4 + i]);
					}

					splitList.clear();
					for (int i = 0; i < noOfUsers; i++) {
						splitList.add(Double.parseDouble(commands[5 + noOfUsers + i]));

					}

					em.addExpense(amount, paidBy, noOfUsers, listOfPayers, "EXACT", splitList);
					break;

				case "PERCENT":
					listOfPayers.clear();
					for (int i = 0; i < noOfUsers; i++) {
						listOfPayers.add(commands[4 + i]);
					}

					splitList.clear();
					for (int i = 0; i < noOfUsers; i++) {
						splitList.add(Double.parseDouble(commands[5 + noOfUsers + i]));

					}
					em.addExpense(amount, paidBy, noOfUsers, listOfPayers, "PERCENT", splitList);

					break;
				}
				break;
			}
			// scanner.close();
		}
		
	}

}
