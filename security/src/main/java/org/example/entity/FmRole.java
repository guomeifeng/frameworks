package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/*
 * Created by kelly on 6/10/2020.
 */
@Data
@Entity
@Table(name="role")
//@NamedQuery(name = "Resource.findById", query = "select name,url from Resource r where r.id=?1")
@ApiModel(value = "Role Entity")
public class FmRole {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(name = "name")
    @ApiModelProperty(value = "Name")
    private String name;

    @Column(name = "description")
    @ApiModelProperty(value = "Description")
    private String description;

    @Column(name = "adminCount")
    @ApiModelProperty(value = "后台用户数量")
    private Integer adminCount;

    @Column(name = "createTime")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @Column(name = "status")
    @ApiModelProperty(value = "启用状态：0->禁用；1->启用")
    private Integer status;

    @Column(name = "sort")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}
