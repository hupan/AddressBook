package com.eric.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eric.demo.Demo;
import com.eric.manager.ItemManager;

/**
 * State in which the program removes entry with a certain home address.
 * @author hupan
 * 
 */
public class RemoveByNameState implements StateInterface{
    private ItemManager manager;
    
    /**
     * Constructor without parameter.
     */
    public RemoveByNameState(){
        this.manager = new ItemManager();
    }

    /**
     * Constructor that copies the item manager passed in as parameter.
     * @param manager
     * 
     */
    public RemoveByNameState(ItemManager manager){
        this.manager = manager;
    }
    
    
    /* (non-Javadoc)
     * Get the address from keyboard input and remove corresponding entries.
     * Always return true.
     * @see com.eric.state.StateInterface#execute(com.eric.demo.Demo)
     */
    public boolean execute(Demo demo) {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(streamReader);
        String name = null;
        
        while (name == null || name.equals("")){
            System.out.print("name: ");
            try {
                name = buf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error! Please re-input the name.");
                return true;
            }
        }
        
        if(this.manager.removeEntryByName(name))
            this.rollBack(demo);
        return true;
    }

    /* (non-Javadoc)
     * Here do nothing.
     * @see com.eric.state.StateInterface#getForward(com.eric.demo.Demo, java.lang.String)
     * 
     */
    public boolean getForward(Demo demo, String cmd) {
        return true;
    }

    /* (non-Javadoc)
     * Move backward to a precedent state.
     * @see com.eric.state.StateInterface#rollBack(com.eric.demo.Demo)
     * 
     */
    public boolean rollBack(Demo demo) {
        StateInterface initialState = new InitialState(this.manager);
        demo.setState(initialState);
        return true;
    }

}
