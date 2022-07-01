package com.inventorycontrol.repository;

import com.inventorycontrol.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    public Optional<UserModel> findByLogin(String login);
}
