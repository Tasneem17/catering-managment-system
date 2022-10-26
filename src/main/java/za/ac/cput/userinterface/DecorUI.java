package za.ac.cput.userinterface;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DecorUI extends JFrame{
    private JRadioButton tableLinenRadioButton;
    private JRadioButton centrePiecesRadioButton;
    private JRadioButton chairCoversRadioButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JRadioButton lightingRadioButton;
    private JComboBox comboBox4;
    private JTextField textField7;
    private JTextField textField8;
    private JButton addButton;
    private JButton menuCategoryButton;
    private JButton exitButton;
    private JTextField DtotalPrice;
    private JPanel DecorP;
    private int decorAmount;



    public DecorUI() {
        setTitle("Decor");
        setContentPane(DecorP);
        setSize(900, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        DtotalPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableLinenRadioButton.isSelected()) {
                    String size = (String)comboBox1.getSelectedItem();
                    String value = comboBox1.getSelectedItem().toString();
                    decorAmount = value == "Small" ? 100 : value == "Medium" ? 150 : 200;
                    textField4.setText("" + decorAmount);
                    String text = textField1.getText();
                    int test =  decorAmount * Integer.parseInt(text);
                    DtotalPrice.setText("" + test);

                } else if (centrePiecesRadioButton.isSelected()) {
                    String size = (String) comboBox2.getSelectedItem();
                    String value = comboBox2.getSelectedItem().toString();
                    decorAmount = value == "Small" ? 50 : value == "Medium" ? 70 : 90;
                    String text1 = textField2.getText();
                    int test = decorAmount * Integer.parseInt(text1);
                    DtotalPrice.setText("" + test);

                } else if (chairCoversRadioButton.isSelected()) {
                    String size = (String) comboBox3.getSelectedItem();
                    String value = comboBox3.getSelectedItem().toString();
                    decorAmount = value == "Small" ? 5 : value == "Medium" ? 10 : 20;
                    String text2 = textField3.getText();
                    int test = decorAmount * Integer.parseInt(text2);
                    DtotalPrice.setText("" + test);

                } else if (lightingRadioButton.isSelected()) {
                    String size = (String) comboBox4.getSelectedItem();
                    String value = comboBox4.getSelectedItem().toString();
                    decorAmount = value == "Small" ? 100 : value == "Medium" ? 150 : 200;
                    String text3 = textField7.getText();
                    int test = decorAmount * Integer.parseInt(text3);
                    DtotalPrice.setText("" + test);
                }

                JOptionPane.showMessageDialog(null, "Successfully added your Decor Selection please PROCEED TO Menu Category");


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
        tableLinenRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        centrePiecesRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        chairCoversRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        lightingRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = (comboBox1.getSelectedItem()).toString();
                if (item == "Small"){
                    textField4.setText("100");
                }
                else if (item == "Medium"){
                    textField4.setText("150");
                }
                else if (item == "Large"){
                    textField4.setText("200");
                }

            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = (comboBox2.getSelectedItem()).toString();
                if (item == "Small"){
                    textField5.setText("50");
                }
                else if (item == "Medium"){
                    textField5.setText("70");
                }
                else if (item == "Large") {
                    textField5.setText("90");
                }
            }
        });
        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = (comboBox3.getSelectedItem()).toString();
                if (item == "Small"){
                    textField6.setText("5");
                }
                else if (item == "Medium"){
                    textField6.setText("10");
                }
                else if (item == "Large") {
                    textField6.setText("20");
                }
            }
        });
        comboBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = (comboBox4.getSelectedItem()).toString();
                if (item == "Small"){
                    textField8.setText("100");
                }
                else if (item == "Medium"){
                    textField8.setText("150");
                }
                else if (item == "Large") {
                    textField8.setText("200");
                }

            }
        });
    }
    public static void main (String[]args){
        DecorUI Form = new DecorUI() ;
    }
}
