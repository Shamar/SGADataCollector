/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.views;

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Form;
import sga.domain.RiskFactor;

/**
 *
 * @author gtesio
 */
public class RiskFactorView extends Form {

    private ChoiceGroup _checkboxes;

    public RiskFactorView(String title)
    {
        super("Fattori di Rischio");

        _checkboxes = new ChoiceGroup(title, ChoiceGroup.MULTIPLE);
        this.append(_checkboxes);
    }

    public void addRiskFactor(RiskFactor factor)
    {
        _checkboxes.append(factor.toString(), null);
    }

    public void enable(RiskFactor factor)
    {
        String factorName = factor.toString();
        for(int i = 0; i < _checkboxes.size(); ++i)
        {
            if(_checkboxes.getString(i).equals(factorName))
            {
                _checkboxes.setSelectedIndex(i, true);
                return;
            }
        }
    }

    public boolean isChecked(RiskFactor factor)
    {
        String factorName = factor.toString();
        for(int i = 0; i < _checkboxes.size(); ++i)
        {
            if(_checkboxes.getString(i).equals(factorName))
            {
                return _checkboxes.isSelected(i);
            }
        }
        return false;
    }

}
