/**
 * 
 */
package com.eric.statetest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eric.demo.Demo;
import com.eric.manager.ItemManager;
import com.eric.state.AddState;
import com.eric.state.StateInterface;

/**
 * @author hupan
 *
 */
public class AddStateTest {
    private AddState addState;
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        addState = new AddState();
    }

    /**
     * Test method for {@link com.eric.state.AddState#AddState()}.
     */
    @Test
    public void testAddState() {
        addState = new AddState();
        assertEquals(addState.setItemManager(new ItemManager()), true);
    }

    /**
     * Test method for {@link com.eric.state.AddState#AddState(com.eric.manager.ItemManager)}.
     */
    @Test
    public void testAddStateItemManager() {
        addState = new AddState(new ItemManager());
        assertEquals(addState.setItemManager(new ItemManager()), true);
    }

    /**
     * Test method for {@link com.eric.state.AddState#execute(com.eric.demo.Demo)}.
     */
    @Test
    public void testExecute() {
        
    }
    
    /**
     * Test method for {@link com.eric.state.AddState#execute(com.eric.demo.Demo)}.
     */
    @Test
    public void testExecuteWithString() {
        assertEquals(addState.executeWithString(new Demo(),"hupan","138","hupanjia"),true);
    }
    
    /**
     * Test method for {@link com.eric.state.AddState#getForward(com.eric.demo.Demo, java.lang.String)}.
     */
    @Test
    public void testGetForward() {
        assertEquals(addState.getForward(new Demo(), ""), true);
    }

    /**
     * Test method for {@link com.eric.state.AddState#rollBack(com.eric.demo.Demo)}.
     */
    @Test
    public void testRollBack() {
        assertEquals(addState.rollBack(new Demo()), true);
    }

    /**
     * Test method for {@link com.eric.state.AddState#setItemManager(com.eric.manager.ItemManager)}.
     */
    @Test
    public void testSetItemManager() {
        assertEquals(addState.setItemManager(new ItemManager()), true);
    }

}
