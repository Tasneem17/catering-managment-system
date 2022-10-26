package za.ac.cput.userinterface;

import za.ac.cput.entity.Decor;

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
    private JTextField textField9;
    private JPanel DecorP;


    public DecorUI() {
        setTitle("Decor");
        setContentPane(DecorP);
        setSize(900, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        tableLinenRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textField9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        DecorUI Form = new DecorUI() ;
    }
}
