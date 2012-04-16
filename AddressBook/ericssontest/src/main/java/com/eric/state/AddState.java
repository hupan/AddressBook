package com.eric.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eric.demo.Demo;
import com.eric.manager.ItemManager;

/**
 * An implementation of StateInterface.
 * A certain state.
 * @author hupan
 */
public class AddState implements StateInterface{
    private ItemManager manager;
    /**
     * Get input from keyboard input.
     * @param buf
     * @param pre
     * @param now
     * @return
     * 
     */
    private String getFromSystemIn(BufferedReader buf, String pre, String now){
        while (now == null || now.equals("")){
            System.out.print(pre + ": ");
            System.out.flush();
            try {
                now = buf.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("Error! Please retry adding this entry.");
                System.out.flush();
                return null;
            }
        }
        return now;
    }
    
    /**
     * Execute in current state with the keyboard input.
     * @param demo
     * @param name
     * @param mobileNumber
     * @param homeAddress
     * @return
     * 
     */
    public boolean executeWithString(Demo demo, String name, String mobileNumber, String homeAddress){
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(streamReader);
        
        name = this.getFromSystemIn(buf, "name", name);
        if(name == null){
            return true;
        }
        
        mobileNumber = this.getFromSystemIn(buf, "mobile", mobileNumber);
        if(mobileNumber == null){
            return true;
        }
        
        homeAddress = this.getFromSystemIn(buf, "address", homeAddress);
        if(homeAddress == null){
            return true;
        }
        
        this.manager.addEntry(name, mobileNumber, homeAddress);
        System.out.println("address entry added");
        System.out.flush();
        this.rollBack(demo);
        return true;
    }
    
    /**
     * Constructor without parameter.
     */
    public AddState(){
        this.manager = new ItemManager();
    }
    
    /**
     * Constructor with ItemManager as parameter.
     * @param manager
     * 
     */
    public AddState(ItemManager manager){
        this.manager = manager;
    }

    /* (non-Javadoc)
     * Implements that of the interface.
     * Always return true.
     * @see com.eric.state.StateInterface#execute(com.eric.demo.Demo)
     */
    public boolean execute(Demo demo) {
        return this.executeWithString(demo, null, null, null);
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
     * Move backward to the precedent state.
     * @see com.eric.state.StateInterface#rollBack(com.eric.demo.Demo)
     * 
     */
    public boolean rollBack(Demo demo) {
        StateInterface initialState = new InitialState(this.manager);
        demo.setState(initialState);
        return true;
    }
    
    /**
     * Set the itemManager as a certain value.
     * @param manager
     * @return
     * 
     */
    public boolean setItemManager(ItemManager manager) {
        this.manager = manager;
        return true;
    }

}
