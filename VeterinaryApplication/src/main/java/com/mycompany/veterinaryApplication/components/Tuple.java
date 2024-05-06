/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components;

import java.io.Serializable;

/**
 * Tuple Class for Key-Value Pairs
 * 
 * This class was created to be used instead of HashMaps to maintain integrity of code
 * by preventing the changing of Keys or Values.
 *
 * My Use case is to be used along side an ArrayList to Store (Ids, Objects) for different Clinic
 * Elements such as Animals, Appointments, People, Businesses, ETC.
 * 
 * @author markc
 * @param <K> Type of the Key
 * @param <V> Type of the Value
 */
public class Tuple<K, V> implements Serializable{
    private final K key;
    private final V value;
    
    /**
     * Constructs a new Tuple with the specified key and value.
     * As Tuple Class used Type Parameters over Actual Types such as String 
     * Key and Value could be of ANY type
     *
     * @param key
     * @param value 
     */
    public Tuple(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    /**
     * Returns the Key of the Tuple
     * 
     * @return key
     */
    public K getKey() {
        return this.key;
    }
    
    /**
     * Returns the Value of the Tuple
     * 
     * @return value
     */
    public V getValue() {
        return this.value;
    }
}
