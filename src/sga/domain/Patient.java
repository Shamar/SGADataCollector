/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sga.domain;

import java.util.Date;
import java.util.Enumeration;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

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
        _diagnosticTests = new DiagnosticTest[0];
    }

    Patient(JSONObject source) throws JSONException {
        _name = source.getString("Name");
        _birthDate = new Date(source.optLong("BirthDay"));
        _father = new Parent(source.getJSONObject("Father"));
        _mother = new Parent(source.getJSONObject("Mother"));
        _GHdeficit = source.optBoolean("GHDeficit", false);
        _mph = new BodyMeasure(source.getJSONObject("MPH"));

        JSONArray array = source.optJSONArray("RiskFactors");
        if(array != null)
        {
            _riskFactors = new RiskFactor[array.length()];
            for(int i = 0; i < array.length(); ++i)
                _riskFactors[i] = new RiskFactor(array.getString(i));
        }
        else
        {
            _riskFactors = new RiskFactor[0];
        }
        array = source.optJSONArray("Checkups");
        if(array != null)
        {
            _checkups = new Checkup[array.length()];
            for(int i = 0; i < array.length(); ++i)
                _checkups[i] = new Checkup(array.getJSONObject(i));
        }
        array = source.optJSONArray("DiagnosticTests");
        if(array != null)
        {
            _diagnosticTests = new DiagnosticTest[array.length()];
            for(int i = 0; i < array.length(); ++i)
                _diagnosticTests[i] = new DiagnosticTest(array.getString(i));
        }
        else
        {
            _diagnosticTests = new DiagnosticTest[0];
        }
    }

    public JSONObject toJSON() throws JSONException
    {
        JSONObject obj = new JSONObject();

        obj.put("Name", _name);
        if(null != _birthDate)
            obj.put("BirthDay", _birthDate.getTime());
        obj.put("Father", getFather().toJSON());
        obj.put("Mother", getMother().toJSON());
        obj.put("GHDeficit", _GHdeficit);
        if(null == _mph)
        {
            obj.put("MPH", new JSONObject());
        }
        else
        {
            obj.put("MPH", _mph.toJSON());
        }
        if(null == _riskFactors)
            obj.put("RiskFactors", new JSONArray());
        else
            for(int i = 0; i < _riskFactors.length; ++i)
                obj.accumulate("RiskFactors", _riskFactors[i].toString());
        if(null == _checkups)
        {
            obj.put("Checkups", new JSONArray());
        }
        else
        {
            for(int i = 0; i < _checkups.length; ++i)
                obj.accumulate("Checkups", _checkups[i].toJSON());
        }
        if(null == _riskFactors)
            obj.put("DiagnosticTests", new JSONArray());
        else
            for(int i = 0; i < _diagnosticTests.length; ++i)
                obj.accumulate("DiagnosticTests", _diagnosticTests[i].toString());

        return obj;
    }

    public Checkup newCheckup()
    {
        Checkup newCheckup;
        if(null == _checkups || _checkups.length == 0)
        {
            _checkups = new Checkup[1];
            newCheckup = new Checkup();
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

    public void removeCheckup(Checkup checkup)
    {
        for(int i = 0; i < _checkups.length; ++i)
        {
            if(_checkups[i].equals(checkup))
            {
                Checkup[] newValue = new Checkup[_checkups.length - 1];
                for(int j = 0; j < _checkups.length; ++j)
                {
                    if(j < i)
                        newValue[j] = _checkups[j];
                    else if(j > i)
                        newValue[j-1] = _checkups[j];
                }
                _checkups = newValue;
                return;
            }
        }
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
            if(riskFactor.equals(_riskFactors[i]))
                return true;
        return false;
    }

    public void addRiskFactor(RiskFactor riskFactor)
    {
        if(!occurred(riskFactor))
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
            if(_riskFactors.length == 0)
                return;
            RiskFactor[] newValue = new RiskFactor[_riskFactors.length - 1];
            int j = 0;
            boolean removed = false;
            for(int i = 0; i < _riskFactors.length; ++i)
                if(_riskFactors[i] != riskFactor)
                {
                    newValue[j++] = _riskFactors[i];
                }
                else
                {
                    removed = true;
                }
            if(removed)
                _riskFactors = newValue;
        }
    }

    public boolean getDiagnosticTestsResult(DiagnosticTest test)
    {
        for(int i = 0; i < _diagnosticTests.length; ++i)
            if(_diagnosticTests[i].equals(test))
                return true;
        return false;
    }

    public void addDiagnosticTest(DiagnosticTest test)
    {
        DiagnosticTest[] newValue;
        newValue = new DiagnosticTest[_diagnosticTests.length + 1];
        for(int i = 0; i < _diagnosticTests.length; ++i)
        {
            if(_diagnosticTests[i].equals(test))
                return;
            newValue[i] = _diagnosticTests[i];
        }
        newValue[_diagnosticTests.length] = test;
        _diagnosticTests = newValue;
    }

    public void removeDiagnosticTest(DiagnosticTest test)
    {
        if(_diagnosticTests.length == 0)
            return;
        DiagnosticTest[] newValue = new DiagnosticTest[_diagnosticTests.length - 1];
        int j = 0;
        boolean removed = false;
        for(int i = 0; i < _diagnosticTests.length; ++i)
        {
            if(!_diagnosticTests[i].equals(test))
            {
                if(j < newValue.length)
                    newValue[j++] = _diagnosticTests[i];
            }
            else
            {
                removed = true;
            }
        }
        if(removed)
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
        if(null == _father)
        {
            _father = new Parent();
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
