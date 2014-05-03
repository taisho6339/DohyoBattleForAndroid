package com.taishonet.osumobattle.app.opengl;


import javax.microedition.khronos.opengles.GL10;

/**
 * Created by taisho6339 on 2014/05/04.
 */
public class Dohyo {

    private static final int CIRCLE_PARTS = 200;

    private float[] mSquareVertices = {
            -0.5f, 0.5f, -0.5f,
            -0.5f, 0.5f, 0.5f,
            0.5f, 0.5f, -0.5f,
            0.5f, 0.5f, 0.5f
    };

    private float[] mTriangleVertices = {
            0.0f, 0.5f, 0.0f,
            0.5f, 0.5f, -0.05f,
            0.5f, 0.5f, 0.05f
    };

    private float[] mRectangleVertices = {
            -0.3f, 0.55f, -0.075f,
            -0.3f, 0.55f, 0.075f,
            -0.25f, 0.55f, -0.075f,
            -0.25f, 0.55f, 0.075f
    };

    private float[] mSideVertices = {
            -0.5f, 0.5f, -0.5f,
            -0.5f, 0.0f, -0.5f,
            -0.5f, 0.5f, 0.5f,
            -0.5f, 0.0f, 0.5f,
    };

    private void drawSquare(GL10 gl) {
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, GLUtility.makeFloatBuffer(mSquareVertices));
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
    }

    private void drawTriangle(GL10 gl) {
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, GLUtility.makeFloatBuffer(mTriangleVertices));
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
    }

    private void drawCircle(GL10 gl) {
        float rate = 360f / CIRCLE_PARTS;
        for (int i = 0; i < CIRCLE_PARTS; i++) {
            gl.glRotatef(rate * i, 0.f, 1.0f, 0.f);
            drawTriangle(gl);
        }
    }

    private void drawRectangle(GL10 gl) {
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, GLUtility.makeFloatBuffer(mRectangleVertices));
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
    }


    private void drawSide(GL10 gl) {
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, GLUtility.makeFloatBuffer(mSideVertices));
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
    }

    private void drawDohyo(GL10 gl) {

        for (int i = 0; i < 4; i++) {
            gl.glPushMatrix();
            gl.glColor4f(0.6f, 0.4f, 0.2f, 1.0f);
            gl.glRotatef(i * 90f, 0.0f, 1.0f, 0.0f);
            drawSide(gl);
            gl.glPopMatrix();
        }

        gl.glPushMatrix();
        gl.glColor4f(0.6f, 0.4f, 0.2f, 1.0f);
        drawSquare(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glColor4f(0.6f, 0.4f, 0.2f, 1.0f);
        gl.glTranslatef(0.0f, -0.5f, 0.0f);
        drawSquare(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        drawCircle(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();

        gl.glScalef(0.95f, 0.95f, 0.95f);
        gl.glColor4f(0.6f, 0.4f, 0.2f, 1.0f);
        gl.glTranslatef(0.0f, 0.05f, 0.0f);
        drawCircle(gl);

        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        drawRectangle(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glRotatef(180f, 0.0f, 1.0f, 0.0f);
        drawRectangle(gl);
        gl.glPopMatrix();

    }


    public void draw(GL10 gl) {
        drawDohyo(gl);
    }
}
