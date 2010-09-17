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
import sga.views.PatientForm;

/**
 *
 * @author giacomo
 */
public class PatientController implements Controller {
    private PatientForm _view;
    private static Command _nextCmd = new Command("Avanti", Command.SCREEN, 60);
    private static Command _prevCmd = new Command("Menù", Command.BACK, 60);
    private Patient _patient;

    public PatientController() {
        User user = User.getInstance();
        _patient = user.getSelectedPatient();
    }

    public Displayable getView() {
        if(null == _view)
        {
            _view = new PatientForm(_patient);
            _view.addCommand(_prevCmd);
            _view.addCommand(_nextCmd);
        }
        return _view;
    }

    public Controller apply(Command c, Displayable d) {
        _patient.setName(_view.getName());
        _patient.setBirthDate(_view.getBirthDate());
        _patient.setMph(_view.getMph());
        if(c == _prevCmd)
        {
            return new ApplicationController();
        }
        if(c == _nextCmd)
        {
            return new MenuController();
        }
        return this;
    }

}
