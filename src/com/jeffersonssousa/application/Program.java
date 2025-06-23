package com.jeffersonssousa.application;

import java.util.Scanner;

import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.services.AuthService;
import com.jeffersonssousa.view.menu.HomeMenuView;
import com.jeffersonssousa.view.util.Screen;

public class Program {
	public static void main(String[] args) {

		AuthService service = new AuthService();
		System.out.println(service.authenticateCpf("123.456.789-00"));
		Account acc = service.login("123.456.789-00", "Jef415");
		
		System.out.println(acc);
		
		//testScreen();
	}

	public static void testScreen() {
		Scanner sc = new Scanner(System.in);
		try {
			HomeMenuView.startNavigation(sc);
		} finally {
			Screen.exitTheSystem(sc);
		}
	}
}
