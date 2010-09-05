/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sga.domain;

import java.util.Date;
import java.util.Enumeration;

/**
 *
 * @author gtesio
 */
public class Patient {
    private String _name;
    private Date _birthDate;
    private RiskFactor[] _riskFactors;
    private boolean _GHdeficit;
    private Parent _mother;
    private Parent _father;
    private Checkup[] _checkups;
    private DiagnosticTest[] _diagnosticTests;

    private BodyMeasure _mph;

    public Patient()
    {
        _riskFactors = new RiskFactor[0];
    }

    public Checkup newCheckup()
    {
        Checkup newCheckup;
        if(null == _checkups)
        {
            _checkups = new Checkup[1];
            newCheckup = new Checkup(null);
            _checkups[0] = newCheckup;
        }
        else
        {
            int checkupsNumber = _checkups.length;
            newCheckup = new Checkup(_checkups[checkupsNumber - 1]);
            Checkup[] newValue = new Checkup[checkupsNumber + 1];
            for(int i = 0; i < checkupsNumber; ++i)
                newValue[i] = _checkups[i];
            newValue[checkupsNumber] = newCheckup;
            _checkups = newValue;
        }
        return newCheckup;
    }

    public int numberOfCheckups()
    {
        if(null == _checkups)
            return 0;
        return _checkups.length;
    }

    public Checkup getCheckup(int index)
    {
        if(null == _checkups || index < 0 || index >= _checkups.length)
            return null;
        return _checkups[index];
    }

    public boolean getGHDeficit()
    {
        return _GHdeficit;
    }

    public void setGHDeficit(boolean deficit)
    {
        _GHdeficit = deficit;
    }

    public boolean occurred(RiskFactor riskFactor)
    {
        for(int i = 0; i < _riskFactors.length; ++i)
            if(riskFactor == _riskFactors[i])
                return true;
        return false;
    }

    public void addRiskFactor(RiskFactor riskFactor)
    {
        if(occurred(riskFactor))
        {
            RiskFactor[] newValue = new RiskFactor[_riskFactors.length + 1];
            for(int i = 0; i < _riskFactors.length; ++i)
                newValue[i] = _riskFactors[i];
            newValue[_riskFactors.length] = riskFactor;
            _riskFactors = newValue;
        }
    }

    public void removeRiskFactor(RiskFactor riskFactor)
    {
        if(occurred(riskFactor))
        {
            RiskFactor[] newValue = new RiskFactor[_riskFactors.length - 1];
            int j = 0;
            for(int i = 0; i < _riskFactors.length; ++i)
                if(_riskFactors[i] != riskFactor)
                {
                    newValue[j++] = _riskFactors[i];
                }
            _riskFactors = newValue;
        }
    }

    public boolean getDiagnosticTestsResult(DiagnosticTest test)
    {
        for(int i = 0; i < _diagnosticTests.length; ++i)
            if(_diagnosticTests[i] == test)
                return true;
        return false;
    }

    public void addDiagnosticTest(DiagnosticTest test)
    {
        DiagnosticTest[] newValue = new DiagnosticTest[_diagnosticTests.length + 1];
        for(int i = 0; i < _diagnosticTests.length; ++i)
        {
            if(_diagnosticTests[i] == test)
                return;
            newValue[i] = _diagnosticTests[i];
        }
        newValue[_diagnosticTests.length] = test;
        _diagnosticTests = newValue;
    }

    public void removeDiagnosticTest(DiagnosticTest test)
    {
        DiagnosticTest[] newValue = new DiagnosticTest[_diagnosticTests.length - 1];
        int j = 0;
        for(int i = 0; i < _diagnosticTests.length; ++i)
            if(_diagnosticTests[i] != test)
            {
                if(j < newValue.length)
                    newValue[j++] = _diagnosticTests[i];
            }
        if(j < _diagnosticTests.length)
            _diagnosticTests = newValue;
    }

    public String getName()
    {
        return _name;
    }

    public void setName(String value)
    {
        _name = value;
    }

    /**
     * @return the _birthDate
     */
    public Date getBirthDate() {
        return _birthDate;
    }

    /**
     * @param birthDate the _birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this._birthDate = birthDate;
    }

    /**
     * @return the _mother
     */
    public Parent getMother() {
        if(null == _mother)
        {
            _mother = new Parent();
        }
        return _mother;
    }

    /**
     * @return the _father
     */
    public Parent getFather() {
        if(null == _mother)
        {
            _mother = new Parent();
        }
        return _father;
    }

    /**
     * @return the _mph
     */
    public BodyMeasure getMph() {
        return _mph;
    }

    /**
     * @param mph the _mph to set
     */
    public void setMph(BodyMeasure mph) {
        this._mph = mph;
    }

    
}
