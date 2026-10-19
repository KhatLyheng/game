package com.gms.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "SYS_MENU_PERMISSION",
        schema = "SUP",
        uniqueConstraints = @UniqueConstraint(
                name = "UK_MENU_PERMISSION",
                columnNames = {"MENU_ID", "PERM_ID"}
        )
)
@Data
public class MenuPermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MP_ID")
    private Long MP_ID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MENU_ID", nullable = false)
    private MenuEntity MENU;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PERM_ID", nullable = false)
    private PermissionEntity PERMISSION;

    @Column(name = "MP_STS", nullable = false)
    private Boolean MP_STS = true;

    @Column(name = "TR_US", length = 100)
    private String TR_US;

    @Column(name = "TR_DATE")
    private LocalDateTime TR_DATE;

    @Column(name = "LTR_US", length = 100)
    private String LTR_US;

    @Column(name = "LTR_DATE")
    private LocalDateTime LTR_DATE;
}
