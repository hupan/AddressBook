package com.eric.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.eric.item.AddressItem;

/**
 * Service that deals with persisting data to XML.
 * @author hupan
 * 
 */
public class PersistService {
    /**
     * Static method that save a certain document to XML file.
     * @param doc
     * 
     */
    private static void saveToXml(Document doc){
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("data.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Add an entry to the database.
     * @param doc
     * @param name
     * @param mobile
     * @param address
     * @return
     * 
     */
    public static Document addNode(Document doc, String name, String mobile, String address){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Element root = null;
        Element addressentry = null;
        Element entryname = null;
        Element entrymobile = null;
        Element entryaddress = null;
        
        factory.setIgnoringElementContentWhitespace(true);
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            if(doc == null){
                doc = builder.newDocument();
                root = doc.createElement("entries");
                addressentry = doc.createElement("entry");
                entryname = doc.createElement("name");
                entryname.setTextContent(name);
                entrymobile = doc.createElement("mobile");
                entrymobile.setTextContent(mobile);
                entryaddress = doc.createElement("address");
                entryaddress.setTextContent(address);
                addressentry.appendChild(entryname);
                addressentry.appendChild(entrymobile);
                addressentry.appendChild(entryaddress);
                root.appendChild(addressentry);
                doc.appendChild(root);
                saveToXml(doc);
            }
            else{
                addressentry = doc.createElement("entry");
                entryname = doc.createElement("name");
                entryname.setTextContent(name);
                entrymobile = doc.createElement("mobile");
                entrymobile.setTextContent(mobile);
                entryaddress = doc.createElement("address");
                entryaddress.setTextContent(address);
                addressentry.appendChild(entryname);
                addressentry.appendChild(entrymobile);
                addressentry.appendChild(entryaddress);
                root = doc.getDocumentElement();
                root.appendChild(addressentry);
                saveToXml(doc);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } 
        return doc;
    }
    
    /**
     * Load data in XML file to memory.
     * @param doc
     * @param add
     * @return
     * 
     */
    public static Document load(Document doc, List<AddressItem> add){
        if(add!=null)
            add.clear();
        File file = new File("data.xml");
        if(!file.exists())
            return null;
        else{
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            NodeList nameList = null;
            NodeList mobileList = null;
            NodeList addressList = null;
            factory.setIgnoringElementContentWhitespace(true);
            
            
            try {
                builder = factory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
            
            try {
                doc = builder.parse(file);
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            nameList = doc.getElementsByTagName("name");
            mobileList = doc.getElementsByTagName("mobile");
            addressList = doc.getElementsByTagName("address");

            for(int i = 0; i < nameList.getLength(); i++){
                String tempName = nameList.item(i).getTextContent();
                String tempMobile = mobileList.item(i).getTextContent();
                String tempAddress = addressList.item(i).getTextContent();
                add.add(new AddressItem(tempName, tempMobile, tempAddress));
            }
            
            return doc;
        }
    }
    
    /**
     * Store memory data to XML file on the disk.
     * @param doc
     * @param addr
     * @return
     * 
     */
    public static Document persist(Document doc, List<AddressItem> addr){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Element root = null;
        Element addressentry = null;
        Element entryname = null;
        Element entrymobile = null;
        Element entryaddress = null;
        
        factory.setIgnoringElementContentWhitespace(true);
        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.newDocument();
            root = doc.createElement("entries");
            for(Iterator<AddressItem> it = addr.iterator(); it.hasNext(); ){
                AddressItem temp = it.next();
                addressentry = doc.createElement("entry");
                entryname = doc.createElement("name");
                entryname.setTextContent(temp.getName());
                entrymobile = doc.createElement("mobile");
                entrymobile.setTextContent(temp.getMobileNumber());
                entryaddress = doc.createElement("address");
                entryaddress.setTextContent(temp.getHomeAddress());
                addressentry.appendChild(entryname);
                addressentry.appendChild(entrymobile);
                addressentry.appendChild(entryaddress);
                root.appendChild(addressentry);
            }
            doc.appendChild(root);
            saveToXml(doc);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } 
        
        return doc;
    }
}
