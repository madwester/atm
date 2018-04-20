/**
 *
 * @author 5856 Madeleine 
 */

//Custom exception to catch error if user try to deposite zero or a negative amount
public class amountZeroException extends Exception {

    public amountZeroException(String message) {
        super(message);
    }
    
}
