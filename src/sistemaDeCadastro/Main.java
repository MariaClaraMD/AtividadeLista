package sistemaDeCadastro;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Usuario> lista = new ArrayList<>();

		int opcao = 0;

		do {
			System.out.println("\n");
			System.out.println("======== Menu ======== ");
			System.out.println("\n");
			System.out.println("1 - Cadastrar Usuário");
			System.out.println("2 - Editar Usuário");
			System.out.println("3 - Listar Usuários");
			System.out.println("4 - Remover Usuário");
			System.out.println("5 - Sair");
			System.out.println("\n");
			System.out.println("Informe uma opção: ");
			System.out.println("\n");

			opcao = sc.nextInt();

			// Opção 1 ( = Cadastrar Usuário)
			if (opcao == 1) {
				System.out.println("\n");
				System.out.println("Para realizar o cadastro, digite 1 para aluno ou 2 para professor: ");
				int alunoOuProfessor = sc.nextInt();
				sc.nextLine();

				if (alunoOuProfessor != 1 && alunoOuProfessor != 2) {
					System.out.println("\n");
					System.out.println("Alerta: opção inválida!");
				} else {
					System.out.println("\n");
					System.out.println("Digite seu nome: ");
					String nome = sc.nextLine();

					if (nome.isEmpty() || nome.equals(" ")) {
						System.out.println("\n");
						System.out.println("Alerta: Campo vazio!");
					} else {
						System.out.println("Digite seu CPF: ");
						String CPF = sc.nextLine();

						if (CPF.isEmpty() || CPF.equals(" ")) {
							System.out.println("\n");
							System.out.println("Alerta: Campo vazio!");

						} else {
							boolean cpfRepetido = false;
							for (int j = 0; j < lista.size(); j++) {
								if (lista.get(j).getCPF().equals(CPF)) {
									cpfRepetido = true;
									break;
								}
							}

							if (cpfRepetido) {
								System.out.println("\n");
								System.out.println("Alerta: o CPF informado pertece a outro usuário!");
							} else {
								System.out.println("Digite sua data de nascimento (dd/mm/aaaa): ");
								String dataNascimento = sc.nextLine();
								java.util.Date data = null;

								if (dataNascimento.isEmpty() || dataNascimento.equals(" ")) {
									System.out.println("\n");
									System.out.println("Alerta: Campo vazio!");
								} else {
									try {
										SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
										data = date.parse(dataNascimento);
									} catch (Exception e) {
										System.out.println("\n");
										System.out.println("Alerta: data inválida!");
									}

									if (data != null) {
										if (alunoOuProfessor == 1) {
											System.out.println("Digite sua matrícula: ");
											long matricula = sc.nextLong();

											if (matricula <= 0) {
												System.out.println("\n");
												System.out.println("Alerta: matricula inválida!");
											} else {
												boolean matriculaRepetida = false;
												for (int j = 0; j < lista.size(); j++) {
													if ((lista.get(j).toString().contains("Matrícula"))) {
														if (((Aluno) lista.get(j)).getMatricula() == matricula) {
															matriculaRepetida = true;
															break;
														}
													}
												}

												if (matriculaRepetida) {
													System.out.println("\n");
													System.out.println(
															"Alerta: a matrícula informada pertece a outro usuário!");
												} else {
													System.out.println("Digite seu CRE: ");
													double CRE = sc.nextDouble();

													if (CRE < 0) {
														System.out.println("\n");
														System.out.println("Alerta: CRE inválida!");
													} else {
														Aluno aluno = new Aluno();
														aluno.setNome(nome);
														aluno.setCPF(CPF);
														aluno.setDataNascimento(data);
														aluno.setMatricula(matricula);
														aluno.setCRE(CRE);

														lista.add(aluno);

														System.out.println("\n");
														System.out.println("O aluno foi cadastrado com sucesso!");
													}
												}

											}
										} else if (alunoOuProfessor == 2) {
											System.out.println("Digite seu SIAPE: ");
											long SIAPE = sc.nextLong();

											boolean siapeRepetido = false;
											for (int j = 0; j < lista.size(); j++) {
												if ((lista.get(j).toString().contains("SIAPE"))) {
													if (((Professor) lista.get(j)).getSIAPE() == SIAPE) {
														siapeRepetido = true;
														break;
													}
												}
											}

											if (siapeRepetido) {
												System.out.println("\n");
												System.out
														.println("Alerta: o SIAPE informado pertece a outro usuário!");
											} else {

												if (SIAPE <= 0) {
													System.out.println("\n");
													System.out.println("Alerta: SIAPE inválido!");
												} else {
													System.out.println("Digite sua Carga Horária: ");
													int cargaHoraria = sc.nextInt();

													if (cargaHoraria <= 0) {
														System.out.println("\n");
														System.out.println("Alerta: carga horária inválida!");
													} else {
														Professor professor = new Professor();
														professor.setNome(nome);
														professor.setCPF(CPF);
														professor.setDataNascimento(data);
														professor.setSIAPE(SIAPE);
														professor.setCargaHoraria(cargaHoraria);

														lista.add(professor);

														System.out.println("\n");
														System.out.println("O professor foi cadastrado com sucesso!");
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}

			// Opção 2 (= Editar Usuário)
			} else if (opcao == 2) {
				if (lista.isEmpty()) {
					System.out.println("Nenhum usuário foi cadastrado!");
				} else if (lista.size() > 0) {
					System.out.println("\n");
					System.out.println("Lista de Usuário Cadastrados");
					System.out.println("\n");

					for (int i = 0; i < lista.size(); i++) {
						System.out.println(i + ". " + lista.get(i).toString());
						System.out.println("\n");
					}

					System.out.println("\n");
					System.out.println("Digite o número do usuário que você deseja editar: ");
					int i = sc.nextInt();
					sc.nextLine();

					if (i < 0 || i >= lista.size()) {
						System.out.println("\n");
						System.out.println("Alerta: usuário inexistente!");
					} else {
						String informacoesUsuario = lista.get(i).toString();
						boolean tipoAluno = informacoesUsuario.contains("Matrícula");

						System.out.println("\n");
						System.out.println("Digite o número correspondente ao que você deseja editar: ");
						System.out.println("\n");
						System.out.println("1 - Nome");
						System.out.println("2 - CPF");
						System.out.println("3 - Data de Nascimento");

						if (tipoAluno) {
							System.out.println("4 - Matrícula");
							System.out.println("5 - CRE");
						} else {
							System.out.println("4 - SIAPE");
							System.out.println("5 - Carga Horária");
						}

						int oQueEditar = sc.nextInt();
						sc.nextLine();

						if (oQueEditar < 1 || oQueEditar > 5) {
							System.out.println("Alerta: opção inválida!");
						} else {
							if (oQueEditar == 1) {
								System.out.println("\n");
								System.out.println("Edite o nome: ");
								lista.get(i).setNome(sc.nextLine());
							} else if (oQueEditar == 2) {
								System.out.println("\n");
								System.out.println("Edite o CPF: ");
								String cpfEditado = sc.nextLine();

								boolean cpfRepetido = false;
								for (int j = 0; j < lista.size(); j++) {
									if (lista.get(j).getCPF().equals(cpfEditado) && j != i) {
										cpfRepetido = true;
									}
								}

								if (cpfRepetido) {
									System.out.println("\n");
									System.out.println("Alerta: o CPF informado pertece a outro usuário!");
								} else {
									lista.get(i).setCPF(cpfEditado);
								}
							} else if (oQueEditar == 3) {
								System.out.println("\n");
								System.out.println("Edite a data de nascimento (dd/mm/aaaa): ");
								String novaDataNascimento = sc.nextLine();

								try {
									SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
									java.util.Date novaData = date.parse(novaDataNascimento);
									lista.get(i).setDataNascimento(novaData);
								} catch (Exception e) {
									System.out.println("\n");
									System.out.println("Alerta: data inválida!");
								}

							} else if (oQueEditar == 4) {
								if (tipoAluno) {
									System.out.println("\n");
									System.out.println("Edite sua matrícula: ");
									long matriculaEditada = sc.nextLong();

									boolean matriculaRepetida = false;
									for (int j = 0; j < lista.size(); j++) {
										if ((lista.get(j).toString().contains("Matrícula"))) {
											if (((Aluno) lista.get(j)).getMatricula() == matriculaEditada && j != i) {
												matriculaRepetida = true;
											}
										}
									}

									if (matriculaRepetida) {
										System.out.println("\n");
										System.out.println("Alerta: a matrícula informada pertece a outro usuário!");
									} else {
										((Aluno) lista.get(i)).setMatricula(matriculaEditada);
									}
								} else {
									System.out.println("\n");
									System.out.println("Edite seu SIAPE: ");
									long siapeEditado = sc.nextLong();

									boolean siapeRepetido = false;
									for (int j = 0; j < lista.size(); j++) {
										if ((lista.get(j).toString().contains("SIAPE"))) {
											if (((Professor) lista.get(j)).getSIAPE() == siapeEditado && j != i) {
												siapeRepetido = true;
											}
										}
									}

									if (siapeRepetido) {
										System.out.println("\n");
										System.out.println("Alerta: o SIAPE informado pertece a outro usuário!");
									} else {
										((Professor) lista.get(i)).setSIAPE(siapeEditado);
									}
								}
							} else if (oQueEditar == 5) {
								if (tipoAluno) {
									System.out.println("\n");
									System.out.println("Edite seu CRE: ");
									((Aluno) lista.get(i)).setCRE(sc.nextDouble());
								} else {
									System.out.println("\n");
									System.out.println("Edite sua Carga Horária: ");
									((Professor) lista.get(i)).setCargaHoraria(sc.nextInt());
								}
							}

							System.out.println("\n");
							System.out.println("O usuário foi editado com sucesso!");

						}
					}
				}

			// Opção 3 (= Listar Usuários)
			} else if (opcao == 3) {

				if (lista.isEmpty()) {
					System.out.println("\n");
					System.out.println("Nenhum usuário cadastrado!");
				} else {
					System.out.println("\n");
					System.out.println("Lista de Usuário Cadastrados");
					System.out.println("\n");

					for (int i = 0; i < lista.size(); i++) {
						System.out.println(i + ". " + lista.get(i).toString());
						System.out.println("\n");
					}
				}

			// Opção 4 (= Remover Usuário)
			} else if (opcao == 4) {

				if (lista.isEmpty()) {
					System.out.println("\n");
					System.out.println("Nenhum usuário foi cadastrado!");
				} else if (lista.size() > 0) {
					System.out.println("\n");
					System.out.println("Lista de Usuário Cadastrados");
					System.out.println("\n");

					for (int i = 0; i < lista.size(); i++) {
						System.out.println(i + ". " + lista.get(i).toString());
						System.out.println("\n");
					}

					System.out.println("\n");
					System.out.println("Digite o número do usuário que você deseja remover: ");
					int i = sc.nextInt();

					if (i < 0 || i >= lista.size()) {
						System.out.println("\n");
						System.out.println("Alerta: Usuário inexistente!");
					} else {
						lista.remove(i);

						System.out.println("\n");
						System.out.println("O usuário foi removido com sucesso!");
					}
				}

			} else if (opcao != 5) {
				System.out.println("\n");
				System.out.println("Alerta: opção inválida!");
			}

		} while (opcao != 5);

		System.out.println("\n");
		System.out.println("Fim do programa");

		sc.close();

	}
}