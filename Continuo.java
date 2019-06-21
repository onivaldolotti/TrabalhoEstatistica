package trabalhodaUeno;

import java.text.DecimalFormat;

public class Continuo {

	private double comprimentoDaClasse;
	private double media;
	private int N;
	private double Li;
	private double delta1;
	private double delta2;
	private double moda;
	private double var;
	private double maiorFrequencia;
	
	DecimalFormat df = new DecimalFormat("0.00");
	
	public void calcularComprimentoDaClasse(double[][] tabela){
		this.comprimentoDaClasse = tabela[0][1]- tabela[0][0];
	}
	
	public void calcularSomaN(double[][] tabela) {
		for (int i = 0; i < tabela.length; i++) {
			for (int j = 2; j < 3; j++) {
				this.N += tabela[i][j];
			}
		}
	}

	public void calcularPontoMedioXi(double[][] tabela) {
		for (int i = 0; i < tabela.length; i++) {
			tabela[i][3] = (tabela[i][0] + tabela[i][1]) / 2;
		}
	}

	public int calcularMaiorFrequencia(double[][] tabela) {
		this.maiorFrequencia = 0;

		for (int i = 0; i < tabela.length; i++) {
			for (int j = 2; j < 3; j++) {
				if (tabela[i][j] > this.maiorFrequencia) {
					this.maiorFrequencia = tabela[i][j];
				}
			}
		}
		return (int) this.maiorFrequencia;
	}

	public double calcularMedia(double[][] tabela) {
		double soma = 0;
		for (int i = 0; i < tabela.length; i++) {
			tabela[i][4] = tabela[i][2] * tabela[i][3];
		}
		for (int i = 0; i < tabela.length; i++) {
			for (int j = 4; j < 5; j++) {
				soma += tabela[i][j];
			}
		}
		this.media = soma / this.N;
		return this.media;

	}

	public double calcularVariancia(double[][] tabela) {
		this.var = 0;
		for (int i = 0; i < tabela.length; i++) {
			tabela[i][4] = (Math.pow((tabela[i][3] - this.media), 2)) * tabela[i][2];
		}
		for (int i = 0; i < tabela.length; i++) {
			this.var = this.var + tabela[i][4];
		}
		this.var = this.var / (this.N - 1);

		return this.var;
	}

	public void calcularDelta1(double[][] tabela) {
		for (int i = 0; i < tabela.length; i++) {
			if (tabela[i][2] == this.maiorFrequencia) {
				if (i == 0) {
					this.delta1 = 0;
				} else {
					this.delta1 = tabela[i][2] - tabela[i - 1][2];
				}
			}
		}
	}

	public void calcularDelta2(double[][] tabela) {
		for (int i = 0; i < tabela.length; i++) {
			if (tabela[i][2] == this.maiorFrequencia) {
				this.delta2 = tabela[i][2] - tabela[i + 1][2];
			}
		}
	}

	public void pegaLimiteInferior(double[][] tabela) {
		for (int i = 0; i < tabela.length; i++) {
			if (tabela[i][2] == this.maiorFrequencia) {
				this.Li = tabela[i][0];
			}
		}
	}

	public double calcularModa() {
		this.moda = ((this.delta1 / (this.delta1 + this.delta2)) * this.comprimentoDaClasse) + this.Li;
		return this.moda;
	}

}