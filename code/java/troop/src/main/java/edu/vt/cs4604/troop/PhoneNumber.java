package edu.vt.cs4604.troop;

import lombok.*;

// import java.time.LocalDate;
import javax.persistence.*;
// import java.io.*;

/*
 * NamedNativeQueries allow us to use _SQL_ queries
 * to perform complex queries against the database.
 * Alternatively NamedQueries use _JPQL_ to accomplish
 * the same thing.
 * https://en.wikipedia.org/wiki/Java_Persistence_Query_Language
 */

@NamedNativeQueries({
  @NamedNativeQuery(
    name = "PhoneNumber.activeNums", 
    query = "select * from phone_number", 
    resultClass = PhoneNumber.class
  )
})

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode

// @IdClass(PhoneNumberPK.class)
public class PhoneNumber {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id;

    private String p_number;
}
