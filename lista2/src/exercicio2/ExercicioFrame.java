package exercicio2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class ExercicioFrame extends JFrame implements ActionListener {
	private static JTextField txtNumero, txtMenor, txtMaior;
	private static JLabel lblNumero, lblMenor, lblMaior;
	private static JButton cadastrarButton, exibirButton;
	
	private static ArrayList<Double> numeros = new ArrayList<>();

	public static void main(String[] args) {
		ExercicioFrame frame = new ExercicioFrame();
		frame.setVisible(true);

	}
	
	public ExercicioFrame() {
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		// Número
		JPanel numeroPanel = new JPanel();
		numeroPanel.setLayout(new BoxLayout(numeroPanel, BoxLayout.X_AXIS));
		
		lblNumero = new JLabel("Número:");
		
		txtNumero = new JTextField("");
		txtNumero.setToolTipText("Número");
		
		numeroPanel.add(lblNumero);
		numeroPanel.add(txtNumero);
		
		// Maior e menor
		JPanel maiorMenorPanel = new JPanel();
		maiorMenorPanel.setLayout(new BoxLayout(maiorMenorPanel, BoxLayout.X_AXIS));
		
		lblMenor = new JLabel("Menor:");
		lblMaior = new JLabel("Maior:");
		
		txtMenor = new JTextField("");
		txtMenor.setToolTipText("Menor");
		txtMenor.setEditable(false);
		txtMenor.setEnabled(false);
		
		txtMaior = new JTextField("");
		txtMaior.setToolTipText("Maior");
		txtMaior.setEditable(false);
		txtMaior.setEnabled(false);
		
		maiorMenorPanel.add(lblMenor);
		maiorMenorPanel.add(txtMenor);
		maiorMenorPanel.add(lblMaior);
		maiorMenorPanel.add(txtMaior);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		panel_1.add(numeroPanel);
		panel_1.add(maiorMenorPanel);

		cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.addActionListener(this);
		
		exibirButton = new JButton("Exibir");
		exibirButton.addActionListener(this);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(panel_1);
		panel.add(cadastrarButton);
		panel.add(exibirButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cadastrarButton) {
			numeros.add(Double.valueOf(txtNumero.getText()));
		}
		
		if (e.getSource() == exibirButton) {
			Collections.sort(numeros);

	        double menor = numeros.get(0);
	        double maior = numeros.get(numeros.size() - 1);
	        
	        txtMenor.setText(String.valueOf(menor));
	        txtMaior.setText(String.valueOf(maior));
		}
	}

}
