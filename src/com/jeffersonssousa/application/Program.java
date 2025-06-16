package com.jeffersonssousa.application;

import java.util.Scanner;

import com.jeffersonssousa.view.menu.HomeMenuView;

public class Program {
	public static void main(String[] args) {

		Scanner  sc = new Scanner(System.in);
		
		int option = HomeMenuView.showHomeMenu(sc);
		
		System.out.println(option);
		
		sc.close();
	}
}