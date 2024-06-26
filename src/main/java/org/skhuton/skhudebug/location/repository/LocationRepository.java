package org.skhuton.skhudebug.location.repository;

import org.skhuton.skhudebug.location.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
