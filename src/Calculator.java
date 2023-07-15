// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

//  * java imports *

// Package that provides classes for creating GUI for java programs
//(The package includes graphical components such as buttons, checkboxes, and labels)
import javax.swing.*;
import java.awt.*;

// hanldes GUI events (mouse clicks, key presses and window events)
import java.awt.event.*;



public class Calculator implements ActionListener
{

    // * variables *

    JFrame 						frame;
    // text field
    JTextField 					textField;
    // number buttons from 0 to 9
    JButton[] _numberButtons 	= new JButton[10];

    // function buttons like *, /, +, - and more
    JButton[] functionButtons 	= new JButton[8];

    // function button names
    JButton addBtn, subBtn, mulBtn, divBtn;
    JButton decBtn, equBtn, delBtn, clearBtn;

    // USER UI INTERFACE
    JPanel panel;


    // font
    Font myFont = new Font("Segoe UI",Font.BOLD,30);

    double num1=0,num2=0,result=0;
    char operator;


    Calculator()
    {
        // window configuration
        Window();

        // text field input
        TextInput();

        // buttons
        Buttons();

        // last call
        frame.setVisible(true);

    }

    private void Window()
    {
        // window title
        frame = new JFrame("Calculator");

        // window size
        frame.setSize(420, 550);

        // allows to close the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // sets layout to null ( all content will be set by the programmer (buttons, etc)
        frame.setLayout(null);
    }


    private void TextInput()
    {
        // user text
        textField = new JTextField();

        // text field size & transform
        textField.setBounds(50, 25, 300, 50);

        // text field font
        textField.setFont(myFont);

        // editable = false ( Avoids letters input, sets to text input to false, only GUI can change the text)
        textField.setEditable(false);

        frame.add(textField);

        // text field color
        //textField.setBackground(Color.black);



    }

    private void Buttons()
    {
        // add button
        addBtn = new JButton("+");
        // sub button
        subBtn = new JButton("-");
        // mul button
        mulBtn = new JButton("*");
        // div button
        divBtn = new JButton("/");
    }


    public static void main(String[] args)
    {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
