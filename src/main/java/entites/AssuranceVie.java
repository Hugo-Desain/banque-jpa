package entites;

import jakarta.persistence.Entity;

import java.time.LocalDate;
@Entity

public class AssuranceVie extends Compte{

    private LocalDate dateFin;
    private double taux;

    public AssuranceVie(LocalDate dateFin, double taux) {
        this.dateFin = dateFin;
        this.taux = taux;
    }

    /**
     * Getter
     *
     * @return dateFin
     */
    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
     * Setter
     *
     * @param dateFin dateFin
     */
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Getter
     *
     * @return taux
     */
    public double getTaux() {
        return taux;
    }

    /**
     * Setter
     *
     * @param taux taux
     */
    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AssuranceVie{");
        sb.append(", dateFin=").append(dateFin);
        sb.append(", taux=").append(taux);
        sb.append('}');
        return sb.toString();
    }
}
