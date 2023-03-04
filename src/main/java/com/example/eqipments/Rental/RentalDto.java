package com.example.eqipments.Rental;

import java.time.LocalDate;

public class RentalDto {
    private long id;
    private LocalDate start;
    private LocalDate endTime;
    private  String wyporzyczone;
    private long equipmentsId;
    private long userId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public String getWyporzyczone() {
        return wyporzyczone;
    }

    public void setWyporzyczone(String wyporzyczone) {
        this.wyporzyczone = wyporzyczone;
    }

    public long getEquipmentsId() {
        return equipmentsId;
    }

    public void setEquipmentsId(long equipmentsId) {
        this.equipmentsId = equipmentsId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
