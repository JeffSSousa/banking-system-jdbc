package com.jeffersonssousa.view.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Screen {

	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }
	}

	public static void showReturnToMenu(String msg) {
		System.out.println("1. Voltar ao Menu de " + msg);
		System.out.print("Informe a opção desejada:");
	}

	public static void showReturningToMenu() {
		System.out.println("Voltando ao Menu Principal...");
		System.out.println();
	}

	public static void exitTheSystem(Scanner sc) {
		System.out.println("Saindo...");
		if (sc != null) {
			sc.close();
		}
	}

	public static void notifyInvalidOption(int limitOption, int option) {
		if (option > limitOption || option < 0) {
			System.out.println("\nOpção selecionada inexistente, tente novamente!!!\n");
		}
	}

	public static String formatLocalDate(LocalDate date) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(fmt);
	}
}
