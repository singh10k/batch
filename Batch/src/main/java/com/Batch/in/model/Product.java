package com.Batch.in.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String productNo;
    private String plant;
    private String quantity;
    private String netValue;
    private String date;
}
