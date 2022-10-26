package za.ac.cput.userinterface;

import za.ac.cput.entity.Equipment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipmentUI extends JFrame{
    private JButton addButton;
    private JButton menuCategoryButton;
    private JButton exitButton;
    private JTextField textField1;
    private JRadioButton tablesRadioButton;
    private JRadioButton forksRadioButton;
    private JRadioButton spoonsRadioButton;
    private JRadioButton platesRadioButton;
    private JRadioButton glassRadioButton;
    private JRadioButton teaCupRadioButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField8;
    private JTextField textField10;
    private JTextField textField12;
    private JRadioButton chairsRadioButton;
    private JTextField textField7;
    private JTextField textField9;
    private JTextField textField11;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JTextField textField16;
    private JTextField textField17;
    private JRadioButton knivesRadioButton;
    private JPanel Equipm;

    public EquipmentUI() {
        setTitle("Equipment");
        setContentPane(Equipm);
        setSize(900, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        tablesRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textField1.addActionListener(new ActionListener() {
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
       EquipmentUI form = new EquipmentUI();
    }
}
