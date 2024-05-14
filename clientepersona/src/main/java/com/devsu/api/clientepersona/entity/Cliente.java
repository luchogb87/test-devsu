package com.devsu.api.clientepersona.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="clientes")
public class Cliente extends Persona {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String contrasena;
    private String estado;
}
