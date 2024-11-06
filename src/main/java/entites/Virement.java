package entites;

import jakarta.persistence.*;
@Entity

public class Virement extends Operation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String beneficiaire;

    /**
     * Getter
     *
     * @return id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Setter
     *
     * @param id id
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter
     *
     * @return beneficiaire
     */
    public String getBeneficiaire() {
        return beneficiaire;
    }

    /**
     * Setter
     *
     * @param beneficiaire beneficiaire
     */
    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Virement{");
        sb.append("id=").append(id);
        sb.append(", beneficiaire='").append(beneficiaire).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
