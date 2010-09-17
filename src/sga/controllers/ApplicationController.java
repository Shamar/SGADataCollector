/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.controllers;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import sga.Controller;
import sga.domain.Patient;
import sga.domain.PatientRepository;
import sga.domain.User;

/**
 *
 * @author giacomo
 */

public class ApplicationController implements Controller {
    private List _view;
    private Command _exit = new Command("Esci", Command.EXIT, 60);
    private Command _new = new Command("Nuovo", Command.SCREEN, 60);

    public ApplicationController()
    {
        _view = new List("Pazienti", Choice.IMPLICIT);
        PatientRepository repository = User.getInstance().getRepository();
        for(int i = 0; i < repository.getSize(); ++i)
        {
            _view.append(repository.getPatient(i).getName(), null);
        }
        
        if(repository.getSize() > 0)
            _view.setTitle("Pazienti: " + repository.getSize());
        _view.addCommand(_new);
        _view.addCommand(_exit);
    }
    
    public Displayable getView() {
        return _view;
    }

    public Controller apply(Command c, Displayable d) {
        if(c == _exit)
            return null;
        User user = User.getInstance();

        if(c == _new)
        {
            Patient newPatient = new Patient();
            user.getRepository().addPatient(newPatient);
            user.setSelectedPatient(newPatient);
            return new PatientController();
        }
        if(c == List.SELECT_COMMAND)
        {
            int index = _view.getSelectedIndex();
            Patient selected = user.getRepository().getPatient(index);
            user.setSelectedPatient(selected);
            return new PatientController();
        }
        return this;
    }
    
}
