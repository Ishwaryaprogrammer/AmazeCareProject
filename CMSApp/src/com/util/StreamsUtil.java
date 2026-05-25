package com.util;

import com.enums.IncidentType;
import com.model.Incident;
import com.service.StreamsService;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class StreamsUtil {
    public static void main(String[] args) {
        StreamsService streamsService=new StreamsService();
        List<Incident> list=streamsService.sampleDate();
        System.out.println("---------------LIST OF INCIDENTS WHICH HAS TYPE OF MISSING PERSON------------");
        List<Incident> filteredList= streamsService.filteredListByIncidentType(list, IncidentType.MISSING_PERSON);
        filteredList.forEach(System.out::println);
        System.out.println("---------------INCIDENT TYPES------------");
        List<IncidentType> allIncidentTypes= streamsService.getAllIncidentTypes(list);
        allIncidentTypes.forEach(System.out::println);

        // get the incident type and their count
        System.out.println("---------------INCIDENT TYPE : COUNT------------");
        Map<IncidentType,Integer> map=streamsService.getIncidentTypeWithCountV2(list);
        map.entrySet().forEach(System.out::println);



    }



}
