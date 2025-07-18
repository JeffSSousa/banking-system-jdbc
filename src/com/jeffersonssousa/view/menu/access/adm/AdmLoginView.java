package com.jeffersonssousa.view.menu.access.adm;

import java.util.Scanner;

import com.jeffersonssousa.controller.ClientController;
import com.jeffersonssousa.controller.LoginController;
import com.jeffersonssousa.model.entities.Account;
import com.jeffersonssousa.model.entities.Client;
import com.jeffersonssousa.view.menu.ClientMenuView;
import com.jeffersonssousa.view.util.Screen;

public class AdmLoginView {


	public static void startNavigation(Scanner sc) {
        LoginController loginController = new LoginController();
        ClientController clientController = new ClientController();
        int option = 0;
        
        sc.nextLine();
        

        do {
            try {
                Screen.clearScreen();
                
                System.out.println("====== LOGIN DO CLIENTE ======");
                System.out.println();
               
                
                System.out.print("CPF: ");
                String cpf = sc.nextLine().trim();
                

                System.out.print("Senha: ");
                String senha = sc.nextLine().trim();

                Account account = loginController.validate(cpf, senha);
                

                System.out.println("\n✅ Login bem-sucedido!");
                System.out.println();

                if (account.getPassword().equals(senha)) {
                Client client =  clientController.viewCustomerDataByCpf(cpf);
                option = 1;
                Screen.clearScreen();
                ClientMenuView.startNavigation(sc, account, client);
                }
                
            } catch (Exception e) {
                System.out.println("\n❌ Erro ao fazer login: " + e.getMessage());
                System.out.println();
                System.out.println("Tente novamente...");
                Screen.timeSleep(3000);
            }
            
            
        } while (option != 1);
    }
	
}
