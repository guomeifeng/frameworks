package org.example.repository;

import org.example.entity.FmResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Created by kelly on 5/10/2020.
 */

@Repository
public interface FmResourceRepository extends JpaRepository<FmResource, Long> {

}
