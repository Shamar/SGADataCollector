/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.domain;

/**
 *
 * @author giacomo
 */
public class BodyMeasure {

    private int _percentile; 
    private double _value;
    public BodyMeasure(int percentile, double value)
    {
        _percentile = percentile;
        _value = value;
    }

    public int getPercentile()
    {
        return _percentile;
    }

    public double getCentimeter()
    {
        return _value;
    }
}
