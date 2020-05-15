package escola.modulo10.objetos;
/*Essa é a classe mãe que fornece atributos para as demais*/

public abstract class  Pessoa {
	
	protected String nome;	
	protected String endereco;
	protected int telefone;
	
	public abstract double salario();
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + telefone;
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
		Pessoa other = (Pessoa) obj;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone != other.telefone)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", getNome()=" + getNome()
				+ ", getEndereco()=" + getEndereco() + ", getTelefone()=" + getTelefone() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	
	
	
	
	
	
	

}
