package za.ac.cput.userinterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeverageMenuUI  extends JFrame{

    private JPanel panel1;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField9;
    private JTextField textField1;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JRadioButton tropicalSplashRadioButton;
    private JRadioButton berryBlastRadioButton;
    private JRadioButton cokeRadioButton;
    private JRadioButton waterRadioButton;
    private JButton menuCategoryButton;
    private JButton exitButton;
    private JButton addButton;
    private JTextField textField13;

    public BeverageMenuUI(JFrame parent) {
        setTitle("Beverage Menu");
        setContentPane(panel1);
        setLocationRelativeTo(parent);
        tropicalSplashRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        berryBlastRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cokeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        waterRadioButton.addActionListener(new ActionListener() {
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

            }
        });
    }

    public BeverageMenuUI() {

    }

    public static void main (String[]args){
        BeverageMenuUI form = new BeverageMenuUI(null);
        }
    }

