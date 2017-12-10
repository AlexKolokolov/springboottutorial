package org.kolokolov.springtuttorial.repository;

import org.kolokolov.springtuttorial.model.StudGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<StudGroup,Long> {}
