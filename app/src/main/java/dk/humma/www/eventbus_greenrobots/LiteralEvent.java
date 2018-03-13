package dk.humma.www.eventbus_greenrobots;

/**
 * Created by Waseem on 13/03/2018.
 */

public class LiteralEvent {

    //Literal event is created here
    private String literal;

    LiteralEvent(String literal){
        this.literal=literal;
    }
    String getLiteral(){
        return(literal);
    }
}
