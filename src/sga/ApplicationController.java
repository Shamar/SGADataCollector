/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

/**
 *
 * @author giacomo
 */
public class ApplicationController implements CommandListener {

    private PatientRepository _repository;
    private Command _okCommand;
    private Command _backCommand;
    private Displayable _currentView;
    public ApplicationController(Command okCommand, Command backCommand)
    {
        _okCommand = okCommand;
        _backCommand = backCommand;
        _repository = new PatientRepository();
    }

    public Displayable getViewToShow()
    {
        if(null == _currentView)
        {
            _currentView = buildPatientSelectionScreen();
        }
        return _currentView;
    }

    private Displayable buildPatientFormScreen(Patient patient)
    {
        PatientFormScreen screen = new PatientFormScreen(patient);
        screen.addCommand(_okCommand);
        screen.setCommandListener(this);
        return screen;
    }

    private Displayable buildPatientSelectionScreen()
    {
        PatientSelectionScreen screen = new PatientSelectionScreen();
        for(int i = 0; i < _repository.getSize(); ++i)
            screen.append(_repository.getPatient(i).getName(), null);
        screen.setCommandListener(this);
        screen.addCommand(_okCommand);
        return screen;
    }

    public void commandAction(Command c, Displayable d) {
        if(_currentView instanceof PatientSelectionScreen)
        {
            _currentView.setTitle(c.getLabel());
            _currentView.setCommandListener(null);
            _currentView = buildPatientFormScreen(null);
        }
    }

}
