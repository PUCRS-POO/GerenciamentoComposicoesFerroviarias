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
		if(this.getQtdadeVagoes() == 0 && locomotiva.getComposicao() == -1) {
			locomotivas.add(locomotiva);
			locomotiva.setComposicao(this);
			return true;
		}
		return false;
	}

	public boolean engataVagao(Vagao vagao) {
		// TO DO: escrever o código que permite engatar um vagao
		if(this.getQtdadeLocomotivas() > 0) {
			int numeroTotalVagoes = 0;
			for(int i = 0; i < this.getQtdadeLocomotivas(); i++) {
				numeroTotalVagoes += (this.getLocomotiva(i).getQtdadeMaxVagoes());
			}

			// numero total de vagoes diminui 10% se a composicao possuir mais de 1 locomotiva
			if(this.getQtdadeLocomotivas() > 1) {
				numeroTotalVagoes -= (numeroTotalVagoes*0.1);
			}

			// peso maximo que a composicao suporta
			double maxPeso = 0;
			for(int i = 0; i < this.getQtdadeLocomotivas(); i++) {
				maxPeso += this.getLocomotiva(i).getPesoMaximo();
			}

			// peso atual da composicao
			double pesoAtual = 0;
			for(Vagao v : vagoes) {
				pesoAtual += v.getCapacidadeCarga();
			}

			if((this.getQtdadeVagoes() < numeroTotalVagoes) && (pesoAtual + vagao.getCapacidadeCarga()) <= maxPeso) {
				vagoes.add(vagao);	
				vagao.setComposicao(this);
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public boolean desengataLocomotiva() {
		if(this.getQtdadeLocomotivas() > 0 && this.getQtdadeVagoes() == 0) {
			Locomotiva l = locomotivas.remove(locomotivas.size()-1);
			l.setComposicao(null);
			return true;
		} else {
			return false;
		}
	}

	public boolean desengataVagao() {
		if(this.getQtdadeVagoes() > 0) {
			Vagao v = vagoes.remove(vagoes.size()-1);
			v.setComposicao(null);
			return true;
		} else {
			return false;
		}

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
