import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Assessment 2 the GUI of calculate.
 *
 * @author (Zhiqiang Yu)
 * @version (version 1.0 -- 22/09/2021)
 */
public class CalculateGUI extends JFrame implements ActionListener
{
    JTextField display;     //calculator's display;
    
    JButton[] nmbButtons;
    JButton equalButton;
    String[] nmbButtonNames = {"1","2","3","4","5","6","7","8","9","+/-","0","."};
    String[] nmbButtonCommands = {"CMD_1","CMD_2","CMD_3","CMD_4","CMD_5","CMD_6","CMD_7","CMD_8","CMD_9","CMD_P/N","CMD_0","CMD_DOT"};
    
    JButton[] signButtons;
    String[] signButtonNames = {"+","<<","-","C","*","(","/",")","!","OFF"};
    String[] signButtonCommands = {"CMD_ADD","CMD_BS","CMD_SUB","CMD_CE","CMD_MUL","CMD_LPT","CMD_DIV","CMD_RPT","CMD_FCT","CMD_OFF"};
    
    
    
    /**
     * Constructor for objects of class CalculateGUI
     */
    public CalculateGUI()
    {
        super("Zhiqiang's Calculator");
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        //set the program exit when the window was closed;
        setSize(400,300);       //set the window size is 400 width & 300 high;
        
        createCalcGUI();
    }
    
    /**
     * a method to set up the GUI;
     */
    private void createCalcGUI()
    {
        //create the panel in the top of the window;
        JPanel topPanel = new JPanel();
        GridLayout topPanelLayout  = new GridLayout(0, 1);      //create the topPanelLayout, and set it to one row and one column；
        topPanel.setLayout(topPanelLayout);     //set the layout of topPanel to the topPanelLayout;
        
        //create the bottom panel;
        /*
        JPanel bottomPanel = new JPanel();
        GridLayout bottomPanelLayout = new GridLayout(0, 2);
        bottomPanel.setLayout(bottomPanelLayout);        
        */
        
        //create the panel in the liftside of the bottom panel;
        JPanel liftsidePanel = new JPanel();
        GridLayout liftsidePanelLayout = new GridLayout(2,0);
        liftsidePanel.setLayout(liftsidePanelLayout);
        
        //create the number panel;
        JPanel nmbPanel = new JPanel();
        GridLayout nmbPanelLayout = new GridLayout(4, 3);
        nmbPanel.setLayout(nmbPanelLayout);
        
        //create the equal panel
        JPanel eqPanel = new JPanel();
        GridLayout eqPanelLayout = new GridLayout(0, 1);
        eqPanel.setLayout(eqPanelLayout);
        
        //add nmbPanel & eqPanel to the liftside panel;
        liftsidePanel.add(nmbPanel);
        liftsidePanel.add(eqPanel);
        
        //create the panel in the right side of the bottom panel;
        JPanel rightsidePanel = new JPanel();
        GridLayout rightsidePanelLayout = new GridLayout(5, 2);
        rightsidePanel.setLayout(rightsidePanelLayout);
        
        
        
        //add the liftside panel & rightside panel to the bottom panel;
        /*
        bottomPanel.add(liftsidePanel);
        bottomPanel.add(rightsidePanel);
        */
        
       
       
        //create the layout manager to put the panels in;
        BorderLayout mainLayout = new BorderLayout();
        setLayout(mainLayout);
        add(topPanel, BorderLayout.PAGE_START);
        add(liftsidePanel, BorderLayout.LINE_START);
        add(rightsidePanel, BorderLayout.CENTER);
        //add(bottomPanel);
        
        //create display;
        display = new JTextField("");
        Font displayFont = new Font("Times New Roman", Font.BOLD, 60);
        display.setFont(displayFont);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setPreferredSize(new Dimension(100,70));
        topPanel.add(display);
        
        //create number buttons;
        nmbButtons = new JButton[12];
        for (int i = 0; i < 12; i++)
        {
            nmbButtons[i] = new JButton(nmbButtonNames[i]);
            nmbButtons[i].setActionCommand(nmbButtonCommands[i]);
            nmbButtons[i].addActionListener(this);
            nmbPanel.add(nmbButtons[i]);
        }
        
        //create equal button;
        equalButton = new JButton("=");
        equalButton.setActionCommand("CMD_EQ");
        equalButton.addActionListener(this);
        eqPanel.add(equalButton);
        
        //create sign buttons;
        signButtons = new JButton[10];
        for (int i = 0; i < 10; i++)
        {
            signButtons[i] = new JButton(signButtonNames[i]);
            signButtons[i].setActionCommand(signButtonCommands[i]);
            signButtons[i].addActionListener(this);
            rightsidePanel.add(signButtons[i]);
        }
    }
    
    /**
     * the method of action listener;
     */
    public void actionPerformed(ActionEvent e)
    {
        String displayText;
        displayText = display.getText();
        
        String cmd = e.getActionCommand();
        switch (cmd)
        {
            case "CMD_1":
                displayText = displayText + "1";
                break;
            case "CMD_2":
                displayText = displayText + "2";
                break;
            case "CMD_3":
                displayText = displayText + "3";
                break;
            case "CMD_4":
                displayText = displayText + "4";
                break;
            case "CMD_5":
                displayText = displayText + "5";
                break;
            case "CMD_6":
                displayText = displayText + "6";
                break;
            case "CMD_7":
                displayText = displayText + "7";
                break;
            case "CMD_8":
                displayText = displayText + "8";
                break;
            case "CMD_9":
                displayText = displayText + "9";
                break;
            /*
            case "CMD_P/N":
                String sign = displayText.substring(displayText.length()-1);
                if (sign.equals("-"))
                {
                    displayText = displayText.substring(0, displayText.length()-1);
                } else {
                    displayText = displayText + "-";
                }
                break;
            */
            case "CMD_0":
                displayText = displayText + "0";
                break;
            case "CMD_ADD":
                displayText = displayText + "+";
                break;
            case "CMD_BS":
                displayText = displayText.substring(0, displayText.length()-1);
                break;
            case "CMD_SUB":
                displayText = displayText + "-";
                break;
            case "CMD_CE":
                displayText = "";
                break;
            case "CMD_MUL":
                displayText = displayText + "*";
                break;
            case "CMD_LPT":
                displayText = displayText + "(";
                break;
            case "CMD_DIV":
                displayText = displayText + "/";
                break;
            case "CMD_RPT":
                displayText = displayText + ")";
                break;
            case "CMD_FCT":
                displayText = displayText + "!";
                break;
            case "CMD_OFF":
                System.exit(0);
                break;
        }
        display.setText(displayText);
    }
    
    /**
     * the method of calculating
     */
    
    public static void main (String[] arg)
    {
        CalculateGUI calcGUI = new CalculateGUI();
        calcGUI.setVisible(true);
    }
}
