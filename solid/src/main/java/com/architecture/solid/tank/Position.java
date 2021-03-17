package com.architecture.solid.tank;

import lombok.Data;

@Data
public class Position {
    private int radius = 0; // расстояние до полюса
    private int azimuth = 0; // азимут
}
