package com.rivide.rpg.utils;

import com.badlogic.gdx.math.Vector3;

public class VecOps {
    private static final Vector3 tmpVec = new Vector3();

    public static Vector3 sum(Vector3 v1, Vector3 v2) {
        return copy(v1).add(v2);
    }
    public static Vector3 diff(Vector3 v1, Vector3 v2) {
        return copy(v1).sub(v2);
    }
    public static Vector3 prod(Vector3 v, float factor) {
        return copy(v).scl(factor);
    }
    public static Vector3 quot(Vector3 v, float divisor) {
        return copy(v).scl(1 / divisor);
    }
    public static Vector3 copy(Vector3 v) {
        return tmpVec.set(v);
    }
}
