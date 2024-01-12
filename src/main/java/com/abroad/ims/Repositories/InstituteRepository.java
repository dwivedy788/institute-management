package com.abroad.ims.Repositories;

import com.abroad.ims.Entity.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepository extends JpaRepository<Institute,Long> {
}
