package com.mycompany.atm;

import java.util.Date;

public class Transactions {
    private double amount ; 
    private Date timestamp;
    private String memo ; 
    private Account inAccount ; 
    
    public Transactions(double amount, String memo ,  Account inAccount) {
        this.amount = amount;
        this.inAccount = inAccount;
        this.timestamp = new Date();
	    this.memo = memo;
    }
    
    public double getAmount(){
        return this.amount;
    }
    
    public String getSummaryLine(){
       if(this.amount>=0){
           return String.format("%s : $%.2f : %s", this.timestamp.toString(),this.amount,this.memo);
       }else {
           return String.format("%s : $(%.2f) : %s", this.timestamp.toString(),this.amount,this.memo);
       }
    }
    
}
