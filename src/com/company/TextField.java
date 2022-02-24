package com.company;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextField {
    Dimension dimenzija;
    Font font;

    public TextField(){
        this.dimenzija = new Dimension(60,60);
        this.font = new Font("Serif",Font.BOLD,50);

    }

    public JTextField createnew(){
        JTextField field = new JTextField();


        field.setPreferredSize(dimenzija);
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setFont(font);





        field.setEditable(false);
        field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(field.getText().isEmpty()){
                    if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE  )) {
                        e.consume();
                    }
                }
                else{
                    e.consume();
                }
            }
        });

        return field;
    }


}
