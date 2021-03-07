package nextlevel.jpa.demo.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import nextlevel.jpa.demo.entities.Person;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-05T12:44:43")
@StaticMetamodel(SwimStyle.class)
public class SwimStyle_ { 

    public static volatile ListAttribute<SwimStyle, Person> persons;
    public static volatile SingularAttribute<SwimStyle, Long> id;
    public static volatile SingularAttribute<SwimStyle, String> styleName;

}