/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chadfinal;

/**
 *
 * @author Chad
 */
public class Chequing extends Account
{
    //instant variables
    public double over_limit;
    
    //constructors
    public Chequing(int acc_num, double balance, Customer customer,double over_limit)
    {
      super(customer, acc_num, balance);
      this.over_limit = over_limit;
    }
    
    //getter overdraft limit
    public double getover_limit()
    {
        return over_limit;
    }
    //end getter overdraft limit
    
    //setter overdraft limit
    public void setover_limit(double draft)
    {
        over_limit = draft;
    }
    //end setter overdraft limit
    
    
    @Override
    public void withdraw(double amt) 
    {
        double cheque = 0.0;
        if (getbalance() < amt && amt > over_limit) 
        {
              setbalance(0.0);
        } 
        
        else if (getbalance() < amt && amt < over_limit)
        {
            cheque = getbalance() - amt;
            setbalance(cheque);
        } 
        
        else if (getbalance() > amt) 
        {
            cheque = getbalance() - amt;
            setbalance(cheque);
        }

    }
     
    @Override
    public void deposit(double amt) 
    {
        double new_balance = getbalance() + amt;
        setbalance(new_balance);
    }

    @Override
    public String toString() {
        return "Chequing{" + "over_limit=" + over_limit + '}';
    }
    
}
