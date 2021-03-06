package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/*
 * Created by kelly on 5/10/2020.
 */
@Data
@Entity
@Table(name="resource")
@NamedQuery(name = "Resource.findById", query = "select name,url from Resource r where r.id=?1")
@ApiModel(value = "Resource Entity")
public class Resource implements Serializable {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(name = "date_created")
    @ApiModelProperty(value = "Date Created")
    private Date createTime;

    @Column(name = "url_name")
    @ApiModelProperty(value = "Name")
    private String name;

    @Column(name = "url")
    @ApiModelProperty(value = "URL")
    private String url;

    @Column(name = "description")
    @ApiModelProperty(value = "Description")
    private String description;

    @Column(name = "category_id")
    @ApiModelProperty(value = "Category ID")
    private Long categoryId;

    private static final long serialVersionUID = 1L;
}
