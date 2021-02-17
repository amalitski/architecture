package com.architecture.solid.tank;

import org.junit.Assert;
import org.junit.Test;


public class TankServiceTest {
    @Test
    public void upTest() {
        final int xDefault = 5;
        final int yDefault = 5;
        final Direction dDefault = Direction.DOWN;

        var tank = Tank.builder().x(xDefault).y(yDefault).direction(dDefault).build();
        var tService = new TankService(tank);
        tService.up();

        Assert.assertEquals(tank.getX(), xDefault);
        Assert.assertEquals(tank.getY(), yDefault + 1);
        Assert.assertEquals(tank.getDirection(), Direction.UP);
    }

    @Test
    public void downTest() {
        final int xDefault = 5;
        final int yDefault = 5;
        final Direction dDefault = Direction.UP;

        var tank = Tank.builder().x(xDefault).y(yDefault).direction(dDefault).build();
        var tService = new TankService(tank);
        tService.down();

        Assert.assertEquals(tank.getX(), xDefault);
        Assert.assertEquals(tank.getY(), yDefault - 1);
        Assert.assertEquals(tank.getDirection(), Direction.DOWN);
    }

    @Test
    public void leftTest() {
        final int xDefault = 5;
        final int yDefault = 5;
        final Direction dDefault = Direction.UP;

        var tank = Tank.builder().x(xDefault).y(yDefault).direction(dDefault).build();
        var tService = new TankService(tank);
        tService.left();

        Assert.assertEquals(tank.getX(), xDefault - 1);
        Assert.assertEquals(tank.getY(), yDefault);
        Assert.assertEquals(tank.getDirection(), Direction.LEFT);
    }

    @Test
    public void rightTest() {
        final int xDefault = 5;
        final int yDefault = 5;
        final Direction dDefault = Direction.UP;

        var tank = Tank.builder().x(xDefault).y(yDefault).direction(dDefault).build();
        var tService = new TankService(tank);
        tService.right();

        Assert.assertEquals(tank.getX(), xDefault + 1);
        Assert.assertEquals(tank.getY(), yDefault);
        Assert.assertEquals(tank.getDirection(), Direction.RIGHT);
    }
}
