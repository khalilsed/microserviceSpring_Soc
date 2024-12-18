package org.example;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class FlightService {

    // Web method to get all flights
    @WebMethod
    public List<Flight> getAllFlights() {
        FlightDAO flightDAO = new FlightDAO();
        return flightDAO.getAllFlights();
    }

    // Web method to get a flight by ID
    @WebMethod
    public Flight getFlightById(@WebParam(name = "flightId") long id) {
        FlightDAO flightDAO = new FlightDAO();
        return flightDAO.getFlightById(id);
    }

    // Web method to add a new flight
    @WebMethod
    public Flight addFlight(@WebParam(name = "flight") Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight object is null.");
        }
        FlightDAO flightDAO = new FlightDAO();
        return flightDAO.addFlight(flight);
    }

    @WebMethod
    public Flight updateFlight(@WebParam(name = "flightId") long id, Flight updatedFlight) {
        FlightDAO flightDAO = new FlightDAO();
        return flightDAO.updateFlight(id, updatedFlight);
    }

    // Web method to delete a flight by ID
    @WebMethod
    public Flight deleteFlight(@WebParam(name = "flightId") long id) {
        FlightDAO flightDAO = new FlightDAO();
        return flightDAO.deleteFlight(id);
    }

    // Web method to get flights by origin and destination
    @WebMethod
    public List<Flight> getFlightsByOriginDest(@WebParam(name = "origin") String origin, @WebParam(name = "destination") String dest) {
        FlightDAO flightDAO = new FlightDAO();
        return flightDAO.getFlightsByOriginDest(origin, dest);
    }

    // Web method to get flights within a specific month range
    @WebMethod
    public List<Flight> getFlightsByMonthRange(@WebParam(name = "startMonth") int startMonth, @WebParam(name = "endMonth") int endMonth) {
        FlightDAO flightDAO = new FlightDAO();
        return flightDAO.getFlightsByMonthRange(startMonth, endMonth);
    }

    @WebMethod
    public List<Flight> getFlightsByDelayThreshold(@WebParam(name = "delayThreshold") int delayThreshold) {
        FlightDAO flightDAO = new FlightDAO();
        return flightDAO.getFlightsByDelayThreshold(delayThreshold);
    }

    @WebMethod
    public int countFlightsByDestination(@WebParam(name = "destination") String dest) {
        FlightDAO flightDAO = new FlightDAO();
        return flightDAO.countFlightsByDestination(dest);
    }

    @WebMethod
    public double getAverageDelay(@WebParam(name = "origin") String origin, @WebParam(name = "destination") String dest) {
        FlightDAO flightDAO = new FlightDAO();
        return flightDAO.getAverageDelay(origin, dest);
    }

    @WebMethod
    public List<Flight> getFlightsByThreshold(@WebParam(name = "airTimeThreshold") int airTimeThreshold, @WebParam(name = "distanceThreshold") int distanceThreshold) {
        FlightDAO flightDAO = new FlightDAO();
        return flightDAO.getFlightsByThreshold(airTimeThreshold, distanceThreshold);
    }

    @WebMethod
    public MonthlyReport getMonthlyReport(@WebParam(name = "year") int year, @WebParam(name = "month") int month) {
        FlightDAO flightDAO = new FlightDAO();
        return flightDAO.getMonthlyReport(year, month);
    }


}