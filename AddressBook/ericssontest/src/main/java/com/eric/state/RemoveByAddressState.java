package com.eric.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eric.demo.Demo;
import com.eric.manager.ItemManager;

/**
 * Remove entry with a certain address in this state.
 * @author hupan
 * 
 */
public class RemoveByAddressState implements StateInterface{
    private ItemManager manager;
    
    /**
     * Constructor without parameter.
     */
    public RemoveByAddressState(){
        this.manager = new ItemManager();
    }
    
    /**
     * Constructor that copies the item manager.
     * @param manager
     * 
     */
    public RemoveByAddressState(ItemManager manager){
        this.manager = manager;
    }

    /* (non-Javadoc)
     * Things to do in this certain state.
     * Always return true.
     * @see com.eric.state.StateInterface#execute(com.eric.demo.Demo)
     */
    public boolean execute(Demo demo) {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(streamReader);
        String address = null;
        
        while(address == null || address.equals("")){
            System.out.print("address: ");
            try {
                address = buf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error! Please re-input the address.");
                return true;
            }
        }
        
        if(this.manager.removeEntryByAddress(address))
            this.rollBack(demo);
        return true;
    }

    /* (non-Javadoc)
     * Get forward to a further state.
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
