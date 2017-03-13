package com.bsk.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by Mitrius on 12.03.17.
 */
@Entity
@Getter
@Setter
public class Label {

    private int labelId;
    private String userLogin;
    private List<String> tables; //Do jakich tablic ma dostep uzytkownik

}
