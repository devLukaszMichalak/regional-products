package dev.lukaszmichalak.regionalproducts.product;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter(AccessLevel.PACKAGE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
class Product {
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_type_id", nullable = false)
    private ProductType productType;
    
    @Column(name = "voivodeship_id", nullable = false)
    private Integer voivodeshipId;
    
    @Column(name = "date_of_entry", nullable = false)
    private LocalDate dateOfEntry;
    
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
}
