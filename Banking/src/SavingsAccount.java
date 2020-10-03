
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tidus
 */
public class SavingsAccount extends Account {
    
    private double intrestRate;
    
    public SavingsAccount(){
    
    }
public SavingsAccount(String AccountN, double Bal,Customer cust, double intRate){
   super(AccountN,Bal,cust);
    
    this.intrestRate= intRate;


}    

public double getIntrestRate(){

    return this.intrestRate;

}

    public void setIntrestRate(double intRate) {
        this.intrestRate = intRate;
    }

     public void payInterest(){
        intrestRate /= 100;
        double intr = GetBalance() * intrestRate;
        double add_intr = GetBalance() + intr;
        SetBalance(add_intr);
         savinginformation.add(new Transaction(new Date(), 'I', intr, GetBalance(), "Interest"));
    }
     
    @Override
    public void withdraw(double amount){
     double sum;
     sum = GetBalance() - amount;
     if(sum>= 0){
           SetBalance(sum);
     }else{
         System.out.println("You funds are insuffienct");
     }
    savinginformation.add(new Transaction(new Date(),'W', amount, GetBalance(), "Withdrawal"));
    }
    
    @Override
    public void deposit(double amount){
       
            double new_balance = GetBalance() + amount;
            SetBalance(new_balance);
            savinginformation.add(new Transaction(new Date(),'D', amount, GetBalance(), "Deposition"));
        
    }

    @Override
    public String toString(){
 
 
 return("Account Number: " + getAccountN()+ "Balance: " + GetBalance() + "IntrestRate: " + intrestRate);
 
    }
}
