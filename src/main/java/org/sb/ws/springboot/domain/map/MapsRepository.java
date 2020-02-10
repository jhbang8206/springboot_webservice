package org.sb.ws.springboot.domain.map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MapsRepository extends JpaRepository<Maps, Long> {
    @Query("SELECT p FROM Maps p ORDER BY p.id DESC")
    List<Maps> findAllDesc();
}
