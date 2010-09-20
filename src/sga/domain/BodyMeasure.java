/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.domain;

import org.json.me.JSONException;
import org.json.me.JSONObject;

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

    BodyMeasure(JSONObject source) {
        _percentile = source.optInt("Percentile", 0);
        _value = source.optDouble("Value", 0);
    }

    public int getPercentile()
    {
        return _percentile;
    }

    public double getValue()
    {
        return _value;
    }

    public JSONObject toJSON() throws JSONException
    {
        JSONObject obj = new JSONObject();
        obj.put("Percentile", _percentile);
        obj.put("Value", _value);

        return obj;
    }
}
