package com.sinoduck.db.repository;

import com.sinoduck.db.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author where.liu
 */
@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findAllByDistrictCode(String districtCode);
}
