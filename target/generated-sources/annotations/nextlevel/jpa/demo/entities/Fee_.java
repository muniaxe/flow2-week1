package nextlevel.jpa.demo.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import nextlevel.jpa.demo.entities.Person;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-05T12:44:43")
@StaticMetamodel(Fee.class)
public class Fee_ { 

    public static volatile SingularAttribute<Fee, Integer> amount;
    public static volatile SingularAttribute<Fee, Person> person;
    public static volatile SingularAttribute<Fee, Long> id;
    public static volatile SingularAttribute<Fee, Date> payDate;

}