package escola.modulo10.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import escola.modulo10.objetos.Aluno;
import escola.modulo10.objetos.Disciplinas;

public class controllerAluno {

	List<Aluno> aluList = new ArrayList<Aluno>();

	public void guiaAluno() {
		

		int cont = 0;
		while (cont != 5) {

			cont = Integer.parseInt(JOptionPane.showInputDialog( "Cadastramento de aluno--1" 
																	+ "\nLista de aluno--2" 
																	+ "\nVer boletim--3"
																	+ "\nExcluir cadastro--4"
																	+"\nPara sair--5"));
			switch (cont) {
			case 1:
				Aluno aln = new Aluno();
				
				double insereNotas[] = new double[4];
				
				JOptionPane.showMessageDialog(null,
						"BEM VINDO ABA DE CADASTRAMENTO DE ALUNOS!" + "\nENTER para continuar.");
				
				aln.setNome(JOptionPane.showInputDialog("informe o nome do aluno: "));
				aln.setNomeEscola(JOptionPane.showInputDialog("Informe o nome da escola: "));
				aln.setDataMatricula(JOptionPane.showInputDialog("informe a data de matricula: "));
				aln.setSerie(Integer.parseInt(JOptionPane.showInputDialog("informe a serie: ")));
				
				for(int i=0; i<1; i++) {
					Disciplinas dcpls = new Disciplinas();
					dcpls.setMateria(JOptionPane.showInputDialog("informe o nome da matéria "+(i+1)+":"));
					
					for (int l=0; l<insereNotas.length; l++) {
						double notta = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota do "+(l+1)+"º bimestre:"));
						 insereNotas[l] = notta;
					}
					       
					dcpls.setNotas(insereNotas);
					aln.getDcpl().add(dcpls);
					
				}
				aluList.add(aln);
				JOptionPane.showMessageDialog(null, "SALVO!");
				break;
				
			case 2:
				for (Aluno aluno : aluList) {
					JOptionPane.showMessageDialog(null, "nome: "+aluno.getNome()
														+"\nNome da escola: "+aluno.getNomeEscola()
														+"\nData da matricula: "+aluno.getDataMatricula()
														+"\nSérie: "+aluno.getSerie()+"º"
														+"\n---DISCIPLINAS----"
														+"\n"+aluno.getDcpl().toString().replace("[", "").replace("]", "").replace(",", "")
														);
					
					
				}
				
				
				break;
			case 3:
				String nome = JOptionPane.showInputDialog("Informe um nome");
				boolean verifc = true;
				
				for (Aluno aluno : aluList) {
					if(aluno.getNome().equalsIgnoreCase(nome)) {
						
						StringBuilder imprime = new StringBuilder();
						
						imprime.append("----BOLETIM ESCOLAR----");
						imprime.append("\nNome: "+aluno.getNome());
						imprime.append("\nNome da escola: "+aluno.getNomeEscola());
						imprime.append("\nData matricula: "+aluno.getDataMatricula());
						imprime.append("\nSerie: "+aluno.getSerie());
						imprime.append("\n---Disciplinas---------");
						imprime.append("\n"+aluno.getDcpl().toString().replace("[", "").replace("]", "").replace(",", ""));
						imprime.append("\n----------NOTAS-----------");
						for(Disciplinas disc: aluno.getDcpl()) {
							for(int i=0; i< disc.getNotas().length; i++) {
								
								imprime.append("\nNota "+(i+1)+ "º Bimestre: "+disc.getNotas()[i]);
							}
							
						}
						imprime.append("\nMedia: "+aluno.calculaMedia());
						imprime.append("\nResultado: "+aluno.situacaoAluno());
						
						JOptionPane.showMessageDialog(null, imprime.toString(), "Boletim", 1);
						
						verifc = false;
						
						
					
					
					}
				}
				if(verifc) {
					JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
				}
				break;
				
				
				
			case 4:
				String nomeRemov = JOptionPane.showInputDialog("Informe um nome para remover do cadastro.");
				boolean verific=false;
				int i;
				int procurar;
				for( i = 0;i < aluList.size(); i++ ) {
					
					Aluno excluir = aluList.get(i);
					
					for(procurar = 0; procurar < aluList.size(); procurar++) {
						
						if(excluir.getNome().equalsIgnoreCase(nomeRemov)) {
							aluList.remove(i);
							JOptionPane.showMessageDialog(null, "Removido");
							verific=true;
						}
						
					}
					
				}if (verific==false) {
					JOptionPane.showMessageDialog(null, "Cadastro não encontrado!");
				}
				
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "OK, para sair.");
				break;


			default:
				break;
			}
		}

	}

}

