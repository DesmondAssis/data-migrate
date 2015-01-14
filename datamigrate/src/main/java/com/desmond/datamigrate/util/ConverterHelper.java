package com.desmond.datamigrate.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;


public class ConverterHelper {

    public static String toString(Object o) {
        return o != null ? String.valueOf(o) : null;
    }
    
    public static Date toDate(Object o) {
        Date result = null;
        if (o instanceof Timestamp) {
            result = o != null ? new Date(((Timestamp) o).getTime()) : null; 
        }
        return result;
    }
    
    public static Integer toInt(Object o) {
        Integer r = null;
        if (o != null) {
            if (o instanceof BigDecimal) {
                r = ((BigDecimal) o).intValue();
            } else {
                r = (Integer) o;
            }
        }
        return r;
    }
    
    public static Long toLong(Object o) {
        Long r = null;
        if (o != null) {
            if (o instanceof BigDecimal) {
                r = ((BigDecimal) o).longValue();
            } else {
                r = (Long) o;
            }
        }
        return r;
    }
    
    public static Double toDouble(Object o) {
        Double r = null;
        if (o != null) {
            if (o instanceof BigDecimal) {
                r = ((BigDecimal) o).doubleValue();
            } else if (o instanceof String) {
                r = Double.valueOf((String) o);
            }
        }
        return r;
    }
    
    public static Float toFloat(Object o) {
        Float r = null;
        if (o != null) {
            if (o instanceof BigDecimal) {
                r = ((BigDecimal) o).floatValue();
            } else {
                r = (Float) o;
            }
        }
        return r;
    }
    
    public static Boolean toBoolean(Object o) {
        Boolean result = Boolean.FALSE;
        if (o != null) {
            if (o instanceof BigDecimal) {
                if (((BigDecimal) o).intValue() == 1) {
                    result = Boolean.TRUE;
                }
            } else {
                if ((Integer) o == 1) {
                    result = Boolean.TRUE;
                }
            }
        }
        return result;
    }

    public static Calendar toCalendar(Object o) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(toDate(o));
        return cal;
    }
    
}
