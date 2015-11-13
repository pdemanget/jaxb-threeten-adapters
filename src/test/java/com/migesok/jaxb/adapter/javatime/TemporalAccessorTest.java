package com.migesok.jaxb.adapter.javatime;

import java.util.Date;

import org.junit.Test;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;

import com.migesok.jaxb.adapter.threeten.date.DateAccessorXmlAdapter;


public class TemporalAccessorTest
{

    @Test
    public void testConvert()
    {
        // TODO make pertinent test
        final LocalDateTime localDateTime = DateAccessorXmlAdapter.toLocalDateTime (new Date ());
        System.out.println (localDateTime);

        Date date = DateAccessorXmlAdapter.toDate (LocalDateTime.of (2001, 01, 01, 1, 1, 1));
        System.out.println (date);

        date = DateAccessorXmlAdapter.toDate (LocalDate.of (2001, 02, 03));
        System.out.println (date);
    }

}
