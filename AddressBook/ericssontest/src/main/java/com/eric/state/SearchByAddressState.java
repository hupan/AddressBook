package com.eric.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eric.demo.Demo;
import com.eric.manager.ItemManager;

/**
 * State in which program searches entry with a certain address.
 * @author hupan
 * 
 */
public class SearchByAddressState implements StateInterface{
    private ItemManager manager;
    
    /**
     * Constructor.
     */
    public SearchByAddressState(){
        this.manager = new ItemManager();
    }
    
    /**
     * Constructor that get the item manager as passed in.
     * @param manager
     * 
     */
    public SearchByAddressState(ItemManager manager){
        this.manager = manager;
    }

    /* (non-Javadoc)
     * Get address and use it to search entries.
     * @see com.eric.state.StateInterface#execute(com.eric.demo.Demo)
     * 
     */
    public boolean execute(Demo demo) {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(streamReader);
        String address = null;
        
        while (address == null || address.equals("")){
            System.out.print("address: ");
            try {
                address = buf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error! Please re-input the address.");
                return true;
            }
        }
        
        if(this.manager.searchEntryByAddress(address))
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
     * Move backward to the initial state.
     * @see com.eric.state.StateInterface#rollBack(com.eric.demo.Demo)
     * 
     */
    public boolean rollBack(Demo demo) {
        StateInterface initialState = new InitialState(this.manager);
        demo.setState(initialState);
        return true;
    }

}
