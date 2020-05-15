package escola.modulo10.objetos;

import java.util.ArrayList;
import java.util.List;

import escola.modulo10.status.StatusAluno;

public class Aluno extends Pessoa {
	
	
	private int serie;
	private String nomeEscola;
	private String dataMatricula;
	
	List<Disciplinas> dcpl = new ArrayList<Disciplinas>();
	Disciplinas disciplina = new Disciplinas();
	
	
	
	
	public List<Disciplinas> getDcpl() {
		return dcpl;
	}
	public void setDcpl(List<Disciplinas> dcpl) {
		this.dcpl = dcpl;
	}
	
	
	public int getSerie() {
		return serie;
	}
	public void setSerie(int serie) {
		this.serie = serie;
	}
	public String getNomeEscola() {
		return nomeEscola;
	}
	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}
	public String getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataMatricula == null) ? 0 : dataMatricula.hashCode());
		result = prime * result + ((nomeEscola == null) ? 0 : nomeEscola.hashCode());
		result = prime * result + serie;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (dataMatricula == null) {
			if (other.dataMatricula != null)
				return false;
		} else if (!dataMatricula.equals(other.dataMatricula))
			return false;
		if (nomeEscola == null) {
			if (other.nomeEscola != null)
				return false;
		} else if (!nomeEscola.equals(other.nomeEscola))
			return false;
		if (serie != other.serie)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Aluno [serie=" + serie + ", nomeEscola=" + nomeEscola + ", dataMatricula=" + dataMatricula + ", dcpl="
				+ dcpl + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + "]";
	}
	
	
public double calculaMedia() {
	double media = 0.0;
	for (Disciplinas disciplinas : dcpl) {
		for(int i=0; i<disciplinas.getNotas().length; i++) {
			media += disciplinas.getNotas()[i];
		 }
		
		}
	
	return media/disciplina.getNotas().length;
}



public String situacaoAluno() {
	if (calculaMedia()>=50) {
		if(calculaMedia()>=70) {
			return StatusAluno.Aprovado;
		}
		return StatusAluno.Recuperacao;
	}else {
		return StatusAluno.Reprovado;
	}
}
@Override
public double salario() {
	
	return 0;
}

}
