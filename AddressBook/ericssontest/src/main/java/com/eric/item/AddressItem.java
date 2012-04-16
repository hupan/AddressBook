package com.eric.item;
import java.lang.String;;

/**
 * Domain object AddressItem is used to represent an entry of (name, mobile, address).
 * @author hupan
 * 
 */
public class AddressItem {
    private String name;
    private String mobileNumber;
    private String homeAddress;
    
    /**
     * Constructor without parameter.
     */
    public AddressItem(){
        this.name = "";
        this.mobileNumber = "";
        this.homeAddress = "";
    }
    
    /**
     * Constructor with entry name, mobile number and address as three parameters.
     * @param name
     * @param mobileNumber
     * @param homeAddress
     * 
     */
    public AddressItem(String name, String mobileNumber, String homeAddress){
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.homeAddress = homeAddress;
    }
    
    /**
     * Get entry name of the instance.
     * @return
     * 
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Set entry name as a certain value.
     * @param name
     * 
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Get mobile number of the instance.
     * @return
     * 
     */
    public String getMobileNumber(){
        return this.mobileNumber;
    }
    
    /**
     * Set mobile number as a certain value.
     * @param mobileNumber
     * 
     */
    public void setMobileNumber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }
    
    /**
     * Get address of the instance.
     * @return
     * 
     */
    public String getHomeAddress(){
        return this.homeAddress;
    }
    
    /**
     * Set address as a certain value.
     * @param homeAddress
     * 
     */
    public void setHomeAddress(String homeAddress){
        this.homeAddress = homeAddress;
    }
}
