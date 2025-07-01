package com.jeffersonssousa.view.menu.access.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import com.jeffersonssousa.controller.ClientController;
import com.jeffersonssousa.controller.RegisterController;
import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.view.util.Screen;

public class RegistrationView {

	public static void startNavigation(Scanner sc) {
		RegisterController registerController = new RegisterController();
		int option = 0;

		sc.nextLine();

		do {
			Screen.clearScreen();

			System.out.println("===== CADASTRO DE CLIENTE =====");
			System.out.println();

			String name[] = readName(sc);
			LocalDate birthDate = readBirthDate(sc);
			String cpf = readCpf(sc);
			String email = readEmail(sc);

			System.out.println();
			System.out.println("===== CADASTRO DA CONTA =====");
			System.out.println();

			int typeAccount = readTypeAccount(sc);
			String password = readPassword(sc);

			Client client = new Client(null, name[0], name[1], cpf, email, birthDate);
			Account account = new Account(null, null, password, 0.0, typeAccount, null);
	
			option = registerController.registerClientAndAccount(client, account);
			
		} while (option != 1);
	}

	private static String[] readName(Scanner sc) {
		ClientController clientController = new ClientController();
		
		while (true) {
			System.out.print("Nome completo: ");
			String name = sc.nextLine().trim();
			if (!name.isEmpty() && name.contains(" ")) {
				return clientController.splitName(name);
			}
			System.out.println("Nome não pode ser vazio, tente novamente...");
			Screen.timeSleep(1000);
		}
	}

	private static LocalDate readBirthDate(Scanner sc) {
		while (true) {
			System.out.print("Data de Nascimento (dd/MM/yyyy): ");
			String input = sc.nextLine().trim();
			try {
				LocalDate date = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				if (ChronoUnit.YEARS.between(date, LocalDate.now()) >= 18) {
					return date;
				} else {
					System.out.println("Você deve ter 18 anos ou mais.");
					Screen.timeSleep(1000);
				}
			} catch (DateTimeParseException e) {
				System.out.println("Formato invalido. Tente novamente...");
				Screen.timeSleep(1000);
			}
		}
	}

	
	private static String readCpf(Scanner sc) {
		ClientController client = new ClientController();

		while (true) {
			System.out.print("CPF (xxx.xxx.xxx-xx): ");
			String cpf = sc.nextLine().trim();

			if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
				System.out.println("Formato de CPF inválido. Tente novamente...");
				Screen.timeSleep(1000);
				continue;
			}

			if (!client.isCpfAvailable(cpf)) {
				System.out.println("CPF já cadastrado. Use um CPF diferente...");
				Screen.timeSleep(1000);
				continue;
			}

			return cpf;
		}
	}

	private static String readEmail(Scanner sc) {
		ClientController client = new ClientController();
		
		while (true) {
			System.out.print("Email:");
			String email = sc.nextLine().trim();
			
			if (!email.contains("@") || !email.endsWith(".com") ) {
				System.out.println("Email invalido. Tente Novamente...");
				Screen.timeSleep(1000);
				continue;
			}
			
			if(!client.isEmailAvailable(email)) {
				System.out.println("Esse Email já está cadastrado. Tente um diferente...");
				Screen.timeSleep(1000);
				continue;
			}

			return email;
		}
	}

	private static int readTypeAccount(Scanner sc) {
		while (true) {
			System.out.println("TIPO DA CONTA:");
			System.out.println("1. POUPANÇA");
			System.out.println("2. CORRENTE");
			System.out.print("Selecione o tipo da conta: ");
			try {
				int type = Integer.parseInt(sc.nextLine());
				if (type == 1 || type == 2) {
					return type;
				}
			} catch (NumberFormatException e) {

			}
			System.out.println("Opção invalida. Tente novamente...");
			Screen.timeSleep(1000);
		}
	}

	private static String readPassword(Scanner sc) {
		while (true) {
			System.out.print("Digite uma senha: ");
			String password = sc.nextLine().trim();
			System.out.print("Digite a senha novamente: ");
			String confirm = sc.nextLine().trim();

			if (password.equals(confirm) && !password.isEmpty()) {
				return password;
			}

			System.out.println("Senhas não coicidem ou vazias. Tente novamente...");
			Screen.timeSleep(1000);

		}
	}
}
