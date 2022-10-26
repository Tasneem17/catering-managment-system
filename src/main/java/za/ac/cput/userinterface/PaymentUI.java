package za.ac.cput.userinterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentUI extends JFrame {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JPasswordField txtFName;
    private JTextField txtFID;
    private JButton SAVEButton;
    private JButton clearButton;
    private JButton exitButton;
    private JTextField txtFPrice;

    public PaymentUI() {
        setTitle("Appointment UI");
        setContentPane(panel1);
        setSize(900, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtFPrice.setText("");
                txtFName.setText("");
                txtFID.setText("");
            }
        });
        SAVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Saved payment Successfully");

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
            PaymentUI Form = new PaymentUI();
        }

    }