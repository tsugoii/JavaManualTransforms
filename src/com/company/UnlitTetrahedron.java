package com.company;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import java.lang.Math;


import java.awt.*;

public class UnlitTetrahedron extends UnlitShape {
    public UnlitTetrahedron() {
        super();
    }

    private void triangle(GL2 gl2, double r, double g, double b) {
        gl2.glColor3d(r, g, b);
        gl2.glBegin(GL2.GL_TRIANGLE_FAN);
        gl2.glVertex3d(-.5, 0, .29);
        gl2.glVertex3d(.5, 0, .29);
        gl2.glVertex3d(0, Math.sqrt(.75), 0); //apex
        gl2.glEnd();
    }

    double unit = 0.1;

    private void tetrahedron(GL2 gl2, double size) {
        gl2.glPushMatrix();
        gl2.glScaled(size, size, size);
        triangle(gl2, 1, 0, 0); //red front face
        gl2.glPushMatrix();
        gl2.glRotated(120, 0, 1, 0);
        triangle(gl2,0, 1, 0); // green right face
        gl2.glPopMatrix();
        gl2.glPushMatrix();
        gl2.glRotated(240, 0, 1, 0);
        triangle(gl2,0, 0, 1); // blue left face
        gl2.glPopMatrix();

        gl2.glPushMatrix(); //cyan bottom
        gl2.glRotated(180, 0, 0,1 );
        gl2.glColor3d(0, 1, 1);
        gl2.glBegin(GL2.GL_TRIANGLE_FAN);
        gl2.glVertex3d(-.5, 0, .29);
        gl2.glVertex3d(.5, 0, .29);
        gl2.glVertex3d(0, 0, -.58); //apex
        gl2.glEnd();
        gl2.glPopMatrix();

        gl2.glPopMatrix();

    }

    @Override
    public void display(GLAutoDrawable drawable) {tetrahedron(super.setup(drawable), 1); }
}