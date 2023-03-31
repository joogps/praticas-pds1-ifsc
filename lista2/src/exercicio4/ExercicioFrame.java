package exercicio4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class ExercicioFrame extends JFrame implements ActionListener {
	private static JTextField txtClasse, txtOrdem, txtBioma, txtCor, txtAlimento;
	private static JButton cadastrarButton, exibirMacacosButton, exibirPassarosButton;
	private static JRadioButton macacoButton, passaroButton;

	private static ArrayList<Macaco> macacos = new ArrayList<>();
	private static ArrayList<Passaro> passaros = new ArrayList<>();

	public static void main(String[] args) {
		ExercicioFrame frame = new ExercicioFrame();
		frame.setVisible(true);

	}
	
	public ExercicioFrame() {
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		// Classe
		JPanel classePanel = new JPanel();
		classePanel.setLayout(new BoxLayout(classePanel, BoxLayout.X_AXIS));

		JLabel lblClasse = new JLabel("Classe:");

		txtClasse = new JTextField("");
		txtClasse.setToolTipText("Classe");

		classePanel.add(lblClasse);
		classePanel.add(txtClasse);

		// Ordem
		JPanel ordemPanel = new JPanel();
		ordemPanel.setLayout(new BoxLayout(ordemPanel, BoxLayout.X_AXIS));

		JLabel lblOrdem = new JLabel("Ordem:");

		txtOrdem = new JTextField("");
		txtOrdem.setToolTipText("Ordem");

		ordemPanel.add(lblOrdem);
		ordemPanel.add(txtOrdem);

		// Bioma
		JPanel biomaPanel = new JPanel();
		biomaPanel.setLayout(new BoxLayout(biomaPanel, BoxLayout.X_AXIS));

		JLabel lblBioma = new JLabel("Bioma:");

		txtBioma = new JTextField("");
		txtBioma.setToolTipText("Bioma");

		biomaPanel.add(lblBioma);
		biomaPanel.add(txtBioma);

		// Cor
		JPanel corPanel = new JPanel();
		corPanel.setLayout(new BoxLayout(corPanel, BoxLayout.X_AXIS));

		JLabel lblCor = new JLabel("Cor:");

		txtCor = new JTextField("");
		txtCor.setToolTipText("Cor");

		corPanel.add(lblCor);
		corPanel.add(txtCor);

		// Alimento
		JPanel alimentoPanel = new JPanel();
		alimentoPanel.setLayout(new BoxLayout(alimentoPanel, BoxLayout.X_AXIS));

		JLabel lblAlimento = new JLabel("Alimento:");

		txtAlimento = new JTextField("");
		txtAlimento.setToolTipText("Alimento");

		alimentoPanel.add(lblAlimento);
		alimentoPanel.add(txtAlimento);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		panel_1.add(classePanel);
		panel_1.add(ordemPanel);
		panel_1.add(biomaPanel);
		panel_1.add(corPanel);
		panel_1.add(alimentoPanel);
		
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.X_AXIS));

		macacoButton = new JRadioButton("Macaco");
		passaroButton = new JRadioButton("Pássaro");

		ButtonGroup group = new ButtonGroup();
		group.add(macacoButton);
		group.add(passaroButton);

		radioPanel.add(macacoButton);
		radioPanel.add(passaroButton);

		cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.addActionListener(this);
		
		exibirMacacosButton = new JButton("Exibir macacos");
		exibirMacacosButton.addActionListener(this);
		exibirPassarosButton = new JButton("Exibir pássaros");
		exibirPassarosButton.addActionListener(this);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(panel_1);
		panel.add(radioPanel);
		panel.add(cadastrarButton);
		panel.add(exibirMacacosButton);
		panel.add(exibirPassarosButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cadastrarButton) {
			if (macacoButton.isSelected()) {
				Macaco macaco = new Macaco();
				macaco.setClasseAnimal(txtClasse.getText());
				macaco.setOrdem(txtOrdem.getText());
				macaco.setBioma(txtBioma.getText());
				macaco.setCor(txtCor.getText());
			    
			    macacos.add(macaco);
			} else if (passaroButton.isSelected()) {
				Passaro passaro = new Passaro();
				passaro.setClasseAnimal(txtClasse.getText());
				passaro.setOrdem(txtOrdem.getText());
				passaro.setBioma(txtBioma.getText());
				passaro.setAlimento(txtAlimento.getText());
			    
			    passaros.add(passaro);
			}
		}
		
		if (e.getSource() == exibirMacacosButton) {
			displayText(formatar(macacos));
		}
		
		if (e.getSource() == exibirPassarosButton) {
			displayText(formatar(passaros));
		}
	}
	
	public void displayText(String text) {
		JOptionPane.showMessageDialog(this, text);
	}

	public static <T extends Animal> String formatar(ArrayList<T> list) {
        String text = "";

        for (T pessoa : list) {
        	text+= pessoa.toString();
        	text+= "\n";
        }

        return text;
    }
}
