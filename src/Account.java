/**
 *
 * @author 5856 Madeleine 
 */
public abstract class Account {
    public double balance = 10000; // setting the balance for every each account to 10000 to start with
    private int depositAmount;
    public double interest;
    public String message = ""; //string to be able to custom a message
    
    //METHOD to get balance
    public void getBalance() {
        message = "Your balance is: $" +balance;
    }
    
    //METHOD to make a deposit
    public double makeDeposit(double depositAmount) throws amountZeroException{
        
        if(depositAmount > 0){
            balance = depositAmount + balance;
            message = "You have just made a $" +depositAmount +" deposit."; 
            message = "Your new balance is: $" +balance;
        }
        else
            throw new amountZeroException("You can only deposit a positive amount");
        return balance;
    }
    
    //ABSTRACT method to do every withdrawl differently in each class
    public abstract double makeWithdrawal(double amount) throws amountZeroException;
        //No body here, as it is an abstract method body is placed in the children
}
