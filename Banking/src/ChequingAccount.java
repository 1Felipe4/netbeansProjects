
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
public class ChequingAccount extends Account {
    private double overDraftLimit;
    
    
    public ChequingAccount(){
    
    }
    public ChequingAccount(String AccountN, double Bal, Customer cust, double OdLimit){
    super(AccountN,Bal,cust);
    
    this.overDraftLimit= OdLimit;
    
    
    }

    public double getOverDraftLimit() {
        return overDraftLimit;
    }

    public void setOverDraftLimit(double overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }
    
      @Override
    public void withdraw(double amount) 
    {
     double sum;
     sum = GetBalance() - amount;
     if(sum>= overDraftLimit){
           SetBalance(sum);
     }else{
         System.out.println("You funds are insuffienct");
     }
    savinginformation.add(new Transaction(new Date(),'W', amount, GetBalance(), "Withdrawal"));
    }
     
    @Override
    public void deposit(double amount) 
    {
        double new_balance = GetBalance() + amount;
        SetBalance(new_balance);
        savinginformation.add(new Transaction(new Date(),'D', amount, GetBalance(), "Deposition"));
    }
    
    
    
    public String toString(){
 
 
 return("Account Number: " + getAccountN()+ "Balance: " + GetBalance() + "OverDraftLimit: " + overDraftLimit);
 
    }
}
