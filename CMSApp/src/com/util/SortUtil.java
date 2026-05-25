package com.util;

import com.enums.IncidentStatus;
import com.enums.IncidentType;
import com.model.Incident;

public class SortUtil {
    public static void main(String[] args) {
        Incident incident1 = new Incident(1, IncidentType.ABUSE, "Case file created.", IncidentStatus.INITIATED);
        Incident incident2 = new Incident(2, IncidentType.THEFT, "Security footage under review.", IncidentStatus.ACTIVE);
        Incident incident3 = new Incident(3, IncidentType.THEFT, "Security footage under review.", IncidentStatus.ACTIVE);
        Incident incident4 = new Incident(1, IncidentType.ABUSE, "Case file created.", IncidentStatus.INITIATED);

        System.out.println(incident1 == incident2);
        System.out.println(incident2 == incident3);
        System.out.println(incident1 == incident4);


        System.out.println(incident1.equals(incident2));
        System.out.println(incident2.equals(incident3));
        System.out.println(incident1.equals(incident4));
    }
}