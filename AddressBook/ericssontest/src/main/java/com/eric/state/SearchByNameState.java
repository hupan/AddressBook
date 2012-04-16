package com.eric.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eric.demo.Demo;
import com.eric.manager.ItemManager;

/**
 * State in which the program get a name from keyboard and use it to search entries.
 * @author hupan
 * 
 */
public class SearchByNameState implements StateInterface{
    private ItemManager manager;
    
    /**
     * Constructor without parameter.
     */
    public SearchByNameState(){
        this.manager = new ItemManager();
    }
    
    /**
     * Constructor that get the item manager passed in as parameter.
     * @param manager
     * 
     */
    public SearchByNameState(ItemManager manager){
        this.manager = manager;
    }

    /* (non-Javadoc)
     * Get the name and search.
     * @see com.eric.state.StateInterface#execute(com.eric.demo.Demo)
     * 
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
        
        if(this.manager.searchEntryByName(name))
            this.rollBack(demo);
        return true;
    }

    /* (non-Javadoc)
     * Do nothing.
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
