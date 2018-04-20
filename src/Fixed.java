/**
 *
 * @author 5856 Madeleine 
 */
public class Fixed extends Account implements InterestAccount {
    
    //making this true as we are assuming any withdrawal is too early
    boolean earlyWithdrawal = true;
    
    public boolean earlyWithdrawal(){
        return earlyWithdrawal;
    }
    
    public void setearlyWithdrawal(){
        this.earlyWithdrawal = earlyWithdrawal;
    }
    
    @Override
    public double makeWithdrawal(double amount) throws amountZeroException
    {
        //NESTED LOOP STARTS! 
            //to make sure user not taking out money that they dont have
            if(amount <= balance)
            {   
                //to make sure user not taking out any negativ amounts
                if(amount > 0)
                {
                    //the logic to make sure the amount can be taken out in 20,50 and 100 bills
                    if(amount == 20 || amount > 30 && amount %10 == 0)
                    {
                        balance = balance - amount; //updating balance when money has been taken out
                        message = "You have just withdrawled : $" +amount+ " \nYour new balance is: " +balance;
                        earlyWithdrawal = true; //assuming every withdrawl is to early
                    }
                    else
                        message = "Amount cannot be processed. \nThis machine only has $20, $50 and $100 bills.";
                }
                else
                    throw new amountZeroException("You cannot withdrawal a negative amount");
            }
            else
                message = "You don't have enough money in your account";
        return balance;
    }
    
     //GET interest
    public double getInterest(){
        return interest;
    }

    //SET interest
    public void setInterest(double interest){
        this.interest = interest;
    }
    
    //METHOD to calculate the interest
    @Override
    public double calculateInterest(double interest){
        if(earlyWithdrawal = false)//wont happen in this case
        {
            balance = balance + balance * interest; //user gets interest
        }
        else 
            balance = balance; //no interest (this is never gonna happen as we are assuming all the withdrawls are too early)
        return balance;
        }
}

