package com.lime.gui;

import java.awt.*;
import javax.swing.*;

/**
 * Created by vdruzhinin on 5/23/2017.
 */
public class JFrameGUI extends JFrame{
    public JFrameGUI (String title, int wight, int height) {
        super(title);
        super.setSize(wight, height);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new FlowLayout());
        super.setVisible(true);
//        super.setIconImage(new ImageIcon("../../lime.jpg").getImage());
    }

    public JFrameGUI (String title, int wight, int height, Component comp) {
        this(title, wight, height);
        super.getContentPane().add(comp);
    }
}
