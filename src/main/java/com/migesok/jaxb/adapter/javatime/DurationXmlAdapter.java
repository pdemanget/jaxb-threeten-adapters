package com.migesok.jaxb.adapter.javatime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.threeten.bp.Duration;


/**
 * {@code XmlAdapter} mapping JSR-310 {@code Duration} to ISO-8601 string
 * <p>
 * String format details:
 * <ul>
 * <li>{@link java.time.Duration#parse(java.lang.CharSequence)}</li>
 * <li>{@link java.time.Duration#toString()}</li>
 * </ul>
 *
 * @see javax.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.Duration
 */
public class DurationXmlAdapter extends XmlAdapter<String, Duration> {
    @Override
    public Duration unmarshal(final String stringValue) {
        return stringValue != null ? Duration.parse(stringValue) : null;
    }

    @Override
    public String marshal(final Duration value) {
        return value != null ? value.toString() : null;
    }
}
