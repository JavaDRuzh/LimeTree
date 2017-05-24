package com.lime.gui;


import java.awt.*;
import javax.swing.*;

/**
 * Created by vdruzhinin on 5/23/2017.
 */
public class JPanelGUI extends JPanel {

    public JPanelGUI(String name, int width, int height ){
        super.setSize(width, height);
        super.setName(name);
        super.setBorder(BorderFactory.createEtchedBorder());
    }

    public JPanelGUI (String name, int width, int height, Component comp) {
        this(name, width, height);
        super.add(comp);
    }

    public JPanelGUI (String name, int width, int height, LayoutManager layoutManager){
        this(name, width, height);
        super.setLayout(layoutManager);
    }

    public JPanelGUI (String name, int width, int height, LayoutManager layoutManager, Component comp){
        this(name, width, height);
        super.setLayout(layoutManager);
        super.add(comp);
    }
}
