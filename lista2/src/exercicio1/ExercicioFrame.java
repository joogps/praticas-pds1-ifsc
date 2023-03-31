package exercicio1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class ExercicioFrame extends JFrame implements ActionListener {
	private static JTextField txtNumero, txtResultado;
	private static JLabel lblNumero, lblResultado;
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
		
		// Resultado
		JPanel resultadoPanel = new JPanel();
		resultadoPanel.setLayout(new BoxLayout(resultadoPanel, BoxLayout.X_AXIS));
		
		lblResultado = new JLabel("Resultado:");
		
		txtResultado = new JTextField("");
		txtResultado.setToolTipText("Resultado");
		txtResultado.setEditable(false);
		txtResultado.setEnabled(false);
		
		resultadoPanel.add(lblResultado);
		resultadoPanel.add(txtResultado);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		panel_1.add(numeroPanel);
		panel_1.add(resultadoPanel);

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
			int pares = 0;
	        for (double n : numeros) {
	            if (n % 2 == 0) {
	            	pares++;
	            }
	        } 
			txtResultado.setText("Há "+pares+" números pares.");
		}
	}

}
