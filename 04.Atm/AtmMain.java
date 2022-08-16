package com.mycompany.atm;

import java.util.Scanner;


public class AtmMain {

    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         Bank theBank = new Bank("Bank1");
         User user1 = theBank.addUser("ahmed","ali","12345");
         Account acc1 = new Account("Checking",user1,theBank);
         User user ; 
         while(true){
             user = AtmMain.mainMenuPrompt(theBank , input);
             AtmMain.printUserMenu(user,input);
         }
    }
    public static User mainMenuPrompt(Bank thebank  , Scanner input){
        String userid ; 
        String pin ; 
        User authUser ; 
        do{
            System.out.println("Welcome to "+thebank.getName());
            System.out.println("Enter user Id : ");
            userid= input.nextLine();
            System.out.println("Enter pin : ");
            pin= input.nextLine();
             
            authUser = thebank.userLogin(userid, pin);
            if(authUser == null){
                System.out.println("Incorrect user id/pin combination.  please try agin. ");
            }
        }while(authUser == null);
        return authUser;
    }
    public static void printUserMenu(User theUser , Scanner input ){
      //print a summary of the user's accounts
        theUser.printAccountsSummary();
      int choise ; 
      do{
           System.out.println("what would you like to do "+theUser.getFirstName());
           System.out.println("1) Show account trasaction history ");
           System.out.println("2) Withdrowl ");
           System.out.println("3) deposit ");
           System.out.println("4) Transfer ");
           System.out.println("5) Qusit ");
           System.out.println("Enert choise: ");
           choise = input.nextInt();
           if(choise < 1 || choise >5){
               System.out.println("invalid choise . please choose 1-5");
           }
    }while (choise <1 || choise >5);
          
      switch(choise){
        case 1: 
          AtmMain.showTransHistory(theUser ,input);    
         break;
        case 2: 
            AtmMain.withdrow(theUser ,input);
        break;
        case 3: 
            AtmMain.deposit(theUser, input);
        break;
        case 4: 
            AtmMain.transfer(theUser , input);
        break;  
        case 5: 
            System.out.printf("Thanks for your time\n");
        break; 

      }
         if(choise!=5)
            printUserMenu(theUser , input);
          
    }
        
    
    public static void showTransHistory(User theUser , Scanner input){
        int theAcc ;
        do{
            System.out.printf("Enter the number (1-%d) of the accout\n"+
                    "whose transactions you want to see: " ,theUser.numberOfAccounts());
            theAcc = input.nextInt()-1;
            if(theAcc<0 || theAcc>=theUser.numberOfAccounts()){
                System.out.println("Invalid account. Please try again.");
            }
        }while(theAcc<0 || theAcc>=theUser.numberOfAccounts());
            theUser.printAccountTransHistory(theAcc);
        }
    public static void transfer(User theUser ,Scanner input){
        int fromAcc ; 
        int toAcc; 
        double amount ; 
        double acctBal;
        do{
            System.out.printf("Enter the number of account to transfer from:\n"); 
            fromAcc= input.nextInt()-1;
            
            if(fromAcc <0 || fromAcc >=theUser.numberOfAccounts()){  
                System.out.printf("Invalid account. Please try again.\n");
            }
        }while(fromAcc<0 || fromAcc>=theUser.numberOfAccounts());
            acctBal=theUser.getAccBalance(fromAcc);
            do{
                System.out.printf("Enter the number of account to transfer to:\n"); 
                toAcc= input.nextInt()-1;
            if(toAcc <0 || toAcc >=theUser.numberOfAccounts()){
                System.out.println("Invalid account. Please try again.");
            }
        }while(toAcc<0 || toAcc>=theUser.numberOfAccounts());
            
            do{
                System.out.println("Enter amount:");
                amount =input.nextDouble();
                if(amount<0){
                    System.out.println("Amout must be greater than zero.");
                }else if(amount > acctBal){
                    System.out.println("Amout must be less than current balance .");
                    System.out.println("balance of $%.2f."+acctBal);
                } 
            }while(amount < 0  || amount > acctBal);
            theUser.addAccTransaction(fromAcc ,-1*amount ,String.format(
            "Transfer to account %s",theUser.getAccUuid(toAcc)));
            theUser.addAccTransaction(toAcc ,amount ,String.format(
            "Transfer to account %s",theUser.getAccUuid(fromAcc)));
    }
    
    public static void withdrow(User theUser , Scanner input){
        int fromAcc ; 
        double amount ; 
        double acctBal;
        String memo ;
        do{
            System.out.printf("Enter the number of account to withdrow from:\n"); 
            fromAcc= input.nextInt()-1;
            if(fromAcc <0 || fromAcc >=theUser.numberOfAccounts()){
                System.out.printf("Invalid account. Please try again.\n");
            }
        }while(fromAcc<0 || fromAcc>=theUser.numberOfAccounts());
        
            acctBal=theUser.getAccBalance(fromAcc); 
            System.out.println(" acctBal=theUser.getAccBalance(toAcc);");
            do{
                System.out.printf("Enter amount to transfer (max $%.02f): $\n",acctBal);
                amount =input.nextDouble();
                if(amount<0){
                    System.out.println("Amout must be greater than zero.");
                }else if(amount > acctBal){
                    System.out.println("Amout must be less than current balance .");
                    System.out.printf("balance of $%.2f."+acctBal);
                } 
            
            }while(amount < 0  || amount > acctBal);
            System.out.println("enter memo");
            input.nextInt();
            System.out.println();
            memo = input.nextLine();
            
            theUser.addAccTransaction(fromAcc, -1*amount, memo);
    }
        public static void deposit(User theUser , Scanner input){
        int toAcc ; 
        double amount ; 
        double acctBal;
        String memo ;
        do{
            System.out.printf("Enter the number of account to deposit to: \n"); 
            toAcc= input.nextInt()-1;
             
            if(toAcc <0 || toAcc >=theUser.numberOfAccounts()){
                System.out.println("Invalid account. Please try again.");
            }
        }while(toAcc<0 || toAcc>=theUser.numberOfAccounts());
        
            acctBal=theUser.getAccBalance(toAcc); 
            do{
                System.out.println("Enter amount :");
                amount =input.nextDouble();
                if(amount<0){
                    System.out.println("Amout must be greater than zero.");
                }
            }while(amount < 0);
            System.out.println("enter memo");
            input.nextInt();
            memo = input.nextLine();
            theUser.addAccTransaction(toAcc, amount, memo);
    }
   
   
}

