package com.service;

import com.model.Incident;
import com.model.User;
import com.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public User authenticateUser(String username, String password) throws SQLException {
       return userRepository.authenticateUser(username,password);
    }

    public List<Incident> getIncidentsOfOfficer(int userId) throws SQLException {
        return userRepository.getIncidentsOfOfficer(userId);

    }

    public List<Incident> getIncidentsByStatus1(int userId, String status) throws SQLException {
        return userRepository.getIncidentsByStatus1(userId,status);
    }

    public Boolean insertIncident(int user_id, String type, String details, String istatus) throws SQLException {
        return userRepository.insertIncident(user_id, type, details, istatus);
    }
}
