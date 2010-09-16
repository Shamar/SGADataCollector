/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.views;

import java.util.Date;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author gtesio
 */
public class CheckupView extends Form {
    private DateField _date = new DateField("Data", DateField.DATE);
    private TextField _weight = new TextField("Peso", "", 4, TextField.DECIMAL);
    private TextField _speed = new TextField("Velocità", "", 4, TextField.DECIMAL);

    public CheckupView()
    {
        super("Visita");
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
        if(value == null || value == "")
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
        if(value == null || value == "")
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
        return _dosage;
    }

    /**
     * @param dosage the _dosage to set
     */
    public void setDosage(double dosage) {
        this._dosage = dosage;
    }

    /**
     * @return the _enterPuberty
     */
    public boolean inPuberty() {
        return _inPuberty;
    }

    /**
     * @param enterPuberty the _enterPuberty to set
     */
    public void enterPuberty() {
        this._inPuberty = true;
    }

}
