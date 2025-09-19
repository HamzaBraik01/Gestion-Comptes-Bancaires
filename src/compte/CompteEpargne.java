package compte;
public class CompteEpargne extends Compte {
    private double tauxInteret;

    public CompteEpargne(String code, double soldeInitial, double tauxInteret) {
        super(code, soldeInitial);
        this.tauxInteret = tauxInteret;
    }


    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("Erreur : le montant doit être positif.");
            return;
        }

        if (solde >= montant) {
            solde -= montant;
            System.out.println("Retrait de " + montant + " effectué. Nouveau solde : " + solde);
        } else {
            System.out.println("Erreur : solde insuffisant pour effectuer le retrait.");
        }
    }

    
    public double calculerInteret() {
        return solde * tauxInteret;
    }

    public void afficherDetails() {
        System.out.println("=== Compte Épargne ===");
        System.out.println("Code : " + code);
        System.out.println("Solde : " + solde);
        System.out.println("Taux d'intérêt : " + (tauxInteret * 100) + "%");
        System.out.println("Intérêts calculés : " + calculerInteret());
    }

    
    public double getTauxInteret() {
        return tauxInteret;
    }
}
