 package com.mycompany.atm;
import java.util.ArrayList;

public class Account {
    private String type ; 
    /** Account id **/
    private String uuid ;
    /** the user that own this account **/ 
    private User hoder ;
    private ArrayList<Transactions> transactions ;
   
    public Account(String type, User hoder ,Bank thebank) {
        this.type = type;
        this.hoder = hoder; 
        this.uuid= thebank.GetNewAccountUUID();
        this.transactions=new ArrayList<Transactions>();
        hoder.addAccount(this);

    }
    public String getSummaryLine(){
        double balance = this.getBalance();
        if(balance >=0){
            return String.format("%s : $%.02f : %s",this.uuid ,balance , this.type);
        }else {
            return String.format("%s : $(%.02f) : %s",this.uuid ,balance , this.type);
        }
    }
    public double  getBalance(){
        double balance = 0 ; 
        for(Transactions  t  : this.transactions ){
           balance +=t.getAmount();  
        }
        return balance;
    } 

    public String getAccUuid() {
        return uuid;
    }
    
    public void printTransHistory(){
      System.out.printf("\nTransaction history for account %s\n", this.uuid);
      for(int i =this.transactions.size()-1 ;i>=0 ; i--){
          System.out.println(this.transactions.get(i).getSummaryLine());
      }
      System.out.println();
    }
    
    public void addTransaction(double amount , String memo ){
      Transactions  t = new Transactions(amount, memo , this);
      this.transactions.add(t); 
    }
    
}
