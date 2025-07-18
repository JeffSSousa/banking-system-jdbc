package com.jeffersonssousa.view.menu.access.adm;

import java.util.Scanner;

import com.jeffersonssousa.controller.LoginController;
import com.jeffersonssousa.model.entities.Employee;
import com.jeffersonssousa.view.menu.AdministratorMenuView;
import com.jeffersonssousa.view.util.Screen;

public class AdmLoginView {


	public static void startNavigation(Scanner sc) {
        LoginController loginController = new LoginController();
        int option = 0;
        
        sc.nextLine();
        

        do {
            try {
                Screen.clearScreen();
                
                System.out.println("====== LOGIN DO COLABORADOR ======");
                System.out.println();
               
                
                System.out.print("CPF: ");
                String cpf = sc.nextLine().trim();
                

                System.out.print("Senha: ");
                String password = sc.nextLine().trim();

                Employee employee = loginController.validateEmployee(cpf, password);
                

                System.out.println("\n✅ Login bem-sucedido!");
                System.out.println();

                if (employee.getPassword().equals(password)) {
                option = 1;
                Screen.clearScreen();
                AdministratorMenuView.startNavigation(sc, employee);
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
