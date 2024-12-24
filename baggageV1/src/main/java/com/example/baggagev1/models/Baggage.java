package com.example.baggagev1.models;

import com.example.baggagev1.enums.BaggageStatusEnum;
import jakarta.persistence.*;

@Entity
public class Baggage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    private double weight;

    @Enumerated(EnumType.STRING)
    private BaggageStatusEnum status;

    public Baggage() {
    }

    public Baggage(Long id, Passenger passenger, double weight, BaggageStatusEnum status) {
        this.id = id;
        this.passenger = passenger;
        this.weight = weight;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
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
        return "Baggage{" +
                "id=" + id +
                ", passenger=" + passenger +
                ", weight=" + weight +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Baggage baggage = (Baggage) o;

        if (Double.compare(baggage.weight, weight) != 0) return false;
        if (id != null ? !id.equals(baggage.id) : baggage.id != null) return false;
        if (passenger != null ? !passenger.equals(baggage.passenger) : baggage.passenger != null) return false;
        return status == baggage.status;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = passenger != null ? passenger.hashCode() : 0;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}