package com.example.picturedemo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Collate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column()
    private String userName;
    @Lob
    @Column(length = 1000000)
    private byte[] displayPicture;


}
