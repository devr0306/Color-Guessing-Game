
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ColorGuess extends JFrame{
    
    //instance variables
    JButton blueAdd = new JButton("+");
    JButton blueSubtract = new JButton("-");
    JButton redAdd = new JButton("+");
    JButton redSubtract = new JButton("-");
    JButton greenAdd = new JButton("+");
    JButton greenSubtract = new JButton("-");
    
    JPanel titlePanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JPanel background = new JPanel();    
    JPanel guess = new JPanel();
    JPanel target = new JPanel();
    
    JLabel title = new JLabel("Color Guessing Game");
    Font myFont = new Font("Roboto", Font.BOLD, 18);
    
    int rValue = 0;
    int gValue = 0;
    int bValue = 0;
    int r;
    int b;
    int g;
    
    //constructor
    public ColorGuess(){
        
        //JFrame specifics
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        //panel that contains the buttons
        bottomPanel.setBackground(Color.BLACK);
        add(bottomPanel, BorderLayout.SOUTH);
        
        //instantiate all the buttons and add action listeners to them
        redAdd.setBackground(Color.RED);
        redAdd.addActionListener((ActionEvent ae) -> {
            
            //if red value is less than 255, it adds 15 to the red value
            rValue = rValue == 255 ? rValue : rValue + 15;
            guess.setBackground(new Color(rValue, gValue, bValue));
            if(isMatch())
                winMessage();
        });
        
        redSubtract.setBackground(Color.RED);
        redSubtract.addActionListener((ActionEvent ae) -> {
            
            rValue = rValue == 0 ? rValue : rValue - 15;
            guess.setBackground(new Color(rValue, gValue, bValue));
            if(isMatch())
                winMessage();
        });
        
        blueAdd.setBackground(Color.BLUE);
        blueAdd.addActionListener((ActionEvent ae) -> {
            
            bValue = bValue == 255 ? bValue : bValue + 15;
            guess.setBackground(new Color(rValue, gValue, bValue));
            if(isMatch())
                winMessage();
                });
        
        blueSubtract.setBackground(Color.BLUE);
        blueSubtract.addActionListener((ActionEvent ae) -> {
            
            bValue = bValue == 0 ? bValue : bValue - 15;
            guess.setBackground(new Color(rValue, gValue, bValue));
            if(isMatch())
                winMessage();
        });
        
        greenAdd.setBackground(Color.GREEN);
        greenAdd.addActionListener((ActionEvent ae) ->{
            
            gValue = gValue == 255 ? gValue : gValue + 15;
            guess.setBackground(new Color(rValue, gValue, bValue));
            if(isMatch())
                winMessage();
        });
        
        greenSubtract.setBackground(Color.GREEN);
        greenSubtract.addActionListener((ActionEvent ae) ->{
            
            gValue = gValue == 0 ? gValue : gValue - 15;
            guess.setBackground(new Color(rValue, gValue, bValue));
            if(isMatch())
                winMessage();
        });
        
        //adds the buttons to the panel
        bottomPanel.add(redAdd, BorderLayout.SOUTH);
        bottomPanel.add(redSubtract, BorderLayout.SOUTH);
        bottomPanel.add(greenAdd, BorderLayout.SOUTH);
        bottomPanel.add(greenSubtract, BorderLayout.SOUTH);
        bottomPanel.add(blueAdd, BorderLayout.SOUTH);
        bottomPanel.add(blueSubtract, BorderLayout.SOUTH); 
        
        // adds background to the game
        background.setBackground(Color.WHITE);
        add(background, BorderLayout.CENTER);
        
        //set specifics for the title panel and add it along with the title
        titlePanel.setPreferredSize(new Dimension(100, 30));
        titlePanel.setBackground(Color.BLACK);
        title.setFont(myFont);
        title.setForeground(Color.WHITE);
        //titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);
        
        //adds the panel which changes color
        guess.setPreferredSize(new Dimension(70, 70));
        guess.setBackground(Color.BLACK);
        background.add(guess);
        
        //add the panel which contains the target color
        target.setPreferredSize(new Dimension(70, 70));
        target.setLocation(100, 100);
        
        //colors for the target panel
        r = (int)(Math.random() * 17) * 15;
        g = (int)(Math.random() * 17) * 15;
        b = (int)(Math.random() * 17) * 15;
        System.out.println(r + " " + g + " " + b);
        
        target.setBackground(new Color(r, g, b));
        background.add(target);
               
    }
    //checks if the colors are equal to each other
    public boolean isMatch(){
        return rValue == r && bValue == b && gValue == g;
    }
    //displays the win message
    public void winMessage(){
        JOptionPane.showMessageDialog(null,"Congrats you nailed it. Red: " + rValue + " Green: " + gValue + " Blue: " + bValue);
    }
    
    public static void main(String[] args){        
        new ColorGuess();
    }
    
}
