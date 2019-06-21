package trabalhodaUeno;

import java.text.DecimalFormat;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Aplicacao {

	public static void main(String[] args) {
		int soma = 0;
		int op = 0;
		int numeroDeClasses = 0;
		double[][] tabela = new double[0][];
		Continuo resultado;
		DecimalFormat df = new DecimalFormat(".00");
		do {

			op = Integer.parseInt(JOptionPane.showInputDialog("     Deseja entrar com: \n" + "\n 1 - Dados Continuos "
					+ "\n 2 - Dados Agrupados" + "\n 3 - Dados Nao Agrupados " + "\n 0 - Encerrar"));
			switch (op) {
			case 1:
				String a = " ";
				numeroDeClasses = Integer.parseInt(JOptionPane.showInputDialog("Entre com o número de classes:"));
				tabela = new double[numeroDeClasses][5];
				for (int i = 0; i < tabela.length; i++) {
					for (int j = 0; j < 1; j++) {
						tabela[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Entre com os limites inferiores:"));
					}
				}

				for (int i = 0; i < tabela.length; i++) {
					for (int j = 1; j < 2; j++) {
						tabela[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Entre com os limites superiores:"));
					}
				}

				for (int i = 0; i < tabela.length; i++) {
					for (int j = 2; j < 3; j++) {
						tabela[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Entre com as frequencias:"));
					}
				}

				resultado = new Continuo();
				resultado.calcularComprimentoDaClasse(tabela);
				resultado.calcularSomaN(tabela);
				resultado.calcularPontoMedioXi(tabela);
				resultado.calcularMaiorFrequencia(tabela);
				resultado.calcularDelta1(tabela);
				resultado.calcularDelta2(tabela);
				resultado.pegaLimiteInferior(tabela);
				a += "Media : " + (resultado.calcularMedia(tabela)) + "\n";
				double varr = resultado.calcularVariancia(tabela);
				double moda = resultado.calcularModa();
				a += "Variancia : " + df.format(varr) + "\n";
				a += " Moda: " + df.format(moda) + "\n";
				a += "Li       |Ls       |Fi       |Xi       \n";

				for (int i = 0; i < tabela.length; i++) {
					for (int j = 0; j < 4; j++) {
						a += (tabela[i][j] + " | ");
					}
					a += "\n";
				}
				JOptionPane.showMessageDialog(null, a);

				break;
			case 2:
				String b = " ";
				numeroDeClasses = Integer.parseInt(JOptionPane.showInputDialog("Entre com o número de classes:"));
				tabela = new double[numeroDeClasses][4];
				for (int i = 0; i < tabela.length; i++) {
					for (int j = 0; j < 1; j++) {
						tabela[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Entre com os dados"));
					}
				}

				for (int i = 0; i < tabela.length; i++) {
					for (int j = 1; j < 2; j++) {
						tabela[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Entre com as frequencias:"));
					}
				}
				soma = Integer.parseInt(JOptionPane.showInputDialog("Entre com a soma das frequencias:"));

				Agrupado agrupados = new Agrupado();
				agrupados.calcularMaiorFrequencia(tabela);
				agrupados.pegaLimiteInferior(tabela);
				agrupados.receberN(soma);
				b += "Media : " + agrupados.calcularMedia(tabela)+ "\n";
				double var = agrupados.calcularVariancia(tabela);
				b += "Variancia : " + df.format(var) + "\n";
				b += " Moda: " + agrupados.pegaLimiteInferiorAgrupados(tabela) + "\n";
				b += "Xi       |Fi             \n";

				for (int i = 0; i < tabela.length; i++) {
					for (int j = 0; j < 2; j++) {
						b += (tabela[i][j] + " | ");
					}
					b += "\n";
				}
				JOptionPane.showMessageDialog(null, b);
				break;
			case 3:

				String c = " ";
				int dados = Integer.parseInt(JOptionPane.showInputDialog("Quantos numeros deseja calcular: "));
				int[] vet = new int[dados];
				for (int i = 0; i < vet.length; i++) {
					vet[i] = Integer.parseInt(JOptionPane.showInputDialog("Entre com os numeros"));
				}
				Arrays.sort(vet);
				NaoAgrupado naoAgrupados = new NaoAgrupado();
				c+="Media: " +naoAgrupados.calcularMedia(vet, dados)+"\n";
				double vari = naoAgrupados.calcularVariancia(vet, dados);
				c += "Variancia: " + df.format(vari)  + "\n";
				int modal = naoAgrupados.calcularModa(vet, dados);
				if (modal == 0) {
					c += "Moda: Amodal \n";	
				}else {
					c += "Moda: " +  modal + "\n";
				}
				JOptionPane.showMessageDialog(null, c);
			}

		} while (op != 0);

	}

}
