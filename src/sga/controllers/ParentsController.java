/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.controllers;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import sga.Controller;
import sga.domain.Patient;
import sga.domain.User;
import sga.views.ParentsForm;

/**
 *
 * @author giacomo
 */
public class ParentsController implements Controller {
    private static Command _nextCmd = new Command("Avanti", Command.SCREEN, 60);
    private static Command _prevCmd = new Command("Menù", Command.BACK, 60);
    private ParentsForm _form;

    public ParentsController()
    {
        Patient selected = User.getInstance().getSelectedPatient();
        _form = new ParentsForm(selected.getName(), selected.getMother(), selected.getFather());
        _form.addCommand(_nextCmd);
        _form.addCommand(_prevCmd);
    }

    public Displayable getView() {
        return _form;
    }

    public Controller apply(Command c, Displayable d) {
        Patient selected = User.getInstance().getSelectedPatient();
        selected.getMother().setHeight(_form.getMotherHeight());
        selected.getMother().setIsSGA(_form.hasMotherSGA());
        selected.getFather().setHeight(_form.getFatherHeight());
        selected.getFather().setIsSGA(_form.hasFatherSGA());
        if(c == _nextCmd)
        {
             return new MaternalController();
        }
        return new MenuController();
    }

}
