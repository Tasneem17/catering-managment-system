package za.ac.cput.userinterface;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipmentChoiceUI extends JFrame{
    private JButton addButton;
    private JButton menuCategoryButton;
    private JButton exitButton;
    private JRadioButton companySRadioButton;
    private JRadioButton yourOwnRadioButton;
    private JPanel EquipPanel;


    public EquipmentChoiceUI() {
        setTitle("Equipment Choice");
        setContentPane(EquipPanel);
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        companySRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        yourOwnRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

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
        EquipmentChoiceUI form = new EquipmentChoiceUI();
    }
}


