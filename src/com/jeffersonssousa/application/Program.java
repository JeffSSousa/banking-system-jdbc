package com.jeffersonssousa.application;

import java.util.Scanner;

import com.jeffersonssousa.services.AccountService;
import com.jeffersonssousa.services.ClientService;
import com.jeffersonssousa.view.menu.ClientMenuView;
import com.jeffersonssousa.view.util.Screen;

public class Program {
	public static void main(String[] args) {

		AccountService account = new AccountService();
		ClientService client = new ClientService();
		System.out.println(account.findAccountData(1));
		System.out.println(client.findClienttData(1));
		
	}

	public static void testScree() {
		Scanner sc = new Scanner(System.in);
		try {
			ClientMenuView.startNavigation(sc);
		} finally {
			Screen.exitTheSystem(sc);
		}
	}
}
