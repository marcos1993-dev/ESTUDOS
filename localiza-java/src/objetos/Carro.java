package objetos;

import java.util.ArrayList;
import java.util.List;


import status.java.SituacaoVeiculo;

public class Carro {

	
	
	private String nome;
	private String cor;
	private double motor;
	private int ano;
	private String placa;
	private boolean alugado;
	private double Diaria;
	
	List<Marcas> marcList = new ArrayList<Marcas>();
	
	
	public List<Marcas> getMarcList() {
		return marcList;
	}
	
	public void setMarcList(List<Marcas> marcList) {
		this.marcList = marcList;
	}
	public double getDiaria() {
		return Diaria;
	}
	public void setDiaria(double diaria) {
		Diaria = diaria;
	}
	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public double getMotor() {
		return motor;
	}
	public void setMotor(double motor) {
		this.motor = motor;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public boolean isAlugado() {
		return alugado;
	}
	
	
	


	@Override
	public String toString() {
		return "Carro [nome=" + nome + ", cor=" + cor + ", motor=" + motor + ", ano=" + ano + ", placa=" + placa
				+ ", alugado=" + alugado + ", Diaria=" + Diaria + ", marcList=" + marcList + "]";
	}

	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(Diaria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (alugado ? 1231 : 1237);
		result = prime * result + ano;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((marcList == null) ? 0 : marcList.hashCode());
		temp = Double.doubleToLongBits(motor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (Double.doubleToLongBits(Diaria) != Double.doubleToLongBits(other.Diaria))
			return false;
		if (alugado != other.alugado)
			return false;
		if (ano != other.ano)
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (marcList == null) {
			if (other.marcList != null)
				return false;
		} else if (!marcList.equals(other.marcList))
			return false;
		if (Double.doubleToLongBits(motor) != Double.doubleToLongBits(other.motor))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}

	public String aluguel() {
		if (alugado == true) {
			return SituacaoVeiculo.ALUGADO;
		}else {
			return SituacaoVeiculo.LIVRE;
		}
	}
	
	public Double calculaAlug(double dias, double valor) {
		return (dias*valor);
		
	}	
}

	
	
	
	
	
	
	
	

