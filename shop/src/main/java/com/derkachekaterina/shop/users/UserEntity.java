package com.derkachekaterina.shop.users;


import com.derkachekaterina.shop.orders.OrderEntity;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity//Указывает, что данный бин (класс) является сущностью.
@Getter
@Setter
@ToString
@RequiredArgsConstructor//генерирует конструктор, принимающий значения для каждого final поля или поля с аннотацией @NonNull
@Table(name = "USERINFO")//указывает на имя таблицы, которая будет отображаться в этой сущности.
public class UserEntity {
    @Setter(AccessLevel.NONE)
    private @Id//id колонки
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "number",nullable = false,unique = true)//указывает на имя колонки, которая отображается в свойство сущности.
    @NaturalId(mutable = true)
    private String number;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "name")
    private String name;

    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @OneToMany(mappedBy = "user" ,fetch = FetchType.LAZY,orphanRemoval = false)
    private List<OrderEntity> orders = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserEntity that = (UserEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}