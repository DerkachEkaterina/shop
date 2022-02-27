package com.derkachekaterina.shop.goods;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


@Entity //Указывает, что данный бин (класс) является сущностью.
@Getter
@Setter(AccessLevel.PROTECTED)
@ToString
@RequiredArgsConstructor//генерирует конструктор, принимающий значения для каждого final поля или поля с аннотацией @NonNull
@Table(name = "CAKE")//указывает на имя таблицы, которая будет отображаться в этой сущности.
public class CakeEntity {

    @Setter(AccessLevel.NONE)
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    //id колонки

    @Column(name = "name")//указывает на имя колонки, которая отображается в свойство сущности.
    private String name;

    private BigDecimal calories;

    private String image;

    private BigDecimal price;

    private BigDecimal weight;

    private String compositions;

    private String storageConditions;

    private String shelfLife;

    private AvailabilityOfCake availabilityOfCake;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CakeEntity that = (CakeEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}