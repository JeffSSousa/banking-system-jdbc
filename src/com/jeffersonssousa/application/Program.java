package com.jeffersonssousa.application;

import java.util.Scanner;

import com.jeffersonssousa.controller.AccountController;
import com.jeffersonssousa.controller.ClientController;
import com.jeffersonssousa.view.menu.ClientMenuView;
import com.jeffersonssousa.view.util.Screen;

public class Program {
	public static void main(String[] args) {

		AccountController acc = new AccountController();
		ClientController client = new ClientController();
		
		System.out.println(acc.viewAccountdetails(1));
		System.out.println(client.viewCustomerData(1));
		
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
