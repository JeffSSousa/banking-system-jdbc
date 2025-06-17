package com.jeffersonssousa.view.util;

import java.util.Scanner;

public class Screen {
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public static void exitTheSystem(Scanner sc) {
		System.out.println("Saindo...");
		if(sc != null) {
			sc.close();
		}
	}
}
