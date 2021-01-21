import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
    
public class PrimeNumbers_V3
{   
    static JTextField textfieldLowNum, textfieldHighNum;
    public static int lowNum, highNum;
    public static String lowNumStr, highNumStr;
        
    public static void main(String s[]) 
    {            
        JFrame frame = new JFrame("Trevor_MacDiarmid : PrimeNumbers_V3");  
        
        JPanel panel = new JPanel(); 
        panel.setLayout(new FlowLayout());  
         
        Font Sherif = new Font("Times New Roman", Font.TRUETYPE_FONT, 12);
        
        //Creates and configurestwo new JTextFields..
        textfieldLowNum = new JTextField("Low Number Here",10);
        textfieldHighNum = new JTextField("High Number Here",10);
        
        textfieldLowNum.setForeground(Color.DARK_GRAY);
        textfieldHighNum.setForeground(Color.DARK_GRAY);
        
        textfieldLowNum.setFont(Sherif);
        textfieldHighNum.setFont(Sherif);
        
        
        //Creates and configures a new JTextArea and JScrollPane, and assigns the JScrollPane to the JTextArea.
        JTextArea textArea = new JTextArea(11 ,16);
        JScrollPane scrollPane = new JScrollPane(textArea); 
        textArea.setEditable(false);
        textArea.setForeground(Color.DARK_GRAY);
        textArea.setFont(Sherif);
            
        //Creates and configures a new JButton
        JButton button = new JButton();  
        button.setText("Find Prime Numbers");   
        button.setLocation(200, 200);
        panel.add(button);  
        
        //Creates and configuresa new JButton
        JButton resetButton = new JButton();  
        resetButton.setText("Reset");   
        resetButton.setLocation(200, 300);
        panel.add(resetButton);  
            
        //Sets the layout of the JFrame "frame"
        frame.getContentPane().setLayout(new FlowLayout());
        
        //Adds two JTextFields and a JScrollPane to the frame
        frame.getContentPane().add(textfieldLowNum);
        frame.getContentPane().add(textfieldHighNum);
        frame.getContentPane().add(scrollPane);
            
        //Adds the JPanel "panel" to frame
        frame.add(panel);  
            
        //Sets the size, relative location, default close operation, and vidibility of the frame.
        frame.setSize(400, 300);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
                                
        //Adds an action listener for JButton "button"
        button.addActionListener(new ActionListener()
        {  
            public void actionPerformed(ActionEvent a){  
                lowNumStr = textfieldLowNum.getText();
                highNumStr = textfieldHighNum.getText();
        
                lowNum = Integer.parseInt(lowNumStr);
                highNum = Integer.parseInt(highNumStr);
                        
                for(int i = lowNum; i <= highNum; i++)
                {                       
                    if(isPrime(i) != false && i != 1)    
                        textArea.append(Integer.toString(i)+"\n");
                }
            }  
        });
        
        //Adds an action listener for JButton "resetButton"  
        resetButton.addActionListener(new ActionListener()
        {  
            public void actionPerformed(ActionEvent b){  
                textArea.setText("");
                textfieldLowNum.setText("Low Number Here");
                textfieldHighNum.setText("High Number Here");
            }  
        });
    }  
    
    /**
     * isPrime() checks if a given number is a prime or not. 
     * Returns true if it is, and false if it isn't.
     */
    public static boolean isPrime(int x)
    {
        boolean isPrime;
        isPrime = true;
            
        int div;
        div = 2; 
    
        while(div <= x/2 && isPrime != false)
        {
            if (x % div != 0)
                    isPrime = true;
            if (x % div == 0 && x != div) //x != div only exists for the sake of the number 2. 
                isPrime = false;
            div += 1;
        }
           
        return isPrime;
    }
}  