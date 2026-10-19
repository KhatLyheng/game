package com.gms.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "SYS_PERMISSION", schema = "SUP")
@Data
public class PermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERM_ID")
    private Long PERM_ID;

    @Column(name = "PERM_CODE", nullable = false, unique = true, length = 100)
    private String PERM_CODE;

    @Column(name = "PERM_NAME", nullable = false, length = 150)
    private String PERM_NAME;

    @Column(name = "PERM_NAME_KH", length = 150)
    private String PERM_NAME_KH;

    @Column(name = "PERM_TYPE", length = 50)
    private String PERM_TYPE;

    @Column(name = "PERM_DESC", length = 500)
    private String PERM_DESC;

    @Column(name = "PERM_STS", nullable = false)
    private Boolean PERM_STS = true;

    @Column(name = "TR_US", length = 100)
    private String TR_US;

    @Column(name = "TR_DATE")
    private LocalDateTime TR_DATE;

    @Column(name = "LTR_US", length = 100)
    private String LTR_US;

    @Column(name = "LTR_DATE")
    private LocalDateTime LTR_DATE;
}
