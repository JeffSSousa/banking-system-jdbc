package com.jeffersonssousa.application;

import java.util.Scanner;

import com.jeffersonssousa.view.menu.adm.ListClientsView;
import com.jeffersonssousa.view.util.Screen;

public class Program {
	public static void main(String[] args) {
		
		
		testScreen();
	}

	public static void testScreen() {
		Scanner sc = new Scanner(System.in);
		try {
			ListClientsView.startNavigation(sc);
			//StartView.startNavigation(sc);
		} finally {
			Screen.exitTheSystem(sc);
		}
	}
}
