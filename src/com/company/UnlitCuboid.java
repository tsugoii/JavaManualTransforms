package com.company;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class UnlitCuboid extends UnlitShape {
    public UnlitCuboid() {
        super();
    }
        double unit = 0.1;

    private void square(GL2 gl2, double r, double g, double b) {
        gl2.glColor3d(r, g, b);
        gl2.glBegin(GL2.GL_TRIANGLE_FAN);
        gl2.glVertex3d(-0.4, -0.4, 0.8);
        gl2.glVertex3d(0.4, -0.4, 0.8);
        gl2.glVertex3d(0.4, 0.4, 0.8);
        gl2.glVertex3d(-0.4, 0.4, 0.8);
        gl2.glEnd();
    }

    private void rectangle(GL2 gl2, double r, double g, double b) {
        gl2.glColor3d(r, g, b);
        gl2.glBegin(GL2.GL_TRIANGLE_FAN);
        gl2.glVertex3d(unit * -8, unit * -4, unit * 4);
        gl2.glVertex3d(unit * 8, unit * -4, unit * 4);
        gl2.glVertex3d(unit * 8, unit * 4, unit * 4);
        gl2.glVertex3d(unit * -8, unit * 4, unit * 4);
        gl2.glEnd();
    }

    private void cuboid(GL2 gl2, double size) {
        gl2.glPushMatrix();
        gl2.glScaled(size, size, size); // scale unit cube to desired size

        square(gl2, 1, 0, 0); // red front face

        gl2.glPushMatrix();
        gl2.glRotated(90, 0, 1, 0);
        rectangle(gl2, 0, 1, 0); // green right face
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glRotated(-90, 0, 1, 0);
        rectangle(gl2, 0, 0, 1); // blue left face
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glRotated(180, 0, 1, 0);
        square(gl2, 0, 1, 1); // cyan back face
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glRotated(180, 0, 1, 0);
        gl2.glRotated(90, 1, 0, 0);
        gl2.glRotated(90, 0, 0, 1);
        rectangle(gl2, 1, 0, 1); // magenta top face
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glRotated(-90, 0, 1, 0);
        gl2.glRotated(-90, 1, 0, 0);
        gl2.glRotated(180, 0, 0, 1);
        rectangle(gl2, 1, 1, 0); // yellow bottom face
        gl2.glPopMatrix();

        gl2.glPopMatrix(); // Restore matrix to its state before cube() was called.
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        cuboid(super.setup(drawable), 1);
    }
}
