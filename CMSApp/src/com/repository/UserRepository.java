package com.repository;

import com.enums.IncidentStatus;
import com.enums.IncidentType;
import com.enums.Role;
import com.exception.UserNotFoundException;
import com.model.Incident;
import com.model.User;
import com.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepository {


    public User authenticateUser(String username, String password) throws SQLException {

        String sql = "select * from users where username = ? and password = ?";
        PreparedStatement preparedStatement = DBConnection.getInstance().dbConnect().prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet rst = preparedStatement.executeQuery();
        if(rst.next()){
            int id =  rst.getInt("id");
            String username1 = rst.getString("username");
            String password1 = rst.getString("password");
            Role role  = Role.valueOf(rst.getString("role").toUpperCase()) ;
            User user = new User(id,username1,password1,role);
            DBConnection.getInstance().dbClose();
            return user;
        }
        else{
            DBConnection.getInstance().dbClose();
            throw new UserNotFoundException("Invalid Credentials");
        }

    }

    public List<Incident> getIncidentsOfOfficer(int userId) throws SQLException {
        Connection connection=DBConnection.getInstance().dbConnect();
        String sql="select i.* from incident i join officer o on o.id=i.officer_id where o.users_id=?";
        PreparedStatement preparedStatement=connection.prepareCall(sql);
        preparedStatement.setInt(1,userId);
        ResultSet rst=preparedStatement.executeQuery();
        ArrayList<Incident> list=new ArrayList<>();
        while(rst.next()){
            int id=rst.getInt("id");
            IncidentType type=IncidentType.valueOf(rst.getString("type").toUpperCase());
            String details=rst.getString("progress_details");
            IncidentStatus status=IncidentStatus.valueOf(rst.getString("status").toUpperCase());
            Incident incident=new Incident(id,type,details,status);
            list.add(incident);
        }
        DBConnection.getInstance().dbClose();
        return list;
    }


    public List<Incident> getIncidentsByStatus1(int userId, String v_status) throws SQLException{
        Connection connection=DBConnection.getInstance().dbConnect();
        String sql="select i.* from incident i join officer o on o.id=i.officer_id where o.users_id=? and i.status=?";
        PreparedStatement preparedStatement=connection.prepareCall(sql);
        preparedStatement.setInt(1,userId);
        preparedStatement.setString(2,v_status);
        ResultSet rst=preparedStatement.executeQuery();
        ArrayList<Incident> list=new ArrayList<>();
        while(rst.next()){
            int id=rst.getInt("id");
            IncidentType type=IncidentType.valueOf(rst.getString("type").toUpperCase());
            String details=rst.getString("progress_details");
            IncidentStatus status=IncidentStatus.valueOf(rst.getString("status").toUpperCase());
            Incident incident=new Incident(id,type,details,status);
            list.add(incident);
        }
        DBConnection.getInstance().dbClose();
        return list;

    }

    public Boolean insertIncident(int userId, String type, String details, String istatus) throws SQLException {
        Connection connection=DBConnection.getInstance().dbConnect();
//        String sql="select id from officer where users_id=?";
//        PreparedStatement preparedStatement=connection.prepareStatement(sql);
//        preparedStatement.setInt(1,userId);
//        ResultSet resultSet=preparedStatement.executeQuery();
//        resultSet.next();
//        int officer_id=resultSet.getInt("id");
//        System.out.println(officer_id);
//
//        String sql2="insert into incident(officer_id, type, progress_details, status) value(?,?,?,?)";
//        PreparedStatement preparedStatement2=connection.prepareStatement(sql2);
//        preparedStatement2.setInt(1,officer_id);
//        preparedStatement2.setString(2,type.toLowerCase());
//        preparedStatement2.setString(3,details.toLowerCase());
//        preparedStatement2.setString(4,istatus.toLowerCase());
//        int rst=preparedStatement2.executeUpdate();


        String sql = "{call insert_incident(?,?,?,?)}";

        CallableStatement callableStatement = connection.prepareCall(sql);

        callableStatement.setInt(1, userId);
        callableStatement.setString(2, type.toLowerCase());
        callableStatement.setString(3, details.toLowerCase());
        callableStatement.setString(4, istatus.toLowerCase());
        int rst = callableStatement.executeUpdate();

        if(rst>0){
            DBConnection.getInstance().dbClose();
            return true;
        }
        DBConnection.getInstance().dbClose();
        return false;
    }
}
