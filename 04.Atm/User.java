package com.mycompany.atm;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
	
    private String firstName ; 
    private String  lastName; 
    private String  uuid ; 
    private byte pinHash[]; // pin code for user 
    private ArrayList<Account> accounts ; // accounts which users have 

    public User(String firstName, String lastName ,String pin , Bank thebank) {
        
    	this.firstName = firstName;
        this.lastName = lastName;
        // genrate pin code 
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash=md.digest(pin.getBytes());
        }catch(java.security.NoSuchAlgorithmException e){
            System.err.println("error , caughy noSuchAlgorithm Excption");
            System.exit(1);
        }
        // get uniqe code form bank
        this.uuid=thebank.GetNewUserUUID();
        // create list of accoutns 
        this.accounts = new ArrayList<Account>();
        
        System.err.println("New user "+firstName+" with id "+uuid +" is created" );   
    }
    
    public void addAccount(Account acc){
        this.accounts.add(acc);
    }

     public  ArrayList getAccounts(User a ) {
      return  a.accounts;
    }

    public String getUuid() {
        return uuid;
    }
    
    public boolean validatePin(String apin){
		    try{
		          MessageDigest md = MessageDigest.getInstance("MD5");
		           return MessageDigest.isEqual(md.digest(apin.getBytes()), this.pinHash);
		      }catch(NoSuchAlgorithmException e){
	          		System.err.println(e.toString());
	                e.printStackTrace();
	                System.exit(1);
		        }
	    return false;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public int numberOfAccounts() {
        return accounts.size();
    } 
   
    public void printAccountTransHistory(int accIdx){
        this.accounts.get(accIdx).printTransHistory();
    }
                    
    public void printAccountsSummary(){
	     System.out.println(this.firstName+"'s accounts summary");
	     for(int i = 0 ;i<accounts.size() ;i++){
	         System.out.println((i+1)+") "+this.accounts.get(i).getSummaryLine());
	     }
    }
    
    public double getAccBalance(int index ){
      
    	return this.accounts.get(index).getBalance();
    }
    
    public String getAccUuid(int index){
        return this.accounts.get(index).getAccUuid();
    }
    
    public void addAccTransaction(int accInd ,double amount ,String memo ){
        this.accounts.get(accInd).addTransaction(amount , memo);
    }
}
