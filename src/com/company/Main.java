package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Main {

    public static void main(String[] args) throws Exception {

       UserInterface ui = new UserInterface();
       SwingUtilities.invokeLater(ui);



    }
}
