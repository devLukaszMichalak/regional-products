package dev.lukaszmichalak.regionalproducts.product;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter(AccessLevel.PACKAGE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_type")
class ProductType {
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
}
