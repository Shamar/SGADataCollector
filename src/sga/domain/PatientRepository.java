/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.domain;

import java.util.Enumeration;
import java.util.Hashtable;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;
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

    public void addPatient(Patient newPatient)
    {
        Patient[] collection = new Patient[_collection.length + 1];
        for(int i = 0 ; i < _collection.length; ++i)
            collection[i] = _collection[i];
        collection[_collection.length] = newPatient;
        _collection = collection;
    }

    public Patient getPatient(int index) {
        if(index < 0 || index >= _collection.length)
            return null;
        return _collection[index];
    }

    public JSONArray toJSON() throws JSONException
    {
        JSONArray arr = new JSONArray();

        for(int i = 0; i < _collection.length; ++i)
            arr.put(_collection[i].toJSON());

        return arr;
    }

    public void fromJSON(JSONArray array) throws JSONException
    {
        if(array != null)
        {
            _collection = new Patient[array.length()];
            for(int i = 0; i < array.length(); ++i)
            {
                _collection[i] = new Patient(array.getJSONObject(i));
            }
        }
    }
}
