package cz.legas.brl.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "APP_CONFIG")
public class ApplicationConfiguration {

    @Id
    @GeneratedValue(generator = Sequence.BRL, strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = Sequence.BRL, sequenceName = Sequence.BRL, allocationSize = Sequence.INCREMENT_BRL)
    @Column(name = "CFG_ID")
    private Long id;

    @Column(name = "CFG_KEY")
    private String key;

    @Column(name = "CFG_VALUE")
    private String value;
}
