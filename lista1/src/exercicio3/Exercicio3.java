package exercicio3;

import javax.swing.JOptionPane;

public class Exercicio3 {

	public static void main(String[] args) {
		// Double[] lista = new Double[3];
		Double total = 0.0;
		
		for (int i = 0; i < 3; i++) {
			String valor = JOptionPane.showInputDialog("Digite uma nota:");
			total+= Double.valueOf(valor);
		}
		
		Double media = total/3.0;
		String texto = "";
		if (media >= 6) {
			texto = "Aprovado(a)";
		} else if (media >= 4) {
			texto = "Recuperação";
		} else {
			texto = "Reprovado(a)";
		}
		
		JOptionPane.showMessageDialog(null, texto);
	}

}
