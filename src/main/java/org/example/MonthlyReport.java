package org.example;

import lombok.Data;

@Data
public class MonthlyReport {
    private int totalFlights;
    private double avgDepDelay;
    private double avgArrDelay;
    private int totalDistance;
}
