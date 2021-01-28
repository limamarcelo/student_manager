package control.program;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.group.GroupDAO;
import model.dao.group.GroupDAOSGBDImpl;
import model.dao.list.ListGroupsDAO;
import model.dao.list.ListGroupsDAOSGBDImpl;
import model.dao.student.StudentDAO;
import model.dao.student.StudentDAOSGBDImpl;
import model.entity.group.Group;
import model.entity.student.Student;
import model.enumeration.menu.Menu;
import model.enumeration.menu.attributes.AttributeGroup;
import model.enumeration.menu.attributes.AttributeStudent;
import model.enumeration.menu.ordination.Order;
import model.enumeration.menu.submenu.SubMenu;
import model.enumeration.menu.submenu.SubMenuListGroup;
import model.enumeration.menu.submenu.SubMenuUpdateGroup;
import model.enumeration.menu.submenu.SubMenuUpdateStudent;
import model.execptions.GroupCodeException;
import model.execptions.GroupDeleteException;
import model.execptions.GroupNameException;
import model.execptions.StudentNameException;
import model.execptions.StudentSurnameException;

public class Program {

	public static void main(String[] args)
			throws GroupNameException, GroupCodeException, StudentNameException, StudentSurnameException, SQLException {

		Scanner sc = new Scanner(System.in);
		Menu menu = null;
		SubMenu subMenu = null;
		SubMenuUpdateGroup subMenuUpdateGroup = null;
		SubMenuUpdateStudent subMenuUpdateStudent = null;
		SubMenuListGroup subMenuListGroup = null;
		List<Group> groups = new ArrayList<Group>();
		List<Student> students = null;
		Group group = new Group();
		GroupDAO daoGroup = new GroupDAOSGBDImpl();
		StudentDAO daoStudent = new StudentDAOSGBDImpl();
		ListGroupsDAO daoListGroups = new ListGroupsDAOSGBDImpl();
		Order order = null;
		boolean condition;

		// Everything related to the CLASS was used the word GROUP;
		// Start of the main menu to choose from: Group, Student, General List;
		System.out.println("Seja bem-vindo.\n");
		do {
			do {
				try {
					System.out.println("Selecione uma das seguintes opções:\n");
					System.out.println("1 - Turma");
					System.out.println("2 - Aluno");
					System.out.println("3 - Listagem");
					System.out.println("4 - Sair");

					menu = Menu.values()[Integer.parseInt(sc.next()) - 1];
					condition = false;
					System.out.println();
				} catch (NumberFormatException exception) {
					System.err.println("\nFavor informar um número das opções acima.\n");
					condition = true;
				} catch (IndexOutOfBoundsException exception) {
					System.err.println("\nOpção inválida.\n");
					condition = true;
				} catch (NullPointerException exception) {
					System.err.println("\nErro ao acessar o objeto nulo.\n");
					condition = true;
				}
			} while (condition);

			switch (menu) {

			// Start of choice for subMenu for Group;
			case GROUP:

				// Starts subMenu - choose CRUD action for Group:
				// Insert, List, Update, Delete or Back Main Menu;

				do {
					do {
						try {
							System.out.println("Selecione uma das seguintes opções:\n");
							System.out.println("1 - Inserir Turma.");
							System.out.println("2 - Listar Turmas.");
							System.out.println("3 - Editar Turma.");
							System.out.println("4 - Excluir Turma.");
							System.out.println("5 - Voltar Menu Principal.");

							subMenu = SubMenu.values()[Integer.parseInt(sc.next()) - 1];
							condition = false;
							System.out.println();

						} catch (NumberFormatException exception) {
							System.err.println("\nFavor informar um número das opções acima.\n");
							condition = true;
						} catch (IndexOutOfBoundsException exception) {
							System.err.println("\nOpção inválida.\n");
							condition = true;
						} catch (NullPointerException exception) {
							System.err.println("\nErro ao acessar o objeto nulo.\n");
							condition = true;
						}
					} while (condition);

					switch (subMenu) {

					// Start Insert Group;
					case INSERT:

						System.out.println("Informe o nome da turma:");
						sc.nextLine();
						String name = sc.nextLine();

						System.out.println("Informe o código da turma:");
						String code = sc.nextLine();

						group.setName(name);
						group.setCode(code);

						daoGroup.insertGroup(group);
						System.out.println("Turma inserida com sucesso!");
						System.out.println();

						break;

					// Start Group List;
					case LIST:

						AttributeGroup attribute = null;

						do {
							try {
								System.out.println("Selecione uma das seguintes opções:\n");
								System.out.println("1 - Listar Turmas pelo Id.");
								System.out.println("2 - Listar Turmas pelo Nome.");
								System.out.println("3 - Listar Turmas pelo Código.");

								attribute = AttributeGroup.values()[Integer.parseInt(sc.next()) - 1];
								condition = false;
								System.out.println();

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um número das opções acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOpção inválida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);

						do {
							try {
								System.out.println("Selecione uma das seguintes opções:\n");
								System.out.println("1 - Listar em Ordem Ascendente.");
								System.out.println("2 - Listar em Ordem Descendente.");

								order = Order.values()[Integer.parseInt(sc.next()) - 1];
								condition = false;
								System.out.println();

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um número das opções acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOpção inválida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);

						switch (attribute) {

						// List By ID;
						case ID:

							switch (order) {

							case ASCENDING:
								groups = daoGroup.listGroupsByIdAsc();
								break;

							case DESCENDING:
								groups = daoGroup.listGroupsByIdDesc();
								break;
							}
							break;

						// List By Name;
						case NAME:

							switch (order) {

							case ASCENDING:
								groups = daoGroup.listGroupsByNameAsc();
								break;

							case DESCENDING:
								groups = daoGroup.listGroupsByNameDesc();
								break;
							}
							break;

						// List by Code;
						case CODE:

							switch (order) {

							case ASCENDING:
								groups = daoGroup.listGroupsByCodeAsc();
								break;

							case DESCENDING:
								groups = daoGroup.listGroupsByCodeDesc();
								break;
							}
							break;
						}

						// Listing according to the chosen option;
						System.out.println("Listagem das turmas:");
						for (int i = 0; i < groups.size(); i++) {
							System.out.println("Número Sequencial da Turma: #" + (i + 1) + ", Registro: #"
									+ groups.get(i).getId() + ", Nome: " + groups.get(i).getName() + ", Código: "
									+ groups.get(i).getCode() + ", Quantidade de Aluno(s): "
									+ groups.get(i).getStudents().size());
						}
						System.out.println();
						break;

					// Start subMenuUpdateGroup for Group editing;
					case UPDATE:

						groups = daoGroup.listGroupsByIdAsc();

						do {
							do {
								try {
									System.out.println("Selecione uma das seguintes opções:\n");
									System.out.println("1 - Alterar o nome do turma.");
									System.out.println("2 - Alterar o código do turma.");
									System.out.println("3 - Alterar o todos os dados do turma.");
									System.out.println("4 - Voltar Menu Principal.");

									subMenuUpdateGroup = SubMenuUpdateGroup.values()[Integer.parseInt(sc.next()) - 1];
									condition = false;
									System.out.println();

								} catch (NumberFormatException exception) {
									System.err.println("\nFavor informar um número das opções acima.\n");
									condition = true;
								} catch (IndexOutOfBoundsException exception) {
									System.err.println("\nOpção inválida.\n");
									condition = true;
								} catch (NullPointerException exception) {
									System.err.println("\nErro ao acessar o objeto nulo.\n");
									condition = true;
								}
							} while (condition);

							// Listing Groups by Id Asc;
							System.out.println("Listagem das turmas:");
							for (int i = 0; i < groups.size(); i++) {
								System.out.println("Número Sequencial da Turma: #" + (i + 1) + ", Registro: #"
										+ groups.get(i).getId() + ", Nome: " + groups.get(i).getName() + ", Código: "
										+ groups.get(i).getCode());
							}
							System.out.println();

							switch (subMenuUpdateGroup) {

							// Start Edition Group Name;
							case NAME:

								do {
									try {

										System.out.println("Informe o Número Sequencial da turma para alterar:");
										group = groups.get(Integer.parseInt(sc.next()) - 1);
										condition = false;
										System.out.println();

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um número das opções acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOpção inválida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe o novo nome do turma:");
								sc.nextLine();
								group.setName(sc.nextLine());

								daoGroup.updateGroup(group);
								System.out.println("Turma alterada com sucesso!");

								System.out.println();

								break;

							// Start Edition Group Code;
							case CODE:

								do {
									try {

										System.out.println("Informe o Número Sequencial da turma para alterar:");
										group = groups.get(Integer.parseInt(sc.next()) - 1);
										condition = false;
										System.out.println();

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um número das opções acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOpção inválida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe o novo código do turma:");
								sc.nextLine();
								group.setCode(sc.nextLine());

								daoGroup.updateGroup(group);
								System.out.println("Turma alterada com sucesso!");
								System.out.println();

								break;

							// Start Edition All Group Data;
							case ALL:

								do {
									try {

										System.out.println("Informe o Número Sequencial da turma para alterar:");
										group = groups.get(Integer.parseInt(sc.next()) - 1);
										condition = false;
										System.out.println();

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um número das opções acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOpção inválida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe o novo nome do turma:");
								sc.nextLine();
								group.setName(sc.nextLine());

								System.out.println("Informe o novo código do turma:");
								group.setCode(sc.nextLine());

								daoGroup.updateGroup(group);
								System.out.println("Turma alterada com sucesso!");
								System.out.println();

								break;

							default:
								break;
							}
						} while (subMenuUpdateGroup != SubMenuUpdateGroup.EXIT);
						// Final UpdateGroup subMenu for Group editing;
						break;

					// Start Delete Group;
					case DELETE:

						groups = daoGroup.listGroupsByIdAsc();

						// Listing Groups by Id Asc;
						System.out.println("Listagem das turmas:");
						for (int i = 0; i < groups.size(); i++) {
							System.out.println("Número Sequencial da Turma: #" + (i + 1) + ", Registro: #"
									+ groups.get(i).getId() + ", Nome: " + groups.get(i).getName() + ", Código: "
									+ groups.get(i).getCode());
						}
						System.out.println();

						do {
							try {

								System.out.println("Informe o Número Sequencial da turma para excluir:");
								group = groups.get(Integer.parseInt(sc.next()) - 1);
								condition = false;

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um número das opções acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOpção inválida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);

						try {
							daoGroup.deleteGroup(group);
							condition = false;
							System.out.println();
						} catch (GroupDeleteException exception) {
							System.err.println("\nTurma não pode ser excluída, pois há alunos vinculados.\n");
							condition = true;
						} catch (SQLException exception) {
							System.err.println("\nTurma não pode ser excluída.\n");
							condition = true;
						}

						if (condition == false) {
							System.out.println("Turma deletada com sucesso!");
							System.out.println();
						}

						break;

					default:
						break;
					}
				} while (subMenu != SubMenu.EXIT);

				break;
			// End of the subMenu for Group;

			// Start of choice for subMenu for Student;
			case STUDENT:

				Student student = new Student();
				// Start subMenu - choose action CRUD Students: Insert, List, Update, Delete
				// or Back Main Menu.

				do {
					do {
						try {
							System.out.println("Selecione uma das seguintes opções:\n");
							System.out.println("1 - Inserir Aluno.");
							System.out.println("2 - Listar Alunos.");
							System.out.println("3 - Editar Aluno.");
							System.out.println("4 - Excluir Aluno.");
							System.out.println("5 - Voltar Menu Principal.");

							subMenu = SubMenu.values()[Integer.parseInt(sc.next()) - 1];
							condition = false;
							System.out.println();

						} catch (NumberFormatException exception) {
							System.err.println("\nFavor informar um número das opções acima.\n");
							condition = true;
						} catch (IndexOutOfBoundsException exception) {
							System.err.println("\nOpção inválida.\n");
							condition = true;
						} catch (NullPointerException exception) {
							System.err.println("\nErro ao acessar o objeto nulo.\n");
							condition = true;
						}
					} while (condition);

					switch (subMenu) {

					// Start Insert Student;
					case INSERT:

						System.out.println("Informe o nome do Aluno:");
						sc.nextLine();
						String name = sc.nextLine();

						System.out.println("Informe o sobrenome do Aluno:");
						String surname = sc.nextLine();

						groups = daoGroup.listGroupsByIdAsc();

						// Listing Groups by Id Asc;
						System.out.println("Listagem das turmas:");
						for (int i = 0; i < groups.size(); i++) {
							System.out.println("Número Sequencial da Turma: #" + (i + 1) + ", Registro: #"
									+ groups.get(i).getId() + ", Nome: " + groups.get(i).getName() + ", Código: "
									+ groups.get(i).getCode());
						}
						System.out.println();

						do {
							try {

								System.out.println("Informe o Número Sequencial da Turma do Aluno:");
								group = groups.get(Integer.parseInt(sc.next()) - 1);

								condition = false;
								System.out.println();

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um número das opções acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOpção inválida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);

						student.setName(name);
						student.setSurname(surname);
						student.setGroup(group);

						daoStudent.insertStudent(student);
						System.out.println("Aluno inserido com sucesso!");
						System.out.println();

						break;

					// Start List Student;
					case LIST:

						AttributeStudent attribute = null;

						do {
							try {
								System.out.println("Selecione uma das seguintes opções:\n");
								System.out.println("1 - Listar Alunos pelo Id.");
								System.out.println("2 - Listar Alunos pelo Nome.");
								System.out.println("3 - Listar Alunos pelo Sobrenome.");
								System.out.println("4 - Listar Alunos pelo Id da Turma.");

								attribute = AttributeStudent.values()[Integer.parseInt(sc.next()) - 1];
								condition = false;
								System.out.println();

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um número das opções acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOpção inválida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);

						do {
							try {
								System.out.println("Selecione uma das seguintes opções:\n");
								System.out.println("1 - Listar em Ordem Ascendente.");
								System.out.println("2 - Listar em Ordem Descendente.");

								order = Order.values()[Integer.parseInt(sc.next()) - 1];
								condition = false;
								System.out.println();

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um número das opções acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOpção inválida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);

						switch (attribute) {

						// List By ID;
						case ID:

							switch (order) {

							case ASCENDING:
								students = daoStudent.listStudentsByIdAsc();
								break;

							case DESCENDING:
								students = daoStudent.listStudentsByIdDesc();
								break;
							}
							break;

						// List By Name;
						case NAME:

							switch (order) {

							case ASCENDING:
								students = daoStudent.listStudentsByNameAsc();
								break;

							case DESCENDING:
								students = daoStudent.listStudentsByNameDesc();
								break;
							}
							break;

						// List By Surname;
						case SURNAME:

							switch (order) {

							case ASCENDING:
								students = daoStudent.listStudentsBySurnameAsc();
								break;

							case DESCENDING:
								students = daoStudent.listStudentsBySurnameDesc();
								break;
							}

							break;

						// List By idGroup;
						case IDGROUP:

							switch (order) {

							case ASCENDING:
								students = daoStudent.listStudentsByGroupAsc();
								break;

							case DESCENDING:
								students = daoStudent.listStudentsByGroupDesc();
								break;
							}

							break;
						}

						// Listing according to the chosen option;
						System.out.println("Listagem de alunos:");
						for (int i = 0; i < students.size(); i++) {
							System.out.println("Registro do Aluno #" + students.get(i).getId() + ", Nome: "
									+ students.get(i).getName() + ", Sobrenome: " + students.get(i).getSurname()
									+ ", Registro da Turma: #" + students.get(i).getGroup().getId());
						}
						System.out.println();

						break;

					// Start Update Student;
					case UPDATE:

						students = daoStudent.listStudentsByIdAsc();

						// Start subMenuUpdateStudent for Student edition;
						do {
							do {
								try {
									System.out.println("Selecione uma das seguintes opções:\n");
									System.out.println("1 - Alterar o nome do Aluno.");
									System.out.println("2 - Alterar o sobrenome do Aluno.");
									System.out.println("3 - Alterar a turma do Aluno.");
									System.out.println("4 - Alterar o todos os dados do Aluno.");
									System.out.println("5 - Voltar Menu Principal.");

									subMenuUpdateStudent = SubMenuUpdateStudent.values()[Integer.parseInt(sc.next())
											- 1];
									condition = false;
									System.out.println();

								} catch (NumberFormatException exception) {
									System.err.println("\nFavor informar um número das opções acima.\n");
									condition = true;
								} catch (IndexOutOfBoundsException exception) {
									System.err.println("\nOpção inválida.\n");
									condition = true;
								} catch (NullPointerException exception) {
									System.err.println("\nErro ao acessar o objeto nulo.\n");
									condition = true;
								}
							} while (condition);

							// Listing Students By Id;
							System.out.println("Listagem de alunos:");
							for (int i = 0; i < students.size(); i++) {
								System.out.println("Número Sequencial do Aluno: #" + (i + 1) + ", Registro :#"
										+ students.get(i).getId() + ", Nome: " + students.get(i).getName()
										+ ", Sobrenome: " + students.get(i).getSurname() + ", Registro da Turma: #"
										+ students.get(i).getGroup().getId());

							}

							System.out.println("");

							switch (subMenuUpdateStudent) {

							// Start Edition Student Name;
							case NAME:

								do {
									try {

										System.out.println("Informe o Número Sequencial do Aluno:");
										student = students.get(Integer.parseInt(sc.next()) - 1);
										condition = false;
										System.out.println();

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um número das opções acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOpção inválida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe o novo nome do Aluno:");
								sc.nextLine();
								student.setName(sc.nextLine());

								daoStudent.updateStudent(student);
								System.out.println("Aluno alterado com sucesso!");
								System.out.println();

								break;

							// Start Edition Student Surname;
							case SURNAME:

								do {
									try {

										System.out.println("Informe o Número Sequencial do Aluno para alterar:");
										student = students.get(Integer.parseInt(sc.next()) - 1);
										condition = false;
										System.out.println();

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um número das opções acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOpção inválida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe o novo Sobrenome do Aluno:");
								sc.nextLine();
								student.setSurname(sc.nextLine());

								daoStudent.updateStudent(student);
								System.out.println("Aluno alterado com sucesso!");
								System.out.println();

								break;

							// Start Edition Student Group;
							case GROUP:

								do {
									try {

										System.out.println("Informe o Número Sequencial do Aluno para alterar:");
										student = students.get(Integer.parseInt(sc.next()) - 1);
										condition = false;
										System.out.println();

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um número das opções acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOpção inválida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								groups = daoGroup.listGroupsByIdAsc();

								// Listing Groups by Id Asc;
								System.out.println("Listagem das turmas:");
								for (int i = 0; i < groups.size(); i++) {
									System.out.println("Número Sequencial da Turma: #" + (i + 1) + ", Registro: #"
											+ groups.get(i).getId() + ", Nome: " + groups.get(i).getName()
											+ " e Código: " + groups.get(i).getCode());
								}
								System.out.println();

								do {
									try {

										System.out.println("Informe o Número Sequencial da nova Turma do Aluno:");
										sc.nextLine();
										group = groups.get(Integer.parseInt(sc.next()) - 1);

										condition = false;
										System.out.println();

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um número das opções acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOpção inválida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								student.setGroup(group);

								daoStudent.updateStudent(student);
								System.out.println("Aluno alterado com sucesso!");
								System.out.println();

								break;

							// Start Edition All Student Data;
							case ALL:

								do {
									try {

										System.out.println(
												"Informe o Número Sequencial do Aluno para alterar todos os dados:");
										student = students.get(Integer.parseInt(sc.next()) - 1);
										condition = false;
										System.out.println();

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um número das opções acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOpção inválida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe o novo Nome do Aluno:");
								sc.nextLine();
								student.setName(sc.nextLine());

								System.out.println("Informe o novo Sobrenome do Aluno:");
								student.setSurname(sc.nextLine());

								groups = daoGroup.listGroupsByIdAsc();

								// Listing Groups by Id Asc;
								System.out.println("Listagem das turmas:");
								for (int i = 0; i < groups.size(); i++) {
									System.out.println("Número Sequencial da Turma: #" + (i + 1) + ", Registro: #"
											+ groups.get(i).getId() + ", Nome: " + groups.get(i).getName()
											+ " e Código: " + groups.get(i).getCode());
								}
								System.out.println();

								do {
									try {

										System.out.println("Informe o Número Sequencial da nova Turma do Aluno:");
										group = groups.get(Integer.parseInt(sc.next()) - 1);

										condition = false;
										System.out.println();

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um número das opções acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOpção inválida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								student.setGroup(group);

								daoStudent.updateStudent(student);
								System.out.println("Aluno alterado com sucesso!");
								System.out.println();

								break;

							default:
								break;
							}
						} while (subMenuUpdateStudent != SubMenuUpdateStudent.EXIT);
						// Final subMenuUpdateStudent for Student Edition;
						break;

					// Start Delete Student;
					case DELETE:

						students = daoStudent.listStudentsByIdAsc();

						// Listing Students By Id;
						System.out.println("Listagem de alunos:");
						for (int i = 0; i < students.size(); i++) {
							System.out.println("Número Sequencial do Aluno: #" + (i + 1) + ", Registro :#"
									+ students.get(i).getId() + ", Nome: " + students.get(i).getName() + ", Sobrenome: "
									+ students.get(i).getSurname() + ", Registro da Turma: #"
									+ students.get(i).getGroup().getId());

						}

						System.out.println("");

						do {
							try {

								System.out.println("Informe o Número Sequencial do Aluno para excluir:");
								student = students.get(Integer.parseInt(sc.next()) - 1);
								condition = false;
								System.out.println();

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um número das opções acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOpção inválida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);

						daoStudent.deleteStudent(student);
						System.out.println("Aluno deletado com sucesso!");
						System.out.println();

						break;

					default:
						break;
					}
				} while (subMenu != SubMenu.EXIT);

				break;
			// End of subMenu for Student;

			// Start of choice for Groups Listing;
			case LISTGROUPS:

				AttributeStudent attribute = null;

				// Start the subMenuListGroup - choose the type of listing or Back Main Menu.
				do {
					do {
						try {
							System.out.println("Selecione uma das seguintes opções:\n");
							System.out.println("1 - Listar todas as Turmas com Alunos.");
							System.out.println("2 - Listar Menor Turma.");
							System.out.println("3 - Listar Maior Turma.");
							System.out.println("4 - Voltar Menu Principal.");

							subMenuListGroup = SubMenuListGroup.values()[Integer.parseInt(sc.next()) - 1];
							condition = false;
							System.out.println();

						} catch (NumberFormatException exception) {
							System.err.println("\nFavor informar um número das opções acima.\n");
							condition = true;
						} catch (IndexOutOfBoundsException exception) {
							System.err.println("\nOpção inválida.\n");
							condition = true;
						} catch (NullPointerException exception) {
							System.err.println("\nErro ao acessar o objeto nulo.\n");
							condition = true;
						}
					} while (condition);

					switch (subMenuListGroup) {

					// Start of choice for listing all groups and students;
					case ALL:

						do {
							try {
								System.out.println("Selecione uma das seguintes opções:\n");
								System.out.println("1 - Listar Alunos por Turmas Ordenado pelo Id do Aluno.");
								System.out.println("2 - Listar Alunos por Turmas Ordenado pelo Nome do Aluno.");
								System.out.println("3 - Listar Alunos por Turmas Ordenado pelo Sobrenome do Aluno.");
								System.out.println("4 - Listar Alunos por Turmas Ordenado pelo Id da Turma.");
								attribute = AttributeStudent.values()[Integer.parseInt(sc.next()) - 1];
								condition = false;
								System.out.println();

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um número das opções acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOpção inválida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);

						do {
							try {
								System.out.println("Selecione uma das seguintes opções:\n");
								System.out.println("1 - Listar em Ordem Ascendente.");
								System.out.println("2 - Listar em Ordem Descendente.");

								order = Order.values()[Integer.parseInt(sc.next()) - 1];
								condition = false;
								System.out.println();

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um número das opções acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOpção inválida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);

						switch (attribute) {

						// Start of choice Listing by Student Id;
						case ID:

							switch (order) {

							case ASCENDING:
								groups = daoListGroups.listStudentGroupsByIdAsc();
								break;

							case DESCENDING:
								groups = daoListGroups.listStudentGroupsByIdDesc();
								break;
							}
							break;

						// Start of choice Listing by Student Name;
						case NAME:

							switch (order) {

							case ASCENDING:
								groups = daoListGroups.listStudentGroupsByNameAsc();
								break;

							case DESCENDING:
								groups = daoListGroups.listStudentGroupsByNameDesc();
								break;
							}
							break;

						// Start of choice Listing by Student Surname;
						case SURNAME:

							switch (order) {

							case ASCENDING:
								groups = daoListGroups.listStudentGroupsBySurnameAsc();
								break;

							case DESCENDING:
								groups = daoListGroups.listStudentGroupsBySurnameDesc();
								break;
							}
							break;
						
						case IDGROUP:

							switch (order) {

							case ASCENDING:
								groups = daoListGroups.listStudentGroupsByIdGroupAsc();
								break;

							case DESCENDING:
								groups = daoListGroups.listStudentGroupsByIdGroupDesc();
								break;
							}
							break;

						default:
							break;
						}

						// Listing according to the chosen option;
						System.out.println("Listagem de alunos por turma:");
						for (int i = 0; i < groups.size(); i++) {
							System.out.println("Registro da Turma: #" + groups.get(i).getId() + ", Nome: "
									+ groups.get(i).getName() + " e Código: " + groups.get(i).getCode()
									+ ", Quantidade de Aluno(s): " + groups.get(i).getStudents().size());
							if (groups.get(i).getStudents().size() > 0) {
								System.out.println("	Aluno(s) Cadastrado(s) na Turma: ");
								for (int j = 0; j < groups.get(i).getStudents().size(); j++) {
									System.out.println(
											"	Registro do Aluno: #" + groups.get(i).getStudents().get(j).getId()
													+ ", Nome: " + groups.get(i).getStudents().get(j).getName()
													+ ", Sobrenome: " + groups.get(i).getStudents().get(j).getSurname()
													+ ", Registro da Turma: #" + groups.get(i).getId());
								}
							} else {
								System.out.println("Não Há Alunos Cadastrados Nesta Turma");
							}
							System.out.println("");
						}

						System.out.println("");
						break;

					// List Of Classes With Fewer Students;
					case SMALLER:

						List<Group> smallestGroup = daoListGroups.listSmallestStudentGroup();

						for (int i = 0; i < smallestGroup.size(); i++) {
							System.out.println("Número Sequencial da Turma: #" + (i + 1) + ", Registro: #"
									+ smallestGroup.get(i).getId() + ", Nome: " + smallestGroup.get(i).getName()
									+ ", Código: " + smallestGroup.get(i).getCode() + "  e Total de Aluno(s): "
									+ smallestGroup.get(i).getStudents().size());
						}
						System.out.println();

						break;

					// List Of Classes With More Students;
					case BIGGER:

						List<Group> biggestGroup = daoListGroups.listBiggestStudentGroup();

						for (int i = 0; i < biggestGroup.size(); i++) {
							System.out.println("Número Sequencial da Turma: #" + (i + 1) + ", Registro: #"
									+ biggestGroup.get(i).getId() + ", Nome: " + biggestGroup.get(i).getName()
									+ ", Código: " + biggestGroup.get(i).getCode() + " e Total de Aluno(s): "
									+ biggestGroup.get(i).getStudents().size());
						}
						System.out.println();

						break;

					default:
						break;
					}
				} while (subMenuListGroup != SubMenuListGroup.EXIT);
				// End of subMenuListGroup - List of Groups;

			default:
				break;
			}
		} while (menu != Menu.EXIT);
		// End of the Main Menu;
		System.out.println("Saindo do Sistema...");
		System.out.println("Muito obrigado e volte sempre.");

		sc.close();
	}
}