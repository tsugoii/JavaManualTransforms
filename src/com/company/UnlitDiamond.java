package com.company;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;

public class UnlitDiamond extends UnlitShape {
    public UnlitDiamond() {
        super();
}

    private void triangle(GL2 gl2, double r, double g, double b) {
        gl2.glColor3d(r, g, b);
        gl2.glBegin(GL2.GL_TRIANGLE_FAN);
        gl2.glVertex3d(-.5, 0, .5);
        gl2.glVertex3d(.5, 0, .5);
        gl2.glVertex3d(0, Math.sqrt(.75), 0); //apex
        gl2.glEnd();
    }

    private void square(GL2 gl2, double r, double g, double b) {
        gl2.glColor3d(r, g, b);
        gl2.glBegin(GL2.GL_TRIANGLE_FAN);
        gl2.glVertex3d(-0.5, -0.5, 0);
        gl2.glVertex3d(0.5, -0.5, 0);
        gl2.glVertex3d(0.5, 0.5, 0);
        gl2.glVertex3d(-0.5, 0.5, 0);
        gl2.glEnd();
    }


    private void pyramid(GL2 gl2, double size) {
        gl2.glPushMatrix();

        gl2.glScaled(size, size, size);
        triangle(gl2, 1, 0, 0); //red front face
        gl2.glPushMatrix();
        gl2.glRotated(90, 0, 1, 0);
        triangle(gl2,0, 1, 0); // green right face
        gl2.glPopMatrix();
        gl2.glPushMatrix();
        gl2.glRotated(180, 0, 1, 0);
        triangle(gl2,0, 0, 1); // blue left face
        gl2.glPopMatrix();
        gl2.glPushMatrix();
        gl2.glRotated(270, 0, 1, 0);
        triangle(gl2,0, 1, 1); // cyan left face
        gl2.glPopMatrix();

        gl2.glPopMatrix(); // Restore matrix to its state before cube() was called.
    }
    private void diamond(GL2 gl2, double size){
        pyramid(gl2, size);
        gl2.glRotated(180, 0, 0, 1);
        gl2.glRotated(180, 0, 1, 0);
        pyramid(gl2, size);
    }
    @Override
    public void display(GLAutoDrawable drawable) {
        diamond(super.setup(drawable), 1);
    }
}
