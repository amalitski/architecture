package com.architecture.solid.tank;

import java.util.Vector;

public class MovableAdaptor implements MovableInterface {
    private final EntityInterface e;

    public MovableAdaptor(EntityInterface e) {
        this.e = e;
        this.e.setValue("position", new Integer[]{0});
        this.e.setValue("velocity", new Integer[]{1});
    }

    @Override
    public Integer[] getPosition() {
        return IoC.resolve("position", e);
    }

    @Override
    public void setPosition(Integer[] pos) {
        e.setValue("position", pos);
    }

    @Override
    public Integer[] getVelocity() {
        return IoC.resolve("velocity", e);
    }
}
