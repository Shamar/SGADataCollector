/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;

/**
 *
 * @author giacomo
 */
public interface Controller {

    Displayable getView();

    Controller apply(Command c, Displayable d);
}
