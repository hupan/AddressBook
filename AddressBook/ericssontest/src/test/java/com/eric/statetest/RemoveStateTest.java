/**
 * 
 */
package com.eric.statetest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eric.demo.Demo;
import com.eric.manager.ItemManager;
import com.eric.state.RemoveState;

/**
 * @author hupan
 *
 */
public class RemoveStateTest {
    private RemoveState rem;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        rem = new RemoveState();
    }

    /**
     * Test method for {@link com.eric.state.RemoveState#RemoveState()}.
     */
    @Test
    public void testRemoveState() {
        rem = new RemoveState();
        assertEquals(rem.setItemManager(new ItemManager()), true);
    }

    /**
     * Test method for {@link com.eric.state.RemoveState#RemoveState(com.eric.manager.ItemManager)}.
     */
    @Test
    public void testRemoveStateItemManager() {
        rem = new RemoveState(new ItemManager());
        assertEquals(rem.setItemManager(new ItemManager()), true);
    }

    /**
     * Test method for {@link com.eric.state.RemoveState#execute(com.eric.demo.Demo)}.
     */
    @Test
    public void testExecute() {
        
    }
    
    /**
     * Test method for {@link com.eric.state.RemoveState#execute(com.eric.demo.Demo)}.
     */
    @Test
    public void testExecuteWithString() {
        assertEquals(rem.executeWithString(new Demo(), "name"), true);
    }
    
    /**
     * Test method for {@link com.eric.state.RemoveState#execute(com.eric.demo.Demo)}.
     */
    @Test
    public void testExecuteWithStringTwo() {
        assertEquals(rem.executeWithString(new Demo(), "mobile"), true);
    }
    
    /**
     * Test method for {@link com.eric.state.RemoveState#execute(com.eric.demo.Demo)}.
     */
    @Test
    public void testExecuteWithStringThree() {
        assertEquals(rem.executeWithString(new Demo(), "address"), true);
    }
    
    /**
     * Test method for {@link com.eric.state.RemoveState#execute(com.eric.demo.Demo)}.
     */
    @Test
    public void testExecuteWithStringFour() {
        assertEquals(rem.executeWithString(new Demo(), "test"), true);
    }

    /**
     * Test method for {@link com.eric.state.RemoveState#getForward(com.eric.demo.Demo, java.lang.String)}.
     */
    @Test
    public void testGetForward() {
        assertEquals(rem.getForward(new Demo(), "name"), true);
    }

    /**
     * Test method for {@link com.eric.state.RemoveState#getForward(com.eric.demo.Demo, java.lang.String)}.
     */
    @Test
    public void testGetForwardTwo() {
        assertEquals(rem.getForward(new Demo(), "mobile"), true);
    }
    
    /**
     * Test method for {@link com.eric.state.RemoveState#getForward(com.eric.demo.Demo, java.lang.String)}.
     */
    @Test
    public void testGetForwardThree() {
        assertEquals(rem.getForward(new Demo(), "address"), true);
    }
    
    /**
     * Test method for {@link com.eric.state.RemoveState#getForward(com.eric.demo.Demo, java.lang.String)}.
     */
    @Test
    public void testGetForwardFour() {
        assertEquals(rem.getForward(new Demo(), "test"), true);
    }
    
    /**
     * Test method for {@link com.eric.state.RemoveState#rollBack(com.eric.demo.Demo)}.
     */
    @Test
    public void testRollBack() {
        assertEquals(rem.rollBack(new Demo()), true);
    }

    /**
     * Test method for {@link com.eric.state.RemoveState#setItemManager(com.eric.manager.ItemManager)}.
     */
    @Test
    public void testSetItemManager() {
        assertEquals(rem.setItemManager(new ItemManager()), true);
    }

}
