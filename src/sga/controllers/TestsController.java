/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.controllers;

import java.util.Enumeration;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import sga.Controller;
import sga.domain.DiagnosticTest;
import sga.domain.Patient;
import sga.domain.User;
import sga.views.TestsView;

/**
 *
 * @author giacomo
 */
public class TestsController implements Controller {
    private TestsView _view;
    private static Command _nextCmd = new Command("Avanti", Command.SCREEN, 60);
    private static Command _prevCmd = new Command("Menù", Command.BACK, 60);

    public TestsController()
    {
        Patient selected = User.getInstance().getSelectedPatient();

        _view = new TestsView("Test diagnostici");
        _view.addCommand(_nextCmd);
        _view.addCommand(_prevCmd);
        for(Enumeration e = DiagnosticTest.All(); e.hasMoreElements();)
        {
            DiagnosticTest dt = (DiagnosticTest)e.nextElement();
            _view.addRiskFactor(dt);
            if(selected.getDiagnosticTestsResult(dt))
            {
                _view.enable(dt);
            }
        }
    }

    public Displayable getView() {
        return _view;
    }

    public Controller apply(Command c, Displayable d) {
        Patient selected = User.getInstance().getSelectedPatient();
        for(Enumeration e = DiagnosticTest.All(); e.hasMoreElements();)
        {
            DiagnosticTest dt = (DiagnosticTest)e.nextElement();
            if(_view.isChecked(dt))
                selected.addDiagnosticTest(dt);
            else
                selected.removeDiagnosticTest(dt);
        }

        if(c == _nextCmd)
        {
            return new TestsController();
        }
        return new MenuController();
    }

}
