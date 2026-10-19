package com.gms.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "SYS_MENU", schema = "SUP")
@Data
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ID")
    private Long MENU_ID;

    @Column(name = "MENU_CODE", nullable = false, unique = true, length = 100)
    private String MENU_CODE;

    @Column(name = "MENU_NAME", nullable = false, length = 150)
    private String MENU_NAME;

    @Column(name = "MENU_NAME_KH", length = 150)
    private String MENU_NAME_KH;

    @Column(name = "MENU_ICON", length = 100)
    private String MENU_ICON;

    @Column(name = "MENU_PATH", length = 255)
    private String MENU_PATH;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_MENU_ID")
    private MenuEntity PARENT_MENU;

    @Column(name = "MENU_SEQ")
    private Integer MENU_SEQ;

    @Column(name = "MENU_STS", nullable = false)
    private Boolean MENU_STS = true;

    @Column(name = "TR_US", length = 100)
    private String TR_US;

    @Column(name = "TR_DATE")
    private LocalDateTime TR_DATE;

    @Column(name = "LTR_US", length = 100)
    private String LTR_US;

    @Column(name = "LTR_DATE")
    private LocalDateTime LTR_DATE;
}
