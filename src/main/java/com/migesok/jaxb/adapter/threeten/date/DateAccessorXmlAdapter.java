package com.migesok.jaxb.adapter.threeten.date;

import static java.util.Objects.requireNonNull;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.threeten.bp.LocalDateTime;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;


/**
 * {@code XmlAdapter} mapping any JSR-310 {@code TemporalAccessor} to string
 * using provided {@code DateTimeFormatter}
 * <p>
 * Example:
 * 
 * <pre>
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * {
 *     &#064;code
 *     public class DottedDateXmlAdapter extends TemporalAccessorXmlAdapter&lt;LocalDate&gt;
 *     {
 * 
 *         public DottedDateXmlAdapter()
 *         {
 *             super (DateTimeFormatter.ofPattern (&quot;dd.MM.yyyy&quot;), LocalDate.FROM);
 *         }
 *     }
 * }
 * </pre>
 * 
 * @param <T>
 *            mapped temporal type
 * @see javax.xml.bind.annotation.adapters.XmlAdapter
 * @see java.time.temporal.TemporalAccessor
 * @see java.time.format.DateTimeFormatter
 */
public class DateAccessorXmlAdapter<T extends TemporalAccessor> extends XmlAdapter<Date, T>
{

    private final TemporalQuery<? extends T> temporalQuery;

    /**
     * @param formatter
     *            the formatter for printing and parsing, not null
     * @param temporalQuery
     *            the query defining the type to parse to, not null
     */
    public DateAccessorXmlAdapter(@Nonnull final TemporalQuery<? extends T> temporalQuery)
    {
        this.temporalQuery = requireNonNull (temporalQuery, "temporal query must not be null");
    }

    /**
     * Parse a date into an XMLGregorianCalendar
     * 
     * @param date
     *            the date
     * @return the XMLGregorianCalendar instance
     */
    public static Date toDate(final Temporal temp)
    {
        if (temp == null)
        {
            return null;
        }
        final Calendar cal = Calendar.getInstance ();
        cal.set (1970, 0, 1, 0, 0, 0);
        final TemporalField[] temporalFields = new TemporalField[] { ChronoField.YEAR, ChronoField.MONTH_OF_YEAR, ChronoField.DAY_OF_MONTH,
                ChronoField.HOUR_OF_DAY, ChronoField.MINUTE_OF_HOUR, ChronoField.SECOND_OF_MINUTE, ChronoField.MILLI_OF_SECOND };
        final int[] calendarFields = new int[] { Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND,
                Calendar.MILLISECOND,

        };
        try
        {
            for (int i = 0; i < temporalFields.length; i++)
            {
                if (temp.isSupported (temporalFields[i]))
                {
                    final int field = (temporalFields[i] == ChronoField.MONTH_OF_YEAR ? 1 : 0) + temp.get (temporalFields[i]);
                    cal.set (calendarFields[i], field);
                }
            }

            return cal.getTime ();
        }
        catch (final Exception e)
        {
            // LOGGER.error ("Unexpected Error while parsing calendar", e);
            return null;
        }
    }

    public static LocalDateTime toLocalDateTime(final Date date)
    {
        final Calendar calendar = Calendar.getInstance ();
        calendar.setTime (date);
        final int year = calendar.get (Calendar.YEAR);
        final int month = calendar.get (Calendar.MONTH);
        final int day = calendar.get (Calendar.DATE);
        final int hour = calendar.get (Calendar.HOUR_OF_DAY);
        final int minute = calendar.get (Calendar.MINUTE);
        final int second = calendar.get (Calendar.SECOND);
        final int milli = calendar.get (Calendar.MILLISECOND);
        return LocalDateTime.of (year, month + 1, day, hour, minute, second, milli * 1000000);
    }

    @Override
    public T unmarshal(final Date value)
    {
        return this.temporalQuery.queryFrom (toLocalDateTime (value));
    }

    @Override
    public Date marshal(final T value)
    {
        return toDate ((Temporal) value);
    }
}
