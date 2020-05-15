package escola.modulo10.sistema;

import javax.swing.JOptionPane;

import escola.modulo10.controller.ControllerDiretor;
import escola.modulo10.controller.ControllerSecretario;
import escola.modulo10.controller.controllerAluno;
import escola.modulo10.funcoes.FuncaoAutenticar;
import escola.modulo10.objetos.Secretario;

public class Sistema {

	public static void main(String[] args) {

		for (int i = 0; i <= 3; i++) {


			String user = JOptionPane.showInputDialog("Informe seu usuário");
			String senha = JOptionPane.showInputDialog("Digite a senha");

			if (new FuncaoAutenticar(new Secretario(user, senha)).autenticarUsuario()) {
				menu();
				break;

			} else {
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto", "OPs", 0);
			}
		}

	}

	private static void menu() {


		ControllerDiretor ctrlDir = new ControllerDiretor();
		controllerAluno ctrAlun = new controllerAluno();
		ControllerSecretario ctrSecret = new ControllerSecretario();
		int esc = 0;
		while (esc != 4) {

			esc = Integer.parseInt(JOptionPane.showInputDialog("Guia de diretores--1 " + "\nGuia de secretarios--2 "
					+ "\nGuia de alunos--3" + "\nSair do programa--4"));

			switch (esc) {

			case 1:
				ctrlDir.guiaDiretor();
				break;

			case 2:
				ctrSecret.guiaSecretario();
				break;

			case 3:
				ctrAlun.guiaAluno();
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "ENTER, para finalizar! ");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opção inválida, tente mais tarde!");
				break;
			}

		}

	}

}
