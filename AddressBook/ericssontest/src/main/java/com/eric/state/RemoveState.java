package com.eric.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eric.demo.Demo;
import com.eric.manager.ItemManager;

/**
 * State in with the program get keyboard input and determined which mode to go to.
 * @author hupan
 * 
 */
public class RemoveState implements StateInterface{
    private ItemManager manager;
    
    /**
     * Constructor without parameter.
     */
    public RemoveState(){
        this.manager = new ItemManager();
    }
    
    
    /**
     * Constructor that get the item manager passed as parameter.
     * @param manager
     * 
     */
    public RemoveState(ItemManager manager){
        this.manager = manager;
    }
    
    /**
     * Get mode from keyboard input.
     * @param buf
     * @param mode
     * @return
     * 
     */
    private String getFromSystemIn(BufferedReader buf, String mode){
        if(mode == null){
            try {
                mode = buf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error! Please re-choose a mode.");
                return null;
            }
        }
        return mode;
    }
    
    /**
     * Use the chosen mode to move on.
     * @param demo
     * @param mode
     * @return
     * 
     */
    public boolean executeWithString(Demo demo, String mode){
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(streamReader);
        System.out.print("by (name|mobile|address): ");
        
        mode = this.getFromSystemIn(buf, mode);
        if(mode == null){
            return true;
        }
        
        this.getForward(demo, mode);
        return true;
    }

    /* (non-Javadoc)
     * Things to do in current state.
     * @see com.eric.state.StateInterface#execute(com.eric.demo.Demo)
     * 
     */
    public boolean execute(Demo demo) {
        return executeWithString(demo, null);
    }

    /* (non-Javadoc)
     * Get forward to a further state.
     * @see com.eric.state.StateInterface#getForward(com.eric.demo.Demo, java.lang.String)
     * 
     */
    public boolean getForward(Demo demo, String mode) {
        if(mode.equals("name")){
            StateInterface removeByNameState = new RemoveByNameState(this.manager);
            demo.setState(removeByNameState);
        }
        else if(mode.equals("mobile")){
            StateInterface removeByMobileState = new RemoveByMobileState(this.manager);
            demo.setState(removeByMobileState);
        }
        else if(mode.equals("address")){
            StateInterface removeByAddressState = new RemoveByAddressState(this.manager);
            demo.setState(removeByAddressState);
        }
        else{
            System.out.println("you can remove by `name`, `mobile` or `address`.");
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

    
    /**
     * Set item manager as a certain value.
     * @param manager
     * @return
     * 
     */
    public boolean setItemManager(ItemManager manager) {
        this.manager = manager;
        return true;
    }

}
