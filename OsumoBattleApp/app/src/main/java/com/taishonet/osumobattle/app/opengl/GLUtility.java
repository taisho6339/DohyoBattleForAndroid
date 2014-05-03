package com.taishonet.osumobattle.app.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Created by taisho6339 on 2014/05/04.
 */
public class GLUtility {

    private GLUtility() {
    }

    public static FloatBuffer makeFloatBuffer(float[] array) {
        FloatBuffer buffer = ByteBuffer.allocateDirect(array.length * 4).
                order(ByteOrder.nativeOrder()).asFloatBuffer();
        buffer.put(array).position(0);
        return buffer;
    }

}
