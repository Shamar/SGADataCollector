/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sga.domain;

/**
 *
 * @author gtesio
 */
public class Patient {
    private String _name;
    private DrugDose[] _dosages;

    public Patient()
    {
        _dosages = new DrugDose[0];
    }

    public String getName()
    {
        return _name;
    }

    public void setName(String value)
    {
        _name = value;
    }

    public DrugDose[] getDosages()
    {
        return _dosages;
    }

    public void setDosage(int index, DrugDose dosage)
    {
        if(index < _dosages.length)
            _dosages[index] = dosage;
        else
        {
            DrugDose[] newDosages = new DrugDose[_dosages.length + 1];
            for(int i = 0; i < _dosages.length; ++i)
                newDosages[i] = _dosages[i];
            newDosages[_dosages.length] = dosage;
            _dosages = newDosages;
        }
    }

    public void removeDosage(int index)
    {
        if(index < _dosages.length && index > -1)
        {
            DrugDose[] newDosages = new DrugDose[_dosages.length - 1];
            int j = 0;
            for(int i = 0; i < _dosages.length; ++i, ++j)
                if(i != index)
                    newDosages[j] = _dosages[i];
            _dosages = newDosages;

        }
    }
    
}
