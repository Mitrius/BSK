package com.bsk.entities;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by Mitrius on 12.03.17.
 */
@Entity
@Data
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User implements Serializable {
    private String userLogin;
    private String userPassword;
    private Label label;
}
