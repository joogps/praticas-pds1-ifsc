package exercicio5;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercicio5 extends JFrame implements ActionListener {
	private static JTextField txt1;
	private static JTextField txt2;
	private static JTextField txt3;

	public static void main(String[] args) {
		Exercicio5 frame = new Exercicio5();
		frame.setVisible(true);
	}
	
	public Exercicio5() {
		// TODO Auto-generated method stub
		super("Calculadora");
		BorderLayout borderLayout = (BorderLayout) this.getContentPane().getLayout();
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.getContentPane().add(panel, BorderLayout.NORTH);
		
		txt1 = new JTextField("");
		txt1.setToolTipText("Lado um");
		
		txt2 = new JTextField();
		txt2.setToolTipText("Lado dois");
		
		txt3 = new JTextField();
		txt3.setToolTipText("Lado três");
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JButton verifyButton = new JButton("Verificar");
		panel_1.add(verifyButton);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(txt1);
		panel.add(txt2);
		panel.add(txt3);
		panel.add(panel_1);
		
		verifyButton.setActionCommand("verify");
		verifyButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Double value1 = Double.valueOf(txt1.getText());
		Double value2 = Double.valueOf(txt2.getText());
		Double value3 = Double.valueOf(txt3.getText());
		
		if (value1.compareTo(value2) == 0 && value2.compareTo(value3) == 0) {
        	displayResult("O triângulo é equilátero");
		} else if (value1.compareTo(value2) == 0 || value2.compareTo(value3) == 0 || value1.compareTo(value3) == 0) {
        	displayResult("O triângulo é isósceles");
		} else {
        	displayResult("O triângulo é escaleno");
		}
    }
	
	public static void displayResult(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

}
