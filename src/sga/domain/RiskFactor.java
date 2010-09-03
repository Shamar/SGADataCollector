/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.domain;

import java.util.Enumeration;
import java.util.Vector;


/**
 *
 * @author gtesio
 */
public class RiskFactor {
    private static Vector _maternals;
    public static Enumeration Maternals()
    {
        if(null == _maternals)
        {
            //_all = new
            _maternals = new Vector(16);
            _maternals.addElement(new RiskFactor("high blood pressure"));
            _maternals.addElement(new RiskFactor("chronic kidney disease"));
            _maternals.addElement(new RiskFactor("advanced diabetes"));
            _maternals.addElement(new RiskFactor("heart or respiratory disease"));
            _maternals.addElement(new RiskFactor("malnutrition, anemia"));
            _maternals.addElement(new RiskFactor("infection"));
            _maternals.addElement(new RiskFactor("substance use"));
            _maternals.addElement(new RiskFactor("cigarette smoking"));
        }
        return _maternals.elements();
    }

    private static Vector _uterins;
    public static Enumeration Uterins()
    {
        if(null == _uterins)
        {
            //_all = new
            _uterins = new Vector(16);
            _uterins.addElement(new RiskFactor("decreased blood flow in the uterus and placenta"));
            _uterins.addElement(new RiskFactor("placental abruption (placenta detaches from the uterus)"));
            _uterins.addElement(new RiskFactor("placenta previa (placenta attaches low in the uterus)"));
            _uterins.addElement(new RiskFactor("infection in the tissues around the fetus"));
        }
        return _uterins.elements();
    }

    private static Vector _fetals;
    public static Enumeration Fetals()
    {
        if(null == _fetals)
        {
            //_all = new
            _fetals = new Vector(16);
            _fetals.addElement(new RiskFactor("multiple gestation"));
            _fetals.addElement(new RiskFactor("infection"));
            _fetals.addElement(new RiskFactor("birth defects"));
            _fetals.addElement(new RiskFactor("chromosomal abnormality"));
        }
        return _fetals.elements();
    }

    private String _name;
    private RiskFactor(String name)
    {
        _name = name;
    }
    public String toString()
    {
        return _name;
    }
}
