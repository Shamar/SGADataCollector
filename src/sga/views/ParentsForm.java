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
    private TextField _fatherHeight = new TextField("Altezza (cm)", null, 4, TextField.DECIMAL);
    private TextField _motherHeight = new TextField("Altezza (cm)", null, 4, TextField.DECIMAL);
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
    }
}
