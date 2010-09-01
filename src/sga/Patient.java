/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sga;

/**
 *
 * @author gtesio
 */
public class Patient {
    private String _name;
    private double[] _dosages;

    public Patient(String name)
    {
        _dosages = new double[0];
    }

    public String getName()
    {
        return _name;
    }

    public double[] getDosages()
    {
        return _dosages;
    }

    public void addDosage(double dosage)
    {
        double[] newDosages = new double[_dosages.length + 1];
        for(int i = 0; i < _dosages.length; ++i)
            newDosages[i] = _dosages[i];
        newDosages[_dosages.length] = dosage;
        _dosages = newDosages;
    }

    
}
