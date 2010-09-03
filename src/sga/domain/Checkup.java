/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.domain;

import java.util.Date;

/**
 *
 * @author gtesio
 */
public class Checkup {
    private Date _date;
    private BodyMeasure _height;
    private double _weight;
    private double _growthSpeed;
    private double _dosage;
    private boolean _inPuberty;

    public Checkup(Checkup previous)
    {
        if(null != previous)
        {
            _date = new Date(previous.getDate().getTime() + 15768000000L);
            _inPuberty = previous._inPuberty;
        }
    }

    /**
     * @return the _date
     */
    public Date getDate() {
        return _date;
    }

    /**
     * @param date the _date to set
     */
    public void setDate(Date date) {
        this._date = date;
    }

    /**
     * @return the _height
     */
    public BodyMeasure getHeight() {
        return _height;
    }

    /**
     * @param height the _height to set
     */
    public void setHeight(BodyMeasure height) {
        this._height = height;
    }

    /**
     * @return the _weight
     */
    public double getWeight() {
        return _weight;
    }

    /**
     * @param weight the _weight to set
     */
    public void setWeight(double weight) {
        this._weight = weight;
    }

    /**
     * @return the _growthSpeed
     */
    public double getGrowthSpeed() {
        return _growthSpeed;
    }

    /**
     * @param growthSpeed the _growthSpeed to set
     */
    public void setGrowthSpeed(double growthSpeed) {
        this._growthSpeed = growthSpeed;
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
