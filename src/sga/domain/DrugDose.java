/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.domain;

/**
 *
 * @author giacomo
 */
public class DrugDose {

    private double _quantity;
    public DrugDose(double quantity)
    {
        _quantity = quantity;
    }

    public double getQuantity()
    {
        return _quantity;
    }
}
