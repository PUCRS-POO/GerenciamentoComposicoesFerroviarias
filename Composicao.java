import java.util.ArrayList;

public class Composicao {
	private ArrayList<Vagao> vagoes;
	private ArrayList<Locomotiva> locomotivas;
	private int identificador;

	public Composicao(int identificador){
		this.identificador = identificador;
		vagoes = new ArrayList<>();
		locomotivas = new ArrayList<>();
	}

	public int getIdentificador() {
		return identificador;
	}

	public int getQtdadeLocomotivas() {
		return locomotivas.size();
	}

	public Locomotiva getLocomotiva(int posicao) {
		if (posicao >= 0 && posicao < locomotivas.size()) {
			return locomotivas.get(posicao);
		} else {
			return null;
		}
	}

	public int getQtdadeVagoes() {
		return vagoes.size();
	}

	public Vagao getVagao(int posicao) {
		if (posicao >= 0 && posicao < vagoes.size()) {
			return vagoes.get(posicao);
		} else {
			return null;
		}
	}

	public boolean engataLocomotiva(Locomotiva locomotiva) {
		// TO DO: escrever o código que permite engatar uma locomotiva
		if(getQtdadeVagoes == 0 && locomotiva.getComposicao() == -1) {
			locomotivas.add(locomotiva);
			locomotiva.setComposicao(this);
			return true;
		}
		return false;
	}

	public boolean engataVagao(Vagao vagao) {
		// TO DO: escrever o código que permite engatar um vagao
		if(getQtdadeLocomotivas > 0) {
			int numeroTotalVagoes = 0;
			for(int i = 0; i < this.getQtdadeLocomotivas(); i++) {
				numeroTotalVagoes += (this.getLocomotiva(i).getQtdadeMaxVagoes());
			}
			if(this.getQtdadeLocomotivas > 1) {
				numeroTotalVagoes -= (numeroTotalVagoes*0.1);
			}

			double maxPeso = 0;
			for(int i = 0; i < this.getQtdadeLocomotivas(); i++) {
				maxPeso += this.getLocomotiva(i).getPesoMaximo();
			}

			double pesoAtual = 0;
			for(Vagao v : vagoes) {
				pesoAtual += v.getCapacidadeCarga();
			}

			if(this.getQtdadeVagoes() < numeroTotalVagoes && (maxPeso+vagoes.getCapacidadeCarga()) <= pesoAtual) {
				vagoes.add(vagao);	
				vagao.setComposicao(this);	
			}
		}
		return true;
	}

	public boolean desengataLocomotiva() {
		// TO DO: escrever o código que permite desengatar uma locomotiva
		return true;
	}

	public boolean desengataVagao() {
		// TO DO: escrever o código que permite desengatar um vagao
		return true;
	}

	public String toLineFile(){
		String aux = "";
		aux += this.getIdentificador() +",";
		aux += this.getQtdadeLocomotivas()+",";
		for(int i=0;i<this.getQtdadeLocomotivas();i++){
			aux += this.getLocomotiva(i).toLineFile()+",";
		}
		aux += this.getQtdadeVagoes()+",";
		for(int i=0;i<this.getQtdadeVagoes();i++){
			aux += this.getVagao(i).toLineFile();
			if (i<this.getQtdadeVagoes()-1){
				aux += ",";
			}
		}
		return aux;
	}
}
