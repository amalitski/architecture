package com.architecture.solid;

import com.architecture.solid.tank.Direction;
import com.architecture.solid.tank.Tank;
import com.architecture.solid.tank.TankService;

public class App
{
    public static void main( String[] args )
    {
        var tank = Tank.builder().x(0).y(0).direction(Direction.UP).build();
        var tService = new TankService(tank);

        tService.up();
        tService.right();
        tService.down();
        tService.left();

        System.out.println("Direction: " + tank.getDirection());
        System.out.println("X: " + tank.getX());
        System.out.println("Y: " + tank.getY());
    }
}
