package com.jeffersonssousa.view.menu.access.client;

import java.util.Scanner;

import com.jeffersonssousa.controller.LoginController;
import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.view.menu.ClientMenuView;
import com.jeffersonssousa.view.util.Screen;

public class ClientLoginView {

	public static void startNavigation(Scanner sc) {
        LoginController controller = new LoginController();
        int option = 0;

        do {
            try {
                Screen.clearScreen();

                
                System.out.println("====== LOGIN DO CLIENTE ======");
                System.out.println();

                System.out.print("CPF: ");
                sc.nextLine(); 
                String cpf = sc.nextLine().trim();

                System.out.print("Senha: ");
                String senha = sc.nextLine().trim();

                Account account = controller.validate(cpf, senha);

                System.out.println("\n✅ Login bem-sucedido!");
                System.out.println();

                if (account != null) {
                option = 1;
                Screen.clearScreen();
                ClientMenuView.startNavigation(sc);
                }
                
            } catch (Exception e) {
                System.out.println("\n❌ Erro ao fazer login: " + e.getMessage());
                System.out.println("Tente novamente.\n");
            }
            
            
        } while (option != 1);
    }
}
