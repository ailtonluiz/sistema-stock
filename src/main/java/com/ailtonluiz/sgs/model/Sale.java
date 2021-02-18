package com.ailtonluiz.sgs.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sale")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Sale {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "total_value")
    private BigDecimal totalValue = BigDecimal.ZERO;

    private String note;

    @ManyToOne
    @JoinColumn(name = "client_id", foreignKey = @ForeignKey(name = "fk_client_sale"))
    private Client client;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_sale"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "fk_company_sale"))
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column(length = 12)
    private MovementSatus status = MovementSatus.BUDGET;

    @OneToMany(mappedBy = "sale")
    private List<ItemSale> itemSales;

    @PrePersist
    @PreUpdate
    private void prePersistUpdate() {
        note = note.toUpperCase();
    }

}
