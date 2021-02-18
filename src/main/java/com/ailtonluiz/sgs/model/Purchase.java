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
@Table(name = "purchase")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Purchase {


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
    @JoinColumn(name = "supplier_id", foreignKey = @ForeignKey(name = "fk_supplier_purchase"))
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_purchase"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "fk_company_purchase"))
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column(length = 12)
    private MovementSatus status = MovementSatus.BUDGET;

    @OneToMany(mappedBy = "purchase")
    private List<ItemPurchase> itemPurchases;

    @PrePersist
    @PreUpdate
    private void prePersistUpdate() {
        note = note.toUpperCase();
    }

}
