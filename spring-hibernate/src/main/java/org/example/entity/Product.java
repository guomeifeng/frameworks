package org.example.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax. persistence. *;
import java.io.Serializable;
import org.hibernate.annotations.GenericGenerator;

@Data
@ToString
@Entity
@Table(name="product")
@NamedQuery(name = "Product.findByProductId", query = "select productName,productDesc from Product p where p.productId=?1")
public class Product implements Serializable {
    @Id
//    @GeneratedValue(generator = "native")
//    @GenericGenerator(name = "native", strategy = "native")
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_desc")
    private String productDesc;

}