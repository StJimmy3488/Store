package com.example.store.order_settings;

import com.example.store.order_item.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_settings")
public class OrderSettings {

    public enum OrderStatus {NEW, CHECKOUT, PAID, FAILED, SHIPPED, DELIVERED, RETURNED, COMPLETED}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_settings_id", nullable = false)
    private Long OrderSettingsId;

    @Column(name = "user_id", nullable = false)
    private Integer orderUserID;

    @Column(name = "session_id", nullable = false)
    private Integer orderSessionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    @Column(name = "sub_total", nullable = false)
    private Double OrderSubTotal;

    @Column(name = "vat")
    private Double orderVat;

    @Column(name = "shipping")
    private Double orderShipping;

    @Column(name = "total")
    private Double orderTotal;

    @Column(name = "created_at")
    private LocalDate orderCreatedAt;

    @OneToMany
    @JoinColumn(name = "order_settings_id")
    private List<OrderItem> orderItems = new ArrayList<>();

}
