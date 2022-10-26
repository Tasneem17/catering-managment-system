
package za.ac.cput.userinterface;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class VenueUI extends JFrame implements ActionListener {
    private JPanel pNorth, pCenter, pSouth;
    private JLabel lblType, lblDescription, lblLocation, lblTitle; //lblAdd;
    private JComboBox cBoxType, cBoxDescription, cBoxLocation;
    private String[] type = {"", "Hotel", "Bar", "Restaurant","Club", "Parks and Fields"};
    private String[] description = {"", "Birthday", "Graduation", "Retirement","Wedding", "Baby Shower"};
    private String[] location = {"", "Cape Town", "Johannesburg", "Durban"};
    //private JRadioButton yBtn;
    //private JRadioButton nBtn;
    //private ButtonGroup group;
    private JButton bBack, bNext, bExit;
    private Font ft1, ft2;

    public VenueUI() {
        super("Venue");
        pNorth = new JPanel();
        pCenter = new JPanel();
        pSouth = new JPanel();

        lblTitle = new JLabel("Venue");
        lblType = new JLabel("Type");
        lblDescription = new JLabel("Description");
        lblLocation = new JLabel("Location");
        //lblAdd = new JLabel("Add Catering?");

        //yBtn = new JRadioButton("Yes");
        //nBtn = new JRadioButton("No");
        //group = new ButtonGroup();


        cBoxType = new JComboBox(type);
        cBoxDescription = new JComboBox(description);
        cBoxLocation = new JComboBox(location);

        bBack = new JButton("Back");
        bNext = new JButton("Print");
        bExit = new JButton("Exit");

        ft1 = new Font("Monospaced", Font.BOLD, 36);
        ft2 = new Font("Monospaced", Font.BOLD, 16);
        }

        public void setVenueGUI() {
            this.setVisible(true);
            this.setSize(800, 310);

            pNorth.setLayout(new FlowLayout());
            pCenter.setLayout(new GridLayout(3, 3));
            pSouth.setLayout(new GridLayout(1, 3));

            //panel North
            pNorth.setBackground(new Color (66, 135, 245));
            pNorth.add(lblTitle);
            lblTitle.setFont(ft1);
            lblTitle.setForeground(Color.black);



            //panel Center
            pCenter.setBackground(new Color (104, 156, 237));
            pCenter.add(lblType);
            pCenter.add(cBoxType);
            pCenter.add(lblDescription);
            pCenter.add(cBoxDescription);
            pCenter.add(lblLocation);
            pCenter.add(cBoxLocation);
            //pCenter.add(lblAdd);
            //pCenter.add(yBtn);


            lblType.setFont(ft2);
            lblDescription.setFont(ft2);
            lblLocation.setFont(ft2);
            //lblAdd.setFont(ft2);

            //panelSouth
            pSouth.add(bBack);
            pSouth.add(bNext);
            pSouth.add(bExit);
            bBack.setForeground(new Color (104, 156, 237));
            bBack.setBackground(new Color (0, 0, 0));
            bNext.setForeground(new Color (104, 156, 237));
            bNext.setBackground(new Color (0, 0, 0));
            bExit.setForeground(new Color (104, 156, 237));
            bExit.setBackground(new Color (0, 0, 0));

            this.add(pNorth, BorderLayout.NORTH);
            this.add(pCenter, BorderLayout.CENTER);
            this.add(pSouth, BorderLayout.SOUTH);

            bBack.addActionListener(this);
            bNext.addActionListener(this);
            bExit.addActionListener(this);
            //yBtn.addActionListener(this);
            //nBtn.addActionListener(this);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {


        } else if (e.getActionCommand().equals("Print")) {

        }
        else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new VenueUI().setVenueGUI();
    }
}
