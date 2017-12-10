package org.kolokolov.springtuttorial.repository;

import org.kolokolov.springtuttorial.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Long> {}
