package com.gms.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Table(
        name = "SYS_ROLE_PERMISSION",
        schema = "SUP",
        uniqueConstraints = @UniqueConstraint(
                name = "UK_ROLE_PERMISSION",
                columnNames = {"ROLE_ID", "PERM_ID"}
        )
)
@Data
public class RolePermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RP_ID")
    private Long RP_ID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private RoleEntity ROLE;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PERM_ID", nullable = false)
    private PermissionEntity PERMISSION;

    @Column(name = "RP_STS", nullable = false)
    private Boolean RP_STS = true;

    @Column(name = "TR_US", length = 100)
    private String TR_US;

    @Column(name = "TR_DATE")
    private LocalDateTime TR_DATE;

    @Column(name = "LTR_US", length = 100)
    private String LTR_US;

    @Column(name = "LTR_DATE")
    private LocalDateTime LTR_DATE;
}