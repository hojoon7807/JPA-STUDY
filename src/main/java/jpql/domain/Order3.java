package jpql.domain;

import javax.persistence.*;

@Entity
public class Order3 {
    @Id @GeneratedValue
    private Long id;
    private int orderAmount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Embedded
    private Address3 address;
}
