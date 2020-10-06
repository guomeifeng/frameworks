package org.example.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name="fm_user_role_relation")
public class FmAdminRoleRelation implements Serializable {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "roleId")
    private Long roleId;

    private static final long serialVersionUID = 1L;


}