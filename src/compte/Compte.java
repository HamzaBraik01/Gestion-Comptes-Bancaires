package compte;
import java.util.ArrayList;
import java.util.List;       
import java.util.regex.Pattern;
import operation.Operation;  // import class Operation

public abstract class Compte {
    protected String code;
    protected double solde;
    protected List<Operation> listeOperations;  

    public Compte(String code, double soldeInitial) {
        if (!validerCode(code)) {
            throw new IllegalArgumentException("Code de compte invalide. Format attendu : CPT-12345");
        }
        this.code = code;
        this.solde = soldeInitial;              
        this.listeOperations = new ArrayList<>();
    }

    // ✅ Validation du code
    private boolean validerCode(String code) {
        String regex = "CPT-\\d{5}"; 
        return Pattern.matches(regex, code);
    }

    // ✅ Ajouter opération
    public void ajouterOperation(Operation op) {
        this.listeOperations.add(op);
    }

    // ✅ Déposer
    public void deposer(double montant) {
        if (montant <= 0) {
            System.out.println("Erreur : le montant doit être positif.");
            return;
        }
        solde += montant;
    }

    // ✅ Méthodes abstraites
    public abstract void retirer(double montant);
    public abstract double calculerInteret();
    public abstract void afficherDetails();

    // ✅ Getters
    public String getCode() {
        return code;
    }

    public double getSolde() {
        return solde;
    }

    public List<Operation> getListeOperations() {
        return listeOperations;
    }
}
