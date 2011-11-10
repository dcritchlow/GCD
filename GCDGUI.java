package GCDGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;



public class GCDGUI extends JPanel
{
    //init
    private int firstNumber;
    private int secondNumber;
    private String gcdAnswer;
    
    //Labels to identify the fields
    private JLabel label1;
    private JLabel label2;
    private JLabel answerLabel;
    
    //Strings for the labels
    private static String label1String = "Enter a positive number: ";
    private static String label2String = "Enter a positive number: ";
    private static String answerLabelString = "The Answer is: ";
    
    //Fields for data entry
    private JTextField num1;
    private JTextField num2;
    private JTextField answer;
    private JButton button;
    
    public static void main(String[] args) {
        //Took this from the java tutorial site
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Turn off metal's use of bold fonts
	        UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }

    public GCDGUI ()
    {
        super(new BorderLayout(50,50));
        
        //Create the labels.
        label1 = new JLabel(label1String);
        label2 = new JLabel(label2String);
        answerLabel = new JLabel(answerLabelString);
        
        //Create the text fields and set them up.
        num1 = new JTextField(2);
        num2 = new JTextField(2);
        
        answer = new JTextField(2);
        answer.setEditable(false);
        answer.setForeground(Color.red);
        
        //Tell accessibility tools about label/textfield pairs.
        label1.setLabelFor(num1);
        label2.setLabelFor(num2);
        answerLabel.setLabelFor(answer);
        
        //Add the button to calculate
        button = new JButton("Calculate");
        //button ActionListener
        button.addActionListener(new ActionListener()
            {
            @Override
                public void actionPerformed(ActionEvent event1)
                {
                    //getInt(string1,string2);
                    firstNumber = Integer.parseInt(num1.getText());
                    secondNumber = Integer.parseInt(num2.getText());
                    
                    gcdAnswer = Integer.toString(gcd(firstNumber,secondNumber));
                    answer.setText(gcdAnswer);
                }
            });
        
        //Lay out the labels in a panel.
        JPanel labelPane = new JPanel(new GridLayout(0,1));
        labelPane.add(label1);
        labelPane.add(label2);
        labelPane.add(answerLabel);
        
        //Layout the text fields in a panel.
        JPanel fieldPane = new JPanel(new GridLayout(0,1));
        fieldPane.add(num1);
        fieldPane.add(num2);
        fieldPane.add(answer);
        
        //Put the panels in this panel, labels on left,
        //text fields on right.
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(labelPane, BorderLayout.CENTER);
        add(fieldPane, BorderLayout.LINE_END);
        add(button, BorderLayout.SOUTH);
        
        
    }//End of constructor.
    
    //create the GUI and create it.
    private static void createAndShowGUI() 
    {
        //Create and set up the window.
        JFrame frame = new JFrame("Greatest Common Divisor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.add(new GCDGUI());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    //GCD method
    public  int gcd(int p, int q) 
    {
	if (q == 0) 
        {
            return p;
	}
    return gcd(q, p % q);
    }//end of GCD method
    
    
}//end of class
