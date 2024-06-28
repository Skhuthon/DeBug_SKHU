package org.skhuton.skhudebug.bughunt.repository;

import org.skhuton.skhudebug.bughunt.domain.Bughunt;
import org.skhuton.skhudebug.member.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BughuntRepository extends JpaRepository<Bughunt, Long> {
    List<Bughunt> findByLatitudeBetweenAndLongitudeBetween(BigDecimal minLat, BigDecimal maxLat, BigDecimal minLng, BigDecimal maxLng);

    Bughunt findByUser(User user);

    Optional<Bughunt> findByUserLoginId(String loginId);
}
