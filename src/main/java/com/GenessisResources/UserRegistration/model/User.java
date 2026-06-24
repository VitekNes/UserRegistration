package com.GenessisResources.UserRegistration.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User extends UserSimple{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String PersonID;
    private UUID uuid;

    public User() {
    }

    public User(String personID, UUID uuid) {
        PersonID = personID;
        this.uuid = uuid;
    }

    public String getPersonID() {
        return PersonID;
    }

    public void setPersonID(String personID) {
        PersonID = personID;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
