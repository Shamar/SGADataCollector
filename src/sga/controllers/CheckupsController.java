/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.controllers;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import sga.Controller;
import sga.domain.Checkup;
import sga.domain.Patient;
import sga.domain.User;
import sga.views.CheckupView;

/**
 *
 * @author giacomo
 */
public class CheckupsController implements Controller {
    private static Command _nextCmd = new Command("Nuova", Command.SCREEN, 60);
    private static Command _prevCmd = new Command("Indietro", Command.BACK, 60);

    private Checkup _selectedCheckup;

    public Displayable getView() {
        if(null != _selectedCheckup)
            return buildCheckupView();
        return buildCheckupList();
    }

    private CheckupView buildCheckupView()
    {
        CheckupView v = new CheckupView();

        

        return v;
    }

    private List buildCheckupList()
    {

        Patient selected = User.getInstance().getSelectedPatient();
        List l = new List("Visite", List.IMPLICIT);
        
        for(int i = 0; i < selected.numberOfCheckups(); ++i)
        {
            Checkup c = selected.getCheckup(i);
            String cLabel = c.getDate().toString();
            l.append(cLabel, null);
        }

        l.addCommand(_nextCmd);
        l.addCommand(_prevCmd);

        return l;
    }

    public Controller apply(Command c, Displayable d) {

        Patient selected = User.getInstance().getSelectedPatient();

        if(c == List.SELECT_COMMAND)
        {
            List l = (List)d;
            _selectedCheckup = selected.getCheckup(l.getSelectedIndex());
            return this;
        }

        return new MenuController();
    }

}
