package com.Back.Reto1Ciclo4.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author Home
 */
@Entity
@Data  //<-- Para lombok cree los metodos get y set de manera automatica
@RequiredArgsConstructor
@NoArgsConstructor
@Table (name="user", indexes = @Index( name="indx_email", columnList="user_email", unique=true)) //<--Para que el valor del email sea unico
public class User implements Serializable{  //<-- Implementen de la interfaz serializable  
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //<-- Convierte en autoincremental
    private Integer id;
    
    @NonNull
    @Column(name="user_email", nullable=false, length=50)
    private String email;
    
    @NonNull
    @Column(name="user_name", nullable=false, length=50)
    private String password; 
    
    @NonNull
    @Column(name="user_password", nullable=false, length=80)
    private String name;
}
