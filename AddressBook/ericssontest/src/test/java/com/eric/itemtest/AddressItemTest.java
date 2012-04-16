/**
 * 
 */
package com.eric.itemtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eric.item.AddressItem;

/**
 * @author hupan
 *
 */
public class AddressItemTest {
    private AddressItem item;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        item = new AddressItem();
    }

    /**
     * Test method for {@link com.eric.item.AddressItem#AddressItem()}.
     */
    @Test
    public void testAddressItem() {
        item = new AddressItem();
        assertEquals("", item.getName());
    }

    /**
     * Test method for {@link com.eric.item.AddressItem#AddressItem(java.lang.String, java.lang.String, java.lang.String)}.
     */
    @Test
    public void testAddressItemStringStringString() {
        item = new AddressItem("hupan", "138", "hupanjia");
        assertEquals("138", item.getMobileNumber());
    }

    /**
     * Test method for {@link com.eric.item.AddressItem#getName()}.
     */
    @Test
    public void testGetName() {
        assertEquals("", item.getName());
    }

    /**
     * Test method for {@link com.eric.item.AddressItem#setName(java.lang.String)}.
     */
    @Test
    public void testSetName() {
        item.setName("hupan");
        assertEquals("hupan", item.getName());
    }

    /**
     * Test method for {@link com.eric.item.AddressItem#getMobileNumber()}.
     */
    @Test
    public void testGetMobileNumber() {
        assertEquals("", item.getMobileNumber());
    }

    /**
     * Test method for {@link com.eric.item.AddressItem#setMobileNumber(java.lang.String)}.
     */
    @Test
    public void testSetMobileNumber() {
        item.setMobileNumber("138");
        assertEquals("138", item.getMobileNumber());
    }

    /**
     * Test method for {@link com.eric.item.AddressItem#getHomeAddress()}.
     */
    @Test
    public void testGetHomeAddress() {
        assertEquals("", item.getHomeAddress());
    }

    /**
     * Test method for {@link com.eric.item.AddressItem#setHomeAddress(java.lang.String)}.
     */
    @Test
    public void testSetHomeAddress() {
        item.setHomeAddress("hupanjia");
        assertEquals("hupanjia", item.getHomeAddress());
    }

}
