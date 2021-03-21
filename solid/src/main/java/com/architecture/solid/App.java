package com.architecture.solid;

import com.architecture.solid.tank.*;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        var e = new Entity();

        new MoveCommand(new MovableAdaptor(e)).execute();
        new RotateCommand(new RotableAdaptor(e)).execute();

        for (var key: List.of("position", "direction", "angularVelocity", "velocity")) {
            System.out.println(key + ": " + VectorHelper.str(IoC.resolve(key, e)));
        }
    }
}
