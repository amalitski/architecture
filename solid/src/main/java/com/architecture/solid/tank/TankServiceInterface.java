package com.architecture.solid.tank;


/**
 * axis: y
 * |
 * |
 * |___
 * axis: x
 */
public interface TankServiceInterface {
    public Tank up();
    public Tank down();
    public Tank left();
    public Tank right();
}
