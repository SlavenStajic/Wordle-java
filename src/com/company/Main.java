package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception {

       UserInterface ui = new UserInterface();
       SwingUtilities.invokeLater(ui);
    }
}
