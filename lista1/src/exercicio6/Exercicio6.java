package exercicio6;

import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

public class Exercicio6 extends JFrame implements ActionListener {
	private static JTextField txtNome;
	private static JTextField[] txtNotas;

	public static void main(String[] args) {
		Exercicio6 frame = new Exercicio6();
		frame.setVisible(true);
	}
	
	public Exercicio6() {
		// TODO Auto-generated method stub
		super("Notas");
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		txtNome = new JTextField("");
		txtNome.setToolTipText("Nome");
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JButton verifyButton = new JButton("Verificar");
		panel_1.add(verifyButton);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		JLabel lblJNome = new JLabel("Nome");
		lblJNome.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblJNome.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblJNome);
		panel.add(txtNome);
		
		JPanel panel_notas = new JPanel();
		panel.add(panel_notas);
		panel_notas.setLayout(new BoxLayout(panel_notas, BoxLayout.X_AXIS));
		
		txtNotas = new JTextField[3];
		for(int i = 0; i < txtNotas.length; i++) {
			JPanel panel_nota = new JPanel();
			panel_notas.add(panel_nota);
			panel_nota.setLayout(new BoxLayout(panel_nota, BoxLayout.Y_AXIS));
			
			JLabel lblNota = new JLabel("Nota "+(i+1));
			lblNota.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblNota.setHorizontalAlignment(SwingConstants.CENTER);
			panel_nota.add(lblNota);
			
			JTextField txtNota = new JTextField();
			txtNota.setToolTipText("Nota "+(i+1));
			panel_nota.add(txtNota);
			
			txtNotas[i] = txtNota;
		}
		
		panel.add(panel_1);
		
		verifyButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
        String nome = txtNome.getText();
        
        Double[] notas = new Double[3];
        for (int i = 0; i < txtNotas.length; i++) {
            notas[i] = Double.valueOf(txtNotas[i].getText());
        }

        Double soma = 0.0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }
        Double media = soma / notas.length;

        displayResult(nome + ", sua média é " + media);
    }
	
	public void displayResult(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

}
