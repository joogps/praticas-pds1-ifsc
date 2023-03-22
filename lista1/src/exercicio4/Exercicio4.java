package exercicio4;

import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercicio4 extends JFrame implements ActionListener {
	private static JTextField txt1;
	private static JTextField txt2;

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
		
		txt1 = new JTextField("");
		txt1.setToolTipText("Número um");
		
		txt2 = new JTextField();
		txt2.setToolTipText("Número dois");
		
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
		panel.add(txt1);
		panel.add(txt2);
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
	
	public static void displayResult(Double result) {
		JOptionPane.showMessageDialog(null, "O resultado é "+result);
	}

}
