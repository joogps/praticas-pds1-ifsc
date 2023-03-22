package exercicio4;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercicio4 extends JFrame implements ActionListener {
	private static JTextField txtOne;
	private static JTextField txtTwo;

	public static void main(String[] args) {
		Exercicio4 frame = new Exercicio4();
		frame.setVisible(true);
	}
	
	public Exercicio4() {
		// TODO Auto-generated method stub
		super("Calculadora");
		BorderLayout borderLayout = (BorderLayout) this.getContentPane().getLayout();
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.getContentPane().add(panel, BorderLayout.NORTH);
		
		txtOne = new JTextField("");
		txtOne.setToolTipText("Número um");
		
		txtTwo = new JTextField();
		txtTwo.setToolTipText("Número um");
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JButton sumButton = new JButton("+ Soma");
		panel_1.add(sumButton);
		
		JButton subtractButton = new JButton("- Subtração");
		panel_1.add(subtractButton);
		
		JButton multiplyButton = new JButton("× Multiplicação");
		panel_1.add(multiplyButton);
		
		JButton divisionButton = new JButton("÷ Divisão");
		panel_1.add(divisionButton);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(txtOne);
		panel.add(txtTwo);
		panel.add(panel_1);
		
		sumButton.setActionCommand("sum");
		subtractButton.setActionCommand("subtract");
		multiplyButton.setActionCommand("multiply");
		divisionButton.setActionCommand("divide");
		
		sumButton.addActionListener(this);
		subtractButton.addActionListener(this);
		multiplyButton.addActionListener(this);
		divisionButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Double value1 = Double.valueOf(txtOne.getText());
		Double value2 = Double.valueOf(txtTwo.getText());
		
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
	
	public static void displayResult(Double result) {
		JOptionPane.showMessageDialog(null, "O resultado é "+result);
	}

}
