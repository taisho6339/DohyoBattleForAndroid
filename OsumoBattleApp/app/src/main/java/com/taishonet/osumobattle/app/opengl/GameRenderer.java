package com.taishonet.osumobattle.app.opengl;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by taisho6339 on 2014/05/03.
 */
public class GameRenderer implements GLSurfaceView.Renderer {

    private int mWidth, mHeight;
    private float mAspectRatio;
    private Dohyo mDohyo;

    public GameRenderer(int width, int height) {
        mWidth = width;
        mHeight = height;
        mAspectRatio = (float) mWidth / (float) mHeight;
        mDohyo = new Dohyo();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        init(gl);
        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
    }

    private void init(GL10 gl) {
        gl.glViewport(0, 0, mWidth, mHeight);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
    }


    private void clearColor(GL10 gl) {
        gl.glClearColor(0, 0, 0, 0.0f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }

    private void draw(GL10 gl) {
        // モデルビューの設定をする
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

        GLU.gluPerspective(gl, 45.0f, mAspectRatio, 0.01f, 10.f);
        GLU.gluLookAt(gl, 0.0f, 3.0f, 2.0f, 0.0f, 0.f, 0.f, 0.0f,
                0.0f, -1.0f);
        mDohyo.draw(gl);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        clearColor(gl);
        draw(gl);
    }
}
