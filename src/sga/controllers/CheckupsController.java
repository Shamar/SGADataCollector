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

    public Displayable getView() {
        return new List("", List.IMPLICIT);
    }

    public Controller apply(Command c, Displayable d) {
        return new MenuController();
    }

}
