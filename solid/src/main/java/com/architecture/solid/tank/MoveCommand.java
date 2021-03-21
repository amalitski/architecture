package com.architecture.solid.tank;

public class MoveCommand implements CommandInterface {
    private final MovableInterface m;

    public MoveCommand(MovableInterface m) {
        this.m = m;
    }

    public void execute() {
        m.setPosition(VectorHelper.plus(m.getPosition(), m.getVelocity()));
    }
}
