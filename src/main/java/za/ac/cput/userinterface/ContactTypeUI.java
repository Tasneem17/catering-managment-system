package za.ac.cput.userinterface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class ContactTypeUI extends JFrame implements ActionListener {
    private JPanel pNorth, pCenter, pSouth;
    private JTextField txtFirst, txtLast, txtPhone, txtEmail;
    private JLabel lblFirst, lblLast, lblTitle, lblPhone, lblEmail;
    private JButton bBack, bUpdate, bExit;
    private Font ft1, ft2;

    public ContactTypeUI() {
        super("Contact Information");
        pNorth = new JPanel();
        pCenter = new JPanel();
        pSouth = new JPanel();

        lblTitle = new JLabel("Contact Information");
        lblFirst = new JLabel("First Name");
        lblLast = new JLabel("Last Name");
        lblPhone = new JLabel("Phone");
        lblEmail = new JLabel("Email");

        txtFirst = new JTextField();
        txtLast = new JTextField();
        txtPhone = new JTextField();
        txtEmail = new JTextField();

        bBack = new JButton("Back");
        bUpdate = new JButton("Update");
        bExit = new JButton("Exit");

        ft1 = new Font("Monospaced", Font.BOLD, 36);
        ft2 = new Font("Monospaced", Font.BOLD, 16);
    }

    public void setContactTypeGUI() {
        this.setVisible(true);
        this.setSize(700, 310);

        pNorth.setLayout(new FlowLayout());
        pCenter.setLayout(new GridLayout(4, 2));
        pSouth.setLayout(new GridLayout(1, 3));

        //panel North
        pNorth.setBackground(new Color(66, 135, 245));
        pNorth.add(lblTitle);
        lblTitle.setFont(ft1);
        lblTitle.setForeground(Color.black);

        //panel Center
        pCenter.setBackground(new Color(104, 156, 237));
        pCenter.add(lblFirst);
        pCenter.add(txtFirst);
        pCenter.add(lblLast);
        pCenter.add(txtLast);
        pCenter.add(lblPhone);
        pCenter.add(txtPhone);
        pCenter.add(lblEmail);
        pCenter.add(txtEmail);

        //panelSouth
        pSouth.add(bBack);
        pSouth.add(bUpdate);
        pSouth.add(bExit);
        bBack.setForeground(new Color(66, 135, 245));
        bBack.setBackground(new Color(0, 0, 0));
        bUpdate.setForeground(new Color(66, 135, 245));
        bUpdate.setBackground(new Color(0, 0, 0));
        bExit.setForeground(new Color(66, 135, 245));
        bExit.setBackground(new Color(0, 0, 0));

        lblFirst.setFont(ft2);
        lblLast.setFont(ft2);
        lblPhone.setFont(ft2);
        lblEmail.setFont(ft2);

        this.add(pNorth, BorderLayout.NORTH);
        this.add(pCenter, BorderLayout.CENTER);
        this.add(pSouth, BorderLayout.SOUTH);

        bBack.addActionListener(this);
        bUpdate.addActionListener(this);
        bExit.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {


        } else if (e.getActionCommand().equals("Update")) {
            JOptionPane.showMessageDialog(this, "Contact Saved");
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }
    public static void main(String[] args){new ContactTypeUI().setContactTypeGUI();}
}