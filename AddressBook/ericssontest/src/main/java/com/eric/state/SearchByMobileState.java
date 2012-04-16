package com.eric.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eric.demo.Demo;
import com.eric.manager.ItemManager;

/**
 * State in which program searches entry with a certain mobileNumber.
 * @author hupan
 *
 */
public class SearchByMobileState implements StateInterface{
    private ItemManager manager;
    
    /**
     * Constructor without parameter.
     */
    public SearchByMobileState(){
        this.manager = new ItemManager();
    }
    
    /**
     * Constructor that copies the item manager passed in as parameter.
     * @param manager
     * 
     */
    public SearchByMobileState(ItemManager manager){
        this.manager = manager;
    }
    
    /* (non-Javadoc)
     * Get the mobile number and use it to search entries.
     * @see com.eric.state.StateInterface#execute(com.eric.demo.Demo)
     * 
     */
    public boolean execute(Demo demo) {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(streamReader);
        String mobile = null;
        
        while (mobile == null || mobile.equals("")){
            System.out.print("mobile: ");
            try {
                mobile = buf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error! Please re-input the mobile number.");
                return true;
            }
        }
        
        if(this.manager.searchEntryByMobile(mobile))
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
