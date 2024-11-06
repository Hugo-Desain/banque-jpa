package entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity

public class LivretA extends Compte{

    private double taux;



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
        final StringBuffer sb = new StringBuffer("LivretA{");
        sb.append(", taux=").append(taux);
        sb.append('}');
        return sb.toString();
    }
}
