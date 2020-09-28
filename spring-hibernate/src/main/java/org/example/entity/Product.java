package org.example.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "Product Entity")
public class Product implements Serializable {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @ApiModelProperty(value = "Product ID")
    private Long productId;
    @Column(name = "product_name")
    @ApiModelProperty(value = "Product Name")
    private String productName;
    @Column(name = "product_desc")
    @ApiModelProperty(value = "Product Description")
    private String productDesc;

}