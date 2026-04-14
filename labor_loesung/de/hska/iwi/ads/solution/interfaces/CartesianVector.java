package de.hska.iwi.ads.solution.interfaces;

import de.hska.iwi.ads.interfaces.Vector;

public class CartesianVector implements Vector {

    private double x;
    private double y;

    public CartesianVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public CartesianVector() {
        this(0, 0);
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public double getDirection() {
        return Math.atan2(y, x);
    }

    @Override
    public Vector add(Vector addend) {
        if (addend == null) {
            return new CartesianVector(this.x, this.y);
        }

        return new CartesianVector(this.x + addend.getX(), this.y + addend.getY());
    }

    @Override
    public void scale(double factor) {
        if (factor < 0) {
            throw new IllegalArgumentException("factor must be >= 0");
        }

        this.x *= factor;
        this.y *= factor;
    }

    @Override
    public double getDimension() {
        return getLength();
    }
}