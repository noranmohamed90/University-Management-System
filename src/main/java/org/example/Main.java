package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.entities.*;
import org.example.persistence.customePersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String puNam = "pu-name";
        String providerClassName = "org.hibernate.jpa.HibernatePersistenceProvider";
        String jdbcUrl = "jdbc:mysql://localhost/uni_system";
        String userName = "root";
        String pass = "123456";
        List<String> mangedClassName =List.of("org.example.entities.Student","org.example.entities.Instructor",
                "org.example.entities.Department","org.example.entities.Course","org.example.entities.Student_Card");

        HashMap<?, ?> props = new HashMap<>();


        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new customePersistenceUnitInfo(puNam, providerClassName, jdbcUrl, userName, pass, mangedClassName), props);

        EntityManager em = emf.createEntityManager();
        try {

            em.getTransaction().begin();


            em.getTransaction().commit();
        } finally {
            em.close();
        }


    }
}