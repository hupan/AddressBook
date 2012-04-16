package com.eric.manager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.w3c.dom.Document;

import com.eric.item.*;
import com.eric.util.PersistService;

/**
 * ItemManager has a series of methods including add, search and remove.
 * @author hupan
 * 
 */
public class ItemManager {
    private List<AddressItem> addressList;
    private Document doc;
    
    /**
     * Output the result of delete.
     * @param cnt
     * 
     */
    private void deleteResults(int cnt){
        if(cnt == 0){
            System.out.println("No entry deleted.");
        }
        else if(cnt == 1){
            System.out.println("1 address entry deleted.");
        }
        else {
            System.out.println(cnt + " address entries deleted.");
        }
    }
    
    /**
     * Output the results of an adding action.
     * @param tempResults
     * 
     */
    private void outputResults(List<AddressItem> tempResults){
        String outputString = null;
        int tempResultsSize = tempResults.size();
        if(tempResultsSize == 0){
            System.out.println("No entry found.");
        }
        else if(tempResultsSize == 1){
            outputString = tempResultsSize + " address entry found.";
            System.out.println(outputString);
            Iterator<AddressItem> it = tempResults.iterator();
            it.hasNext();
            AddressItem tempAddress = it.next();
            System.out.print("name: ");
            System.out.println(tempAddress.getName());
            System.out.print("mobile: ");
            System.out.println(tempAddress.getMobileNumber());
            System.out.print("address: ");
            System.out.println(tempAddress.getHomeAddress());
        }
        else{
            outputString = tempResultsSize + " address entries found.";
            System.out.println(outputString);
            for(Iterator<AddressItem> it = tempResults.iterator(); it.hasNext(); ){
                AddressItem tempAddress = it.next();
                System.out.print("name: ");
                System.out.println(tempAddress.getName());
                System.out.print("mobile: ");
                System.out.println(tempAddress.getMobileNumber());
                System.out.print("address: ");
                System.out.println(tempAddress.getHomeAddress());
                System.out.println("");
            }
        }
    }
    
    /**
     * Constructor without parameter.
     */
    public ItemManager(){
        this.addressList = new ArrayList<AddressItem>();
        this.doc = null;
        this.doc = PersistService.load(doc, addressList);
    }
    
    /**
     * Constructor with list of addresses and the document as parameters.
     * @param addressList
     * @param doc
     * 
     */
    public ItemManager(List<AddressItem> addressList, Document doc){
        this.addressList = addressList;
        this.doc = doc;
    }
    
    /**
     * Copy constructor.
     * @param manager
     * 
     */
    public ItemManager(ItemManager manager){
        this.addressList = manager.getAddressList();
        this.doc = manager.getDoc();
    }
    
    /**
     * Get the current document.
     * @return
     * 
     */
    public Document getDoc(){
        return this.doc;
    }
    
    /**
     * Set the current document as a certain value.
     * @param doc
     * 
     */
    public void setDoc(Document doc){
        this.doc = doc;
    }
    
    /**
     * Get the list of the current address entries.
     * @return
     * 
     */
    public List<AddressItem> getAddressList(){
        return this.addressList;
    }
    
    /**
     * Set the list of the current address entries as a certain value.
     * @param addressList
     * 
     */
    public void setAddressList(List<AddressItem> addressList){
        this.addressList = addressList;
    }
    
    /**
     * Add an entry.
     * @param name
     * @param mobileNumber
     * @param homeAddress
     * @return
     * 
     */
    public boolean addEntry(String name, String mobileNumber, String homeAddress){
        this.doc = PersistService.load(doc, addressList);
        AddressItem toBeAdded = new AddressItem(name, mobileNumber, homeAddress);
        addressList.add(toBeAdded);
        this.doc = PersistService.addNode(doc, name, mobileNumber, homeAddress);
        return true;
    }
    
    /**
     * Search entry(entries) using entry name.
     * @param name
     * @return
     * 
     */
    public boolean searchEntryByName(String name){
        this.doc = PersistService.load(doc, addressList);
        List<AddressItem> tempResults = new ArrayList<AddressItem>();
        Pattern pattern = null;
        Matcher matcher = null;
        name = "^" + name + "$";
        
        try{
            pattern = Pattern.compile(name);
        }
        catch(PatternSyntaxException e){
            e.printStackTrace();
            System.out.println("Error! Please re-input the name.");
            return false;
        }
        
        for(Iterator<AddressItem> it = this.addressList.iterator(); it.hasNext(); ){
            AddressItem tempAddress = it.next();
            String currentName = tempAddress.getName();
            matcher = pattern.matcher(currentName);
            if(matcher.find() == true){
                tempResults.add(tempAddress);
            }
        }
        
        this.outputResults(tempResults);
        return true;
    }
    
    /**
     * Search entry(entries) using mobile number.
     * @param mobile
     * @return
     * 
     */
    public boolean searchEntryByMobile(String mobile){
        this.doc = PersistService.load(doc, addressList);
        List<AddressItem> tempResults = new ArrayList<AddressItem>();
        Pattern pattern = null;
        Matcher matcher = null;
        mobile = "^" + mobile + "$";
        
        try{
            pattern = Pattern.compile(mobile);
        }
        catch(PatternSyntaxException e){
            e.printStackTrace();
            System.out.println("Error! Please re-input the mobile number.");
            return false;
        }
        
        for(Iterator<AddressItem> it = this.addressList.iterator(); it.hasNext(); ){
            AddressItem tempAddress = it.next();
            String currentMobile = tempAddress.getMobileNumber();
            matcher = pattern.matcher(currentMobile);
            if(matcher.find() == true){
                tempResults.add(tempAddress);
            }
        }
        
        
        this.outputResults(tempResults);
        return true;
    }
    
    /**
     * Search entry(entries) using address.
     * @param address
     * @return
     * 
     */
    public boolean searchEntryByAddress(String address){
        this.doc = PersistService.load(doc, addressList);
        List<AddressItem> tempResults = new ArrayList<AddressItem>();
        Pattern pattern = null;
        Matcher matcher = null;
        address = "^" + address + "$";
        
        try{
            pattern = Pattern.compile(address);
        }
        catch(PatternSyntaxException e){
            e.printStackTrace();
            System.out.println("Error! Please re-input the address.");
            return false;
        }
        
        for(Iterator<AddressItem> it = this.addressList.iterator(); it.hasNext(); ){
            AddressItem tempAddress = it.next();
            String currentAddress = tempAddress.getHomeAddress();
            matcher = pattern.matcher(currentAddress);
            if(matcher.find() == true){
                tempResults.add(tempAddress);
            }
        }
        
        this.outputResults(tempResults);
        return true;
    }
    
    /**
     * Remove entry(entries) with a certain name.
     * @param name
     * @return
     * 
     */
    public boolean removeEntryByName(String name){
        this.doc = PersistService.load(doc, addressList);
        int cnt = 0;
        Pattern pattern = null;
        Matcher matcher = null;
        name = "^" + name + "$";
        
        try{
            pattern = Pattern.compile(name);
        }
        catch(PatternSyntaxException e){
            e.printStackTrace();
            System.out.println("Error! Please re-input the name.");
            return false;
        }
        
        for(Iterator<AddressItem> it = this.addressList.iterator(); it.hasNext(); ){
            String currentName = it.next().getName();
            matcher = pattern.matcher(currentName);
            if(matcher.find() == true){
                it.remove();
                cnt ++;
            }
        }
        
        this.doc = PersistService.persist(doc, this.addressList);
        this.deleteResults(cnt);
        return true;
    }
    
    /**
     * Remove entry(entries) with a certain mobile number.
     * @param mobile
     * @return
     * 
     */
    public boolean removeEntryByMobile(String mobile){
        this.doc = PersistService.load(doc, addressList);
        int cnt = 0;
        Pattern pattern = null;
        Matcher matcher = null;
        mobile = "^" + mobile + "$";
        
        try{
            pattern = Pattern.compile(mobile);
        }
        catch(PatternSyntaxException e){
            e.printStackTrace();
            System.out.println("Error! Please re-input the mobile number.");
            return false;
        }
        
        for(Iterator<AddressItem> it = this.addressList.iterator(); it.hasNext(); ){
            String currentMobile = it.next().getMobileNumber();
            matcher = pattern.matcher(currentMobile);
            if(matcher.find() == true){
                it.remove();
                cnt ++;
            }
        }
        
        this.doc = PersistService.persist(doc, this.addressList);
        this.deleteResults(cnt);
        return true;
    }
    
    /**
     * Remove entry(entries) with a certain address.
     * @param address
     * @return
     * 
     */
    public boolean removeEntryByAddress(String address){
        this.doc = PersistService.load(doc, addressList);
        int cnt = 0;
        Pattern pattern = null;
        Matcher matcher = null;
        address = "^" + address + "$";
        
        try{
            pattern = Pattern.compile(address);
        }
        catch(PatternSyntaxException e){
            e.printStackTrace();
            System.out.println("Error! Please re-input the address.");
            return false;
        }
        
        for(Iterator<AddressItem> it = this.addressList.iterator(); it.hasNext(); ){
            String currentAddress = it.next().getHomeAddress();
            matcher = pattern.matcher(currentAddress);
            if(matcher.find() == true){
                it.remove();
                cnt ++;
            }
        }
        
        this.doc = PersistService.persist(doc, this.addressList);
        this.deleteResults(cnt);
        return true;
    }
}
