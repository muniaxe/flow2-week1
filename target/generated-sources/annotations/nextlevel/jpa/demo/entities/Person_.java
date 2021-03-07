package nextlevel.jpa.demo.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import nextlevel.jpa.demo.entities.Address;
import nextlevel.jpa.demo.entities.Fee;
import nextlevel.jpa.demo.entities.SwimStyle;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-05T12:44:43")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile ListAttribute<Person, Fee> fees;
    public static volatile SingularAttribute<Person, Address> address;
    public static volatile SingularAttribute<Person, Integer> year;
    public static volatile SingularAttribute<Person, String> name;
    public static volatile ListAttribute<Person, SwimStyle> styles;
    public static volatile SingularAttribute<Person, Long> p_id;

}