package com.a5.group18.service;

import com.a5.group18.pojo.ConcessionOpenDate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DateService {

    ArrayList<ConcessionOpenDate> concessionOpenDates;

    public DateService() {
        concessionOpenDates = addConcessionOpenDates();
    }

    public ArrayList<ConcessionOpenDate> updateConcessionOpenDate(String targetDate){
        ConcessionOpenDate updateDate = new ConcessionOpenDate(targetDate);
        concessionOpenDates.remove(1);
        return concessionOpenDates;
    }


    public ArrayList<ConcessionOpenDate> findConcessionOpenDates(){
        return concessionOpenDates;
    }

    private ArrayList<ConcessionOpenDate> addConcessionOpenDates(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrowDate = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date inSixMonth = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 300);
        Date inOneYear = calendar.getTime();

        // This is to convert Date to String
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        ConcessionOpenDate tomorrow = new ConcessionOpenDate(sdf.format(tomorrowDate));
        ConcessionOpenDate sixMonth = new ConcessionOpenDate(sdf.format(inSixMonth));
        ConcessionOpenDate oneYear = new ConcessionOpenDate(sdf.format(inOneYear));

        return concessionOpenDates = new ArrayList<ConcessionOpenDate>(Arrays.asList(tomorrow, sixMonth, oneYear));
    }
}
