/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga;

import java.util.Enumeration;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author gtesio
 */
public class SGADataCollectorMIDlet extends MIDlet implements CommandListener {

    private boolean midletPaused = false;
    private PatientRepository _repository;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command itemCommand;
    private List list;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The SGADataCollectorMIDlet constructor.
     */
    public SGADataCollectorMIDlet() {
        _repository = new PatientRepository();
        _repository.createPatient("Giacomo Tesio");
        _repository.createPatient("Sara Bertolotto");
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getList());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
        switchDisplayable(null, getList());//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|


        // write pre-action user code here

                // write pre-action user code here


    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == list) {//GEN-BEGIN:|7-commandAction|1|54-preAction
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|1|54-preAction
                // write pre-action user code here
                listAction();//GEN-LINE:|7-commandAction|2|54-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|3|58-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|4|58-postAction
                // write post-action user code here
            } else if (command == itemCommand) {//GEN-LINE:|7-commandAction|5|60-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|6|60-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|7|7-postCommandAction
        }//GEN-END:|7-commandAction|7|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|8|
    //</editor-fold>//GEN-END:|7-commandAction|8|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: list ">//GEN-BEGIN:|53-getter|0|53-preInit
    /**
     * Returns an initiliazed instance of list component.
     * @return the initialized component instance
     */
    public List getList() {
        if (list == null) {//GEN-END:|53-getter|0|53-preInit
            // write pre-init user code here
            list = new List("Pazienti", Choice.IMPLICIT);//GEN-BEGIN:|53-getter|1|53-postInit
            list.addCommand(getExitCommand());
            list.addCommand(getItemCommand());
            list.setCommandListener(this);//GEN-END:|53-getter|1|53-postInit
            // write post-init user code here
            Enumeration names = _repository.getPatientsNames();
            int i = 0;
            while(names.hasMoreElements())
                list.append((String)names.nextElement(), null);
        }//GEN-BEGIN:|53-getter|2|
        return list;
    }
    //</editor-fold>//GEN-END:|53-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: listAction ">//GEN-BEGIN:|53-action|0|53-preAction
    /**
     * Performs an action assigned to the selected list element in the list component.
     */
    public void listAction() {//GEN-END:|53-action|0|53-preAction
        // enter pre-action user code here
        String __selectedString = getList().getString(getList().getSelectedIndex());//GEN-LINE:|53-action|1|53-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|53-action|2|
    //</editor-fold>//GEN-END:|53-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand ">//GEN-BEGIN:|59-getter|0|59-preInit
    /**
     * Returns an initiliazed instance of itemCommand component.
     * @return the initialized component instance
     */
    public Command getItemCommand() {
        if (itemCommand == null) {//GEN-END:|59-getter|0|59-preInit
            // write pre-init user code here
            itemCommand = new Command("Nuovo", Command.ITEM, 0);//GEN-LINE:|59-getter|1|59-postInit
            // write post-init user code here
        }//GEN-BEGIN:|59-getter|2|
        return itemCommand;
    }
    //</editor-fold>//GEN-END:|59-getter|2|
    //</editor-fold>


    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

}
