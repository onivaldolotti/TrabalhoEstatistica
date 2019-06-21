package trabalhodaUeno;

public class NaoAgrupado {

	private double media;
	private double soma = 0;

	public double calcularMedia(int[] vet, int dados) {
		for (int i = 0; i < vet.length; i++) {
			soma += vet[i];
		}
		return media = soma / dados;
	}

	public double calcularVariancia(int[] vet, int dados) {
		soma = 0;
		for (int i = 0; i < vet.length; i++) {
			soma += Math.pow((vet[i] - media), 2);
		}
		return soma / (dados - 1);
	}

	public int calcularModa(int[] vet, int dados) {
		int cont = 0;
		int moda = 0;
		int indice = 0;
		for (int i = 0; i < vet.length; i++) {
			for (int j = 0; j < vet.length -1; j++) {
				if (vet[j] == vet[j + 1]) {
					cont++;
					if (cont > indice) {
						moda = vet[j];
						indice = cont;
					}
				} else {
					cont++;
				}
			}
		}
		return moda;
	}

}
