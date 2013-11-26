package framework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDate {
    
    private SimpleDateFormat strToDate;
    private final Calendar date;
    
    public MyDate() {
        date = new GregorianCalendar();
    }
    
    public MyDate(int year, int month, int day) {
        date = new GregorianCalendar(year, month, day);
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
        
        return strToDate.format(date.getTime());        
    }
    
    public Date getDate() {
        return date.getTime();
    }

    @Override
    public String toString() {
        return toString("dd/MM/yyyy");
    }
    
    public static MyDate today() {
        return new MyDate();
    }
    
    public static MyDate strptime(String date, String format) {
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
    
    public static MyDate strptime(String date) {
        return MyDate.strptime(date, "dd/MM/yyyy");
    }
}
