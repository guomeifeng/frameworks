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
@Table(name="resource")
@NamedQuery(name = "FmResource.findById", query = "select name,url from FmResource r where r.id=?1")
@ApiModel(value = "Resource Entity")
public class FmResource implements Serializable {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(name = "date_created")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @Column(name = "url_name")
    @ApiModelProperty(value = "资源名称")
    private String name;

    @Column(name = "url")
    @ApiModelProperty(value = "资源URL")
    private String url;

    @Column(name = "description")
    @ApiModelProperty(value = "描述")
    private String description;

    @Column(name = "category_id")
    @ApiModelProperty(value = "资源分类ID")
    private Long categoryId;

    private static final long serialVersionUID = 1L;
}
