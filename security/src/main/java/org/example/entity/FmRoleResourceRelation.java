package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name="fm_role_resource_relation")
//@NamedQuery(name = "Resource.findById", query = "select name,url from Resource r where r.id=?1")
@ApiModel(value = "Role Resource Relation Entity")
public class FmRoleResourceRelation implements Serializable {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(name = "roleId")
    @ApiModelProperty(value = "Role ID")
    private Long roleId;

    @Column(name = "resourceId")
    @ApiModelProperty(value = "Resource ID")
    private Long resourceId;

    private static final long serialVersionUID = 1L;


}