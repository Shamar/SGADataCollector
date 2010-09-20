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

/**
 *
 * @author giacomo
 */
public class MenuController implements Controller {

    public static String CHECKUPS = "Visite";
    public static String PARENTS = "Genitori";
    public static String MATERNALS = "Fattori materni";
    public static String UTERINS = "Fattori uterini";
    public static String FETALS = "Fattori fetali";
    public static String TESTS = "Test diagnostici";

    public static Command _prevCmd = new Command("Indietro", Command.BACK, 60);

    private List _view;

    public MenuController()
    {
        Patient selected = User.getInstance().getSelectedPatient();
        _view = new List(selected.getName(), List.IMPLICIT);
        _view.append(PARENTS, null);
        _view.append(MATERNALS, null);
        _view.append(UTERINS, null);
        _view.append(FETALS, null);
        _view.append(TESTS, null);
        _view.append(CHECKUPS, null);
        if(selected.numberOfCheckups() > 0)
            _view.setSelectedIndex(5, true);
        _view.addCommand(_prevCmd);
    }

    public Displayable getView() {
        return _view;
    }

    public Controller apply(Command c, Displayable d) {
        if(c == List.SELECT_COMMAND)
        {
            if(_view.getString(_view.getSelectedIndex()) == PARENTS)
            {
                return new ParentsController();
            }
            if(_view.getString(_view.getSelectedIndex()) == MATERNALS)
            {
                return new MaternalController();
            }
            if(_view.getString(_view.getSelectedIndex()) == UTERINS)
            {
                return new UterinsController();
            }
            if(_view.getString(_view.getSelectedIndex()) == FETALS)
            {
                return new FetalsController();
            }
            if(_view.getString(_view.getSelectedIndex()) == TESTS)
            {
                return new TestsController();
            }
            if(_view.getString(_view.getSelectedIndex()) == CHECKUPS)
            {
                return new CheckupsController();
            }
        }
        if(c == _prevCmd)
        {
            return new PatientController();
        }
        return this;
    }

}
