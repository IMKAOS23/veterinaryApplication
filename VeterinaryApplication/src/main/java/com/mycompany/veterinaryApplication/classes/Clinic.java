package com.mycompany.veterinaryApplication.classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author markc
 */
public class Clinic implements Serializable{
    // Basic Store Information
    private String clinicName;
    
    // Using HashMaps as more scalable than standard Lists
    private Map<Integer, Owner> petOwners;
    private Map<Integer, Vet> vets;
    private Map<Integer, HousePet> housePets;
    private Map<Integer, ZooAnimal> zooAnimals;
    private Map<Integer, Zoo> zoos;
    
    // First Constructor - Used when creating an initial Clinic
    public Clinic(String clinicName) throws FileNotFoundException {
        // Stores the Clinic Name
        this.clinicName = clinicName;
        
        // Creates Empty HashMaps of Necessary types
        this.petOwners = new HashMap<>();
        this.vets = new HashMap<>();
        this.housePets = new HashMap<>();
        this.zooAnimals = new HashMap<>();
        this.zoos = new HashMap<>();
        
        String filename = this.clinicName + ".txt";
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(this);
            System.out.println("Data Saved to " + filename);
        }  
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Overides the initial Constructor - Used when opening a clinic
    public Clinic(String clinicName, Map<Integer, Owner> petOwners, Map<Integer, Vet> vets,
            Map<Integer, HousePet> housePets, Map<Integer, ZooAnimal> zooAnimals, Map<Integer, Zoo> zoos) {
        // Stores the clinic Name
        this.clinicName = clinicName;
        
        // Stores the Already iniated Maps
        this.petOwners = petOwners;
        this.vets = vets;
        this.housePets = housePets;
        this.zooAnimals = zooAnimals;
        this.zoos = zoos;
    }
    
    public String getName() {
        return this.clinicName;
    }
    
    public void setName(String clinicName) {
        this.clinicName = clinicName;
    }
    
    public void addPetOwner(Owner owner) {
        if (this.petOwners.isEmpty()) {
           this.petOwners.put(1, owner);
        }
        else {
            int key = findHighestKey(this.petOwners) + 1;
            this.petOwners.put(key, owner);
        }
    }
    
    // Used to retrieve the highest key within the Map
    private static Integer findHighestKey(Map<Integer, ?> map) {
        int highestKey = Integer.MIN_VALUE;
        for (Integer key : map.keySet()) {
            if (key > highestKey){
                highestKey = key;
            }
        }
        return highestKey;
    }
}

