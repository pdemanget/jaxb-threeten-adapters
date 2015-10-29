package com.migesok.jaxb.adapter.javatime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.threeten.bp.Year;

/**
 * {@code XmlAdapter} mapping JSR-310 {@code Year} to ISO proleptic year number
 * <p>
 * Year number interpretation details:
 * <ul>
 * <li>{@link java.time.Year#of(int)}</li>
 * <li>{@link java.time.Year#getValue()}</li>
 * </ul>
 *
 * @see javax.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.Year
 */
public class YearXmlAdapter extends XmlAdapter<Integer, Year> {
    @Override
    public Year unmarshal(Integer isoYearInt) {
        return isoYearInt != null ? Year.of(isoYearInt) : null;
    }

    @Override
    public Integer marshal(Year year) {
        return year != null ? year.getValue() : null;
    }
}
