package cz.legas.brl.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@Table(name = "PLAYER")
public class Player {

    @Id
    @GeneratedValue(generator = Sequence.BRL, strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = Sequence.BRL, sequenceName = Sequence.BRL, allocationSize = Sequence.INCREMENT_BRL)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", unique = true)
    @NotNull
    String name;

    @Column(name = "ALIVE")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean alive;

    @Column(name = "LATITUDE")
    double latitude;

    @Column(name = "LONGITUDE")
    double longitude;

}
