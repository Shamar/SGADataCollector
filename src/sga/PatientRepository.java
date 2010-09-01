/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author gtesio
 */
public class PatientRepository {
    private Hashtable _collection;
    public PatientRepository()
    {
        _collection = new Hashtable();
    }

    public int getSize()
    {
        return _collection.size();
    }

    public void createPatient(String name)
    {
        Patient newPatient = new Patient(name);
        _collection.put(name, newPatient);
    }

    public void removePatient(String name)
    {
        _collection.remove(name);
    }

    public Enumeration getPatientsNames()
    {
        return _collection.keys();
    }

    public Patient getPatient(String name)
    {
        return (Patient)_collection.get(name);
    }

}
