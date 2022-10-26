package za.ac.cput.userinterface;

import javax.swing.*;
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
                    String text = textField1.getText();
                    int test = Integer.parseInt(text) * 200;
                    DtotalPrice.setText("" + test);
                } else if (centrePiecesRadioButton.isSelected()) {
                    String text1 = textField2.getText();
                    int test = Integer.parseInt(text1) * 100;
                    DtotalPrice.setText("" + test);
                } else if (chairCoversRadioButton.isSelected()) {
                    String text2 = textField3.getText();
                    int test = Integer.parseInt(text2) * 5;
                    DtotalPrice.setText("" + test);
                } else if (lightingRadioButton.isSelected()) {
                    String text3 = textField7.getText();
                    int test = Integer.parseInt(text3) * 2;
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
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public static void main (String[]args){
        DecorUI Form = new DecorUI() ;
    }
}
