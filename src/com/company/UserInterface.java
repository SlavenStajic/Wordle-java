package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserInterface extends JFrame implements Runnable {

    private JFrame frame;
    private TextField field = new TextField();
    private String randomrijec = new randomrijec().rijec();
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private int counter = 0;
    private boolean gamestatus = false;



    public void run() {

        frame = new JFrame();
        frame.setTitle("Pogodi rijec");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);

        Components(frame.getContentPane()); // saljem frame

        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        frame.getContentPane().setBackground(new Color(168, 173, 180));
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));



    }

    public void changeEditable(JTextField[] array) {

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

    public void lockEditable(JTextField[] array){

        for (int i = 0; i < array.length; i++) {
            array[i].setEditable(false);
        }

    }

    public void unlockEditable(JTextField[] array){

        for (int i = 0; i < array.length; i++) {
            array[i].setEditable(true);
        }

    }
    public void addToPanel(JTextField[]array) {

        for (int i = 0; i < array.length; i++)

            this.panel.add(array[i]);

    }

    public int[] compareText(String input) {

        int[] array = new int[5];


        for (int i = 0; i < 5; i++) {

            char randomword = randomrijec.charAt(i);
            char inputText = input.charAt(i);

            if (randomword == inputText) {

                array[i] = 1;

            }else {
                array[i] = 0;
            }

            for(int j = 0; j < 5; j++){

                char randomLetter = randomrijec.charAt(j);

                if(randomLetter == inputText && i != j && array[i] != 1)  {

                        array[i] = 2;


                }


            }


        }
        return array;
    }

    public void changeColors(String inputText, JTextField[] textFields) {

        int[] compared = compareText(inputText);

        for (int i = 0; i < 5; i++) {

            if (compared[i] == 1) {
                textFields[i].setBackground(Color.GREEN);
            } else if(compared[i] == 2) {
                textFields[i].setBackground(Color.yellow);

            }
        }




        }


        public void increaseCounter () {
            counter++;
        }

        public Component Components (Container container){


            panel2.setPreferredSize(new Dimension(100, 100));
            panel2.setBackground(new Color(168, 173, 180));
            panel2.setLayout(new FlowLayout());


            panel.setPreferredSize(new Dimension(350, 600));
            panel.setBackground(new Color(168, 173, 180));
            panel.setLayout(new FlowLayout());

            JButton dugme = new JButton("Potvrdi");
            JButton restart = new JButton("Restartuj igru");
            JButton rjesenje = new JButton("Rješenje");

            JLabel tekstRjesnje = new JLabel(randomrijec);
            tekstRjesnje.setFont(new Font("Serif", Font.BOLD, 50));
            tekstRjesnje.setVisible(false);


            JTextField one1 = field.createnew();
            JTextField two1 = field.createnew();
            JTextField three1 = field.createnew();
            JTextField four1 = field.createnew();
            JTextField five1 = field.createnew();

            JTextField[] firstrow = {one1, two1, three1, four1, five1};

            changeEditable(firstrow);



            JTextField one2 = field.createnew();
            JTextField two2 = field.createnew();
            JTextField three2 = field.createnew();
            JTextField four2 = field.createnew();
            JTextField five2 = field.createnew();

            JTextField[] secondrow = {one2, two2, three2, four2, five2};

            JTextField one3 = field.createnew();
            JTextField two3 = field.createnew();
            JTextField three3 = field.createnew();
            JTextField four3 = field.createnew();
            JTextField five3 = field.createnew();

            JTextField[] thirdrow = {one3, two3, three3, four3, five3};

            JTextField one4 = field.createnew();
            JTextField two4 = field.createnew();
            JTextField three4 = field.createnew();
            JTextField four4 = field.createnew();
            JTextField five4 = field.createnew();

            JTextField[] fourthrow = {one4, two4, three4, four4, five4};

            JTextField one5 = field.createnew();
            JTextField two5 = field.createnew();
            JTextField three5 = field.createnew();
            JTextField four5 = field.createnew();
            JTextField five5 = field.createnew();

            JTextField[] fifthrow = {one5, two5, three5, four5, five5};

            ArrayList<JTextField[]> lista = new ArrayList<JTextField[]>();
            lista.add(firstrow);
            lista.add(secondrow);
            lista.add(thirdrow);
            lista.add(fourthrow);
            lista.add(fifthrow);

            restart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {



                  for(int i = 0; i < 5; i ++){

                      JTextField[] temp = lista.get(i);

                      lockEditable(temp);

                      for(int j= 0; j < 5; j++){

                          temp[j].setText("");
                          temp[j].setBackground(Color.WHITE);
                      }

                  }

                    unlockEditable(firstrow);
                  counter = 0;
                    randomrijec = new randomrijec().rijec();

                    tekstRjesnje.setVisible(false);
                        tekstRjesnje.setText(randomrijec);
                        gamestatus = false;
                }
            });


            rjesenje.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(tekstRjesnje.isVisible()){
                        tekstRjesnje.setVisible(false);
                    } else{
                        tekstRjesnje.setVisible(true);
                    }


                }
            });

            dugme.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    if (counter == 5 || gamestatus == true) {
                        return;
                    }

                    JTextField[] RowList = lista.get(counter);

                    if (!(RowList[0].getText().isEmpty() == false && RowList[1].getText().isEmpty() == false &&
                            RowList[2].getText().isEmpty() == false && RowList[3].getText().isEmpty() == false &&
                            RowList[4].getText().isEmpty() == false)) {

                        JOptionPane.showMessageDialog(frame,
                                "Popuni sva polja!!!");
                    } else {


                        String inputText = RowList[0].getText() + RowList[1].getText() +
                                RowList[2].getText() + RowList[3].getText() + RowList[4].getText();

                        changeColors(inputText, RowList);

                        changeEditable(lista.get(counter));

                        if (inputText.equals(randomrijec)) {
                            gamestatus = true;
                            JOptionPane.showMessageDialog(frame,
                                    "Pogodili ste rijec!");

                            return;
                        }


                        if (counter < 4) {
                            changeEditable(lista.get(counter + 1));
                        }


                        increaseCounter();

                    }


                }


            });


            one1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    two1.requestFocus();
                }
            });


            addToPanel(firstrow);
            addToPanel(secondrow);
            addToPanel(thirdrow);
            addToPanel(fourthrow);
            addToPanel(fifthrow);


            panel2.add(dugme);
            panel2.add(restart);
            panel2.add(rjesenje);

            panel.add(tekstRjesnje);


            container.add(panel);
            container.add(panel2);


            return null;
        }


    }



