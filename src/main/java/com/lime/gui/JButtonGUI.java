package com.lime.gui;

import javax.swing.*;

/**
 * Created by vdruzhinin on 5/23/2017.
 */
public class JButtonGUI extends JButton{

    public JButtonGUI(String title){
        super.setText(title);
    }

    public JButtonGUI(String title, int wight, int height){
        this(title);
        super.setSize(wight, height);
    }
}
