package ui;
import service.BanqueService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BanqueService banque = new BanqueService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU BANQUE ===");
            System.out.println("1. Créer un compte courant");
            System.out.println("2. Créer un compte épargne");
            System.out.println("3. Effectuer un versement");
            System.out.println("4. Effectuer un retrait");
            System.out.println("5. Effectuer un virement");
            System.out.println("6. Consulter le solde");
            System.out.println("7. Consulter les opérations");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    System.out.print("Code du compte (CPT-12345) : ");
                    String codeC = scanner.nextLine();
                    System.out.print("Solde initial : ");
                    double soldeC = scanner.nextDouble();
                    System.out.print("Découvert autorisé : ");
                    double decouvert = scanner.nextDouble();
                    banque.creerCompteCourant(codeC, soldeC, decouvert);
                    break;

                case 2:
                    System.out.print("Code du compte (CPT-12345) : ");
                    String codeE = scanner.nextLine();
                    System.out.print("Solde initial : ");
                    double soldeE = scanner.nextDouble();
                    System.out.print("Taux d'intérêt (ex: 0.05 pour 5%) : ");
                    double taux = scanner.nextDouble();
                    banque.creerCompteEpargne(codeE, soldeE, taux);
                    break;

                case 3:
                    System.out.print("Code du compte : ");
                    String codeV = scanner.nextLine();
                    System.out.print("Montant du versement : ");
                    double montantV = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Source du versement : ");
                    String source = scanner.nextLine();
                    banque.effectuerVersement(codeV, montantV, source);
                    break;

                case 4:
                    System.out.print("Code du compte : ");
                    String codeR = scanner.nextLine();
                    System.out.print("Montant du retrait : ");
                    double montantR = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Destination du retrait : ");
                    String destination = scanner.nextLine();
                    banque.effectuerRetrait(codeR, montantR, destination);
                    break;

                case 5:
                    System.out.print("Code du compte source : ");
                    String codeS = scanner.nextLine();
                    System.out.print("Code du compte destination : ");
                    String codeD = scanner.nextLine();
                    System.out.print("Montant du virement : ");
                    double montantVirement = scanner.nextDouble();
                    banque.effectuerVirement(codeS, codeD, montantVirement);
                    break;

                case 6:
                    System.out.print("Code du compte : ");
                    String codeSolde = scanner.nextLine();
                    banque.consulterSolde(codeSolde);
                    break;

                case 7:
                    System.out.print("Code du compte : ");
                    String codeOps = scanner.nextLine();
                    banque.consulterOperations(codeOps);
                    break;

                case 0:
                    System.out.println("Merci et au revoir !");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Choix invalide !");
            }
        }
    }
}
