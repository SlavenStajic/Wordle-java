package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserInterface extends JFrame implements Runnable {

    private JFrame frame;
    private TextField field = new TextField();
    private String RandomGenereatedWord = new RandomWord().word();
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private int counter = 0;
    private boolean isgamefinished = false;

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

    public void LockEditable(JTextField[] array){
        for (int i = 0; i < array.length; i++) {
            array[i].setEditable(false);
        }
    }

    public void UnlockEditable(JTextField[] array){
        for (int i = 0; i < array.length; i++) {
            array[i].setEditable(true);
        }
    }

    public void AddToPanel(JTextField[]array) {
        for (int i = 0; i < array.length; i++)
            this.panel.add(array[i]);
    }

        public Component Components (Container container){


            panel2.setPreferredSize(new Dimension(100, 100));
            panel2.setBackground(new Color(168, 173, 180));
            panel2.setLayout(new FlowLayout());

            panel.setPreferredSize(new Dimension(350, 600));
            panel.setBackground(new Color(168, 173, 180));
            panel.setLayout(new FlowLayout());

            JButton potvrdi = new JButton("Potvrdi");
            JButton restart = new JButton("Restartuj igru");
            JButton rjesenje = new JButton("Rješenje");

            JLabel tekstRjesnje = new JLabel(RandomGenereatedWord);
            tekstRjesnje.setFont(new Font("Serif", Font.BOLD, 50));
            tekstRjesnje.setVisible(false);

            JTextField one1 = field.createNew();
            JTextField two1 = field.createNew();
            JTextField three1 = field.createNew();
            JTextField four1 = field.createNew();
            JTextField five1 = field.createNew();

            JTextField[] firstrow = {one1, two1, three1, four1, five1};
           UnlockEditable(firstrow);

            JTextField one2 = field.createNew();
            JTextField two2 = field.createNew();
            JTextField three2 = field.createNew();
            JTextField four2 = field.createNew();
            JTextField five2 = field.createNew();

            JTextField[] secondrow = {one2, two2, three2, four2, five2};

            JTextField one3 = field.createNew();
            JTextField two3 = field.createNew();
            JTextField three3 = field.createNew();
            JTextField four3 = field.createNew();
            JTextField five3 = field.createNew();

            JTextField[] thirdrow = {one3, two3, three3, four3, five3};

            JTextField one4 = field.createNew();
            JTextField two4 = field.createNew();
            JTextField three4 = field.createNew();
            JTextField four4 = field.createNew();
            JTextField five4 = field.createNew();

            JTextField[] fourthrow = {one4, two4, three4, four4, five4};

            JTextField one5 = field.createNew();
            JTextField two5 = field.createNew();
            JTextField three5 = field.createNew();
            JTextField four5 = field.createNew();
            JTextField five5 = field.createNew();

            JTextField[] fifthrow = {one5, two5, three5, four5, five5};

            ArrayList<JTextField[]> lista = new ArrayList<JTextField[]>();
            lista.add(firstrow);
            lista.add(secondrow);
            lista.add(thirdrow);
            lista.add(fourthrow);
            lista.add(fifthrow);

            WordleManager wordleManager = new WordleManager(RandomGenereatedWord);

            restart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                  for(int i = 0; i < 5; i ++){
                      JTextField[] temp = lista.get(i);
                      LockEditable(temp);

                      for(int j= 0; j < 5; j++){
                          temp[j].setText("");
                          temp[j].setBackground(Color.WHITE);
                      }
                  }
                    UnlockEditable(firstrow);
                  counter = 0;

                    RandomGenereatedWord = new RandomWord().word();
                    wordleManager.setRandomWord(RandomGenereatedWord);
                    tekstRjesnje.setVisible(false);
                        tekstRjesnje.setText(RandomGenereatedWord);
                        isgamefinished = false;
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

            potvrdi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (counter == 5 || isgamefinished == true) {
                        return;
                    }

                    System.out.println(counter);
                    JTextField[] RowList = lista.get(counter);

                    if (!(RowList[0].getText().isEmpty() == false && RowList[1].getText().isEmpty() == false &&
                            RowList[2].getText().isEmpty() == false && RowList[3].getText().isEmpty() == false &&
                            RowList[4].getText().isEmpty() == false)) {

                        JOptionPane.showMessageDialog(frame, "Popuni sva polja!!!");
                    } else {

                        wordleManager.programManager(RowList,isgamefinished,frame,counter,lista);
                        counter++;

                    }
                }
            });

            AddToPanel(firstrow);
            AddToPanel(secondrow);
            AddToPanel(thirdrow);
            AddToPanel(fourthrow);
            AddToPanel(fifthrow);

            panel2.add(potvrdi);
            panel2.add(restart);
            panel2.add(rjesenje);

            panel.add(tekstRjesnje);

            container.add(panel);
            container.add(panel2);

            return null;
        }


    }



