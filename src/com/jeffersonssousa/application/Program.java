package com.jeffersonssousa.application;

import java.util.Scanner;

import com.jeffersonssousa.view.menu.StartView;
import com.jeffersonssousa.view.util.Screen;

public class Program {
	public static void main(String[] args) {

		//DaoFactory.createTransactionDao().findByReceiverId(5).forEach(System.out::println);
		
		testScreen();
	}

	public static void testScreen() {
		Scanner sc = new Scanner(System.in);
		try {
			StartView.startNavigation(sc);
		} finally {
			Screen.exitTheSystem(sc);
		}
	}
}
