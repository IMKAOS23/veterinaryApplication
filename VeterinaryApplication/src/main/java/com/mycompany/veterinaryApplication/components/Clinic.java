package com.mycompany.veterinaryApplication.components;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.components.animal.Animal;
import com.mycompany.veterinaryApplication.components.business.Business;
import com.mycompany.veterinaryApplication.components.person.Person;
import com.mycompany.veterinaryApplication.exceptions.NotFoundException;
import com.mycompany.veterinaryApplication.exceptions.OwnerNotFoundException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Clinic class used to the creation of Clinic objects
 * 
 * @author markc
 */
public class Clinic implements Serializable{
    private String clinicName;
    
    // Using HashMaps as more scalable than standard Lists
    private List<Tuple<Integer, Object>> animals;
    private List<Tuple<Integer, Object>> owners;
    
    public Clinic(String clinicName) throws FileNotFoundException, IOException {
        /**
         * 
         * Constructs a Clinic with given Clinic Name
         * Initiates the required Lists
         * 
         * @param clinicName Name of the Clinic
         */
        this.clinicName = clinicName;
        
        
        this.animals = new ArrayList<>();
        this.owners = new ArrayList<>();
        
        App.fileHandler.serialise(this.clinicName, this);
    }
    
    public String getName() {
        return this.clinicName;
    }
    
    public void setName(String clinicName) {
        this.clinicName = clinicName;
    }
    
    public void addAnimal(Object animal) throws IOException {
        try {
            Tuple pair = new Tuple(getLastId(this.animals) + 1, animal);
            this.animals.add(pair);
            App.fileHandler.serialise(this.clinicName, this);
        } catch (IOException e) {
            App.popup.showError("Error", e.getMessage());
        }
    }
    
    public void addOwner(Object owner) throws IOException {
        try {
            Tuple pair = new Tuple(getLastId(this.owners) + 1, owner);
            this.owners.add(pair);
            App.fileHandler.serialise(this.clinicName, this);
        } catch (IOException e) {
            App.popup.showError("Error", e.getMessage());
        }
    }
    
    public List getOwners() {
        return this.owners;
    }
    
    public Person findOwner(int id) throws NotFoundException {
        Map<Integer, Object> ownerMap = new HashMap<>();

        List<Tuple<Integer, Object>> owners = App.openClinic.getOwners();

        // Add All Owners to the OwnerMap - (Using HashMap for Faster retrieval of Data)
        for (Tuple<Integer, Object> tuple : owners) {
            ownerMap.put(tuple.getKey(), tuple.getValue());
        }

        // Retrieve the owner using the stored owner ID
        Object owner = ownerMap.get(id);
        if (owner == null) {
            // Handle case where owner ID is not found
            throw new NotFoundException("Not Found Error: Person not found within Clinic");
        }
        return (Person) owner;
    }
    
    public Animal findAnimal(int id) throws NotFoundException {
        Map<Integer, Object> animalMap = new HashMap<>();

        List<Tuple<Integer, Object>> animals = App.openClinic.getAnimals();

        // Add All Owners to the OwnerMap - (Using HashMap for Faster retrieval of Data)
        for (Tuple<Integer, Object> tuple : animals) {
            animalMap.put(tuple.getKey(), tuple.getValue());
        }

        // Retrieve the owner using the stored owner ID
        Object animal = animalMap.get(id);
        if (animal == null) {
            // Handle case where owner ID is not found
            throw new NotFoundException("Not Found Error: Animal not found within Clinic");
        }
        return (Animal) animal;
    }
    
    public List getAnimals() {
        return this.animals;
    }
    
    private int getLastId(List list) {
        // Quick check if empty
        if (list.isEmpty()) {
            return 0;
        }
        
        // Checks for Highest ID
        int biggestVal = 0;
        for (int i = 0; i < list.size(); i++) {
           Tuple tuple = (Tuple) list.get(i);
           if ((int) tuple.getKey() > biggestVal) {
               biggestVal = (int) tuple.getKey();
           }
        }
        return biggestVal;
    }
}