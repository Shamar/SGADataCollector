/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.List;

/**
 *
 * @author giacomo
 */
public class PatientSelectionScreen extends List {
    public PatientSelectionScreen()
    {
        super("Pazienti", Choice.EXCLUSIVE);
    }
}
