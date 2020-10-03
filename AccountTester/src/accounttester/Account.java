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
public class Account {
    //Instance Variable
    private String accnum = "null";
    private double balance;
    private String password;
    private boolean available;
    
    
    //Constructors
    Account(){
        balance = 0;
        accnum = "null";
        available = true;
    }
    
    Account(double balance){
        this.balance = balance;
    }
    
    Account(String accnum){
        this.accnum = accnum;
    }
    
    
    Account(String accnum, double balance){
        this.accnum = accnum;
        this.balance = balance; 
        available = false;
                
    }
    
    
    Account(String accnum, String password){
        this.accnum = accnum;
        this.password = password;
        available = false;
                
    }
    
    Account(String accnum, String password, double balance){
        this.accnum = accnum;
        this.password = password;
        available = false;        
    }
    
    //Instance Methods
    public void withdraw(double amt){
        balance-= amt;
    }
    
    public void deposit(double amt){
        balance+= amt;
    }
    
     public void setAccNumAndPw(String accnum, String password){
        this.accnum = accnum;
        this.password = password;
    } 
    
     
    public void setPassword(String password){
    this.password = password;
} 
     
    public String getPassword(){
        return password;
    }
    
    public void setAccNum(String accnum){
        this.accnum = accnum;
    } 
    
    public String getAccNum(){
        return accnum;
    }
    
    public void setBalance(double amt){
        balance = amt;
    }
    
    
    public double getBalance(){
        return balance;
    }
    
    public boolean getAvailable(){
        return available;
    }
    
    public boolean accnumEqual(String accnum){
        if(this.accnum.equals(accnum)){
            return true;
            
        }
        else{
        
        return false;
       }
      }
    
     public boolean passwordEqual(String password){
        if(this.password.equals(password)){
            return true;
        }
        else{
        
        return false;
       }
      }
    
}
