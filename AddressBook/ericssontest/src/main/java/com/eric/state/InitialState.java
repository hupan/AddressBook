package com.eric.state;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eric.manager.ItemManager;
import com.eric.demo.Demo;

/**
 * Initial state of the program.
 * A certain state.
 * @author hupan
 */
public class InitialState implements StateInterface{
    private ItemManager manager;
    
    /**
     * Constructor without parameter.
     */
    public InitialState(){
        this.manager = new ItemManager();
    }
    
    /**
     * Constructor with ItemManager as parameter.
     * @param manager
     * 
     */
    public InitialState(ItemManager manager){
        this.manager = manager;
    }
    
    
    /**
     * Get the current item manager.
     * @return
     * 
     */
    public ItemManager getItemManager(){
        return this.manager;
    }
 
    
    /**
     * Set the current item manager as a certain value.
     * @param manager
     * 
     */
    public void setItemManager(ItemManager manager){
        this.manager = manager;
    }
    
    /* (non-Javadoc)
     * Things to do in the current state.
     * Return false when encounterd quit command.
     * Otherwise return true.
     * @see com.eric.state.StateInterface#execute(com.eric.demo.Demo)
     */
    public boolean execute(Demo demo){
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(streamReader);
        String cmd = null;
        System.out.print("ab> ");
        System.out.flush();
        
        try {
            cmd = buf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
        
        if(cmd.equals("!quit")){
            return false;
        }
        else if(cmd.equals("!help")){
            System.out.println("Use `add` command to add new address entry.");
            System.out.println("Use `search` command to get one or more address entries.");
            System.out.println("Use `remove` command to remove one or more address entries.");
            System.out.flush();
            return true;
        }
        else {
            this.getForward(demo, cmd);
            return true;
        }
    }
    
    /* (non-Javadoc)
     * Get forward to a further state.
     * @see com.eric.state.StateInterface#getForward(com.eric.demo.Demo, java.lang.String)
     * 
     */
    public boolean getForward(Demo demo, String cmd){
        if(cmd.equals("add")){
            StateInterface addState = new AddState(this.manager);
            demo.setState(addState);
        }
        else if(cmd.equals("search")){
            StateInterface searchState = new SearchState(this.manager);
            demo.setState(searchState);
        }
        else if(cmd.equals("remove")){
            StateInterface removeState = new RemoveState(this.manager);
            demo.setState(removeState);
        }
        else {
            System.out.println("Use `add` command to add new address entry.");
            System.out.println("Use `search` command to get one or more address entries.");
            System.out.println("Use `remove` command to remove one or more address entries."); 
            System.out.flush();
        }
        return true;
    }
    
    /* (non-Javadoc)
     * Move backward to a precedent state.
     * @see com.eric.state.StateInterface#rollBack(com.eric.demo.Demo)
     * 
     */
    public boolean rollBack(Demo demo){
        return true;
    }

}
