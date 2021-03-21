package com.architecture.solid.tank;

public class RotateCommand implements CommandInterface {
    private final RotableInterface r;

    public RotateCommand(RotableInterface r) {
        this.r = r;
    }

    public void execute() {
        r.setDirection(VectorHelper.plus(r.getDirection(), r.getAngularVelocity()));
    }
}
