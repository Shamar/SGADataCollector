/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.domain;

import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author gtesio
 */
public class Parent {

    private boolean _isSGA;
    private double _height;

    public Parent()
    {
    }

    Parent(JSONObject source) {
        _isSGA = source.optBoolean("SGA", false);
        _height = source.optDouble("Height", 0);
    }

    /**
     * @return the _isSGA
     */
    public boolean isSGA() {
        return _isSGA;
    }

    /**
     * @param isSGA the _isSGA to set
     */
    public void setIsSGA(boolean isSGA) {
        this._isSGA = isSGA;
    }

    /**
     * @return the _height
     */
    public double getHeight() {
        return _height;
    }

    /**
     * @param height the _height to set
     */
    public void setHeight(double height) {
        this._height = height;
    }

    public JSONObject toJSON() throws JSONException
    {
        JSONObject obj = new JSONObject();
        obj.put("SGA", _isSGA);
        obj.put("Height", _height);

        return obj;
    }
}
