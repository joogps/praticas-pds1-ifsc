package exercicio2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Exercicio2 {

	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			String valor = JOptionPane.showInputDialog("Digite o valor:");
			lista.add(valor);
		}
		
		String texto = String.join(", ", lista);
		JOptionPane.showMessageDialog(null, texto);
	}

}
