/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.views;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import sga.domain.Parent;

/**
 *
 * @author gtesio
 */
public class ParentsForm extends Form {
    private TextField _fatherHeight = new TextField("Altezza (cm)", null, 5, TextField.DECIMAL);
    private TextField _motherHeight = new TextField("Altezza (cm)", null, 5, TextField.DECIMAL);
    private ChoiceGroup _motherSga = new ChoiceGroup("Madre", Choice.MULTIPLE);
    private ChoiceGroup _fatherSga = new ChoiceGroup("Padre", Choice.MULTIPLE);
    public ParentsForm(String patientName, Parent mother, Parent father)
    {
        super(patientName);
        this.append(_motherSga);
        _motherSga.append("SGA", null);
        this.append(_motherHeight);
        this.append(_fatherSga);
        _fatherSga.append("SGA", null);
        this.append(_fatherHeight);

        if(mother.getHeight() > 0)
        {
            _motherHeight.setString(String.valueOf(mother.getHeight()));
        }
        _motherSga.setSelectedIndex(0, mother.isSGA());
        if(father.getHeight() > 0)
        {
            _fatherHeight.setString(String.valueOf(father.getHeight()));
        }
        _fatherSga.setSelectedIndex(0, father.isSGA());
    }

    public double getMotherHeight()
    {
        String s = _motherHeight.getString();
        if(s == null || s.length() == 0)
            return 0;
        return Double.parseDouble(s);
    }

    public double getFatherHeight()
    {
        String s = _fatherHeight.getString();
        if(s == null || s.length() == 0)
            return 0;
        return Double.parseDouble(s);
    }

    public boolean hasFatherSGA()
    {
        return _fatherSga.isSelected(0);
    }
    public boolean hasMotherSGA()
    {
        return _motherSga.isSelected(0);
    }
}
