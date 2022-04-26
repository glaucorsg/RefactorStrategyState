package br.edu.ifpb.foodstore.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Calendar;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@ToString
public class LogRegister {

    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar date;

    private String message;

}
