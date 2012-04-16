package com.eric.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * AddressBook program.
 * @author hupan
 */
public class AddressBook {
    /**
     * ExecutorService is used to handle threads.
     */
    private static ExecutorService exec = Executors.newCachedThreadPool();
    
    /**
     * Entrance of the program.
     * ExecutorService is used to handle threads.
     * @param args
     */
    public static void main(String[] args){
        exec.execute(new Demo());
        exec.shutdownNow();
    }
}
