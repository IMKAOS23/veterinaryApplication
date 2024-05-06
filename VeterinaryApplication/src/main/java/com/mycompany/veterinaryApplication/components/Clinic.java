package com.mycompany.veterinaryApplication.components;

import com.mycompany.veterinaryApplication.App;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
/**
 * Clinic class used to the creation of Clinic objects
 * 
 * @author markc
 */
public class Clinic implements Serializable{
    private String clinicName;
    
    // Using HashMaps as more scalable than standard Lists
    private List<Tuple> animals;
    private List<Tuple> people;
    private List<Tuple> businesses;
    private List appointments;
    
    // Using these to Keep track of IDs even when App has been closed
    private int lastAnimalId;
    private int lastPersonId;
    private int lastBusinessId;
    private int lastAppointmentId;
    
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
        this.people = new ArrayList<>();
        this.businesses = new ArrayList<>();
        this.appointments = new ArrayList<>();
        
        // Initiating the Ids at 0
        lastAnimalId = 0;
        lastPersonId = 0;
        lastBusinessId = 0;
        lastAppointmentId = 0;
        
        App.fileHandler.serialise(this.clinicName, this);
    }
    
    public String getName() {
        return this.clinicName;
    }
    
    public void setName(String clinicName) {
        this.clinicName = clinicName;
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