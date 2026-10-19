package com.gms.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "SYS_USER_ROLE",
        schema = "SUP",
        uniqueConstraints = @UniqueConstraint(
                name = "UK_USER_ROLE",
                columnNames = {"US_ID", "ROLE_ID"}
        )
)
@Data
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UR_ID")
    private Long UR_ID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "US_ID", nullable = false)
    private UserEntity USER;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private RoleEntity ROLE;

    @Column(name = "UR_STS", nullable = false)
    private Boolean UR_STS = true;

    @Column(name = "TR_US", length = 100)
    private String TR_US;

    @Column(name = "TR_DATE")
    private LocalDateTime TR_DATE;

    @Column(name = "LTR_US", length = 100)
    private String LTR_US;

    @Column(name = "LTR_DATE")
    private LocalDateTime LTR_DATE;
}
