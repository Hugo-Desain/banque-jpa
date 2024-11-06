package fr.diginamic;

import entites.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Adresse adresseA = new Adresse();
        adresseA.setNumero(2);
        adresseA.setRue("la colline");
        adresseA.setVille("Montpellier");
        adresseA.setCodePostal(34000);

        Adresse adresseB = new Adresse();
        adresseA.setNumero(5);
        adresseA.setRue("la montagne");
        adresseA.setVille("Paris");
        adresseA.setCodePostal(75000);

        Banque banqueA = new Banque();
        banqueA.setNom("SG");
        em.persist(banqueA);


        Compte compteA = new Compte();
        compteA.setNumero("123456");
        compteA.setSolde(999.99);
        em.persist(compteA);



        Client clientA1 = new Client();
        clientA1.setNom("Terieur");
        clientA1.setPrenom("Alain");
        clientA1.setAdresse(adresseA);
        clientA1.setBanque(banqueA);
        em.persist(clientA1);

        Client clientA2 = new Client();
        clientA2.setNom("Bono");
        clientA2.setPrenom("Jean");
        clientA2.setAdresse(adresseB);
        clientA2.setBanque(banqueA);

        em.persist(clientA2);

        Client clientB1 = new Client("Cover", "Harry", LocalDate.now() ,new Adresse(5, "la paix", "Ales", 30000), banqueA);

        clientB1.ajouterCompte(compteA);
        em.persist(clientB1);

        Compte compteB = new AssuranceVie(LocalDate.now(), 55);
        em.persist(compteB);

        AssuranceVie assvie1 = new AssuranceVie(LocalDate.now(), 22);
        em.persist(assvie1);

        Operation operationA = new Operation();
        operationA.setCompte(compteA);
        operationA.setDate(LocalDateTime.now());
        operationA.setMontant(200.00);
        em.persist(operationA);

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}