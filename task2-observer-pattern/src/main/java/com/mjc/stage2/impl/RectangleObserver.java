package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {
    private final RectangleWarehouse rectangleWarehouse = RectangleWarehouse.getInstance();

    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle source = event.getSource();
        double sideA = source.getSideA();
        double sideB = source.getSideB();
        double square = sideA * sideB;
        double perimeter = 2 * (sideA + sideB);
        RectangleValues rectangleValues = new RectangleValues(square, perimeter);
        rectangleWarehouse.put(source.getId(), rectangleValues);
    }
}
