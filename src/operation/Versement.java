package operation;

public class Versement extends Operation {
    private String source; 

    public Versement(double montant, String source) {
        super(montant); 
        this.source = source;
    }


    public void afficherDetails() {
        System.out.println("Versement [" + numero + "] - " + montant +
                           " DH, Source: " + source +
                           ", Date: " + date);
    }

    public String getSource() {
        return source;
    }
}
