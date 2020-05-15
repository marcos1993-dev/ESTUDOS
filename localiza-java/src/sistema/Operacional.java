package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import objetos.Carro;
import objetos.Marcas;
import objetos.Relatorio;
import status.java.SituacaoVeiculo;

public class Operacional {

	static List<Carro> carList = new ArrayList<Carro>();
	static HashMap<String, List<Carro>> separaCarros = new HashMap<String, List<Carro>>();
	static List<Relatorio> listaBaixas = new ArrayList<Relatorio>();

	public static void main(String[] args) {

		for (int i = 0; i <= 2; i++) {
			String user = JOptionPane.showInputDialog("Informe seu usu�rio");
			String senha = JOptionPane.showInputDialog("Digite a senha");

			if (user.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("123")) {
				menu();
				break;
			} else {
				JOptionPane.showMessageDialog(null, "Usu�rio ou senha inv�lido!");
			}

		}
	}

	private static void menu() {

		int esc = 0;
		while (esc != 9) {
			esc = Integer.parseInt(JOptionPane.showInputDialog("----AUTOCAR---" + "\n" + "Cadastro de ve�culo--1"
					+ "\nConsulta de frota--2 " + "\nAlugar--3" + "\nFinalizar loca��o--4"
					+ "\nLista de carros alugados--5" + "\nLista de carros liberados--6" + "\nRelatorio de baixas--7"
					+ "\nExcluir ve�culo do sistema--8 "

					+ "\nSair--?"));
			switch (esc) {
			case 1:
				Carro carObj = new Carro();
				Marcas marcObj = new Marcas();

				String marca = JOptionPane.showInputDialog("Informe a marca:");
				marcObj.setNomeMarca(marca);
				String nome = JOptionPane.showInputDialog("Informe o nome do ve�culo :");
				carObj.setNome(nome);
				String cor = JOptionPane.showInputDialog("Informe a cor do ve�culo :");
				carObj.setCor(cor);
				double motor = Double.parseDouble(JOptionPane.showInputDialog("Informe a motoriza��o do ve�culo:"));
				carObj.setMotor(motor);
				int ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do ve�culo:"));
				carObj.setAno(ano);
				String placa = JOptionPane.showInputDialog("Informe a placa:");
				carObj.setPlaca(placa);

				double diaria = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da di�ria:"));
				carObj.setDiaria(diaria);

				carObj.getMarcList().add(marcObj);
				carList.add(carObj);

				JOptionPane.showMessageDialog(null, "PRONTO!");

				break;
			case 2:
				for (Carro carro : carList) {
					int i = 0;
					JOptionPane.showMessageDialog(null,
							"Nome: " + carro.getNome() + "\nCor: " + carro.getCor() + "\nMotoriza��o: "
									+ carro.getMotor() + "\nAno: " + carro.getAno() + "\nPlaca: " + carro.getPlaca()
									+ "\nMarca: " + carro.getMarcList().get(i) + "\nSitua��o: " + carro.aluguel());

					i++;
				}
				break;
			case 3:
				String buscCarro = JOptionPane.showInputDialog("Informe a placa do ve�culo:");

				if (!buscCarro.isEmpty()) {
					for (int pos = 0; pos < carList.size(); pos++) {

						Carro alugaCarro = carList.get(pos);

						for (int procura = 0; procura < carList.size(); procura++) {
							if (alugaCarro.getPlaca().equalsIgnoreCase(buscCarro)) {
								if (alugaCarro.isAlugado() == true) {
									JOptionPane.showMessageDialog(null, "Ve�culo ja esta alugado", "ERRO", 0);
									break;
								} else {

									alugaCarro.setAlugado(true);
									JOptionPane.showMessageDialog(null, "Loca��o iniciada!");
									break;
								}

							}

						}

					}
				} else {
					JOptionPane.showMessageDialog(null, "Ve�culo n�o encontrado!");

				}

				break;
			case 4:
				String buscPlaca = JOptionPane.showInputDialog("Informe a placa do ve�culo:");
				for (int i = 0; i < carList.size(); i++) {
					Carro fechamento = carList.get(i);

					for (int proc = 0; proc < carList.size(); proc++) {
						if (fechamento.getPlaca().equalsIgnoreCase(buscPlaca)) {
							if (fechamento.isAlugado() == false) {
								JOptionPane.showMessageDialog(null, "Este veiculo n�o esta alugado!");
								break;
							} else {
								int baixa = JOptionPane.showConfirmDialog(null, "Ve�culo: " + fechamento.getNome()
										+ "\nPlaca: " + fechamento.getPlaca() + "\nDeseja dar baixa neste ve�culo?");
								if (baixa == 0) {
									int dias = Integer
											.parseInt(JOptionPane.showInputDialog("informe a quantidade de dias:"));
									int confirma = JOptionPane.showConfirmDialog(null, "Deseja finalizar o contrato?");

									if (confirma == 0) {
										fechamento.setAlugado(false);
										boolean verifica = true;

										double totalAluguel = (dias * fechamento.getDiaria());
										Relatorio vazia = new Relatorio();

										if (listaBaixas.isEmpty()) {
											vazia.setCarro(fechamento.getNome());
											vazia.setPlaca(fechamento.getPlaca());
											vazia.setValor(totalAluguel);
											listaBaixas.add(vazia);
										} else {
											for (Relatorio achou : listaBaixas) {
												if (achou.getPlaca().equalsIgnoreCase(fechamento.getPlaca())) {
													achou.adicionarValor(totalAluguel);
													verifica = false;
												}
											}
										}

										if (verifica) {
											for (int b = 0; b < listaBaixas.size(); b++) {
												Relatorio novaBaixa = listaBaixas.get(b);
												for (int c = 0; c < listaBaixas.size(); c++) {
													if (!novaBaixa.getPlaca().equalsIgnoreCase(fechamento.getPlaca())) {
														Relatorio novaB = new Relatorio();

														novaB.setCarro(fechamento.getNome());
														novaB.setPlaca(fechamento.getPlaca());
														novaB.setValor(totalAluguel);
														listaBaixas.add(novaB);

														break;
													}
												}
											}
										}

										double valorPago = 0;
										String tipoPagamento;
										StringBuilder impressao = new StringBuilder();

										for (int cont = 0; cont < 4; cont++) {
											int opPagament = Integer.parseInt(JOptionPane
													.showInputDialog("Di�rias: " + dias + "\nValor Total R$: "
															+ totalAluguel + "\nEscolha o tipo de pagamento:"
															+ " \n1----Dinheiro\n2-----Cart�o"));
											if (opPagament == 1) {
												tipoPagamento = "Dinheiro";
												valorPago = Double.parseDouble(
														JOptionPane.showInputDialog("informe o valor pago: "));

												double troco = (valorPago - totalAluguel);

												impressao.append("-------Demonstrativo de baixa------");
												impressao.append("\nValor do aluguel " + fechamento.getDiaria());
												impressao.append("\nValor total: " + totalAluguel);
												impressao.append("\nTotal dias: " + dias);
												impressao.append("\nTroco: " + troco);
												impressao.append("\nTipo de pagamento: " + tipoPagamento);
												impressao.append("\n---------------------------------");
												impressao.append("\n--------Tiau brigado!--------");

												JOptionPane.showMessageDialog(null, impressao.toString(), "Recibo", 1);
												break;

											} else if (opPagament == 2) {
												tipoPagamento = "Cart�o";

												valorPago = Double.parseDouble(
														JOptionPane.showInputDialog("informe o valor pago: "));

												double troco = (valorPago - totalAluguel);

												impressao.append("-------Demonstrativo de baixa------");
												impressao.append("\nValor do aluguel " + fechamento.getDiaria());
												impressao.append("\nValor total: " + totalAluguel);
												impressao.append("\nTotal dias: " + dias);
												impressao.append("\nTroco: " + troco);
												impressao.append("\nTipo de pagamento: " + tipoPagamento);
												impressao.append("\n---------------------------------");
												impressao.append("\n--------Tiau brigado!--------");

												JOptionPane.showMessageDialog(null, impressao.toString(), "Recibo", 1);
												break;

											} else {
												JOptionPane.showMessageDialog(null, "Op��o inv�lida!", "ATEN�AO", 1);
											}

										}

										JOptionPane.showMessageDialog(null, "Loca��o finalizada!");

										int fim = JOptionPane.showConfirmDialog(null, "Imprimir relat�rio da loca��o?");

										if (fim == 0) {

											JOptionPane.showMessageDialog(null,
													"Veiculo: " + fechamento.getNome() + "\nPlaca:  "
															+ fechamento.getPlaca() + "\nAno: " + fechamento.getAno()
															+ "\nTotal R$:" + (dias * fechamento.getDiaria())
															+ "\n--Obrigado pela preferencia!");
											break;
										}
									}
								} else {
									JOptionPane.showMessageDialog(null, "Opera��o cancelada!");

								}
							}
						}

					}

				}

				break;

			case 5:
				separaCarros.put(SituacaoVeiculo.ALUGADO, new ArrayList<Carro>());

				for (Carro carro : carList) {
					if (carro.aluguel().equalsIgnoreCase(SituacaoVeiculo.ALUGADO)) {

						separaCarros.get(SituacaoVeiculo.ALUGADO).add(carro);
					}
				}

				for (Carro imprime : separaCarros.get(SituacaoVeiculo.ALUGADO)) {
					JOptionPane
							.showMessageDialog(null,
									"Nome do carro :" + imprime.getNome() + "\nCor: " + imprime.getCor() + "\nAno: "
											+ imprime.getAno() + "\nPlaca: " + imprime.getPlaca(),
									"Carros Alugados", 1);

				}

				break;

			case 6:
				separaCarros.put(SituacaoVeiculo.LIVRE, new ArrayList<Carro>());

				for (Carro carro : carList) {
					if (carro.aluguel().equalsIgnoreCase(SituacaoVeiculo.LIVRE)) {
						separaCarros.get(SituacaoVeiculo.LIVRE).add(carro);
					}

				}
				for (Carro imprime : separaCarros.get(SituacaoVeiculo.LIVRE)) {

					JOptionPane.showMessageDialog(null, "Carro: " + imprime.getNome() + "\nCor: " + imprime.getCor()
							+ "\nAno: " + imprime.getAno() + "\nPraca: " + imprime.getPlaca(), "carros Livres", 1);
				}

				break;

			case 7:
				for (Relatorio report : listaBaixas) {
					JOptionPane.showMessageDialog(null, "Carro " + report.getCarro() + "\nPlaca " + report.getPlaca()
							+ "\nValor " + report.getValor(), "BAIXAS", 1);
				}
				break;
			case 8:
				boolean vf = false;

				String buscaplaca = JOptionPane.showInputDialog("informe a placa do ve�culo: ");
				if (vf == false) {

					for (int contt = 0; contt < carList.size(); contt++) {
						Carro excluindo = carList.get(contt);

						for (int procura = 0; procura < carList.size(); procura++) {
							if (excluindo.getPlaca().equalsIgnoreCase(buscaplaca)) {
								if (excluindo.isAlugado()) {
									vf = false;
								} else {
									carList.remove(contt);
									JOptionPane.showMessageDialog(null, "removido!");

									vf = true;

								}
							}

						}
					}
				}
				if (vf == false) {
					JOptionPane.showMessageDialog(null, "Este ve�culo est� alugado", "PRESTE ATEN��O!", 0);
				}

				break;

			default:
				JOptionPane.showMessageDialog(null, "Op��o errada!");
				esc = 0;
			}
		}

	}

}
