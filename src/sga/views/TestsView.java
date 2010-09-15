/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.views;

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Form;
import sga.domain.DiagnosticTest;
import sga.domain.RiskFactor;

/**
 *
 * @author gtesio
 */
public class TestsView extends Form {

    private ChoiceGroup _checkboxes;

    public TestsView(String title)
    {
        super(title);

        _checkboxes = new ChoiceGroup("", ChoiceGroup.MULTIPLE);
        this.append(_checkboxes);
    }

    public void addRiskFactor(DiagnosticTest test)
    {
        _checkboxes.append(test.toString(), null);
    }

    public void enable(DiagnosticTest test)
    {
        String name = test.toString();
        for(int i = 0; i < _checkboxes.size(); ++i)
        {
            if(_checkboxes.getString(i).equals(name))
            {
                _checkboxes.setSelectedIndex(i, true);
                return;
            }
        }
    }

    public boolean isChecked(DiagnosticTest test)
    {
        String name = test.toString();
        for(int i = 0; i < _checkboxes.size(); ++i)
        {
            if(_checkboxes.getString(i).equals(name))
            {
                return _checkboxes.isSelected(i);
            }
        }
        return false;
    }

}
