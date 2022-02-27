package com.derkachekaterina.shop.orders;

import com.derkachekaterina.shop.goods.CakeEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity//Указывает, что данный бин (класс) является сущностью.
@Getter
@Setter
@ToString
@RequiredArgsConstructor//генерирует конструктор, принимающий значения для каждого final поля или поля с аннотацией @NonNull
@Table(name = "PURCHASE")//указывает на имя таблицы, которая будет отображаться в этой сущности.
public class PurchaseEntity {
    @Setter(AccessLevel.NONE)
    private @Id//id колонки
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Setter(AccessLevel.PROTECTED)
    @ManyToOne (fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(nullable = false)//создать столбец
    private CakeEntity cake;

    @Setter(AccessLevel.PROTECTED)
    @ManyToOne (fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private OrderEntity order;

    @Setter(AccessLevel.PROTECTED)
    private Integer number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PurchaseEntity that = (PurchaseEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}