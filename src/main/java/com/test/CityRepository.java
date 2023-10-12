package com.test;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    @Query("SELECT c FROM City c WHERE c.name LIKE CONCAT('%',:ending, '%') AND c.population < :num")
    List<City> findByNameEndingWithAndPopulationLessThan(@Param("ending") String ending,
                                                         @Param("num") Integer num);
}