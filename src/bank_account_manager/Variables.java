package bank_account_manager;
import java.util.*;
public class Variables {
	// class variables 
	long num;
	char type;
	double taux;
	double val;

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
			choice = mainMenu();
			switch (choice) {
			case 1 :
				do {
					System.out.print("Choisir le type de compte (C)ourant, (J)oint, (E)pargne : ");
					account_type = userInput.next().charAt(0);
				} while (account_type != 'C' && account_type != 'J' && account_type != 'E' );
				System.out.print("Numero du compte : ");
				account_num_created = userInput.nextLong();
				System.out.print("Premiere valeur creditee : ");
				current_value = userInput.nextDouble();
				
				// if (E)pargne = ask for rate 
				if (account_type == 'E') {
					System.out.print("Choisir le taux de placement : ");
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
					System.out.print("Le compte numéro : " + account_num_created + " est un compte :");
					if (account_type == 'C') System.out.println(" courant.");
					else if (account_type == 'J') System.out.println(" joint");
					else if (account_type == 'E') {
						System.out.print(" epargne");
						System.out.println(" dont le taux est de : " + rate + ".");
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
				out();
				break;
			
			// if choice 5
			case 5 :
				help();
				break;
				
			default :
				System.out.println("Cette option n'est pas prévue par le système");
			}		
		} while (choice != 4);
	}
	
	// printing menu and return user' choice
	public static byte mainMenu() {
		byte choice;
		Scanner userInput = new Scanner(System.in);
		System.out.println("1. Creer un compte");	
		System.out.println("2. Afficher un compte");
		System.out.println("3. Creer une ligne comptable");
		System.out.println("4. Sortir");
		System.out.println("5. De l'aide");
		System.out.print("Votre choix : ");
		// user choice 
		choice = userInput.nextByte();
		return choice;
	}
	
	// getting out of the app
	public static void out() {
		System.out.print("Au revoir");
		System.exit(0);
	}
	
	// displaying some help
	public static void help() {
		System.out.println("======================================================");
		System.out.println("Option 1 :");
		System.out.println("Pour créer un compte courante entrer : C"); 
		System.out.println("Pour créer un compte joint entrer : J");
		System.out.println("Pour créer un compte epargne entrer : E");
		System.out.println("- Entrer ensuite le numero du compte");
		System.out.println("- Entrer alors la valeur creditee");
		System.out.println("Dans le cas d'un compte epargne, entrer le taux.");
		System.out.print("Option 2 :");
		System.out.println(" Le systeme affiche les donnees du compte choisi");
		System.out.print("Option 3 :");
		System.out.println(" Ecrire une ligne comptable");
		System.out.print("Option 4 :");
		System.out.println(" Quitter le programme");
		System.out.print("Option 5 :");
		System.out.println(" Afficher de l'aide. Vous y etes ;) ");
		System.out.println("======================================================");
	}
	
	// print account
	public static void printAccount() {
		
		System.out.print("Le compte n° : " + num + " est un compte ");
		if (type == 'C') System.out.println(" courant ");
		else if (type == 'J') System.out.println(" joint ");
		else if (type == 'E') {
			// print rate 
			System.out.println(" epargne dont le taux est " + taux);
		}
		System.out.println(" Valeur initiale : " + val);
		}

	// create account
	public static char createAccount(String s) {
		// return value is the first letter of the choice made by the user
		return s.charAt(0);
	}

}

