package com.architecture.solid.tank;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
public class Tank {
    private int x;
    private int y;
    private Direction direction;
}
