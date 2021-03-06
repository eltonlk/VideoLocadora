package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDate {
    
    private static String defaultFormat = "dd/MM/yyyy";
    
    private SimpleDateFormat strToDate;
    private final Calendar date;
    
    public MyDate() {
        date = new GregorianCalendar();
    }
    
    public MyDate(int year, int month, int day) {
        date = new GregorianCalendar(year, month, day);
    }
    
    public MyDate(Date date) {
        this(date.getYear(), date.getMonth(), date.getDate());
    }    

    public MyDate setTime(Date _date) {
        date.setTime(_date);
        
        return this;
    }
    
    public MyDate beginningOfMonth() {
        date.set(Calendar.DAY_OF_MONTH, 1);
        
        return this;
    }
    
    public MyDate endOfMonth() {
        date.add(Calendar.MONTH, 1);
        date.set(Calendar.DAY_OF_MONTH, 1);
        date.add(Calendar.DATE, -1);
        
        return this;
    }    
    
    public String toString(String format) {
        strToDate = new SimpleDateFormat(format);
        
        return strToDate.format(getDate());        
    }
    
    public Date getDate() {
        return date.getTime();
    }

    @Override
    public String toString() {
        return toString(defaultFormat);
    }
    
    public static MyDate today() {
        return new MyDate();
    }

    public static String localize(Date date, String format) {
        MyDate myDate = new MyDate(date);
        
        return myDate.toString(format);
    }

    public static String localize(Date date) {
        return MyDate.localize(date, defaultFormat);
    }
    
    public static MyDate delocalize(String date, String format) {
        MyDate myDate = new MyDate();
        
        try {
            DateFormat _strToDate = new SimpleDateFormat(format);
            
            Date dt = _strToDate.parse(date);
            
            myDate.setTime(dt);            
        } catch (ParseException ex) {
            Logger.getLogger(MyDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return myDate;
    }
    
    public static MyDate delocalize(String date) {
        return MyDate.delocalize(date, defaultFormat);
    }
    
}
