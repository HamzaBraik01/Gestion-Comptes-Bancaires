package operation;

public class Retrait extends Operation {
    private String destination; // Exemple: ATM, Chèque, Virement sortant

    public Retrait(double montant, String destination) {
        super(montant); // Appel du constructeur de Operation
        this.destination = destination;
    }

    
    public void afficherDetails() {
        System.out.println("Retrait [" + numero + "] - " + montant +
                           " DH, Destination: " + destination +
                           ", Date: " + date);
    }

    public String getDestination() {
        return destination;
    }
}
