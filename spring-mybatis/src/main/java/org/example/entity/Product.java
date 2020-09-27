package org.example.entity;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Data @ToString
public class Product implements Serializable {

    private Long productId;

    private String productName;

    private String productDesc;

}