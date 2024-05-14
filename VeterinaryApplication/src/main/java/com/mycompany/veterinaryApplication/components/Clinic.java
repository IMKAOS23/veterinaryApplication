package com.mycompany.veterinaryApplication.components;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.components.animal.Animal;
import com.mycompany.veterinaryApplication.exceptions.NotFoundException;
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
    
    /**
     * Returns name of clinic
     * 
     * @return clinicName
     */
    public String getName() {
        return this.clinicName;
    }
    
    /**
     * Allows the changing of the Clinic Name
     * 
     * @param clinicName 
     */
    public void setName(String clinicName) {
        this.clinicName = clinicName;
    }
    
    /**
     * Used to add an Animal object to the clinic
     * 
     * @param animal
     * 
     * @throws IOException 
     */
    public void addAnimal(Animal animal) throws IOException {
        try {
            Tuple pair = new Tuple(this.animals.size() + 1, animal);
            this.animals.add(pair);
            App.fileHandler.serialise(this.clinicName, this);
        } catch (IOException e) {
            App.popup.showError("Error", e.getMessage());
        }
    }
    
    /**
     * Used to add an Owner object to the clinic, this is either PetOwner, Zoo, or Farm
     * 
     * @param owner
     * 
     * @throws IOException 
     */
    public void addOwner(Object owner) throws IOException {
        try {
            Tuple pair = new Tuple(this.owners.size() + 1, owner);
            this.owners.add(pair);
            App.fileHandler.serialise(this.clinicName, this);
        } catch (IOException e) {
            App.popup.showError("Error", e.getMessage());
        }
    }
    
    /**
     * Returns the list of Animals within the clinic
     * 
     * @return animals
     */
    public List getAnimals() {
        return this.animals;
    }
    
    /**
     * Returns the list of Owners within the clinic
     * 
     * @return owners
     */
    public List getOwners() {
        return this.owners;
    }
    
    /**
     * Used to find an Owner based on the ID found within the Tuple.
     * Method uses a HashMap, Splits the Tuple into KEY - VALUE pairs.
     * Then searches for a Key within the HashMap to find the corresponding owner
     * 
     * @param id
     * @return owner. Object of HousePet, Farm, or Zoo
     * 
     * @throws NotFoundException 
     */
    public Object findOwner(int id) throws NotFoundException {
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
        return (Object) owner;
    }
    
    /**
     * Used to find an Animal based on the ID found within the Tuple.
     * Method uses a HashMap, Splits the Tuple into KEY - VALUE pairs.
     * Then searches for a Key within the HashMap to find the corresponding Animal
     * 
     * @param id
     * @return animal. Object of Animal
     * 
     * @throws NotFoundException 
     */
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
}
