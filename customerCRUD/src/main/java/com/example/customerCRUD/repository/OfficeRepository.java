package com.example.customerCRUD.repository;

import com.example.customerCRUD.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface OfficeRepository extends JpaRepository<Office, Integer> {

    @Query("SELECT o FROM Office o WHERE o.city = :city")
    List<Office> findByCity(@Param("city") String city);

    @Query("SELECT o FROM Office o WHERE o.country = :country")
    List<Office> findByCountry(@Param("country") String country);
}
