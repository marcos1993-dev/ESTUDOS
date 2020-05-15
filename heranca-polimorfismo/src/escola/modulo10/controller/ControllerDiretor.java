package escola.modulo10.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import escola.modulo10.objetos.Diretor;

public class ControllerDiretor {
	List<Diretor> listDir = new ArrayList<Diretor>();

	public void guiaDiretor() {

		int esc = 0;

		while (esc != 4) {

			esc = Integer.parseInt(JOptionPane.showInputDialog("Para cadastramento degite - 1" + "\nVer lista de diretores - 2"
							+ "\nPara remover dados do cadastro - 3" + "\nPara sair digite - 4"));

			switch (esc) {
			case 1:
				Diretor drt = new Diretor();

				JOptionPane.showMessageDialog(null,
						"BEM VINDO ABA DE CADASTRAMENTO DE DIRETORES!" + "\nENTER para continuar.");

				drt.setNome(JOptionPane.showInputDialog("Informe o nome: "));
				drt.setEndereco(JOptionPane.showInputDialog("Informe o endereço : "));
				drt.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("informe o telefone : ")));
				drt.setRegisEducacao(JOptionPane.showInputDialog("Informe o numero do registro educacional : "));
				drt.setTempoDirecao(JOptionPane.showInputDialog("Informe o período de gestão: "));
				drt.setTitulacao(JOptionPane.showInputDialog("Informe a titulação :"));
				JOptionPane.showMessageDialog(null, "Dados salvos com sucesso! ");

				listDir.add(drt);

				break;

			case 2:
				for (Diretor diretor : listDir) {
					JOptionPane.showMessageDialog(null,
									"Nome: " + diretor.getNome() 
									+ "\nEnderço: "	+ diretor.getEndereco() 
									+ "\ntelefone: "+diretor.getTelefone()									
									+ "\nNumero registro " + diretor.getRegisEducacao()
									+ "\nPeriodo  de regencia" + diretor.getTempoDirecao() 
									+ "\nTitulação: "+ diretor.getTitulacao()
									+"\nSalario: "+diretor.salario());
									
				}

				break;

			case 3:
				String nome = JOptionPane.showInputDialog("informe o nome :");
				boolean verific = false;
				int i;
				for (i = 0; i < listDir.size(); i++) {
					Diretor drtr = listDir.get(i);

					int cont;
					for (cont = 0; cont < listDir.size(); cont++) {
						if (drtr.getNome().equalsIgnoreCase(nome)) {
							listDir.remove(i);
							JOptionPane.showMessageDialog(null, "Cdastro removido!");
							verific = true;

						}
					}

				}
				if (verific == false) {
					JOptionPane.showMessageDialog(null, "Cadastro inexistente!", "ATENÇÃO", 0);
				}
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Enter, para finalizar!");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opção invalida!", "ATENÇÃO", 0);
				break;
			}

		}

	}

}
