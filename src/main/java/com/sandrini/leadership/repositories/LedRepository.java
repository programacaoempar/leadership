package com.sandrini.leadership.repositories;

import com.sandrini.leadership.domains.Led;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedRepository extends CrudRepository<Led, Long> {
}
