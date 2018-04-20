/**
 *
 * @author 5856 Madeleine 
 */
public class Saving extends Account implements InterestAccount {
    
    double withdrawalLimit = 10000; //giving the withdrawallimit a value
    
    //GET withdrawal amount
    public double getWithdrawalLimit(){
        return withdrawalLimit;
    }
    
    //SET withdrawal amount 
    //method so user can set their own
    public void setWithdrawalLimit(double withdrawalLimit) {
        if(withdrawalLimit > 0)
        this.withdrawalLimit = withdrawalLimit;
        message = "Your withdrawal limit has been set to: $" +withdrawalLimit;
    }
   

    @Override
    public double makeWithdrawal(double amount) throws amountZeroException{
        //NESTED LOOP STARTS! 
        if(amount <= withdrawalLimit)
        {
            //to make sure user not taking out money that they dont have
            if(amount <= balance)
            {
                //to make sure user not taking out any negativ amounts
                if(amount > 0)
                {
                    //the logic to make sure the amount can be taken out in 20,50 and 100 bills
                    if(amount == 20 || amount > 30 && amount %10 == 0)
                    {
                        balance = balance - amount;//updating balance when money has been taken out
                        message = "You have just withdrawled : $" +amount+ " \nYour new balance is: " +balance;
                    }
                    else
                        message = "Amount cannot be processed \nThis machine only has $20, $50 and $100 bills.";
                }
                else
                    throw new amountZeroException("You cannot withdrawal a negative amount");
            }
            else
                message = "You don't have enough money in your account";
        }
        else
                message = "You cannot withdrawal over your daily limit";    
        return balance;
    }
    
    //GET interest
    public double getInterest(){
        return interest;
    }

    //SET interest
    public void setInterest(double interest) {
        this.interest = interest;
    }
    
    //METHOD to calculate the interest
    @Override
    public double calculateInterest(double interest) {
        balance = balance + balance * interest;
        message = "Your interest has been successfully calculated. Your new balance is: "+balance;
        return balance;
    }    
}
