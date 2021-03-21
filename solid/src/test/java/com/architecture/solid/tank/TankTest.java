package com.architecture.solid.tank;

import org.junit.Assert;
import org.junit.Test;

public class TankTest {

    @Test
    public void moveTest() {
        var e = new Entity();
        new MoveCommand(new MovableAdaptor(e)).execute();

        Assert.assertEquals(str("position", e), "1");
    }

    @Test
    public void rotateTest() {
        var e = new Entity();
        new RotateCommand(new RotableAdaptor(e)).execute();

        Assert.assertEquals(str("direction", e), "90");
    }


    @Test
    public void moveAndRotateTest() {
        var e = new Entity();

        new MoveCommand(new MovableAdaptor(e)).execute();
        new RotateCommand(new RotableAdaptor(e)).execute();

        Assert.assertEquals(str("position", e), "1");
        Assert.assertEquals(str("direction", e), "90");
    }


    private static String str(String key, EntityInterface e) {
        return VectorHelper.str(IoC.resolve(key, e));
    }
}
