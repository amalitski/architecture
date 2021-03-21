package com.architecture.solid.tank;

import java.util.Vector;

public interface RotableInterface {
    Integer[] getDirection();

    void setDirection(Integer[] newDirection);

    Integer[] getAngularVelocity();
}
