package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WordleManager  {
    private String randomWord;

    public WordleManager(String word){
        this.randomWord = word;
    }

    public void programManager(JTextField[] list,boolean gameFinished,JFrame frameTemp,int count,ArrayList<JTextField[]> listTextFields) {

        JTextField[] RowList = list;

        String inputText = RowList[0].getText() + RowList[1].getText() +
                RowList[2].getText() + RowList[3].getText() + RowList[4].getText();

        ChangeColors(inputText, list);
        ChangeEditable(list);

        if (inputText.equals(randomWord)) {
            gameFinished = true;
            JOptionPane.showMessageDialog(frameTemp,
                    "Pogodili ste rijec!");
            return;
        }
        if (count < 4) {
            ChangeEditable(listTextFields.get(count + 1));
        }
    }

    public void ChangeEditable(JTextField[] array) {
        if (array[0].isEditable() == false) {

            for (int i = 0; i < array.length; i++) {
                array[i].setEditable(true);
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                array[i].setEditable(false);
            }
        }
    }
    public void ChangeColors(String inputText, JTextField[] textFields) {

        int[] compared = CompareText(inputText);
        for (int i = 0; i < 5; i++) {
            if (compared[i] == 1) {
                textFields[i].setBackground(Color.GREEN);
            } else if(compared[i] == 2) {
                textFields[i].setBackground(Color.yellow);
            }
        }
    }
    public int[] CompareText(String input) {

        int[] array = new int[5];

        for (int i = 0; i < 5; i++) {

            char randomword = randomWord.charAt(i);
            char inputText = input.charAt(i);

            if (randomword == inputText) {

                array[i] = 1;

            } else if (randomword != inputText) {

                for (int j = 0; j < 5; j++) {
                    char randomLetter = randomWord.charAt(j);

                    if (randomLetter == inputText && i != j && input.charAt(j) != randomLetter ) {

                            array[i] = 2;
                    }
                }

            } else {
                array[i] = 0;
            }
        }
        return array;
    }
    public void setRandomWord(String temp){
        this.randomWord = temp;
    }
}