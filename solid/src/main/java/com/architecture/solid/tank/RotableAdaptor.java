package com.architecture.solid.tank;

import java.util.Vector;

public class RotableAdaptor implements RotableInterface {
    private final EntityInterface e;

    public RotableAdaptor(EntityInterface e) {
        this.e = e;
        this.e.setValue("direction", new Integer[]{0});
        this.e.setValue("angularVelocity", new Integer[]{90});
    }

    @Override
    public Integer[] getDirection() {
        return IoC.resolve("direction", e);
    }

    @Override
    public void setDirection(Integer[] newDirection) {
        e.setValue("direction", newDirection);
    }

    @Override
    public Integer[] getAngularVelocity() {
        return IoC.resolve("angularVelocity", e);
    }
}
