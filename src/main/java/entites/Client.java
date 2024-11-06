package entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity

public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    @Embedded
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "ID_Banque")
    private Banque banque;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CLI_COM",
            joinColumns = @JoinColumn(name = "ID_Client", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name="ID_Compte", referencedColumnName="ID")
    )
    private Set<Compte> comptes;

    {
        comptes = new HashSet<>();
    }

    public Client() {
    }

    public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.banque = banque;
        setBanque(banque);
    }



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
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter
     *
     * @param nom nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter
     *
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter
     *
     * @param prenom prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Getter
     *
     * @return dateNaissance
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Setter
     *
     * @param dateNaissance dateNaissance
     */
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Getter
     *
     * @return adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Setter
     *
     * @param adresse adresse
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Client{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append(", adresse=").append(adresse);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Setter
     *
     * @param banque banque
     */
    public void setBanque(Banque banque) {
        if (this.banque != null) {
            this.banque.getClients().remove(this);
        }
        this.banque = banque;
        if (this.banque != null) {
            this.banque.getClients().add(this);
        }
    }

    /**
     * Getter
     *
     * @return banque
     */
    public Banque getBanque() {
        return banque;
    }

    /**
     * Getter
     *
     * @return comptes
     */
    public Set<Compte> getComptes() {
        return comptes;
    }

    /**
     * Setter
     *
     * @param comptes comptes
     */
    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    public void ajouterCompte(Compte compte) {
        if (compte != null) {
            this.comptes.add(compte);
            compte.getClients().add(this);
        }
    }

    public void supprimerCompte(Compte compte) {
        if (compte != null) {
            this.comptes.remove(compte);
            compte.getClients().remove(this);
        }
    }

}
