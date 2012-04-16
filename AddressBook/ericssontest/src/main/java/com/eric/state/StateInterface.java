package com.eric.state;
import com.eric.demo.Demo;

/**
 * Interface for states.
 * @author hupan
 * 
 */
public interface StateInterface {
    
    /**
     * Thing to do in a certain state.
     * @param demo
     * @return
     * 
     */
    public boolean execute(Demo demo);
    
    /**
     * Move forward to further states.
     * @param demo
     * @param cmd
     * @return
     * 
     */
    public boolean getForward(Demo demo, String cmd);
    
    /**
     * Move backward to precedent states.
     * @param demo
     * @return
     * 
     */
    public boolean rollBack(Demo demo);
}
