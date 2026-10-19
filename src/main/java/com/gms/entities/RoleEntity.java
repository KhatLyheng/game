package com.gms.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "SYS_ROLE", schema = "SUP")
@Data
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Long ROLE_ID;

    @Column(name = "ROLE_CODE", nullable = false, unique = true, length = 50)
    private String ROLE_CODE;

    @Column(name = "ROLE_NAME", nullable = false, length = 100)
    private String ROLE_NAME;

    @Column(name = "ROLE_NAME_KH", length = 150)
    private String ROLE_NAME_KH;

    @Column(name = "ROLE_DESC", length = 500)
    private String ROLE_DESC;

    @Column(name = "ROLE_STS", nullable = false)
    private Boolean ROLE_STS = true;

    @Column(name = "TR_US", length = 100)
    private String TR_US;

    @Column(name = "TR_DATE")
    private LocalDateTime TR_DATE;

    @Column(name = "LTR_US", length = 100)
    private String LTR_US;

    @Column(name = "LTR_DATE")
    private LocalDateTime LTR_DATE;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        RoleEntity that = (RoleEntity) o;
        return getROLE_ID() != null && Objects.equals(getROLE_ID(), that.getROLE_ID());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
