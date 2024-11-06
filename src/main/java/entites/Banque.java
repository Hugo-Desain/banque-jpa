package entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity

public class Banque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    @OneToMany(mappedBy = "banque")
    private Set<Client> clients;

    {
        clients = new HashSet<>();
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

    public void ajouterClient(Client client) {
        client.setBanque(this);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Banque{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", client=").append(clients);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Getter
     *
     * @return clients
     */
    public Set<Client> getClients() {
        return clients;
    }

    /**
     * Setter
     *
     * @param clients clients
     */
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
