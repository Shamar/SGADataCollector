/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.controllers;

import java.util.Enumeration;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import sga.Controller;
import sga.domain.Patient;
import sga.domain.RiskFactor;
import sga.domain.User;
import sga.views.RiskFactorView;

/**
 *
 * @author giacomo
 */
public class UterinsController implements Controller {
    private RiskFactorView _view;
    private static Command _nextCmd = new Command("Avanti", Command.SCREEN, 60);
    private static Command _prevCmd = new Command("Menù", Command.BACK, 60);

    public UterinsController()
    {
        Patient selected = User.getInstance().getSelectedPatient();

        _view = new RiskFactorView("Uterini");
        _view.addCommand(_nextCmd);
        _view.addCommand(_prevCmd);
        for(Enumeration e = RiskFactor.Uterins(); e.hasMoreElements();)
        {
            RiskFactor rf = (RiskFactor)e.nextElement();
            _view.addRiskFactor(rf);
            if(selected.occurred(rf))
            {
                _view.enable(rf);
            }
        }
    }

    public Displayable getView() {
        return _view;
    }

    public Controller apply(Command c, Displayable d) {
        Patient selected = User.getInstance().getSelectedPatient();
        for(Enumeration e = RiskFactor.Uterins(); e.hasMoreElements();)
        {
            RiskFactor rf = (RiskFactor)e.nextElement();
            if(_view.isChecked(rf))
                selected.addRiskFactor(rf);
            else
                selected.removeRiskFactor(rf);
        }

        if(c == _nextCmd)
        {
            return new FetalsController();
        }
        return new MenuController();
    }
}
