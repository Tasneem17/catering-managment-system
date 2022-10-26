package za.ac.cput.userinterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipmentUI extends JFrame{
    private JButton addButton;
    private JButton menuCategoryButton;
    private JButton exitButton;
    private JTextField totalPriceEq;
    private JRadioButton tablesRadioButton;
    private JRadioButton forksRadioButton;
    private JRadioButton spoonsRadioButton;
    private JRadioButton platesRadioButton;
    private JRadioButton glassRadioButton;
    private JRadioButton teaCupRadioButton;
    private JTextField Qtext1;
    private JTextField Qtext8;
    private JTextField Qtext2;
    private JTextField Qtext7;
    private JTextField Qtext3;
    private JTextField Qtext4;
    private JTextField Qtext5;
    private JTextField Qtext6;
    private JRadioButton chairsRadioButton;
    private JRadioButton knivesRadioButton;
    private JPanel Equipm;
    private JLabel EPrice1;
    private JLabel EPrice2;
    private JLabel EPrice3;
    private JLabel EPrice4;

    public EquipmentUI() {
        setTitle("Equipment");
        setContentPane(Equipm);
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        tablesRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        totalPriceEq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tablesRadioButton.isSelected()) {
                    String text = Qtext1.getText();
                    int test = Integer.parseInt(text) * 200;
                    totalPriceEq.setText("" + test);
                } else if (chairsRadioButton.isSelected()) {
                    String text1 = Qtext2.getText();
                    int test = Integer.parseInt(text1) * 100;
                    totalPriceEq.setText("" + test);
                } else if (knivesRadioButton.isSelected()) {
                    String text2 = Qtext3.getText();
                    int test = Integer.parseInt(text2) * 5;
                    totalPriceEq.setText("" + test);
                } else if (forksRadioButton.isSelected()) {
                    String text3 = Qtext4.getText();
                    int test = Integer.parseInt(text3) * 2;
                    totalPriceEq.setText("" + test);

                } else if (spoonsRadioButton.isSelected()) {
                    String text4 = Qtext5.getText();
                    int test = Integer.parseInt(text4) * 2;
                    totalPriceEq.setText("" + test);

                } else if (platesRadioButton.isSelected()) {
                    String text5 = Qtext6.getText();
                    int test = Integer.parseInt(text5) * 60;
                    totalPriceEq.setText("" + test);

            } else if(glassRadioButton.isSelected()){
                String text6 = Qtext7.getText();
                int test = Integer.parseInt(text6) * 50;
                totalPriceEq.setText("" + test);

        } else if(teaCupRadioButton.isSelected()){
                    String text7 = Qtext8.getText();
                    int test = Integer.parseInt(text7) * 40;
                    totalPriceEq.setText("" + test);
                }

                JOptionPane.showMessageDialog(null, "Successfully added your Equipment Selection please PROCEED TO Menu Category");

        }
        });
        menuCategoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Exit")) {
                    System.exit(0);
                }
            }
        });
    }
    public static void main (String[]args){
       EquipmentUI form = new EquipmentUI();
    }
}
