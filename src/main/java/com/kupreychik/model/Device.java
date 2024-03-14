package com.kupreychik.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "installation_date") // это sql
    private LocalDate installationDate; // филд в моем обекте

    @Column(name = "device_code", unique = true) // это sql + constraint
    private String deviceCode;  // филд в моем обекте

    @Column(name = "connections_amount", nullable = false) // это sql + constraint
    private int connectionAmount;// филд в моем обекте

    public Device() {
    }

    public Device(String name, LocalDate installationDate, String deviceCode, int connectionAmount) {
        this.name = name;
        this.installationDate = installationDate;
        this.deviceCode = deviceCode;
        this.connectionAmount = connectionAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(LocalDate installationDate) {
        this.installationDate = installationDate;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public int getConnectionAmount() {
        return connectionAmount;
    }

    public void setConnectionAmount(int connectionAmount) {
        this.connectionAmount = connectionAmount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Device{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", installationDate=").append(installationDate);
        sb.append(", deviceCode='").append(deviceCode).append('\'');
        sb.append(", connectionAmount=").append(connectionAmount);
        sb.append('}');
        return sb.toString();
    }
}

