package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/csv_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    // Method to get all flights
    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM flights";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setId(resultSet.getLong("id"));
                flight.setYear(resultSet.getInt("year"));
                flight.setMonth(resultSet.getInt("month"));
                flight.setDay(resultSet.getInt("day"));
                flight.setDepDelay(resultSet.getInt("dep_delay"));
                flight.setArrDelay(resultSet.getInt("arr_delay"));
                flight.setOrigin(resultSet.getString("origin"));
                flight.setDest(resultSet.getString("dest"));
                flight.setAirTime(resultSet.getInt("air_time"));
                flight.setDistance(resultSet.getInt("distance"));
                flight.setHour(resultSet.getInt("hour"));
                flight.setMinute(resultSet.getInt("minute"));
                flight.setName(resultSet.getString("name"));

                flights.add(flight);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flights;
    }

    // Method to get a flight by ID
    public Flight getFlightById(long id) {
        Flight flight = null;
        String query = "SELECT * FROM flights WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    flight = new Flight();
                    flight.setId(resultSet.getLong("id"));
                    flight.setYear(resultSet.getInt("year"));
                    flight.setMonth(resultSet.getInt("month"));
                    flight.setDay(resultSet.getInt("day"));
                    flight.setDepDelay(resultSet.getInt("dep_delay"));
                    flight.setArrDelay(resultSet.getInt("arr_delay"));
                    flight.setOrigin(resultSet.getString("origin"));
                    flight.setDest(resultSet.getString("dest"));
                    flight.setAirTime(resultSet.getInt("air_time"));
                    flight.setDistance(resultSet.getInt("distance"));
                    flight.setHour(resultSet.getInt("hour"));
                    flight.setMinute(resultSet.getInt("minute"));
                    flight.setName(resultSet.getString("name"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flight;
    }



    // Method to add a new flight
    public Flight addFlight(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight object is null.");
        }

        String query = "INSERT INTO flights (year, month, day, dep_delay, arr_delay, origin, dest, air_time, distance, hour, minute, name) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            if (connection == null) {
                throw new SQLException("Failed to establish a database connection.");
            }

            preparedStatement.setInt(1, flight.getYear());
            preparedStatement.setInt(2, flight.getMonth());
            preparedStatement.setInt(3, flight.getDay());
            preparedStatement.setInt(4, flight.getDepDelay());
            preparedStatement.setInt(5, flight.getArrDelay());
            preparedStatement.setString(6, flight.getOrigin());
            preparedStatement.setString(7, flight.getDest());
            preparedStatement.setInt(8, flight.getAirTime());
            preparedStatement.setInt(9, flight.getDistance());
            preparedStatement.setInt(10, flight.getHour());
            preparedStatement.setInt(11, flight.getMinute());
            preparedStatement.setString(12, flight.getName());

            preparedStatement.executeUpdate();
            System.out.println("Flight details: " + flight);
            return flight;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Flight updateFlight(long id, Flight updatedFlight) {
        String query = "UPDATE flights SET year = ?, month = ?, day = ?, dep_delay = ?, arr_delay = ?, origin = ?, dest = ?, air_time = ?, distance = ?, hour = ?, minute = ?, name = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, updatedFlight.getYear());
            preparedStatement.setInt(2, updatedFlight.getMonth());
            preparedStatement.setInt(3, updatedFlight.getDay());
            preparedStatement.setInt(4, updatedFlight.getDepDelay());
            preparedStatement.setInt(5, updatedFlight.getArrDelay());
            preparedStatement.setString(6, updatedFlight.getOrigin());
            preparedStatement.setString(7, updatedFlight.getDest());
            preparedStatement.setInt(8, updatedFlight.getAirTime());
            preparedStatement.setInt(9, updatedFlight.getDistance());
            preparedStatement.setInt(10, updatedFlight.getHour());
            preparedStatement.setInt(11, updatedFlight.getMinute());
            preparedStatement.setString(12, updatedFlight.getName());
            preparedStatement.setLong(13, id);

            preparedStatement.executeUpdate();
            return updatedFlight;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    // Method to delete a flight by ID
    public Flight deleteFlight(long id) {
        Flight flight = getFlightById(id);
        String query = "DELETE FROM flights WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            return flight;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    // Method to get flights by origin and destination
    public List<Flight> getFlightsByOriginDest(String origin, String dest) {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM flights WHERE origin = ? AND dest = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, origin);
            preparedStatement.setString(2, dest);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Flight flight = new Flight();
                    flight.setId(resultSet.getLong("id"));
                    flight.setYear(resultSet.getInt("year"));
                    flight.setMonth(resultSet.getInt("month"));
                    flight.setDay(resultSet.getInt("day"));
                    flight.setDepDelay(resultSet.getInt("dep_delay"));
                    flight.setArrDelay(resultSet.getInt("arr_delay"));
                    flight.setOrigin(resultSet.getString("origin"));
                    flight.setDest(resultSet.getString("dest"));
                    flight.setAirTime(resultSet.getInt("air_time"));
                    flight.setDistance(resultSet.getInt("distance"));
                    flight.setHour(resultSet.getInt("hour"));
                    flight.setMinute(resultSet.getInt("minute"));
                    flight.setName(resultSet.getString("name"));

                    flights.add(flight);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }


    // Method to get flights within a specific month range
    public List<Flight> getFlightsByMonthRange(int startMonth, int endMonth) {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM flights WHERE month BETWEEN ? AND ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, startMonth);
            preparedStatement.setInt(2, endMonth);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Flight flight = new Flight();
                    flight.setId(resultSet.getLong("id"));
                    flight.setYear(resultSet.getInt("year"));
                    flight.setMonth(resultSet.getInt("month"));
                    flight.setDay(resultSet.getInt("day"));
                    flight.setDepDelay(resultSet.getInt("dep_delay"));
                    flight.setArrDelay(resultSet.getInt("arr_delay"));
                    flight.setOrigin(resultSet.getString("origin"));
                    flight.setDest(resultSet.getString("dest"));
                    flight.setAirTime(resultSet.getInt("air_time"));
                    flight.setDistance(resultSet.getInt("distance"));
                    flight.setHour(resultSet.getInt("hour"));
                    flight.setMinute(resultSet.getInt("minute"));
                    flight.setName(resultSet.getString("name"));

                    flights.add(flight);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    public List<Flight> getFlightsByDelayThreshold(int delayThreshold) {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM flights WHERE dep_delay > ? OR arr_delay > ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, delayThreshold);
            preparedStatement.setInt(2, delayThreshold);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Flight flight = new Flight();
                    flight.setId(resultSet.getLong("id"));
                    flight.setYear(resultSet.getInt("year"));
                    flight.setMonth(resultSet.getInt("month"));
                    flight.setDay(resultSet.getInt("day"));
                    flight.setDepDelay(resultSet.getInt("dep_delay"));
                    flight.setArrDelay(resultSet.getInt("arr_delay"));
                    flight.setOrigin(resultSet.getString("origin"));
                    flight.setDest(resultSet.getString("dest"));
                    flight.setAirTime(resultSet.getInt("air_time"));
                    flight.setDistance(resultSet.getInt("distance"));
                    flight.setHour(resultSet.getInt("hour"));
                    flight.setMinute(resultSet.getInt("minute"));
                    flight.setName(resultSet.getString("name"));
                    flights.add(flight);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }

    public int countFlightsByDestination(String dest) {
        int count = 0;
        String query = "SELECT COUNT(*) AS flight_count FROM flights WHERE dest = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, dest);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    count = resultSet.getInt("flight_count");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public double getAverageDelay(String origin, String dest) {
        String query = "SELECT AVG(arr_delay) as avg_delay FROM flights WHERE origin = ? AND dest = ?";
        double avgDelay = 0;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, origin);
            preparedStatement.setString(2, dest);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    avgDelay = resultSet.getDouble("avg_delay");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return avgDelay;
    }

    public List<Flight> getFlightsByThreshold(int airTimeThreshold, int distanceThreshold) {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM flights WHERE air_time > ? OR distance > ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, airTimeThreshold);
            preparedStatement.setInt(2, distanceThreshold);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Flight flight = new Flight();
                    flight.setId(resultSet.getLong("id"));
                    flight.setYear(resultSet.getInt("year"));
                    flight.setMonth(resultSet.getInt("month"));
                    flight.setDay(resultSet.getInt("day"));
                    flight.setDepDelay(resultSet.getInt("dep_delay"));
                    flight.setArrDelay(resultSet.getInt("arr_delay"));
                    flight.setOrigin(resultSet.getString("origin"));
                    flight.setDest(resultSet.getString("dest"));
                    flight.setAirTime(resultSet.getInt("air_time"));
                    flight.setDistance(resultSet.getInt("distance"));
                    flight.setHour(resultSet.getInt("hour"));
                    flight.setMinute(resultSet.getInt("minute"));
                    flight.setName(resultSet.getString("name"));
                    flights.add(flight);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    public MonthlyReport getMonthlyReport(int year, int month) {
        String query = "SELECT COUNT(*) as total_flights, AVG(dep_delay) as avg_dep_delay, " +
                "AVG(arr_delay) as avg_arr_delay, SUM(distance) as total_distance " +
                "FROM flights WHERE year = ? AND month = ?";
        MonthlyReport report = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, year);
            preparedStatement.setInt(2, month);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    report = new MonthlyReport();
                    report.setTotalFlights(resultSet.getInt("total_flights"));
                    report.setAvgDepDelay(resultSet.getDouble("avg_dep_delay"));
                    report.setAvgArrDelay(resultSet.getDouble("avg_arr_delay"));
                    report.setTotalDistance(resultSet.getInt("total_distance"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return report;
    }



    // Method to establish a connection to the database
    private Connection getConnection() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}