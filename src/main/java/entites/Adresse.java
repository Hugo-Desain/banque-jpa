package entites;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Embeddable
public class Adresse implements Serializable {

    private int numero;
    private String rue;
    private int codePostal;
    private String ville;

    public Adresse(){

    }

    public Adresse(int i, String laPaix, String ales, int i1) {
    }


    /**
     * Getter
     *
     * @return numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Setter
     *
     * @param numero numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Getter
     *
     * @return rue
     */
    public String getRue() {
        return rue;
    }

    /**
     * Setter
     *
     * @param rue rue
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
     * Getter
     *
     * @return codePostal
     */
    public int getCodePostal() {
        return codePostal;
    }

    /**
     * Setter
     *
     * @param codePostal codePostal
     */
    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * Getter
     *
     * @return ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * Setter
     *
     * @param ville ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }
}
