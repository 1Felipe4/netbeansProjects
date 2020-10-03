/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounttester;

/**
 *
 * @author Rodrigo
 */
import java.util.Scanner;


public class AccountTester {
    
static Account [] ac = new Account [20];
static Account ac1 = new Account("123");
static int accCount = 0;
static Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        constructAccounts();
        String check;
        System.out.print("Welcome \n");
         do{
             System.out.print(
                     "Press 1 to Create Account\n"
                     + "Press 2 to Log in to Account\n"
                     + "Selection: ");
             check = input.nextLine();
             
             switch(check){
                 case "1": createAccount();
                     break;
                 case "2": logIn();
                     break;
                 default: System.out.println("Invalid Command\n");    
             }
             
         }while (!check.equals("0"));
         
        
        
        /*Account ac1 = new Account();
        double amt;
        
        System.out.print("Please enter amount to deposit: ");
        amt = input.nextDouble();
        
        ac1.deposit(amt);
        
        
        System.out.println("Your balance is: $" + ac1.getBalance());
        */
        
        
    }
    
    public static void createAccount(){
        String accnum;
        String password;
        boolean taken;
    
        //Account
        
            
        if(accCount<ac.length){
            do{
                System.out.print("Please enter an Account Number: ");
                accnum = input.nextLine();
                 taken = checkTaken(accnum);
            
        }while(taken == true);
        
             
            System.out.print("Please Create A Password: ");
            password = input.nextLine();
            ac[accCount].setAccNumAndPw(accnum, password);
            System.out.print("Account Created\n\n");
        }  
        
        else{
            System.out.print("No more Available Accounts\n");
        }
    
    }
    
    public static void logIn(){
        String accnum;
        String password;
        int i = 0;
        boolean match = false;
        System.out.print("Please enter Account Number: ");
        accnum = input.nextLine();
        while(match == false && i < ac.length){
            match = ac[i].accnumEqual(accnum);
           if(match == false){
               i++;
           }
        }
        if(match == false){
            System.out.print("Account not found\n\n");
            
        }
        else{
        match = false;
        while(match == false){
        System.out.print("Please enter password: ");
        password = input.nextLine();
        if(passwordCheck(password, i) == true){
            match = true;
        }
        if(match == true){
            accountOptions(i);
        }
        }
        
            
            
         }

    }
    
    public static boolean checkTaken(String accnum){
    boolean taken = false;    
    for(int i = 0; i <= accCount;i++){
                if(ac[i].accnumEqual(accnum) == true){
                taken = true;
                System.out.print("Number Taken\n");
               }
    }
  
      if(taken ==  false){
          System.out.print("Number Available\n");
      }            
                
    
    return taken;
}
    
    public static boolean passwordCheck(String password, int i){
     
        boolean success = false;
 
            if(ac[i].passwordEqual(password) == true){
                System.out.println("Log In Successful\n");
                success = true;
            }
                else{
                System.out.print("Incorrect Password\n");
  
            }
        return success;
    }
    
    public static void accountOptions(int i){
        String check;
        do{
          System.out.print(
                    "Press 1 to View Balance\n"
                  + "Press 2 to make a deposit\n"
                  + "Press 3 to withdraw funds\n"
                  + "Press 4 to change account settings\n"
                  + "Press 0 to logout\n"
                  + "Selection: ");
          check = input.nextLine();
            switch(check){
                case "1": viewBalance(i);
                    break;
                case "2": deposit(i);
                    break;
                case "3": withdraw(i);
                    break;
                case "4":    
            }
            
        }while(!check.equals("0"));
        
    }
    
    public static void viewBalance(int i){
        System.out.println("\nYour current balance is: $" + ac[i].getBalance());
        System.out.print("Press enter to continue: ");
        input.nextLine();
        System.out.println();
    }
    
    public static void deposit(int i){
        
        double amt;
        
        System.out.print("Please enter amount to be deposited: ");
        amt = input.nextInt();
        ac[i].deposit(amt);
        
        System.out.println("\nYour current balance is: $" + ac[i].getBalance());
        System.out.print("Press enter to continue: ");
        input.nextLine();
        input.nextLine();
        System.out.println();
        
    }
    
    public static void withdraw(int i){
        
        double amt;
        System.out.print("Please enter amount to be withdraw: ");
        amt = input.nextInt();
        ac[i].withdraw(amt);
        
        System.out.println("\nYour current balance is: $" + ac[i].getBalance());
        System.out.print("Press enter to continue: ");
        input.nextLine();
        input.nextLine();
        System.out.println();
        
    }
    
    public static void constructAccounts(){
        for(int i = 0; i <ac.length; i++){
            ac[i] = new Account();
        }
    }
    
}