package com.example.para22;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BD {
    private static final String URL = "jdbc:mysql://localhost/eventscontrol";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public String pomoshProverke() {
        Connection connection = null;
        String name = null;
        try {
            connection=openConnection();
            String q = "SELECT event_name FROM events";
            PreparedStatement statement = connection.prepareStatement(q);
            ResultSet r = statement.executeQuery();
            while (r.next()) {
                name = r.getString("event_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return name;
    }
    public void addEvent(String name,int id_member, int id_sponsor)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "INSERT INTO events (event_name, member_id, sponsor_id) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2,id_member);
            statement.setInt(3, id_sponsor);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Событие добавлено", "Событие добавлено", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public List<Events> getEvents() {
        List<Events> events = new ArrayList<>();
        String query = "SELECT * FROM events ORDER BY event_name ASC";
        Connection connection = null;
        try {
            connection = openConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String event = rs.getString("event_name");
                events.add(new Events(rs.getInt("id_event"), event));
            }
        } catch (Exception e) {
            e.printStackTrace(); }
        finally {
            closeConnection(connection); }
        return events;
    }
    public void addLocation(String name,int id_event)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "INSERT INTO locations (location_name, event_id) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2,id_event);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Место добавлено", "Место добавлено", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public List<Locations> getLocations() {
        List<Locations> locations = new ArrayList<>();
        String query = "SELECT * FROM locations ORDER BY location_name ASC";
        Connection connection = null;
        try {
            connection = openConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String fullName = rs.getString("location_name");
                locations.add(new Locations(rs.getInt("id_location"), fullName));
            }
        } catch (Exception e) {
            e.printStackTrace(); }
        finally {
            closeConnection(connection); }
        return locations;
    }
    public void addMember(String surname,String name,String lastname)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "INSERT INTO members (member_surname, member_name, member_lastname) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,surname);
            statement.setString(2,name);
            statement.setString(3,lastname);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Участник добавлен", "Участник добавлен", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public List<Members> getMembers() {
        List<Members> members = new ArrayList<>();
        String query = "SELECT * FROM members ORDER BY member_surname ASC";
        Connection connection = null;
        try {
            connection = openConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String fullName = rs.getString("member_surname") + " " +
                        rs.getString("member_name") + " " +
                        rs.getString("member_lastname");
                members.add(new Members(rs.getInt("id_member"), fullName));
            }
        } catch (Exception e) {
            e.printStackTrace(); }
        finally {
            closeConnection(connection); }
        return members;
    }
    public void addSponsor(String name,int how_much)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "INSERT INTO sponsors (sponsor_name, how_much) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2,how_much);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Спонсор добавлен", "Спонсор добавлен", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public List<Sponsors> getSponsors() {
        List<Sponsors> sponsors = new ArrayList<>();
        String query = "SELECT * FROM sponsors ORDER BY sponsor_name ASC";
        Connection connection = null;
        try {
            connection = openConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String fullName = rs.getString("sponsor_name");
                sponsors.add(new Sponsors(rs.getInt("id_sponsor"), fullName));
            }
        } catch (Exception e) {
            e.printStackTrace(); }
        finally {
            closeConnection(connection); }
        return sponsors;
    }
    public void addTickets(String name,int id_event)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "INSERT INTO tickets (ticket_owner, event_id) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2,id_event);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Билет добавлен", "Билет добавлен", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public List<Tickets> getTicket() {
        List<Tickets> tickets = new ArrayList<>();
        String query = "SELECT * FROM ORDER BY ticket_owner ASC";
        Connection connection = null;
        try {
            connection = openConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String fullName = rs.getString("ticket_owner");
                tickets.add(new Tickets(rs.getInt("id_ticket"), fullName));
            }
        } catch (Exception e) {
            e.printStackTrace(); }
        finally {
            closeConnection(connection); }
        return tickets;
    }
}
