/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.domain;

import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author giacomo
 */
public class DiagnosticTest {

    private static Vector _allTests;
    public static Enumeration All()
    {
        if(null == _allTests)
        {
            _allTests = new Vector();
            _allTests.addElement(new DiagnosticTest("2 test in deficit"));
            _allTests.addElement(new DiagnosticTest("Notturno"));
            _allTests.addElement(new DiagnosticTest("Test di generazione"));
            _allTests.addElement(new DiagnosticTest("Test di generazione somatomedine"));
            _allTests.addElement(new DiagnosticTest("Diurno"));
            _allTests.addElement(new DiagnosticTest("Nottuno senza sonno"));
        }
        return _allTests.elements();
    }
    
    private String _name;
    private DiagnosticTest(String name)
    {
        _name = name;
    }
    public String toString()
    {
        return _name;
    }
}
