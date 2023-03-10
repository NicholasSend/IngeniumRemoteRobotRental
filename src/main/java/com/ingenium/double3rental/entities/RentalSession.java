package com.ingenium.double3rental.entities;

import jakarta.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

/**
 * Entity representing a Rental Session.
 *
 * @author Nicholas Sendyk, 101143602
 */
@Entity
public class RentalSession {

    private static final Logger logger = LogManager.getLogger(RentalSession.class);
    @Id
    @GeneratedValue
    long id;
    private boolean isClosed;
    private Date startDate;
    private Date endDate;

    /**
     * Default constructor for Survey
     */
    public RentalSession() {
        this(0, 0);
    }

    public RentalSession(int hoursDuration, int minutesDuration) {
        this.startDate = new Date();
        this.endDate = new Date(startDate.getYear(), startDate.getMonth(), startDate.getDate(), startDate.getHours() + hoursDuration, startDate.getMinutes() + minutesDuration);
        this.isClosed = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean closed) {
        isClosed = closed;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
