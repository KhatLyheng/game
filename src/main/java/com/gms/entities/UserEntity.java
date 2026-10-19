package com.gms.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "SYS_USER", schema = "SUP")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "US_ID")
    private Long US_ID;

    @Column(name = "USERNAME", nullable = false, unique = true, length = 100)
    private String USERNAME;

    @Column(name = "EMAIL", unique = true, length = 150)
    private String EMAIL;

    // Store a password hash, never a plain-text password.
    @Column(name = "PASSWORD", nullable = false, length = 255)
    private String PASSWORD;

    @Column(name = "F_NAME", length = 100)
    private String F_NAME;

    @Column(name = "L_NAME", length = 100)
    private String L_NAME;

    @Column(name = "US_STS", nullable = false)
    private Boolean US_STS = true;

    @Column(name = "TR_US", length = 100)
    private String TR_US;

    @Column(name = "TR_DATE")
    private LocalDateTime TR_DATE;

    @Column(name = "LTR_US", length = 100)
    private String LTR_US;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        UserEntity that = (UserEntity) o;
        return getUS_ID() != null && Objects.equals(getUS_ID(), that.getUS_ID());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Column(name = "LTR_DATE")
    private LocalDateTime LTR_DATE;
}
