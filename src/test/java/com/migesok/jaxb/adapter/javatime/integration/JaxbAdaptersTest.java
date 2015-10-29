package com.migesok.jaxb.adapter.javatime.integration;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.helpers.DefaultValidationEventHandler;

import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.MonthDay;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.OffsetTime;
import org.threeten.bp.Period;
import org.threeten.bp.Year;
import org.threeten.bp.YearMonth;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import com.migesok.jaxb.adapter.javatime.DurationXmlAdapter;
import com.migesok.jaxb.adapter.javatime.InstantXmlAdapter;
import com.migesok.jaxb.adapter.javatime.LocalDateTimeXmlAdapter;
import com.migesok.jaxb.adapter.javatime.LocalDateXmlAdapter;
import com.migesok.jaxb.adapter.javatime.LocalTimeXmlAdapter;
import com.migesok.jaxb.adapter.javatime.MonthDayXmlAdapter;
import com.migesok.jaxb.adapter.javatime.OffsetDateTimeXmlAdapter;
import com.migesok.jaxb.adapter.javatime.OffsetTimeXmlAdapter;
import com.migesok.jaxb.adapter.javatime.PeriodXmlAdapter;
import com.migesok.jaxb.adapter.javatime.YearMonthXmlAdapter;
import com.migesok.jaxb.adapter.javatime.YearXmlAdapter;
import com.migesok.jaxb.adapter.javatime.ZoneIdXmlAdapter;
import com.migesok.jaxb.adapter.javatime.ZonedDateTimeXmlAdapter;

public class JaxbAdaptersTest {
    private JAXBContext jaxbContext;

    @Before
    public void setUp() throws JAXBException {
        jaxbContext = JAXBContext.newInstance(Bean.class);
    }

    @Test
    public void unmarshalBean() throws JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setEventHandler(new DefaultValidationEventHandler());
        Bean bean = (Bean) unmarshaller.unmarshal(getClass().getResourceAsStream("/bean.xml"));

        assertNotNull(bean);
        assertThat(bean.duration, equalTo(Duration.parse("P2DT3H4M")));
        assertThat(bean.period, equalTo(Period.parse("P1Y2M3W4D")));
        assertThat(bean.instant, equalTo(Instant.parse("2007-12-03T10:15:30.00Z")));
        assertThat(bean.zonedDateTime, equalTo(ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]")));
        assertThat(bean.localDate, equalTo(LocalDate.parse("2014-12-31+01:00",DateTimeFormatter.ISO_DATE)));
        assertThat(bean.localDate2, equalTo(LocalDate.parse("2014-12-31")));
        assertThat(bean.localDateTime, equalTo(LocalDateTime.parse("2007-12-03T10:15:30")));
        assertThat(bean.localTime, equalTo(LocalTime.parse("10:15:30")));
        assertThat(bean.offsetDateTime, equalTo(OffsetDateTime.parse("2007-12-03T10:15:30+01:00")));
        assertThat(bean.offsetTime, equalTo(OffsetTime.parse("10:15:30+01:00")));
        assertThat(bean.month, equalTo(Month.FEBRUARY));
        assertThat(bean.dayOfWeek, equalTo(DayOfWeek.WEDNESDAY));
        assertThat(bean.year, equalTo(Year.of(-2014)));
        assertThat(bean.yearMonth, equalTo(YearMonth.of(2014, 12)));
        assertThat(bean.monthDay, equalTo(MonthDay.of(Month.DECEMBER, 3)));
        assertThat(bean.zoneOffset, equalTo(ZoneOffset.ofHoursMinutes(-12, 0)));
        assertThat(bean.zoneId, equalTo(ZoneId.of("America/New_York")));
    }

    @XmlRootElement
    public static class Bean {
        @XmlElement
        @XmlJavaTypeAdapter(DurationXmlAdapter.class)
        public Duration duration;
        @XmlElement
        @XmlJavaTypeAdapter(PeriodXmlAdapter.class)
        public Period period;
        @XmlElement
        @XmlJavaTypeAdapter(InstantXmlAdapter.class)
        public Instant instant;
        @XmlElement
        @XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
        public ZonedDateTime zonedDateTime;
        @XmlElement
        @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
        public LocalDate localDate;
        @XmlElement
        @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
        public LocalDate localDate2;
        @XmlElement
        @XmlJavaTypeAdapter(LocalDateTimeXmlAdapter.class)
        public LocalDateTime localDateTime;
        @XmlElement
        @XmlJavaTypeAdapter(LocalTimeXmlAdapter.class)
        public LocalTime localTime;
        @XmlElement
        @XmlJavaTypeAdapter(OffsetDateTimeXmlAdapter.class)
        public OffsetDateTime offsetDateTime;
        @XmlElement
        @XmlJavaTypeAdapter(OffsetTimeXmlAdapter.class)
        public OffsetTime offsetTime;
        @XmlElement
        public Month month;
        @XmlElement
        public DayOfWeek dayOfWeek;
        @XmlElement
        @XmlJavaTypeAdapter(YearXmlAdapter.class)
        public Year year;
        @XmlElement
        @XmlJavaTypeAdapter(YearMonthXmlAdapter.class)
        public YearMonth yearMonth;
        @XmlElement
        @XmlJavaTypeAdapter(MonthDayXmlAdapter.class)
        public MonthDay monthDay;
        @XmlElement
        @XmlJavaTypeAdapter(ZoneIdXmlAdapter.class)
        public ZoneOffset zoneOffset;
        @XmlElement
        @XmlJavaTypeAdapter(ZoneIdXmlAdapter.class)
        public ZoneId zoneId;
    }
}
