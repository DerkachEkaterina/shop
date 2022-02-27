package com.derkachekaterina.shop.orders;

import com.derkachekaterina.shop.users.UserEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity// Указывает, что данный бин (класс) является сущностью.
@Getter
@Setter
@ToString
@RequiredArgsConstructor//генерирует конструктор, принимающий значения для каждого final поля или поля с аннотацией @NonNull
@Table(name = "ORDERINFO")//указывает на имя таблицы, которая будет отображаться в этой сущности.
public class OrderEntity {
    @Setter(AccessLevel.NONE)
    private @Id//id колонки
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;//указывает, что данное свойство будет
    // создаваться согласно указанной стратегии.

    @Setter(AccessLevel.PROTECTED)
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)//создать столбец
    private UserEntity user;

    @Setter(AccessLevel.PROTECTED)
    @ToString.Exclude
    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY,orphanRemoval = true,cascade = CascadeType.ALL)
    private List<PurchaseEntity> purchases;

    @Setter(AccessLevel.PROTECTED)
    private DeliveryMethod deliveryMethod;

    @Setter(AccessLevel.PROTECTED)
    private OrderStatus orderStatus;

    @Setter(AccessLevel.PROTECTED)
    private PaymentMethod paymentMethod;

    @Setter(AccessLevel.PROTECTED)
    private String address;

    @Setter(AccessLevel.PROTECTED)
    private LocalDateTime time;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderEntity that = (OrderEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}