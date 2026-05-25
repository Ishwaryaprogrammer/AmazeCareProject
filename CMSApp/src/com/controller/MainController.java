package com.controller;

import com.enums.Role;
import com.exception.UserNotFoundException;
import com.model.Incident;
import com.model.User;
import com.service.StreamsService;
import com.service.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();

        System.out.println("--------CMS: LOGIN----------");
        System.out.println("Enter Username ");
        String username = sc.next();
        System.out.println("Enter Password ");
        String password = sc.next();
        try {
            User user = userService.authenticateUser(username, password);
            System.out.println("Welcome " + user.getUsername() );
            System.out.println("Role is " + user.getRole());
            if(user.getRole().equals(Role.OFFICER)){
                while(true){
                    System.out.println("1. View Incidents"); // incidents handling by this officer
                    System.out.println("2. Filter incidents by status");
                    System.out.println("3. Insert Incident");
                    System.out.println(" press 0 to exit");
                    int op=sc.nextInt();
                    if(op==0) break;
                    switch(op){
                        case 1:
                            //implement 1
                            System.out.println("-----List of Incidents Handled by Officer "+user.getUsername()+"-----");
                            try {
                                List<Incident> list = userService.getIncidentsOfOfficer(user.getId());
                                list.forEach(System.out::println);
                            }catch(SQLException e){
                                System.out.println(e.getMessage());
                            }
                            System.out.println("----------------------------------------------------------------------");


                            break;
                        case 2:
                            //implement 2
                            System.out.println("Enter the status:");
                            String status=sc.next();
                            StreamsService streamsService=new StreamsService();
                            System.out.println("-----List of Incidents Handled by Officer "+user.getUsername()+" with status "+status+"-----");
                            try {
                                //List<Incident> list = userService.getIncidentsByStatus1(user.getId(),status);
                                List<Incident> list = userService.getIncidentsOfOfficer(user.getId());
                                List<Incident> list2 = streamsService.getIncidentsByStatus1(list,status);
                                list2.forEach(System.out::println);
                            }catch(SQLException e){
                                System.out.println(e.getMessage());
                            }
                            System.out.println("----------------------------------------------------------------------");
                            break;
                        case 3:
                            System.out.println("Enter Incident Type(THEFT, MURDER, MISSING_PERSON, ABUSE): ");
                            String type=sc.next();
                            System.out.println("Enter Progress Details: ");
                            sc.nextLine();
                            String details=sc.nextLine();
                            System.out.println("Enter Incident Status(INITIATED, ACTIVE, VERIFIED, CLOSE): ");
                            String istatus=sc.next();
                            try {
                                Boolean flag = userService.insertIncident(user.getId(), type, details, istatus);

                                if (flag) {
                                    System.out.println("Inserted Successfully");
                                }
                            }catch (SQLException e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        default: break;
                    }
                }

            }else if(user.getRole().equals(Role.STATION_HEAD)){
           }

        } catch (SQLException | UserNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}
