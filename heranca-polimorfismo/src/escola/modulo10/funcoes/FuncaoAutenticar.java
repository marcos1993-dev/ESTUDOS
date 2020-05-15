package escola.modulo10.funcoes;

import escola.modulo10.interfaces.PermiteAcesso;

public class FuncaoAutenticar {
	
	private PermiteAcesso permitirAcesso;

	public boolean autenticarUsuario() {
	
		return permitirAcesso.autenticar();
	}
	
	public FuncaoAutenticar(PermiteAcesso pmtAcesso) {
		this.permitirAcesso = pmtAcesso;
	}
		
}
