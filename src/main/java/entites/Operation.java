package entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime date;
    private double montant;
    private String motif;

    @ManyToOne
    @JoinColumn(name = "ID_Compte")
    private Compte compte;


    /**
     * Getter
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter
     *
     * @return date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Setter
     *
     * @param date date
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Getter
     *
     * @return montant
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Setter
     *
     * @param montant montant
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    /**
     * Getter
     *
     * @return motif
     */
    public String getMotif() {
        return motif;
    }

    /**
     * Setter
     *
     * @param motif motif
     */
    public void setMotif(String motif) {
        this.motif = motif;
    }

    /**
     * Getter
     *
     * @return compte
     */
    public Compte getCompte() {
        return compte;
    }

    /**
     * Setter
     *
     * @param compte compte
     */
    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Operation{");
        sb.append("id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", montant=").append(montant);
        sb.append(", motif='").append(motif).append('\'');
        sb.append(", compte=").append(compte);
        sb.append('}');
        return sb.toString();
    }
}
