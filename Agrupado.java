package trabalhodaUeno;

public class Agrupado {

	private double maiorFrequencia;
	private double Li;
	private double media;
	private double var;
	private int N;

	public void pegaLimiteInferior(double[][] tabela) {
		for (int i = 0; i < tabela.length; i++) {
			if (tabela[i][1] == this.maiorFrequencia) {
				this.Li = tabela[i][0];
			}
		}
	}

	public int calcularMaiorFrequencia(double[][] tabela) {
		this.maiorFrequencia = 0;
		for (int i = 0; i < tabela.length; i++) {
			for (int j = 1; j < 2; j++) {
				if (tabela[i][j] > this.maiorFrequencia) {
					this.maiorFrequencia = tabela[i][j];
				}
			}
		}
		return (int) this.maiorFrequencia;
	}

	public void receberN(int soma) {
		this.N = soma;
	}

	public double calcularMedia(double[][] tabela) {
		double soma = 0;
		for (int i = 0; i < tabela.length; i++) {
			tabela[i][3] = tabela[i][0] * tabela[i][1];
		}
		for (int i = 0; i < tabela.length; i++) {
			for (int j = 3; j < 4; j++) {
				soma += tabela[i][j];
			}
		}
		this.media = soma / this.N;
		return this.media;

	}

	public int pegaLimiteInferiorAgrupados(double[][] tabela) {
		for (int i = 0; i < tabela.length; i++) {
			if (tabela[i][1] == this.maiorFrequencia) {
				this.Li = tabela[i][0];
			}
		}
		return (int) this.Li;
	}

	public double calcularVariancia(double[][] tabela) {
		this.var = 0;
		for (int i = 0; i < tabela.length; i++) {
			tabela[i][2] = (Math.pow((tabela[i][0] - this.media), 2)) * tabela[i][1];
		}
		for (int i = 0; i < tabela.length; i++) {
			this.var = this.var + tabela[i][2];
		}
		return this.var = this.var / (this.N - 1);
	}
}
