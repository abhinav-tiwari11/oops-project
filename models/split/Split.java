package models.split;

import java.util.*;

public class Split {
    double amount;
    String paidby;
    int noOfPayers;
    ArrayList<String> listOfPayers;

    public Split(double amount, String paidby, int noOfPayers, ArrayList<String> listOfPayers) {
        this.amount = amount;
        this.paidby = paidby;
        this.noOfPayers = noOfPayers;
        this.listOfPayers = listOfPayers;
    }
}