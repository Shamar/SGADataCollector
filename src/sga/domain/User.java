/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.domain;

/**
 *
 * @author giacomo
 */
public class User {

    private static User _instance;
    public static User getInstance()
    {
        if(null == _instance)
            _instance = new User();
        return _instance;
    }
    private User()
    {
        _repository = new PatientRepository();
    }

    private PatientRepository _repository;
    public PatientRepository getRepository()
    {
        return _repository;
    }

    private Patient _selectedPatient;
    public void setSelectedPatient(Patient patient)
    {
        _selectedPatient = patient;
    }

    public Patient getSelectedPatient()
    {
        return _selectedPatient;
    }
}
