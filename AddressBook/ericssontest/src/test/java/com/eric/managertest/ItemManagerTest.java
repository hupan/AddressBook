/**
 * 
 */
package com.eric.managertest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import com.eric.item.AddressItem;
import com.eric.manager.ItemManager;

/**
 * @author hupan
 *
 */
public class ItemManagerTest {
    private ItemManager manager;
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        manager = new ItemManager();
    }

    /**
     * Test method for {@link com.eric.manager.ItemManager#ItemManager()}.
     */
    @Test
    public void testItemManager() {
        manager.getAddressList().clear();
        assertEquals(manager.getAddressList().size(), 0);
    }

    /**
     * Test method for {@link com.eric.manager.ItemManager#ItemManager(java.util.List, org.w3c.dom.Document)}.
     */
    @Test
    public void testItemManagerListOfAddressItemDocument() {
        ItemManager newManager = new ItemManager(this.manager.getAddressList(), this.manager.getDoc());
        newManager.getAddressList().clear();
        assertEquals(newManager.getAddressList().size(), 0);
    }

    /**
     * Test method for {@link com.eric.manager.ItemManager#ItemManager(com.eric.manager.ItemManager)}.
     */
    @Test
    public void testItemManagerItemManager() {
        ItemManager newManager = new ItemManager(this.manager);
        newManager.getAddressList().clear();
        assertEquals(newManager.getAddressList().size(), 0);
    }

    /**
     * Test method for {@link com.eric.manager.ItemManager#getDoc()}.
     */
    @Test
    public void testGetDoc() {
        Document doc = manager.getDoc();
        manager.setDoc(doc);
    }

    /**
     * Test method for {@link com.eric.manager.ItemManager#setDoc(org.w3c.dom.Document)}.
     */
    @Test
    public void testSetDoc() {
        Document doc = manager.getDoc();
        manager.setDoc(doc);
    }

    /**
     * Test method for {@link com.eric.manager.ItemManager#getAddressList()}.
     */
    @Test
    public void testGetAddressList() {
        List<AddressItem> addressList = manager.getAddressList();
        addressList.clear();
        assertEquals(addressList.size(), 0);
    }

    /**
     * Test method for {@link com.eric.manager.ItemManager#setAddressList(java.util.List)}.
     */
    @Test
    public void testSetAddressList() {
        List<AddressItem> addressList = new ArrayList<AddressItem>();
        manager.setAddressList(addressList);
        assertEquals(manager.getAddressList().size(), 0);
    }

    /**
     * Test method for {@link com.eric.manager.ItemManager#addEntry(java.lang.String, java.lang.String, java.lang.String)}.
     */
    @Test
    public void testAddEntry() {
        assertEquals(manager.addEntry("hupan", "138", "hupanjia"), true);
    }

    /**
     * Test method for {@link com.eric.manager.ItemManager#searchEntryByName(java.lang.String)}.
     */
    @Test
    public void testSearchEntryByName() {
        assertEquals(manager.searchEntryByName("hupan"), true);
    }

    /**
     * Test method for {@link com.eric.manager.ItemManager#searchEntryByName(java.lang.String)}.
     */
    @Test
    public void testSearchEntryByNameTwo() {
        assertEquals(manager.searchEntryByName("hupan"), true);
    }
    
    /**
     * Test method for {@link com.eric.manager.ItemManager#searchEntryByName(java.lang.String)}.
     */
    @Test
    public void testSearchEntryByNameThree() {
        manager.addEntry("hupan", "138", "hupanjia");
        manager.addEntry("hupan", "138", "hupanjia");
        manager.addEntry("hupan", "138", "hupanjia");
        assertEquals(manager.searchEntryByName("hupan"), true);
    }
    
    /**
     * Test method for {@link com.eric.manager.ItemManager#searchEntryByName(java.lang.String)}.
     */
    @Test
    public void testSearchEntryByNameFour() {
        assertEquals(manager.searchEntryByName("hupan("), false);
    }
    
    /**
     * Test method for {@link com.eric.manager.ItemManager#searchEntryByName(java.lang.String)}.
     */
    @Test
    public void testSearchEntryByNameFive() {
        manager.removeEntryByName("hupan");
        assertEquals(manager.searchEntryByName("hupan"), true);
    }
    
    /**
     * Test method for {@link com.eric.manager.ItemManager#searchEntryByMobile(java.lang.String)}.
     */
    @Test
    public void testSearchEntryByMobile() {
        assertEquals(manager.searchEntryByMobile("138"), true);
    }
    
    /**
     * Test method for {@link com.eric.manager.ItemManager#searchEntryByMobile(java.lang.String)}.
     */
    @Test
    public void testSearchEntryByMobileTwo() {
        assertEquals(manager.searchEntryByMobile("138("), false);
    }

    /**
     * Test method for {@link com.eric.manager.ItemManager#searchEntryByAddress(java.lang.String)}.
     */
    @Test
    public void testSearchEntryByAddress() {
        assertEquals(manager.searchEntryByAddress("hupanjia"), true);
    }
    
    /**
     * Test method for {@link com.eric.manager.ItemManager#searchEntryByAddress(java.lang.String)}.
     */
    @Test
    public void testSearchEntryByAddressTwo() {
        assertEquals(manager.searchEntryByAddress("hupanjia("), false);
    }

    /**
     * Test method for {@link com.eric.manager.ItemManager#removeEntryByName(java.lang.String)}.
     */
    @Test
    public void testRemoveEntryByName() {
        manager.addEntry("hupan", "138", "hupanjia");
        assertEquals(manager.removeEntryByName("hupan"), true);
    }
    
    /**
     * Test method for {@link com.eric.manager.ItemManager#removeEntryByName(java.lang.String)}.
     */
    @Test
    public void testRemoveEntryByNameTwo() {
        assertEquals(manager.removeEntryByName("hupan("), false);
    }


    /**
     * Test method for {@link com.eric.manager.ItemManager#removeEntryByMobile(java.lang.String)}.
     */
    @Test
    public void testRemoveEntryByMobile() {
        manager.addEntry("hupan", "138", "hupanjia");
        assertEquals(manager.removeEntryByMobile("138"), true);
        
    }
    
    /**
     * Test method for {@link com.eric.manager.ItemManager#removeEntryByMobile(java.lang.String)}.
     */
    @Test
    public void testRemoveEntryByMobileTwo() {
        assertEquals(manager.removeEntryByMobile("138("), false);
        
    }

    /**
     * Test method for {@link com.eric.manager.ItemManager#removeEntryByAddress(java.lang.String)}.
     */
    @Test
    public void testRemoveEntryByAddress() {
        manager.addEntry("hupan", "138", "hupanjia");
        assertEquals(manager.removeEntryByAddress("hupanjia"), true);
    }
    
    /**
     * Test method for {@link com.eric.manager.ItemManager#removeEntryByAddress(java.lang.String)}.
     */
    @Test
    public void testRemoveEntryByAddressTwo() {
        manager.addEntry("hupan", "138", "hupanjia");
        assertEquals(manager.removeEntryByAddress("hupanjia("), false);
    }

}
