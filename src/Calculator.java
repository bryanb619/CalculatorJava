// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

//  * java imports *

// Package that provides classes for creating GUI for java programs

//(The package includes graphical components such as buttons, checkboxes, and labels)
import javax.swing.*;

// Package that provides classes and interfaces for a general printing API in windows
import java.awt.*;

// handles GUI events (mouse clicks, key presses and window events)
import java.awt.event.*;


public class Calculator implements ActionListener
{
    // * variables *
    JFrame 						frame;
    // text field
    JTextField 					textField;
    // number buttons from 0 to 9
    JButton[] numberButtons 	= new JButton[10];

    // function buttons like *, /, +, - and more
    JButton[] functionButtons 	= new JButton[8];

    // function button names
    JButton addBtn, subBtn, mulBtn, divBtn;
    JButton decBtn, equBtn, delBtn, clearBtn;

    // USER UI INTERFACE
    JPanel panel;


    // font
    Font myFont = new Font("Segoi UI ",Font.BOLD,20);

    double num1,num2,result;
    char operator;


    Calculator()
    {
        // app window configuration
        Window();

        // text field input for user
        TextInput();

        // UI clickable buttons
        Buttons();

        // last call (SET THIS TO LAST call after methods IN CODE)
        frame.setVisible(true);

    }

    private void Window() {

        // window title
        frame = new JFrame("Calculator");

        // window size
        frame.setSize(420, 550);

        // allows to close the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // sets layout to null ( all content will be set by the programmer (buttons, etc)
        frame.setLayout(null);
    }


    private void TextInput() {

        // user text
        textField = new JTextField();

        // text field size & transform
        textField.setBounds(50, 25, 300, 50);

        // text field font
        textField.setFont(myFont);

        // editable = false ( Avoids letters input, sets to text input to false, only GUI can change the text)
        textField.setEditable(false);

        // text field
        frame.add(textField);

        //textField.setBackground(Color.black);

    }

    private void Buttons() {
        // operations

        // add button
        addBtn = new JButton("+");
        // sub button
        subBtn = new JButton("-");
        // mul button
        mulBtn = new JButton("*");
        // div button
        divBtn = new JButton("/");

        // functions

        // decimal button
        decBtn = new JButton(".");
        // equal button
        equBtn = new JButton("=");
        // delete button
        delBtn = new JButton("delete");
        // clear button
        clearBtn = new JButton("clear");

        //
        functionButtons[0] = addBtn;
        functionButtons[1] = subBtn;
        functionButtons[2] = mulBtn;
        functionButtons[3] = divBtn;
        functionButtons[4] = decBtn;
        functionButtons[5] = equBtn;
        functionButtons[6] = delBtn;
        functionButtons[7] = clearBtn;

        // function buttons
        for( int i = 0; i < 8; i++)
        {
            //
            functionButtons[i].addActionListener(this);
            // set font
            functionButtons[i].setFont(myFont);
            // remove outline
            functionButtons[i].setFocusable(false);
        }

        for ( int i = 0; i < 10; i++)
        {
            //
            numberButtons[i] = new JButton(String.valueOf(i));

            numberButtons[i].addActionListener(this);
            // set font
            numberButtons[i].setFont(myFont);
            // remove outline
            numberButtons[i].setFocusable(false);


        }

        // panel config
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        //panel.setBackground(Color.GRAY);

        // rows layout set up ( 4 rows, 4 columns, 10 horizontal gap, 10 vertical gap)

        // 1st row
        panel.add(numberButtons[1]);    // number 1
        panel.add(numberButtons[2]);    // number 2
        panel.add(numberButtons[3]);    // number 3
        panel.add(addBtn);              // add button

        // 2nd row
        panel.add(numberButtons[4]);    // number 4
        panel.add(numberButtons[5]);    // number 5
        panel.add(numberButtons[6]);    // number 6
        panel.add(subBtn);              // subtraction button

        // 3rd row
        panel.add(numberButtons[7]);    // number 1
        panel.add(numberButtons[8]);    // number 1
        panel.add(numberButtons[9]);    // number 1
        panel.add(mulBtn);              // multiplication button

        // 4th row
        panel.add(decBtn);              // number 1
        panel.add(numberButtons[0]);    // number 1
        panel.add(equBtn);              // number 1
        panel.add(divBtn);              // division button


        // decimal button transform
        delBtn.setBounds(50, 430, 145, 50);
        // decimal button transform
        clearBtn.setBounds(205, 430, 145, 50);

        // panel
        frame.add(panel);
        frame.add(delBtn);
        frame.add(clearBtn);

    }


    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        for (int i = 0; i < 10; i++)
        {
            // get event
            if (e.getSource() == numberButtons[i])
            {
                textField.setText(textField.getText().concat(String.valueOf(i)));

            }
        }

        // * DECIMAL BUTTON *
        if (e.getSource() == decBtn)
        {
            textField.setText(textField.getText().concat("."));
        }


        // * ADD BUTTON *
        if (e.getSource() == addBtn)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        // * ADD BUTTON *
        if (e.getSource() == addBtn)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        // * ADD MULTIPLY BUTTON *
        if (e.getSource() == mulBtn)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        // * DIVIDE BUTTON *
        if (e.getSource() == divBtn)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }


        // * EQUAL BUTTON *
        if (e.getSource() == equBtn)
        {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {

                // add case
                case '+' -> result = num1 + num2;

                // subtractions case
                case '-' -> result = num1 - num2;

                // multiply case
                case '*' -> result = num1 * num2;

                // divide case
                case '/' -> result = num1 / num2;
            }

            // set text field to result
            textField.setText(String.valueOf(result));
            // num1  is equal to the result
            num1 = result;
        }

        // * CLEAR BUTTON *
        if (e.getSource() == clearBtn)
        {
            textField.setText("");
        }

        if (e.getSource() == delBtn)
        {
            // string text field
            String string = textField.getText();
            // text field
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++)
            {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

    }

}
