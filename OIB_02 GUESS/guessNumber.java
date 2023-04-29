/**
 * guess
 */
// importing packages

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class guessNumber extends JFrame {

    // component of frame
    JLabel user_Label;
    JTextField user_Input;
    JButton button;
    JLabel msgLabel;

    // variables
    int rand_Number;
    int num_Gusses;
    
    // constructor
    guessNumber(){
        
        // frame
        setTitle("Number Guessing Game");
        setSize(800,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);  

        // system generated random number(1-100)
        Random random= new Random();
        rand_Number = random.nextInt(100)+1;
        System.out.println(rand_Number);
        
        // input 
        JPanel input_Panel = new JPanel();
        input_Panel.setLayout(new FlowLayout());
        user_Label = new JLabel("Guess a number between 1 and 100:");
        user_Input = new JTextField(10);
        button = new JButton("Guess");
        button.addActionListener(new listener());
        input_Panel.add(user_Label);
        input_Panel.add(user_Input);
        input_Panel.add(button);
        add(input_Panel, BorderLayout.NORTH);
        
        input_Panel.setBackground(Color.BLUE);

        // result
        JPanel result_Panel = new JPanel();
        result_Panel.setLayout(new FlowLayout());
        msgLabel = new JLabel("");
        result_Panel.add(msgLabel);
        add(result_Panel, BorderLayout.CENTER);

        // Visibility of frame
        setVisible(true);
    }
    private class listener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // Get the user's guess
            int user_Guess = Integer.parseInt(user_Input.getText());
            num_Gusses++;

            // Check if the guess is correct
            if (user_Guess ==rand_Number) {
                msgLabel.setText("Congratulations! You guessed the number in " + num_Gusses + " guesses.");
                button.setEnabled(false);
            } else if (user_Guess < rand_Number) {
                msgLabel.setText("Not matched ! try to guess higher than this");
            } else {
                msgLabel.setText("Not matched ! try to guess less than this");
            }
        }
    }

    // main method
    public static void main(String[] args) {
        new guessNumber();
    }
}
