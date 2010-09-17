/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.views;

import java.util.Date;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import sga.domain.BodyMeasure;

/**
 *
 * @author gtesio
 */
public class CheckupView extends Form {
    private DateField _date = new DateField("Data", DateField.DATE);
    private TextField _heightValue = new TextField("Altezza", "", 5, TextField.DECIMAL);
    private TextField _heightPerc = new TextField("Centile", "", 2, TextField.NUMERIC);
    private TextField _weight = new TextField("Peso", "", 5, TextField.DECIMAL);
    private TextField _speed = new TextField("Velocità", "", 5, TextField.DECIMAL);
    private TextField _dosage = new TextField("Dosaggio", "", 5, TextField.DECIMAL);
    private ChoiceGroup _puberty = new ChoiceGroup("", Choice.MULTIPLE);

    public CheckupView()
    {
        super("Visita");

        _puberty.append("In pubertà", null);
        this.append(_date);
        this.append(_heightValue);
        this.append(_heightPerc);
        this.append(_weight);
        this.append(_speed);
        this.append(_dosage);
        this.append(_puberty);
    }

    public void setDate(Date date)
    {
        _date.setDate(date);
    }

    public Date getDate()
    {
        return _date.getDate();
    }

    /**
     * @return the _weight
     */
    public double getWeight() {
        String value = _weight.getString();
        if(value == null || value.equals(""))
            return 0;
        return Double.parseDouble(value);
    }

    /**
     * @param weight the _weight to set
     */
    public void setWeight(double weight) {
        _weight.setString(String.valueOf(weight));
    }

    /**
     * @return the _growthSpeed
     */
    public double getGrowthSpeed() {
        String value = _speed.getString();
        if(value == null || value.equals(""))
            return 0;
        return Double.parseDouble(value);
    }

    /**
     * @param growthSpeed the _growthSpeed to set
     */
    public void setGrowthSpeed(double growthSpeed) {
        _speed.setString(String.valueOf(growthSpeed));
    }

    /**
     * @return the _dosage
     */
    public double getDosage() {
        String value = _dosage.getString();
        if(value == null || value.equals(""))
            return 0;
        return Double.parseDouble(value);
    }

    /**
     * @param dosage the _dosage to set
     */
    public void setDosage(double dosage) {
        this._dosage.setString(String.valueOf(dosage));
    }

    /**
     * @return the _enterPuberty
     */
    public boolean inPuberty() {
        return _puberty.isSelected(0);
    }

    /**
     * @param enterPuberty the _enterPuberty to set
     */
    public void setInPuberty(boolean value) {
        _puberty.setSelectedIndex(0, value);
    }

    public BodyMeasure getPatientHeight()
    {
        if(_heightPerc.size() == 0 || _heightValue.size() == 0)
            return null;
        double v = Double.parseDouble(_heightValue.getString());
        int perc = Integer.parseInt(_heightPerc.getString());
        return new BodyMeasure(perc, v);
    }

    public void setPatientHeight(BodyMeasure value)
    {
        if(null == value)
            return;
        _heightValue.setString(String.valueOf(value.getValue()));
        _heightPerc.setString(String.valueOf(value.getPercentile()));
    }

}
