package de.hska.iwi.ads.solution.interfaces;

import de.hska.iwi.ads.interfaces.AbstractCircle;
import de.hska.iwi.ads.interfaces.Vector;

public class Circle extends AbstractCircle {

    public Circle(double radius) {
        super(radius);
    }

    public Circle(Vector middlePoint, double radius) {
        super(middlePoint, radius);
    }

    @Override
    public void scale(double factor) {
        if (factor < 0.0) {return;}
        double newRadius = this.radius * factor;
        if (newRadius > 0.0) {
            this.radius = newRadius;
        }
    }

    @Override
    public double getDimension() {
        return this.radius;
    }

    @Override
    public double area() {
        return Math.PI * this.radius * this.radius;
    }
}
