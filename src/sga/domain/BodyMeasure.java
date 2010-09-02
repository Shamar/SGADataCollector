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
    private double _centimeter;
    public BodyMeasure(int percentile, double centimeter)
    {
        _percentile = percentile;
        _centimeter = centimeter;
    }

    public int getPercentile()
    {
        return _percentile;
    }

    public double getCentimeter()
    {
        return _centimeter;
    }
}
