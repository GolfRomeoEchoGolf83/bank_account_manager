package bank_account_manager;
import java.util.*;
public class Variables {

	public static void main (String[] args) {
		// variable declaration
		byte choice;
		char account_type = '\0'; 
		char payment_device = '\0';
		char object = '\0';
		double current_value = 0.0;
		double rate = 0.0;
		long account_num_created = 0;
		long account_num_entered = 0;

		Scanner userInput = new Scanner(System.in);
		
		do {
			// printing menu
			System.out.println("1. Creer un compte");	
			System.out.println("2. Afficher un compte");
			System.out.println("3. Creer une ligne comptable");
			System.out.println("4. Sortir");
			System.out.println("5. De l'aide");
			System.out.print("Votre choix : ");
			
			// user's choice
			choice = userInput.nextByte();

			switch (choice) {
			case 1 :
				// if choice 1 : create account
				System.out.println("Choisir le type de compte (C)ourant, (J)oint, (E)pargne :");
				account_type = userInput.next().charAt(0);
				System.out.println("Numero du compte :");
				account_num_created = userInput.nextLong();
				System.out.println("Premiere valeur creditee :");
				current_value = userInput.nextDouble();
				
				// if (E)pargne = ask for rate 
				if (account_type == 'E') {
					System.out.println("Choisir le taux de placement :");
					rate = userInput.nextDouble();
				}
				break;
			
			// if choice 2 : print account
			case 2 :
				System.out.println("Quel compte souhaitez vous consulter ?");
				account_num_entered = userInput.nextLong();
				// if account exist and its an epargne print current_value and its rate
					// account exist
				if (account_num_entered == account_num_created) {
					System.out.println("Le compte numéro : " + account_num_created + " est un compte : ");
					if (account_type == 'C') System.out.print(" courant");
					else if (account_type == 'J') System.out.print(" joint");
					else if (account_type == 'E') {
						System.out.println(" epargne");
						System.out.println(" dont le taux est de : " + rate);
					}	
					System.out.println("La valeur courante du compte est de : " + current_value);
					// account does not exist 
				} else System.out.println("Le compte numéro : " + account_num_entered + " n'est pas reconnu par le système.");	
				break;
			
			// if choice 3 : new operation creation
			case 3 :
				System.out.println("Option non programmee");
				break;
			
			// if choice 4 : exit
			case 4 :
				System.out.print("Au revoir");
				System.exit(0);
				break;
			
			// if choice 5
			case 5 :
				System.out.println("Option 1 :");
				System.out.println("Pour créer un compte courante entrer : C"); 
				System.out.println("Pour créer un compte joint entrer : J");
				System.out.println("Pour créer un compte epargne entrer : E");
				System.out.println("	- Entrer ensuite le numero du compte");
				System.out.println("	- Entrer alors la valeur creditee");
				System.out.println("Dans le cas d'un compte epargne, entrer le taux.");
				System.out.println("Option 2 :");
				System.out.println("Le systeme affiche les donnees du compte choisi");
				System.out.println("Option 3 :");
				System.out.println("Ecrire une ligne comptable");
				System.out.println("Option 4 :");
				System.out.println("Quitter le programme");
				System.out.println("Option 5 :");
				System.out.println("Afficher de l'aide : Vous y etes ;) ");
				break;
			}		
		} while (choice != 4);	
	}
}
