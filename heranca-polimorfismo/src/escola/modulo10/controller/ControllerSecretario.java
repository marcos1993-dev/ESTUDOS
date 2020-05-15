package escola.modulo10.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import escola.modulo10.objetos.Secretario;


public class ControllerSecretario {
	
	List<Secretario> listSecret = new ArrayList<Secretario>();
	
	
public void guiaSecretario(){
	
	int esc = 0;
	while(esc !=4) {
		esc = Integer.parseInt(JOptionPane.showInputDialog("Para cadastramento degite - 1"
														+ "\nVer lista de secretários - 2"
														+ "\nPara remover dados do cadastro - 3"
														+ "\nPara sair digite - 4"));

		
		switch (esc) {
		case 1:
			Secretario secret = new Secretario();
			
			JOptionPane.showMessageDialog(null,
					"BEM VINDO ABA DE CADASTRAMENTO DE SECRETÁRIOS!" + "\nENTER para continuar.");
			
			secret.setNome(JOptionPane.showInputDialog("Informe o nome: "));
			secret.setEndereco(JOptionPane.showInputDialog("informe o endereço:"));
			secret.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Telefone: ")));
			secret.setNivelcargo(JOptionPane.showInputDialog("Tipo de cargo:"));
			secret.setRegistro(JOptionPane.showInputDialog("Informe o numero do registro:"));
			secret.setTitulacao(JOptionPane.showInputDialog("Graduação: "));
			listSecret.add(secret);
			JOptionPane.showMessageDialog(null, "Pronto!");
			break;
			
		case 2:
			for (Secretario secretario : listSecret) {
				JOptionPane.showMessageDialog(null, "Nome :"+secretario.getNome()
													+"\nEndereço:"+secretario.getEndereco()
													+"\nTelefone: "+secretario.getTelefone()
													+"\nTipo de cargo: "+secretario.getNivelcargo()
													+"\nSalério: "+secretario.salario()
													+"\nNúmero de registro: "+secretario.getRegistro()
													+"\nGraduação: "+secretario.getTitulacao());
				
				
				
			}
			break;
			
			
			
		case 3:
			String nome = JOptionPane.showInputDialog("Informe um nome: ");
			boolean verific  = false;
			int i;
			for(i=0; i<listSecret.size(); i++) {
				
				Secretario sctr = listSecret.get(i);
				int cont;
				for(cont=0; cont<listSecret.size(); cont++) {
					
					if(sctr.getNome().equalsIgnoreCase(nome)) {
						listSecret.remove(i);
						JOptionPane.showMessageDialog(null, "Cadastro removido");
						verific=true;
						
					}
				}
				
			}if(verific==false) {
				JOptionPane.showMessageDialog(null, "Cadastro inexistente", "ATENÇÃO", 0);
			}
			break;
			
			
			
			
			
		case 4:
		
			
		JOptionPane.showMessageDialog(null, "DESEJA  sair desta Guia?");
		
			break;

		default:
			JOptionPane.showMessageDialog(null, "Opção errada!");
			break;
		}
	}
}

}
