package exercicio1;

import javax.swing.JOptionPane;

public class Exercicio1 {

	public static void main(String[] args) {
		String precoLitro = "", quantidadeLitros = "";
		
		while (precoLitro.isEmpty()) {
			precoLitro = JOptionPane.showInputDialog("Informe o preço do litro.");
			if (precoLitro.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido.");
			}
		}
		
		while (quantidadeLitros.isEmpty()) {
			quantidadeLitros = JOptionPane.showInputDialog("Informe a quantidade de litros.");
			if (quantidadeLitros.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido.");
			}
		}
		
		Double totalPagamento = calcularTotal(Double.valueOf(precoLitro), Integer.valueOf(quantidadeLitros));
		JOptionPane.showMessageDialog(null, "O total é de R$ "+totalPagamento);
		
	}
	
	public static double calcularTotal(Double preco, Integer litros) {
		return preco*litros;
	}

}
