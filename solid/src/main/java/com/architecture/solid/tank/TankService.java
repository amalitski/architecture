package com.architecture.solid.tank;

public class TankService implements TankServiceInterface {
    private final Position position;

    public TankService() {
        position = new Position();
    }

    /**
     * Прямо
     */
    public void direct() {
        var r = position.getRadius();
        if (position.getAzimuth() == 180) {
            r = r - 1;
        } else {
            r = r + 1;
        }
        position.setRadius(r);
    }

    /**
     * По часовой
     */
    public void clockwise() {
        var a = changeAzimuth(+90);
        position.setAzimuth(a);
    }

    /**
     * Против часовой
     */
    public void counterClockwise() {
        var a = changeAzimuth(-90);
        position.setAzimuth(a);
    }

    private int changeAzimuth(int delta) {
        var a = position.getAzimuth() + delta;
        if (a > 360) {
            a = a - 360;
        }
        return a;
    }

    public Position getPosition() {
        return position;
    }
}
