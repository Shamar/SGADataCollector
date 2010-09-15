/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.controllers;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import sga.Controller;

/**
 *
 * @author giacomo
 */
public class CheckupsController implements Controller {
    private static Command _nextCmd = new Command("Nuova", Command.SCREEN, 60);
    private static Command _prevCmd = new Command("Indietro", Command.BACK, 60);

    public Displayable getView() {
        return new List("Visite", List.IMPLICIT);
    }

    public Controller apply(Command c, Displayable d) {
        return new MenuController();
    }

}
