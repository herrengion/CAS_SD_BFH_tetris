package figure;

public class CollisionException extends Exception {
    //Fields
    public boolean isMovementVertical = false;
    //Constructor
    public CollisionException(String message){super(message);}
    public CollisionException(String message, boolean vertical){
    super(message);
    isMovementVertical = vertical;
    }
    //Methods
}
