package com.ingenium.double3rental.entities;

import com.ingenium.double3rental.enums.UserType;
import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Entity representing a User.
 *
 * @author Nicholas Sendyk, 101143602
 */
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    long id;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    Collection<RentalSession> rentalSessions;
    private String username;
    private String passwordHash;
    private UserType userType;

    /**
     * Default constructor for User
     */
    public User() {
        this("Test User", new BCryptPasswordEncoder().encode("default"));
    }

    public User(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.rentalSessions = new ArrayList<RentalSession>();
        this.userType = UserType.CLIENT;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<RentalSession> getRentalSessions() {
        return rentalSessions;
    }

    public void setRentalSessions(Collection<RentalSession> surveys) {
        this.rentalSessions = surveys;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * Adds a rental session to a user
     *
     * @param rentalSession the rental session to add to the User
     * @author Nicholas Sendyk, 101143602
     */
    public void addRentalSession(RentalSession rentalSession) {
        rentalSessions.add(rentalSession);
    }

    /**
     * Adds an ArrayList of RentalSessions to the User
     *
     * @param sessionArrayList list of rental sessions to add
     * @author Nicholas Sendyk, 101143602
     */
    public void addListRentalSessions(ArrayList<RentalSession> sessionArrayList) {
        for (RentalSession s : sessionArrayList) {
            addRentalSession(s);
        }
    }

    /**
     * Get a list of all the closed sessions
     *
     * @return List - list of all closed sessions
     */
    public List<RentalSession> acquireCompletedSessions() {
        List<RentalSession> closedSessions = new ArrayList<RentalSession>();
        for (RentalSession s : this.rentalSessions) {
            if (s.getIsClosed()) {
                closedSessions.add(s);
            }
        }
        return closedSessions;
    }
}
