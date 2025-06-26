package com.D33.CURDOpration.repository;

import com.D33.CURDOpration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepo extends JpaRepository<User,Long> {
}
