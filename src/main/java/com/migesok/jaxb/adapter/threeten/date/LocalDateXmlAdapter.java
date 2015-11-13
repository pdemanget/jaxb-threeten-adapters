package com.migesok.jaxb.adapter.threeten.date;

import org.threeten.bp.LocalDate;


/**
 * {@code XmlAdapter} mapping JSR-310 {@code LocalDate} to ISO-8601 string
 * <p>
 * It uses {@link java.time.format.DateTimeFormatter#ISO_DATE} for parsing and
 * serializing, time-zone information ignored.
 * 
 * @see javax.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.LocalDate
 */
public class LocalDateXmlAdapter extends DateAccessorXmlAdapter<LocalDate>
{

    public LocalDateXmlAdapter()
    {
        super (LocalDate.FROM);
    }
}
