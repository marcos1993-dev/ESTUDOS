package escola.modulo10.objetos;



public class Diretor extends Pessoa {
	
	
	
	private String regisEducacao;
	private String tempoDirecao;
	private String titulacao;
	
	public String getRegisEducacao() {
		return regisEducacao;
	}
	public void setRegisEducacao(String regisEducacao) {
		this.regisEducacao = regisEducacao;
	}
	public String getTempoDirecao() {
		return tempoDirecao;
	}
	public void setTempoDirecao(String tempoDirecao) {
		this.tempoDirecao = tempoDirecao;
	}
	public String getTitulacao() {
		return titulacao;
	}
	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((regisEducacao == null) ? 0 : regisEducacao.hashCode());
		result = prime * result + ((tempoDirecao == null) ? 0 : tempoDirecao.hashCode());
		result = prime * result + ((titulacao == null) ? 0 : titulacao.hashCode());
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
		Diretor other = (Diretor) obj;
		if (regisEducacao == null) {
			if (other.regisEducacao != null)
				return false;
		} else if (!regisEducacao.equals(other.regisEducacao))
			return false;
		if (tempoDirecao == null) {
			if (other.tempoDirecao != null)
				return false;
		} else if (!tempoDirecao.equals(other.tempoDirecao))
			return false;
		if (titulacao == null) {
			if (other.titulacao != null)
				return false;
		} else if (!titulacao.equals(other.titulacao))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Diretor [regisEducacao=" + regisEducacao + ", tempoDirecao=" + tempoDirecao + ", titulacao=" + titulacao
				+ ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + "]";
	}
	@Override
	public double salario() {
		return 300.85;
		
	}
	
	
	

}
