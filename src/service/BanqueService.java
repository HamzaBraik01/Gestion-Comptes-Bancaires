package service;

import compte.Compte;
import compte.CompteCourant;
import compte.CompteEpargne;
import operation.Versement;
import operation.Retrait;

import java.util.HashMap;

public class BanqueService{
    private HashMap<String, Compte> comptes = new HashMap<>();


    // Créer Compte Courant
    public void creerCompteCourant(String code, double solde, double decouvert) {
        if (comptes.containsKey(code)) {
            System.out.println(" Ce compte existe déjà !");
            return;
        }
        Compte c = new CompteCourant(code, solde, decouvert);
        comptes.put(code, c);
        System.out.println(" Compte courant créé : " + code);
    }
    // Créer Compte Epargne
    public void creerCompteEpargne(String code, double solde, double taux) {
        if (comptes.containsKey(code)) {
            System.out.println(" Ce compte existe déjà !");
            return;
        }
        Compte c = new CompteEpargne(code, solde, taux);
        comptes.put(code, c);
        System.out.println(" Compte épargne créé : " + code);
    }

    public void effectuerVersement(String code, double montant, String source) {
        Compte c = comptes.get(code);
        if (c == null) {
            System.out.println("Compte introuvable !");
            return;
        }
        c.deposer(montant);
        c.ajouterOperation(new Versement(montant, source));
        System.out.println("Versement effectué sur " + code);
    }

    public void effectuerRetrait(String code, double montant, String destination) {
        Compte c = comptes.get(code);
        if (c == null) {
            System.out.println("Compte introuvable !");
            return;
        }
        try {
            c.retirer(montant);
            c.ajouterOperation(new Retrait(montant, destination));
            System.out.println("Retrait effectué sur " + code);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public void effectuerVirement(String codeSource, String codeDest, double montant) {
        Compte source = comptes.get(codeSource);
        Compte dest = comptes.get(codeDest);

        if (source == null || dest == null) {
            System.out.println("Compte source ou destination introuvable !");
            return;
        }

        try {
            source.retirer(montant);
            dest.deposer(montant);
            source.ajouterOperation(new Retrait(montant, "Virement vers " + codeDest));
            dest.ajouterOperation(new Versement(montant, "Virement de " + codeSource));
            System.out.println("Virement effectué de " + codeSource + " vers " + codeDest);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public void consulterSolde(String code) {
        Compte c = comptes.get(code);
        if (c == null) {
            System.out.println(" Compte introuvable !");
            return;
        }
        System.out.println("Solde du compte " + code + " : " + c.getSolde());
    }

    public void consulterOperations(String code) {
        Compte c = comptes.get(code);
        if (c == null) {
            System.out.println("Compte introuvable !");
            return;
        }
        System.out.println("Liste des opérations du compte " + code + " :");
        c.getListeOperations().forEach(op -> op.afficherDetails());
    }

    public boolean compteExiste(String code) {
        return comptes.containsKey(code);
    }
}