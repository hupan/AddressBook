package com.eric.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eric.demo.Demo;
import com.eric.manager.ItemManager;

/**
 * State in which the program tries to get the mode to move on searching.
 * @author hupan
 * 
 */
public class SearchState implements StateInterface{
    private ItemManager manager;
    
    /**
     * Constructor.
     */
    public SearchState(){
        this.manager = new ItemManager();
    }
    
    /**
     * Constructor that gets the item manager passed in as parameter.
     * @param manager
     * 
     */
    public SearchState(ItemManager manager){
        this.manager = manager;
    }

    /* (non-Javadoc)
     * Get the mode from keyboard input and move on.
     * @see com.eric.state.StateInterface#execute(com.eric.demo.Demo)
     * 
     */
    public boolean execute(Demo demo) {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(streamReader);
        String mode = null;
        System.out.print("by (name|mobile|address): ");
        
        try {
            mode = buf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error! Please re-choose a mode.");
            return true;
        }
        
        this.getForward(demo, mode);
        return true;
    }

    /* (non-Javadoc)
     * Get to the next state, depending on the mode.
     * @see com.eric.state.StateInterface#getForward(com.eric.demo.Demo, java.lang.String)
     * 
     */
    public boolean getForward(Demo demo, String mode) {
        if(mode.equals("name")){
            StateInterface searchByNameState = new SearchByNameState(this.manager);
            demo.setState(searchByNameState);
        }
        else if(mode.equals("mobile")){
            StateInterface searchByMobileState = new SearchByMobileState(this.manager);
            demo.setState(searchByMobileState);
        }
        else if(mode.equals("address")){
            StateInterface searchByAddressState = new SearchByAddressState(this.manager);
            demo.setState(searchByAddressState);
        }
        else{
            System.out.println("you can search by `name`, `mobile` or `address`.");
            System.out.println("regular expression can be used to query.");
        }
        return true;
    }

    /* (non-Javadoc)
     * Here do nothing.
     * @see com.eric.state.StateInterface#rollBack(com.eric.demo.Demo)
     * 
     */
    public boolean rollBack(Demo demo) {
        return true;
    }


}
