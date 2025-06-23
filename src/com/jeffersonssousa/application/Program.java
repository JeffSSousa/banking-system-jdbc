package com.jeffersonssousa.application;

import java.util.Scanner;

import com.jeffersonssousa.view.menu.ClientMenuView;
import com.jeffersonssousa.view.menu.HomeMenuView;
import com.jeffersonssousa.view.util.Screen;

public class Program {
	public static void main(String[] args) {

		testScreen();
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
