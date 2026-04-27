package org.messgage.messageservice.JPA;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product")
    private String product;

    @Column(name = "product")
    private Integer quantity;

    @Column(name = "date")
    private LocalDateTime createdAt;
}
