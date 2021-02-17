package com.architecture.solid.tank;


/**
 * axis: y
 * |
 * |
 * |___
 * axis: x
 */
public class TankService implements TankServiceInterface {
    private final Tank tank;

    public TankService(Tank tank) {
        this.tank = tank;
    }

    public Tank up() {
        int y = tank.getY() + 1;
        tank.setY(y);
        tank.setDirection(Direction.UP);
        return tank;
    }

    public Tank down() {
        int y = tank.getY() - 1;
        tank.setY(y);
        tank.setDirection(Direction.DOWN);
        return tank;
    }

    public Tank left() {
        int x = tank.getX() - 1;
        tank.setX(x);
        tank.setDirection(Direction.LEFT);
        return tank;
    }

    public Tank right() {
        int x = tank.getX() + 1;
        tank.setX(x);
        tank.setDirection(Direction.RIGHT);
        return tank;
    }
}
