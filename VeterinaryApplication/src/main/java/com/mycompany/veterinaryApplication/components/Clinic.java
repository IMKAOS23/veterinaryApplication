package com.mycompany.veterinaryApplication.components;

import com.mycompany.veterinaryApplication.components.person.PetOwner;
import com.mycompany.veterinaryApplication.components.person.Vet;
import com.mycompany.veterinaryApplication.components.animal.HousePet;
import com.mycompany.veterinaryApplication.components.animal.ZooAnimal;
import com.mycompany.veterinaryApplication.components.business.Zoo;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author markc
 */
public class Clinic implements Serializable{
    /**
     * To-do for Clinic Class
     * - Adapt Lists to be Easier to Read etc etc
     * - Make sure Information is not Duplicated such as how Pets are linked to Owners/Business.
     */
    // Basic Store Information
    private String clinicName;
    
    // Using HashMaps as more scalable than standard Lists
    private Map<Integer, PetOwner> petOwners;
    private Map<Integer, Vet> vets;
    private Map<Integer, HousePet> housePets;
    private Map<Integer, ZooAnimal> zooAnimals;
    private Map<Integer, Zoo> zoos;
    
    // Using these to Keep track of IDs even when App has been closed
    private int lastAnimalId;
    private int lastPersonId;
    private int lastBusinessId;
    private int lastAppointmentId;
    
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
        
        // Initiating the Ids at 0
        lastAnimalId = 0;
        lastPersonId = 0;
        lastBusinessId = 0;
        lastAppointmentId = 0;
        
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
    public Clinic(String clinicName, Map<Integer, PetOwner> petOwners, Map<Integer, Vet> vets,
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
    
    public void getAnimals() {
    }
    
    public void addPetOwner(PetOwner owner) {
    }
    
    public void increaseAnimalId() {
        this.lastAnimalId += 1;
    }
    
    public int getLastAnimalId() {
        return this.lastAnimalId;
    }
    
    public void increasePersonId() {
        this.lastPersonId += 1;
    }
    
    public int getLastPersonId() {
        return this.lastPersonId;
    }
    
    public void increaseBusinessId() {
        this.lastBusinessId += 1;
    }
    
    public int getLastBusinessId() {
        return this.lastBusinessId;
    }
    
    public void increaseAppointmenId() {
        this.lastBusinessId += 1;
    }
    
    public int getLastAppointmentId() {
        return this.lastAppointmentId;
    }
}

