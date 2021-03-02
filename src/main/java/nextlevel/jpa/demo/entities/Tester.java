/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextlevel.jpa.demo.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jack
 */
public class Tester {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        Person p1 = new Person("Jønke", 1963);
        Person p2 = new Person("Blodie", 1959);

        Address a1 = new Address("Store Torv 1", 2323, "Nr. Snede");
        Address a2 = new Address("Langgade 34", 1212, "Valby");
        
        p1.setAddress(a1);
        p2.setAddress(a2);
        
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();

        System.out.println("p1: " + p1.getP_id() + ", " + p1.getName());
        System.out.println("p2: " + p2.getP_id() + ", " + p2.getName());
        
        System.out.println("Jønkes gade: " + p1.getAddress().getStreet());
        
        System.out.println("Lad os se om to-vejs virker: " + a1.getPerson().getName());
    }

}
