/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.controllers;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import sga.Controller;
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

    private CheckupView _view;

    public Displayable getView() {
        if(null != _view)
            return _view;
        return buildCheckupList();
    }

    private List buildCheckupList()
    {
        List l = new List("Visite", List.IMPLICIT);

        return l;
    }

    public Controller apply(Command c, Displayable d) {

        Patient selected = User.getInstance().getSelectedPatient();

        if(c == List.SELECT_COMMAND)
        {
            List l = (List)d;
            selected.getCheckup(l.getSelectedIndex());
            
        }

        return new MenuController();
    }

}
