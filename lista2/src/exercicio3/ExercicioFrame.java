package exercicio3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	private static JTextField txtNome, txtData, txtCpf, txtSiape, txtMatricula;
	private static JButton cadastrarButton, exibirAlunosButton, exibirProfessoresButton;
	private static JRadioButton alunoButton, professorButton;
	
	private static ArrayList<Aluno> alunos = new ArrayList<>();
	private static ArrayList<Professor> professores = new ArrayList<>();

	public static void main(String[] args) {
		ExercicioFrame frame = new ExercicioFrame();
		frame.setVisible(true);

	}
	
	public ExercicioFrame() {
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		// Nome
		JPanel nomePanel = new JPanel();
		nomePanel.setLayout(new BoxLayout(nomePanel, BoxLayout.X_AXIS));

		JLabel lblNome = new JLabel("Nome:");

		txtNome = new JTextField("");
		txtNome.setToolTipText("Nome");

		nomePanel.add(lblNome);
		nomePanel.add(txtNome);

		// Data
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.X_AXIS));

		JLabel lblData = new JLabel("Data:");

		txtData = new JTextField("");
		txtData.setToolTipText("Data");

		dataPanel.add(lblData);
		dataPanel.add(txtData);

		// CPF
		JPanel cpfPanel = new JPanel();
		cpfPanel.setLayout(new BoxLayout(cpfPanel, BoxLayout.X_AXIS));

		JLabel lblCpf = new JLabel("CPF:");

		txtCpf = new JTextField("");
		txtCpf.setToolTipText("CPF");

		cpfPanel.add(lblCpf);
		cpfPanel.add(txtCpf);

		// SIAPE
		JPanel siapePanel = new JPanel();
		siapePanel.setLayout(new BoxLayout(siapePanel, BoxLayout.X_AXIS));

		JLabel lblSiape = new JLabel("SIAPE:");

		txtSiape = new JTextField("");
		txtSiape.setToolTipText("SIAPE");

		siapePanel.add(lblSiape);
		siapePanel.add(txtSiape);

		// Matrícula
		JPanel matriculaPanel = new JPanel();
		matriculaPanel.setLayout(new BoxLayout(matriculaPanel, BoxLayout.X_AXIS));

		JLabel lblMatricula = new JLabel("Matrícula:");

		txtMatricula = new JTextField("");
		txtMatricula.setToolTipText("Matrícula");

		matriculaPanel.add(lblMatricula);
		matriculaPanel.add(txtMatricula);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		panel_1.add(nomePanel);
		panel_1.add(dataPanel);
		panel_1.add(cpfPanel);
		panel_1.add(siapePanel);
		panel_1.add(matriculaPanel);
		
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.X_AXIS));

		alunoButton = new JRadioButton("Aluno");
		professorButton = new JRadioButton("Professor");

		ButtonGroup group = new ButtonGroup();
		group.add(alunoButton);
		group.add(professorButton);

		radioPanel.add(alunoButton);
		radioPanel.add(professorButton);

		cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.addActionListener(this);
		
		exibirAlunosButton = new JButton("Exibir alunos");
		exibirAlunosButton.addActionListener(this);
		exibirProfessoresButton = new JButton("Exibir professores");
		exibirProfessoresButton.addActionListener(this);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(panel_1);
		panel.add(radioPanel);
		panel.add(cadastrarButton);
		panel.add(exibirAlunosButton);
		panel.add(exibirProfessoresButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cadastrarButton) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        Date data = new Date();
			try {
				data = dateFormat.parse(txtData.getText());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			if (alunoButton.isSelected()) {
			    Aluno aluno = new Aluno();
			    aluno.setNome(txtNome.getText());
		        aluno.setDataNasc(data);
			    aluno.setCpf(Long.valueOf(txtCpf.getText()));
			    aluno.setMatricula(Long.valueOf(txtMatricula.getText()));
			    
			    alunos.add(aluno);
			} else if (professorButton.isSelected()) {
			    Professor professor = new Professor();
			    professor.setNome(txtNome.getText());
		        professor.setDataNasc(data);
			    professor.setCpf(Long.valueOf(txtCpf.getText()));
			    professor.setSiape(Long.valueOf(txtSiape.getText()));
			    
			    professores.add(professor);
			}
		}
		
		if (e.getSource() == exibirAlunosButton) {
			displayText(formatar(alunos));
		}
		
		if (e.getSource() == exibirProfessoresButton) {
			displayText(formatar(professores));
		}
	}
	
	public void displayText(String text) {
		JOptionPane.showMessageDialog(this, text);
	}

	public static <T extends Pessoa> String formatar(ArrayList<T> list) {
        String text = "";

        for (T pessoa : list) {
        	text+= pessoa.toString();
        	text+= "\n";
        }

        return text;
    }
}
