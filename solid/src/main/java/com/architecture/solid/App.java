package com.architecture.solid;

import com.architecture.solid.tank.TankService;

public class App
{
    public static void main( String[] args )
    {
        var tService = new TankService();

        tService.direct();
        tService.clockwise();
        tService.clockwise();
        tService.counterClockwise();;

        var position = tService.getPosition();

        System.out.println("Azimuth: " + position.getAzimuth());
        System.out.println("Radius: " + position.getRadius());
    }
}
