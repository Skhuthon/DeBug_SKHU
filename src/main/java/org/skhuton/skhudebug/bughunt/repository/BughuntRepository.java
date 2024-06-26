package org.skhuton.skhudebug.bughunt.repository;

import org.skhuton.skhudebug.bughunt.domain.Bughunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BughuntRepository extends JpaRepository<Bughunt, Long> {
}
