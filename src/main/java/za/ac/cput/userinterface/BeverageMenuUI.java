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
    private JTextField textq1;
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
    private JTextField totalprice;
    private JLabel tropPrice;

    public BeverageMenuUI() {

        setTitle("Beverage Menu");
        setContentPane(panel1);
        setSize(900,400);
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

            }
        });
        menuCategoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tropicalSplashRadioButton.isSelected()) {
                   // textq1 + tropPrice = totalprice;
                    totalprice.setText("");
                }
               // JOptionPane.showMessageDialog(this,"Successfully added your Beverage Selection please PROCEED TO Menu Category");
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
        totalprice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main (String[]args){
        BeverageMenuUI form = new BeverageMenuUI();
        }


}

