/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextlevel.jpa.demo.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jack
 */
public class Tester {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        Person p1 = new Person("Jønke", 1963);
        Person p2 = new Person("Blondie", 1959);
        Person p3 = new Person("Thomas", 1970);
        Person p4 = new Person("Carsten", 1975);
        Person p5 = new Person("Philip", 1978);
        Person p6 = new Person("Preben", 1968);
        Person p7 = new Person("Mads", 1980);
        Person p8 = new Person("Anders", 1979);
        Person p9 = new Person("Tobias", 1988);
        Person p10 = new Person("Erik", 1981);

        Address a1 = new Address("Store Torv 1", 2323, "Nr. Snede");
        Address a2 = new Address("Langgade 34", 1212, "Valby");

        p1.setAddress(a1);
        p2.setAddress(a2);

        Fee f1 = new Fee(100);
        Fee f2 = new Fee(200);
        Fee f3 = new Fee(300);
        Fee f4 = new Fee(450);
        Fee f5 = new Fee(700);
        Fee f6 = new Fee(150);
        Fee f7 = new Fee(599);
        Fee f8 = new Fee(350);
        Fee f9 = new Fee(275);
        Fee f10 = new Fee(125);
        Fee f11 = new Fee(600);

        p1.addFees(f1);
        p1.addFees(f3);
        p2.addFees(f2);
        p3.addFees(f4);
        p4.addFees(f5);
        p5.addFees(f6);
        p6.addFees(f7);
        p7.addFees(f8);
        p8.addFees(f9);
        p9.addFees(f10);
        p10.addFees(f11);

        SwimStyle s1 = new SwimStyle("Crawl");
        SwimStyle s2 = new SwimStyle("Butterfly");
        SwimStyle s3 = new SwimStyle("Breast stroke");

        p1.addSwimStyle(s1);
        p1.addSwimStyle(s3);
        p2.addSwimStyle(s2);
        p3.addSwimStyle(s2);
        p4.addSwimStyle(s1);
        p4.addSwimStyle(s3);
        p5.addSwimStyle(s3);
        p6.addSwimStyle(s1);
        p7.addSwimStyle(s1);
        p7.addSwimStyle(s2);
        p8.addSwimStyle(s3);
        p9.addSwimStyle(s2);
        p10.addSwimStyle(s1);
        p10.addSwimStyle(s2);
        p10.addSwimStyle(s3);

        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.persist(p5);
        em.persist(p6);
        em.persist(p7);
        em.persist(p8);
        em.persist(p9);
        em.persist(p10);
        em.getTransaction().commit();

        em.getTransaction().begin();
        p1.removeSwimStyle(s3);
        em.getTransaction().commit();

        System.out.println("p1: " + p1.getP_id() + ", " + p1.getName());
        System.out.println("p2: " + p2.getP_id() + ", " + p2.getName());

        System.out.println("Jønkes gade: " + p1.getAddress().getStreet());

        System.out.println("Lad os se om to-vejs virker: " + a1.getPerson().getName());

        System.out.println("Hvem har betalt f2? Det har: " + f2.getPerson().getName());

        System.out.println("Hvad er det blevet betalt i alt?");

        TypedQuery<Fee> q1 = em.createQuery("SELECT f FROM Fee f", Fee.class);
        List<Fee> fees = q1.getResultList();

        for (Fee f : fees) {
            System.out.println("Member: " + f.getPerson().getName() + ". Fees: " + f.getAmount());
        }
        
        TypedQuery<Person> q2 = em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> persons = q2.getResultList();
        
        List<Person> crawlList = new ArrayList<>();
        for (Person p : persons){
            if (p.styles.contains("Crawl")){
                crawlList.add(p);
            }
        }
        
        for (int i = 0; i < crawlList.size(); i++){
            System.out.println(crawlList.get(i));
        }

        
        int i = 0;
        for (Fee f : fees) {
            i = f.getAmount() + i;
        }
        System.out.println("Total fee amount: " + i);
        
        Query q3 = em.createQuery("SELECT MAX(p.amount) FROM Fee p");
        int maxFee = (int)q3.getSingleResult();
        
        System.out.println("Biggest Fee: " + maxFee);
        
        Query q4 = em.createQuery("SELECT MIN(p.amount) FROM Fee p");
        int minFee = (int)q4.getSingleResult();
        
        System.out.println("Lowest Fee: " + minFee);
    }

}
