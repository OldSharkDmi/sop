package com.example.baggagev1.dtos;

import com.example.baggagev1.enums.BaggageStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BaggageDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("passenger_id")
    private Long passengerId;

    @JsonProperty("weight")
    private double weight;

    @JsonProperty("status")
    private BaggageStatusEnum status;

    public BaggageDTO(Long id, Long passengerId, double weight, BaggageStatusEnum status) {
        this.id = id;
        this.weight = weight;
        this.status = status;
        this.passengerId = passengerId;
    }

    public BaggageDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public BaggageStatusEnum getStatus() {
        return status;
    }

    public void setStatus(BaggageStatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BaggageDTO{" +
                "id=" + id +
                ", passengerId=" + passengerId +
                ", weight=" + weight +
                ", status=" + status +
                '}';
    }
}