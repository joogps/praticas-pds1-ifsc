package exercicio4;

import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercicio4 extends JFrame implements ActionListener {
	private static JTextField txt1, txt2;
	private static JButton sumButton, subtractButton, multiplyButton, divideButton;

	public static void main(String[] args) {
		Exercicio4 frame = new Exercicio4();
		frame.setVisible(true);
	}
	
	public Exercicio4() {
		super("Calculadora");
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		txt1 = new JTextField("");
		txt1.setToolTipText("Número um");
		
		txt2 = new JTextField();
		txt2.setToolTipText("Número dois");
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		sumButton = new JButton("+ Soma");
		panel_1.add(sumButton);
		
		subtractButton = new JButton("- Subtração");
		panel_1.add(subtractButton);
		
		multiplyButton = new JButton("× Multiplicação");
		panel_1.add(multiplyButton);
		
		divideButton = new JButton("÷ Divisão");
		panel_1.add(divideButton);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(txt1);
		panel.add(txt2);
		panel.add(panel_1);
		
		sumButton.setActionCommand("sum");
		subtractButton.setActionCommand("subtract");
		multiplyButton.setActionCommand("multiply");
		divideButton.setActionCommand("divide");
		
		sumButton.addActionListener(this);
		subtractButton.addActionListener(this);
		multiplyButton.addActionListener(this);
		divideButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Double value1 = Double.valueOf(txt1.getText());
		Double value2 = Double.valueOf(txt2.getText());
		
        if ("sum".equals(e.getActionCommand())) {
        	displayResult(value1+value2);
        } else if ("subtract".equals(e.getActionCommand())) {
        	displayResult(value1-value2);
        } else if ("multiply".equals(e.getActionCommand())) {
        	displayResult(value1*value2);
        } else if ("divide".equals(e.getActionCommand())) {
        	displayResult(value1/value2);
        } 
    }
	
	public void displayResult(Double result) {
		JOptionPane.showMessageDialog(this, "O resultado é "+result);
	}

}
