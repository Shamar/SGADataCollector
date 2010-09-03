/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.domain;

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
}
