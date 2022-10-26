package za.ac.cput.userinterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeverageMenuUI  extends JFrame {

    private JPanel panel1;
    private JTextField textq1;
    private JTextField textq2;
    private JTextField textq3;
    private JTextField textq4;
    private JRadioButton tropicalSplashRadioButton;
    private JRadioButton berryBlastRadioButton;
    private JRadioButton cokeRadioButton;
    private JRadioButton waterRadioButton;
    private JButton menuCategoryButton;
    private JButton exitButton;
    private JButton addButton;
    private JLabel Price45;
    private JLabel price50;
    private JLabel price30;
    private JLabel  totalP;
    private JLabel price25;
    private JTextField TPrice;
    private int test;
    private int test2;

    public BeverageMenuUI() {

        setTitle("Beverage Menu");
        setContentPane(panel1);
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


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
                if (tropicalSplashRadioButton.isSelected()) {
                    String text = textq1.getText();
                    int test = Integer.parseInt(text) * 45;
                    TPrice.setText("" + test);
                    } else if (berryBlastRadioButton.isSelected()) {
                    String text1 = textq2.getText();
                    int test = Integer.parseInt(text1) * 50;
                    TPrice.setText("" + test);
                    } else if (cokeRadioButton.isSelected()) {
                    String text2 = textq3.getText();
                    int test = Integer.parseInt(text2) * 30;
                    TPrice.setText("" + test);
                } else if (waterRadioButton.isSelected()) {
                    String text3 = textq4.getText();
                    int test = Integer.parseInt(text3) * 25;
                    TPrice.setText("" + test);
                }
                JOptionPane.showMessageDialog(null, "Successfully added your Beverage Selection please PROCEED TO Menu Category");

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
        TPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        BeverageMenuUI form = new BeverageMenuUI();
    }
}




