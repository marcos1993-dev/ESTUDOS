package escola.modulo10.objetos;

import escola.modulo10.interfaces.PermiteAcesso;

public class Secretario extends Pessoa implements PermiteAcesso {
	
	private String registro;
	private String nivelcargo;
	private String titulacao;
	private String usuario;
	private String senha;
	
	
	
	public Secretario(String usuario, String senha) {

		this.usuario = usuario;
		this.senha = senha;
	}
	
	public Secretario() {

	}



	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getNivelcargo() {
		return nivelcargo;
	}
	public void setNivelcargo(String nivelcargo) {
		this.nivelcargo = nivelcargo;
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
		int result = 1;
		result = prime * result + ((nivelcargo == null) ? 0 : nivelcargo.hashCode());
		result = prime * result + ((registro == null) ? 0 : registro.hashCode());
		result = prime * result + ((titulacao == null) ? 0 : titulacao.hashCode());
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
		Secretario other = (Secretario) obj;
		if (nivelcargo == null) {
			if (other.nivelcargo != null)
				return false;
		} else if (!nivelcargo.equals(other.nivelcargo))
			return false;
		if (registro == null) {
			if (other.registro != null)
				return false;
		} else if (!registro.equals(other.registro))
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
		return "Secretario [registro=" + registro + ", nivelcargo=" + nivelcargo + ", titulacao=" + titulacao
				+ ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + "]";
	}
	
	@Override
	public double salario() {
		
		return 1800.00;
	}
	
	@Override
	public boolean autenticar() {
		
		return usuario.equals("admin")&& senha.equals("123");
	}
	
	
	
	
	

}
