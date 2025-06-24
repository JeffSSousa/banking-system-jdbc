package com.jeffersonssousa.view.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.jeffersonssousa.view.util.exceptions.TimeSleepException;

public class Screen {

	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }
	}

	public static void showReturnToMenu(int number) {
		System.out.println(number + ". Voltar");
		System.out.print("Informe a opção desejada:");
	}

	public static void showReturningToMenu() {
		System.out.println("Voltando...");
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
	
	public static String formatInstant(Instant datetime) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
		return fmt.format(datetime);
	}
	
	public static void timeSleep(int value) {
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			throw new TimeSleepException(e.getMessage());
		}
	}
}
