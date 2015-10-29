package com.migesok.jaxb.adapter.javatime;

import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code LocalDate} to ISO-8601 string
 * <p>
 * It uses {@link java.time.format.DateTimeFormatter#ISO_DATE} for parsing and serializing,
 * time-zone information ignored.
 *
 * @see javax.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.LocalDate
 */
public class LocalDateXmlAdapter extends TemporalAccessorXmlAdapter<LocalDate> {
    public LocalDateXmlAdapter() {
        super(DateTimeFormatter.ISO_DATE, LocalDate.FROM);
    }
}
