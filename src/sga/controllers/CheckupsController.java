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
    private static Command _newCmd = new Command("Nuova", Command.SCREEN, 60);
    private static Command _prevCmd = new Command("Menù", Command.BACK, 60);
    private static Command _deleteCmd = new Command("Elimina", Command.BACK, 60);
    private static Command _doneCmd = new Command("Ok", Command.SCREEN, 60);

    private Checkup _selectedCheckup;

    public Displayable getView() {
        if(null != _selectedCheckup)
            return buildCheckupView();
        return buildCheckupList();
    }

    private CheckupView buildCheckupView()
    {
        CheckupView v = new CheckupView();

        v.setDate(_selectedCheckup.getDate());
        v.setDosage(_selectedCheckup.getDosage());
        v.setGrowthSpeed(_selectedCheckup.getGrowthSpeed());
        v.setPatientHeight(_selectedCheckup.getHeight());
        v.setWeight(_selectedCheckup.getWeight());
        v.setInPuberty(_selectedCheckup.inPuberty());

        v.addCommand(_doneCmd);
        v.addCommand(_deleteCmd);
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

        l.addCommand(_newCmd);
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

        if(c == _deleteCmd)
        {
            selected.removeCheckup(_selectedCheckup);
            _selectedCheckup = null;
            return this;
        }

        if(c == _newCmd)
        {
            _selectedCheckup = selected.newCheckup();
            return this;
        }

        if(null != _selectedCheckup)
        {
            CheckupView view = (CheckupView) d;
            _selectedCheckup.setDate(view.getDate());
            _selectedCheckup.setDosage(view.getDosage());
            _selectedCheckup.setGrowthSpeed(view.getGrowthSpeed());
            _selectedCheckup.setWeight(view.getWeight());
            _selectedCheckup.setHeight(view.getPatientHeight());
            if(view.inPuberty() && !_selectedCheckup.inPuberty())
                _selectedCheckup.enterPuberty();
            _selectedCheckup = null;
        }

        if(c == _doneCmd)
        {
            return this;
        }

        return new MenuController();
    }

}
