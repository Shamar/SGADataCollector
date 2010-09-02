/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.views;

import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import sga.domain.Patient;
import sga.domain.User;

/**
 *
 * @author giacomo
 */
public final class PatientFirstForm extends Form {
    private TextField _name = new TextField("Nome", "", 64, TextField.INITIAL_CAPS_WORD);
    
    public PatientFirstForm(Patient selected)
    {
        super("Nuovo Paziente");
        if(null != selected.getName())
            this.setTitle(selected.getName());
        this.append(_name);
        this.setName(selected.getName());
    }

    public void setName(String value)
    {
        _name.setString(value);
    }

    public String getName()
    {
        return _name.getString();
    }
}
