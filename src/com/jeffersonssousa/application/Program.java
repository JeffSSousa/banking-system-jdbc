package com.jeffersonssousa.application;

import java.util.Scanner;

import com.jeffersonssousa.repository.DaoFactory;
import com.jeffersonssousa.repository.EmployeeRepository;
import com.jeffersonssousa.view.menu.StartView;
import com.jeffersonssousa.view.util.Screen;

public class Program {
	public static void main(String[] args) {
		
		EmployeeRepository conn = DaoFactory.createEmployeeDao();
		
		System.out.println(conn.findBycpf("123.456.789-00"));
		
		//testScreen();
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
