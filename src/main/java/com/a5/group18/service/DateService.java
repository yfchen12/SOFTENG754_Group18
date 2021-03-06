package com.a5.group18.service;

import com.a5.group18.pojo.ConcessionOpenDate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

@Service
public class DateService {

    ArrayList<ConcessionOpenDate> concessionOpenDates;
    ArrayList<ConcessionOpenDate> enrollmentOpenDates;

    public DateService() {
        concessionOpenDates = addConcessionOpenDates();
        enrollmentOpenDates = addConcessionOpenDates();
    }

    public ArrayList<ConcessionOpenDate> updateConcessionOpenDate(String targetDate) {
        ConcessionOpenDate updateDate = new ConcessionOpenDate(targetDate);
        concessionOpenDates.remove(1);
        return concessionOpenDates;
    }

    private void updateEnrollmentSemester() {
        int semCount = 1;
        int dateCount = 0;
        for (ConcessionOpenDate dateToChange : enrollmentOpenDates) {
            if (semCount == 3) {
                dateToChange.setSemester("Summer School");
                dateToChange.setOpenDate("2020-12-25");
                semCount = 1;
            } else {
                dateToChange.setSemester("Semester " + semCount);
                if (semCount == 1) {
                    dateToChange.setOpenDate("2020-6-22");
                } else {
                    dateToChange.setOpenDate("2020-9-17");
                }
                semCount++;
            }
            enrollmentOpenDates.set(dateCount, dateToChange);
            dateCount++;
        }
    }

    public ArrayList<ConcessionOpenDate> findConcessionOpenDates() {
        return concessionOpenDates;
    }

    public ArrayList<ConcessionOpenDate> findEnrollmentOpenDates() {
        updateEnrollmentSemester();
        return enrollmentOpenDates;
    }

    private ArrayList<ConcessionOpenDate> addConcessionOpenDates() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrowDate = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date inSixMonth = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 300);
        Date inOneYear = calendar.getTime();

        // This is to convert Date to String
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        ConcessionOpenDate tomorrow = new ConcessionOpenDate();
        ConcessionOpenDate sixMonth = new ConcessionOpenDate();
        ConcessionOpenDate oneYear = new ConcessionOpenDate();

        tomorrow.setOpenDate(sdf.format(tomorrowDate));
        sixMonth.setOpenDate(sdf.format(inSixMonth));
        oneYear.setOpenDate(sdf.format(inOneYear));

        return new ArrayList<ConcessionOpenDate>(Arrays.asList(tomorrow, sixMonth, oneYear));
    }
}

