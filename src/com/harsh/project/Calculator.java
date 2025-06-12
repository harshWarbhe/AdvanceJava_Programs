package com.harsh.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;

public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtoms = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton, decButton, equalButton, delButton, clrButton, negButton;
	JPanel panel;

	Font myFont = new Font("Arial", Font.BOLD, 30);

	double num1 = 0, num2 = 0, result = 0;
	char operator;

	public Calculator() {
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(430, 550);
		frame.setLayout(null);
//		frame.setForeground(new Color(128, 128, 128));
//		frame.setBackground(SystemColor.desktop);

		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equalButton = new JButton("=");
		delButton = new JButton("DEL");
		clrButton = new JButton("AC");
		negButton = new JButton("+/-");

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equalButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;

		for (int i = 0; i < functionButtons.length; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}

		for (int i = 0; i < 10; i++) {
			numberButtoms[i] = new JButton(String.valueOf(i));
			numberButtoms[i].addActionListener(this);
			numberButtoms[i].setFont(myFont);
			numberButtoms[i].setFocusable(false);
		}

		negButton.setBounds(50, 430, 100, 50);
		delButton.setBounds(150, 430, 100, 50);
		clrButton.setBounds(250, 430, 100, 50);

		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 4, 4));
		panel.setBackground(Color.GRAY);

		panel.add(numberButtoms[1]);
		panel.add(numberButtoms[2]);
		panel.add(numberButtoms[3]);
		panel.add(addButton);
		panel.add(numberButtoms[4]);
		panel.add(numberButtoms[5]);
		panel.add(numberButtoms[6]);
		panel.add(subButton);
		panel.add(numberButtoms[7]);
		panel.add(numberButtoms[8]);
		panel.add(numberButtoms[9]);
		panel.add(mulButton);
		panel.add(numberButtoms[0]);
		panel.add(decButton);
		panel.add(equalButton);
		panel.add(divButton);

		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Calculator();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtoms[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if (e.getSource() == equalButton) {
			num2 = Double.parseDouble(textfield.getText());

			switch (operator) {
			case '+':
				result = num1 + num2;
				break;

			case '-':
				result = num1 - num2;
				break;

			case '*':
				result = num1 * num2;
				break;

			case '/':
				result = num1 / num2;
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + operator);
			}
			textfield.setText(String.valueOf(result));
			num1 = result;
		}

		if (e.getSource() == clrButton) {
			textfield.setText("");
		}

		if (e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				textfield.setText(textfield.getText() + string.charAt(i));

			}
		}

		if (e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
		}

	}

}
