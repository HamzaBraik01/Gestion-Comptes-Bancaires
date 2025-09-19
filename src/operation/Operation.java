package operation;

import java.util.UUID;
import java.time.LocalDate;

public abstract class Operation {
    protected String numero;   
    protected LocalDate date;  
    protected double montant;  

    public Operation(double montant) {
        this.numero = UUID.randomUUID().toString(); // Génère ID unique
        this.date = LocalDate.now();               // Date d’aujourd’hui
        this.montant = montant;
    }

    public abstract void afficherDetails();

    public String getNumero() {
        return numero;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }
}
