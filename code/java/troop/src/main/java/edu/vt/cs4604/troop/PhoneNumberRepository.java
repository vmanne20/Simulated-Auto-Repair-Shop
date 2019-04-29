package edu.vt.cs4604.troop;

// import java.sql.Timestamp;
import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;

@RepositoryRestResource
interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
  /**
   * Finds active customers
   * @return  A list of customers.
   */
  @Query(nativeQuery = true)
  public List<PhoneNumber> activeNums(@Param("days")String days);

  public List<PhoneNumber> findByCustomerId(Long c_id);
}
