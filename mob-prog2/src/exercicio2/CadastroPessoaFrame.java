package exercicio2;

import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

import java.util.ArrayList;

// Equipe: João Gabriel Pozzobon dos Santos

public class CadastroPessoaFrame extends JFrame implements ActionListener {
		private static JLabel lblCPF, lblFirstName, lblSurname, lblBirthdate, lblCadastrada;
		private static JTextField txtCPF, txtFirstName, txtSurname, txtBirthdate, txtCadastrada;
		private static JButton cadastrarButton, exibirButton;
		
		private ArrayList<Pessoa> pessoas = new ArrayList<>();
		
		public static void main(String[] args) {
			CadastroPessoaFrame frame = new CadastroPessoaFrame();
			frame.setVisible(true);
		}
		
		public CadastroPessoaFrame() {
			// TODO Auto-generated method stub
			super("Cadastro de Pessoa");
			
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(0, 0, 0, 0));
			getContentPane().add(panel, BorderLayout.NORTH);
			
			// CPF
			JPanel cpfPanel = new JPanel();
			cpfPanel.setLayout(new BoxLayout(cpfPanel, BoxLayout.X_AXIS));
			
			lblCPF = new JLabel("CPF:");
			
			txtCPF = new JTextField("");
			txtCPF.setToolTipText("CPF");
			
			cpfPanel.add(lblCPF);
			cpfPanel.add(txtCPF);
			
			// First name
			JPanel firstNamePanel = new JPanel();
			firstNamePanel.setLayout(new BoxLayout(firstNamePanel, BoxLayout.X_AXIS));
			
			lblFirstName = new JLabel("Primeiros Nome:");
			
			txtFirstName = new JTextField("");
			txtFirstName.setToolTipText("Primeiro Nome");
			
			firstNamePanel.add(lblFirstName);
			firstNamePanel.add(txtFirstName);

			// Surname
			JPanel surnamePanel = new JPanel();
			surnamePanel.setLayout(new BoxLayout(surnamePanel, BoxLayout.X_AXIS));
			
			lblSurname = new JLabel("Sobrenome:");
			
			txtSurname = new JTextField("");
			txtSurname.setToolTipText("Sobrenome");
			
			surnamePanel.add(lblSurname);
			surnamePanel.add(txtSurname);
			
			// Birthdate
			JPanel birthdatePanel = new JPanel();
			birthdatePanel.setLayout(new BoxLayout(birthdatePanel, BoxLayout.X_AXIS));

			lblBirthdate = new JLabel("Data de Nascimento:");
			
			txtBirthdate = new JTextField("");
			txtBirthdate.setToolTipText("Data de Nascimento");
			
			birthdatePanel.add(lblBirthdate);
			birthdatePanel.add(txtBirthdate);
			
			// Pessoa cadastrada
			JPanel cadastradaPanel = new JPanel();
			cadastradaPanel.setLayout(new BoxLayout(cadastradaPanel, BoxLayout.X_AXIS));
			
			lblCadastrada = new JLabel("Pessoas cadastradas:");
			
			txtCadastrada = new JTextField("");
			txtCadastrada.setColumns(1);
			txtCadastrada.setEnabled(false);
			txtCadastrada.setEditable(false);
			
			cadastradaPanel.add(lblCadastrada);
			cadastradaPanel.add(txtCadastrada);
			
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
			
			panel_1.add(cpfPanel);
			panel_1.add(firstNamePanel);
			panel_1.add(surnamePanel);
			panel_1.add(birthdatePanel);
			panel_1.add(cadastradaPanel);
			
			JPanel buttonsPanel = new JPanel();
			buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
			
			cadastrarButton = new JButton("Cadastrar");
			cadastrarButton.addActionListener(this);
			buttonsPanel.add(cadastrarButton);
			
			exibirButton = new JButton("Exibir cadastro");
			exibirButton.addActionListener(this);
			buttonsPanel.add(exibirButton);
			
			panel_1.add(buttonsPanel);
			
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(panel_1);
		}
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == cadastrarButton) {
				Pessoa pessoa = new Pessoa();
				pessoa.setCpf(txtCPF.getText());
				pessoa.setFirstName(txtFirstName.getText());
				pessoa.setSurname(txtSurname.getText());
				pessoa.setBirthdate(txtBirthdate.getText());
				
				pessoas.add(pessoa);
			}
			
			if (e.getSource() == exibirButton) {
				String text = "";
				for (Pessoa pessoa : pessoas) {
					text+= pessoa.toString() + "\n";
				}
				txtCadastrada.setText(text);
			}
	    }
}
