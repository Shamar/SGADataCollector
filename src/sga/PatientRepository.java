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
    private Patient[] _collection;
    public PatientRepository()
    {
        _collection = new Patient[0];
    }

    public int getSize()
    {
        return _collection.length;
    }

    public void createPatient(String name)
    {
        Patient newPatient = new Patient(name);
        Patient[] collection = new Patient[_collection.length + 1];
        for(int i = 0 ; i< _collection.length; ++i)
            collection[i] = _collection[i];
        collection[_collection.length] = newPatient;
    }

    public Patient getPatient(int index) {
        if(index < 0 || index >= _collection.length)
            return null;
        return _collection[index];
    }

}
