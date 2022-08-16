
package com.mycompany.atm;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name ; 
    private ArrayList < User > users ; 
    private ArrayList <Account > accounts ; 
    
    public Bank(String name){
        this.name=name;
        this.users=new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }
       
    public String GetNewUserUUID(){
        String uuid ; 
        Random rng = new Random();
        int len = 6; 
        boolean nonUnique = false ; 
        do{
            uuid="";
            for(int i = 0; i<len ;i++){
                uuid+=((Integer)rng.nextInt(10)).toString();
            }
            for(User u : this.users){
                if(uuid.compareTo(u.getUuid())==0){
                    nonUnique=true;
                    break; 
                }
            }
            
        }while(nonUnique);
        
       return uuid ;  
    }
    
    public String GetNewAccountUUID(){
                String uuid ; 
        Random rng = new Random();
        int len = 10; 
        boolean nonUnique = false ; 
        do{
            uuid="";
            for(int i = 0; i<len ;i++){
                uuid+=((Integer)rng.nextInt(10)).toString();
            }
            for(User u : this.users){
                if(uuid.compareTo(u.getUuid())==0){
                    nonUnique=true;
                    break; 
                }
            }
            
        }while(nonUnique);
        
       return uuid ; 
    }
    
    public void addAccount(Account acc){
        this.accounts.add(acc);
    }
    
    public  User addUser(String name , String last , String pin ){
        User us = new User(name , last , pin , this );
        this.users.add(us);
        
        //create saving account ; 
        Account saving = new Account("saving" , us , this );
                this.accounts.add(saving);
        
        return us ;
    }
    
    public User userLogin(String userId , String pin){
        for(User u : this.users){
            if(u.getUuid().compareTo(userId)==0 && u.validatePin(pin)){
                return u; 
            }
        }
        return null;
    }
    
    public String getName(){
        return this.name ;
    }
 

}