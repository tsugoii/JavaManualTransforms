package com.company;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLJPanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class UnlitShape extends GLJPanel implements GLEventListener, KeyListener {
    double rotateX = 15;    // rotations of the shape about the axes
    double rotateY = -15;
    double rotateZ = 0;
    double translateX = 0;
    double translateY = 0;
    double translateZ = 0;

    public UnlitShape() {
        super(new GLCapabilities(null)); // Makes a panel with default OpenGL "capabilities".
        setPreferredSize(new Dimension(640, 580));
        addGLEventListener(this); // A listener is essential! The listener is where the OpenGL programming lives.
        addKeyListener(this);
    }

    public abstract void display(GLAutoDrawable drawable);

    public void dispose(GLAutoDrawable drawable) {
        // called when the panel is being disposed
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        // called when user resizes the window
    }

    // ----------------  Methods from the KeyListener interface --------------

    public void keyPressed(KeyEvent evt) {
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
            rotateY -= 15;
        else if (key == KeyEvent.VK_RIGHT)
            rotateY += 15;
        else if (key == KeyEvent.VK_DOWN)
            rotateX += 15;
        else if (key == KeyEvent.VK_UP)
            rotateX -= 15;
        else if (key == KeyEvent.VK_PAGE_UP)
            rotateZ += 15;
        else if (key == KeyEvent.VK_PAGE_DOWN)
            rotateZ -= 15;
        else if (key == KeyEvent.VK_HOME)
            rotateX = rotateY = rotateZ = 0;
        else if (key == KeyEvent.VK_W) {
            translateX += .05;
        } else if (key == KeyEvent.VK_S) {
            translateX -= .05;
        } else if (key == KeyEvent.VK_D) {
            translateY += .05;
        } else if (key == KeyEvent.VK_A) {
            translateY -= .05;
        } else if (key == KeyEvent.VK_E) {
            translateZ += .05;
        } else if (key == KeyEvent.VK_Q) {
            translateZ -= .05;
        }
        repaint();
    }

    public void keyReleased(KeyEvent evt) {
    }

    public void keyTyped(KeyEvent evt) {
    }

    public GL2 setup(GLAutoDrawable drawable) {

        GL2 gl2 = drawable.getGL().getGL2(); // The object that contains all the OpenGL methods.

        gl2.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        gl2.glLoadIdentity();             // Set up modelview transform.
        gl2.glRotated(rotateZ, 0, 0, 1);
        gl2.glRotated(rotateY, 0, 1, 0);
        gl2.glRotated(rotateX, 1, 0, 0);

        gl2.glTranslated(translateX, 0, 0);
        gl2.glTranslated(0, translateY, 0);
        gl2.glTranslated(0, 0, translateZ);

        return gl2;
    }

    public void init(GLAutoDrawable drawable) {
        // called when the panel is created
        GL2 gl2 = drawable.getGL().getGL2();
        gl2.glMatrixMode(GL2.GL_PROJECTION);
        gl2.glOrtho(-1, 1, -1, 1, -1, 1);
        gl2.glMatrixMode(GL2.GL_MODELVIEW);
        gl2.glClearColor(0, 0, 0, 1);
        gl2.glEnable(GL2.GL_DEPTH_TEST);
    }
}
