/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.views;

import com.sun.midp.lcdui.Text;
import java.util.Date;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import sga.domain.BodyMeasure;
import sga.domain.Patient;
import sga.domain.User;

/**
 *
 * @author giacomo
 */
public final class PatientForm extends Form {
    private TextField _name = new TextField("Nome", "", 64, TextField.INITIAL_CAPS_WORD);
    private TextField _mphValue = new TextField("MPH (cm)", null, 6, TextField.DECIMAL);
    private TextField _mphCentile = new TextField("MPH (centile)", null, 2, TextField.NUMERIC);
    private DateField _birthDate = new DateField("Data di nascita", DateField.DATE);
    //private ChoiceGroup _deficit = new ChoiceGroup("", Choice.MULTIPLE);

    
    public PatientForm(Patient selected)
    {
        super("Nuovo Paziente");
        if(null != selected.getName())
            this.setTitle(selected.getName());
        //_deficit.append("In Deficit GH", null);
        //_deficit.setSelectedFlags(new boolean[] { false });
        this.append(_name);
        this.append(_birthDate);
        this.append(_mphValue);
        this.append(_mphCentile);
        //this.append(_deficit);

        this.setName(selected.getName());
        this.setBirthDate(selected.getBirthDate());
        this.setMph(selected.getMph());
        //this.setDeficit(selected.getGHDeficit());
    }

    public void setName(String value)
    {
        _name.setString(value);
    }

    public String getName()
    {
        return _name.getString();
    }

    public Date getBirthDate()
    {
        return _birthDate.getDate();
    }
    public void setBirthDate(Date birthDate) {
        _birthDate.setDate(birthDate);
    }

    public BodyMeasure getMph()
    {
        if(_mphCentile == null || _mphValue == null || _mphCentile.getString().length() == 0 || _mphValue.getString().length() == 0 )
            return null;
        return new BodyMeasure(Integer.parseInt(_mphCentile.getString()),
                               Double.parseDouble(_mphValue.getString()));
    }

    public void setMph(BodyMeasure value)
    {
        if(null != value)
        {
            _mphCentile.setString(String.valueOf(value.getPercentile()));
            _mphValue.setString(String.valueOf(value.getValue()));
        }
    }

/*    public boolean getDiagnosticTestResult(DiagnosticTest test)
    {
        return _deficit.isSelected(0);
    }

    public void setDeficit(boolean value)
    {
        _deficit.setSelectedIndex(0, value);
    }
 * 
 */
}
