package com.example.New.demo.Reository;

import com.example.New.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReo extends JpaRepository<User,Long> {
}
