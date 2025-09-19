package compte;
import java.util.ArrayList;
import java.util.List;  
public class CompteCourant extends Compte {
    private double decouvert;


    public CompteCourant (String code , double soldeInitial, double decouvert){
        super(code,soldeInitial);
        this.decouvert = decouvert;   

    }
    public void retirer(double montant){
         if (montant <= 0) {
            System.out.println("Erreur : le montant doit être positif.");
            return;
        }

        if (solde - montant < -decouvert) {
            System.out.println("Erreur : retrait impossible, dépassement du découvert autorisé.");
        } else {
            solde -= montant;
            System.out.println("Retrait de " + montant + " effectué. Nouveau solde : " + solde);
        }

    }

    public void afficherDetails() {
        System.out.println("=== Compte Courant ===");
        System.out.println("Code : " + code);
        System.out.println("Solde : " + solde);
        System.out.println("Découvert autorisé : " + decouvert);
    }

    public double calculerInteret() {
        return 0; // pas d'intérêts sur un compte courant
    }
    public double getDecouvert() {
        return decouvert;
    }
}