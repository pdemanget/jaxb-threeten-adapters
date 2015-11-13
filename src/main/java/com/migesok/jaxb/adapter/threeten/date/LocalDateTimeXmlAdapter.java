package com.migesok.jaxb.adapter.threeten.date;

import org.threeten.bp.LocalDateTime;


/**
 * {@code XmlAdapter} mapping JSR-310 {@code LocalDateTime} to ISO-8601 string
 * <p>
 * String format details:
 * {@link java.time.format.DateTimeFormatter#ISO_LOCAL_DATE_TIME}
 * 
 * @see javax.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.LocalDateTime
 */
public class LocalDateTimeXmlAdapter extends DateAccessorXmlAdapter<LocalDateTime>
{

    public LocalDateTimeXmlAdapter()
    {
        super (LocalDateTime.FROM);
    }
}
