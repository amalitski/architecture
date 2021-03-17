package com.architecture.solid.tank;

import org.junit.Assert;
import org.junit.Test;

public class TankServiceTest {

    @Test
    public void directTest() {
        var tService = new TankService();
        tService.direct();
        tService.clockwise();
        tService.clockwise();
        tService.counterClockwise();
        var position = tService.getPosition();
        Assert.assertEquals(position.getRadius(), 1);
        Assert.assertEquals(position.getAzimuth(), 90);
    }

    @Test
    public void directReverseTest() {
        var tService = new TankService();
        tService.direct();
        tService.clockwise();
        tService.clockwise();
        tService.direct();

        var position = tService.getPosition();

        Assert.assertEquals(position.getRadius(), 0);
        Assert.assertEquals(position.getAzimuth(), 180);
    }


    @Test
    public void direct360Test() {
        var tService = new TankService();
        tService.direct();
        tService.clockwise();
        tService.clockwise();
        tService.clockwise();
        tService.clockwise();
        tService.direct();

        var position = tService.getPosition();
        Assert.assertEquals(position.getRadius(), 2);
        Assert.assertEquals(position.getAzimuth(), 360);
    }

    @Test
    public void reverse180Test() {
        var tService = new TankService();
        tService.direct();
        tService.clockwise();
        tService.clockwise();
        tService.direct();

        var position = tService.getPosition();
        Assert.assertEquals(position.getRadius(), 0);
        Assert.assertEquals(position.getAzimuth(), 180);
    }
}
