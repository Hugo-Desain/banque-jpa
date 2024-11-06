package entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity

public class Compte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    private double solde;

    @ManyToMany(mappedBy="comptes")
    private Set<Client> clients;

    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations;

    {
        clients = new HashSet<>();
        operations = new HashSet<>();
    }

    public Compte(){

    }

    public Compte(int id, String numero, double solde) {
        this.id = id;
        this.numero = numero;
        this.solde = solde;

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
     * @return numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Setter
     *
     * @param numero numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Getter
     *
     * @return solde
     */
    public double getSolde() {
        return solde;
    }

    /**
     * Setter
     *
     * @param solde solde
     */
    public void setSolde(double solde) {
        this.solde = solde;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Compte{");
        sb.append("id=").append(id);
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", solde=").append(solde);
        sb.append(", operation=").append(operations);
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

    /**
     * Getter
     *
     * @return operations
     */
    public Set<Operation> getOperations() {
        return operations;
    }

    /**
     * Setter
     *
     * @param operations operations
     */
    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public void ajouterClient(Client client) {
        if (client != null) {
            this.clients.add(client);
            client.getComptes().add(this);
        }
    }

    public void supprimerClient(Client client) {
        if (client != null) {
            this.clients.remove(client);
            client.getComptes().remove(this);
        }
    }
}

