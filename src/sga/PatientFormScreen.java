/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga;

import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author giacomo
 */
public class PatientFormScreen extends Form {
    private TextField _nameField = new TextField("Nome", "", 64, TextField.ANY);

    public PatientFormScreen(Patient patient)
    {
        super(patient == null ? "Nuovo Paziente" : patient.getName());

        this.append(_nameField);
    }

    public String getName()
    {
        return _nameField.getString();
    }

}
