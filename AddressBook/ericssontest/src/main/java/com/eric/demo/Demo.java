package com.eric.demo;
import com.eric.state.*;

/**
 * Each running instance of class Demo can be regarded as a user using the program.
 * @author hupan
 */
public class Demo implements Runnable{
    private StateInterface state;
    
    /**
     * Constructor.
     */
    public Demo(){
        this.state = new InitialState();
    }
    
    /**
     * Change the current state dynamically.
     * @param state
     * 
     */
    public void setState(StateInterface state){
        this.state = state;
    }
    
    /**
     * Run the corresponding method of the current state.
     */
    public void execute(){
        while(this.state.execute(this) != false){
            
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
        Demo demo = new Demo();
        demo.execute();
    }
}
