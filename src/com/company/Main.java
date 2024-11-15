package com.company;

import com.jogamp.opengl.awt.GLJPanel;
import javax.swing.*;
import java.awt.*;

public class Main {

    static GLJPanel selectedPanel;
    static JFrame window;
    static JPanel selectionPanel;
    static JPanel shapeContainer;

    public static void main(String[] args) {
        window = new JFrame("A Simple Shape Mover");
        selectionPanel = new JPanel();
        selectionPanel.setBackground(Color.white);
        shapeContainer = new JPanel();
        window.add(shapeContainer);
        window.setContentPane(shapeContainer);
        JOptionPane.showMessageDialog(window, "Up, Down, Left, Right, Page_UP, Page_Down are Rotations on Different Axes\nW, A, S, D, Q, E are Sliding on Different Axes");
        JTextField optionText = new JTextField("Select Shape:");
        optionText.setEditable(false);
        optionText.setBackground(Color.white);
        optionText.setBorder(null);
        JButton cubeButton = new JButton("Cube");
        cubeButton.addActionListener(e -> add(new UnlitCube()));
        JButton PyramidButton = new JButton("Pyramid");
        PyramidButton.addActionListener(e -> add(new UnlitPyramid()));
        JButton cuboidButton = new JButton("Cuboid");
        cuboidButton.addActionListener(e -> add(new UnlitCuboid()));
        JButton prismButton = new JButton("Prism");
        prismButton.addActionListener(e -> add(new UnlitPrism()));
        JButton tetrahedronButton = new JButton("Tetrahedron");
        tetrahedronButton.addActionListener(e -> add(new UnlitTetrahedron()));
        JButton diamondButton = new JButton("Diamond");
        diamondButton.addActionListener(e -> add(new UnlitDiamond()));
        selectionPanel.add(optionText);
        selectionPanel.add(diamondButton);
        selectionPanel.add(tetrahedronButton);
        selectionPanel.add(cubeButton);
        selectionPanel.add(PyramidButton);
        selectionPanel.add(cuboidButton);
        selectionPanel.add(prismButton);
        window.add(selectionPanel);
        window.setPreferredSize(new Dimension(640, 580));
        window.pack();
        window.setLocation(50, 50);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    static void add(GLJPanel panel) {
        if (selectedPanel != null) {
            selectedPanel.setVisible(false);
            shapeContainer.remove(selectedPanel);
        }
        selectedPanel = panel;
        shapeContainer.add(panel);
        window.pack();
        panel.requestFocusInWindow();
    }
}
