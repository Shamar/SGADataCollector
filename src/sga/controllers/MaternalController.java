/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.controllers;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import sga.Controller;

/**
 *
 * @author giacomo
 */
public class MaternalController implements Controller {

    public Displayable getView() {
        return new Form("");
    }

    public Controller apply(Command c, Displayable d) {
        return new MenuController();
    }
}
