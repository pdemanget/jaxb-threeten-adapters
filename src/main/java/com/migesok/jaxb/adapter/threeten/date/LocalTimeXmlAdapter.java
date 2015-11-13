package com.migesok.jaxb.adapter.threeten.date;

import org.threeten.bp.LocalTime;


/**
 * {@code XmlAdapter} mapping JSR-310 {@code LocalTime} to ISO-8601 string
 * <p>
 * String format details:
 * {@link java.time.format.DateTimeFormatter#ISO_LOCAL_TIME}
 * 
 * @see javax.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.LocalTime
 */
public class LocalTimeXmlAdapter extends DateAccessorXmlAdapter<LocalTime>
{

    public LocalTimeXmlAdapter()
    {
        super (LocalTime.FROM);
    }
}
