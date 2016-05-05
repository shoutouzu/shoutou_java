// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DateUtils.java

package com.loan.utils;

import java.io.PrintStream;
import java.text.*;
import java.util.*;

// Referenced classes of package com.rd.util:
//            NumberUtils, StringUtils

public class DateUtils
{

    public DateUtils()
    {
    }

    public static String dateStr(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat("MM\u6708dd\u65E5 hh:mm");
        String str = format.format(date);
        return str;
    }

    public static String dateStr(Date date, String f)
    {
        SimpleDateFormat format = new SimpleDateFormat(f);
        String str = format.format(date);
        return str;
    }

    public static String dateStr2(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(date);
        return str;
    }

    public static String dateStr5(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy\u5E74MM\u6708dd\u65E5HH\u65F6mm\u5206ss\u79D2");
        String str = format.format(date);
        return str;
    }

    public static String dateStr3(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = format.format(date);
        return str;
    }

    public static String dateStr4(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }

    public static String dateStr6(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy\u5E74MM\u6708dd\u65E5");
        String str = format.format(date);
        return str;
    }

    public static String dateStr7(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String str = format.format(date);
        return str;
    }

    public static String dateStr8(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
        String str = format.format(date);
        return str;
    }

    public static Date getDate(String times)
    {
        long time = Long.parseLong(times);
        return new Date(time * 1000L);
    }

    public static String dateStr(String times)
    {
        return dateStr(getDate(times));
    }

    public static String dateStr2(String times)
    {
        return dateStr2(getDate(times));
    }

    public static String dateStr3(String times)
    {
        return dateStr3(getDate(times));
    }

    public static String dateStr4(String times)
    {
        return dateStr4(getDate(times));
    }

    public static String dateStr5(String times)
    {
        return dateStr5(getDate(times));
    }

    public static long getTime(Date date)
    {
        return date.getTime() / 1000L;
    }

    public static int getDay(Date d)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return cal.get(5);
    }

    public static Date valueOf(String s)
    {
        int YEAR_LENGTH = 4;
        int MONTH_LENGTH = 2;
        int DAY_LENGTH = 2;
        int MAX_MONTH = 12;
        int MAX_DAY = 31;
        int threeDash = 0;
        int fourDash = 0;
        Date d = null;
        if(s == null)
            throw new IllegalArgumentException();
        int firstDash = s.indexOf('-');
        int secondDash = s.indexOf('-', firstDash + 1);
        if(s.contains(":"))
        {
            threeDash = s.indexOf(':');
            fourDash = s.indexOf(':', threeDash + 1);
        }
        if(firstDash > 0 && secondDash > 0 && secondDash < s.length() - 1)
        {
            String yyyy = s.substring(0, firstDash);
            String mm = s.substring(firstDash + 1, secondDash);
            String dd = "";
            String hh = "";
            String MM = "";
            String ss = "";
            if(s.contains(":"))
            {
                dd = s.substring(secondDash + 1, threeDash - 3);
                hh = s.substring(threeDash - 2, threeDash);
                MM = s.substring(threeDash + 1, fourDash);
                ss = s.substring(fourDash + 1);
            } else
            {
                dd = s.substring(secondDash + 1);
            }
            if(yyyy.length() == 4 && mm.length() == 2 && dd.length() == 2)
            {
                int year = Integer.parseInt(yyyy);
                int month = Integer.parseInt(mm);
                int day = Integer.parseInt(dd);
                int hour = 0;
                int minute = 0;
                int second = 0;
                if(s.contains(":"))
                {
                    hour = Integer.parseInt(hh);
                    minute = Integer.parseInt(MM);
                    second = Integer.parseInt(ss);
                }
                if(month >= 1 && month <= 12)
                {
                    int maxDays = 31;
                    switch(month)
                    {
                    case 2: // '\002'
                        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                            maxDays = 29;
                        else
                            maxDays = 28;
                        break;

                    case 4: // '\004'
                    case 6: // '\006'
                    case 9: // '\t'
                    case 11: // '\013'
                        maxDays = 30;
                        break;
                    }
                    if(day >= 1 && day <= maxDays)
                    {
                        Calendar cal = Calendar.getInstance();
                        cal.set(year, month - 1, day, hour, minute, second);
                        cal.set(14, 0);
                        d = cal.getTime();
                    }
                }
            }
        }
        if(d == null)
            throw new IllegalArgumentException();
        else
            return d;
    }

    public static Map getApartTime(String Begin, String end)
    {
        String temp[] = Begin.split("-");
        String temp2[] = end.split("-");
        if(temp.length > 1 && temp2.length > 1)
        {
            Calendar ends = Calendar.getInstance();
            Calendar begin = Calendar.getInstance();
            begin.set(NumberUtils.getInt(temp[0]), NumberUtils.getInt(temp[1]), NumberUtils.getInt(temp[2]));
            ends.set(NumberUtils.getInt(temp2[0]), NumberUtils.getInt(temp2[1]), NumberUtils.getInt(temp2[2]));
            if(begin.compareTo(ends) < 0)
            {
                Map map = new HashMap();
                ends.add(1, -NumberUtils.getInt(temp[0]));
                ends.add(2, -NumberUtils.getInt(temp[1]));
                ends.add(5, -NumberUtils.getInt(temp[2]));
                map.put("YEAR", Integer.valueOf(ends.get(1)));
                map.put("MONTH", Integer.valueOf(ends.get(2) + 1));
                map.put("DAY", Integer.valueOf(ends.get(5)));
                return map;
            }
        }
        return null;
    }

    public static Date rollDay(Date d, int day)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(5, day);
        return cal.getTime();
    }

    public static Date rollMon(Date d, int mon)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(2, mon);
        return cal.getTime();
    }

    public static Date rollYear(Date d, int year)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(1, year);
        return cal.getTime();
    }

    public static Date rollDate(Date d, int year, int mon, int day)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(1, year);
        cal.add(2, mon);
        cal.add(5, day);
        return cal.getTime();
    }

    public static String getNowTimeStr()
    {
        String str = Long.toString(System.currentTimeMillis() / 1000L);
        return str;
    }

    public static int getNowTime()
    {
        return Integer.parseInt((new StringBuilder(String.valueOf(System.currentTimeMillis() / 1000L))).toString());
    }

    public static String getTimeStr(Date time)
    {
        long date = time.getTime();
        String str = Long.toString(date / 1000L);
        return str;
    }

    public static String getTimeStr(String dateStr, String format)
        throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(dateStr);
        String str = getTimeStr(date);
        return str;
    }

    public static String rollMonth(String addtime, String time_limit)
    {
        Date t = rollDate(getDate(addtime), 0, NumberUtils.getInt(time_limit), 0);
        return (new StringBuilder(String.valueOf(t.getTime() / 1000L))).toString();
    }

    public static String rollDay(String addtime, String time_limit_day)
    {
        Date t = rollDate(getDate(addtime), 0, 0, NumberUtils.getInt(time_limit_day));
        return (new StringBuilder(String.valueOf(t.getTime() / 1000L))).toString();
    }

    public static Date getIntegralTime()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(11, 0);
        cal.set(13, 0);
        cal.set(12, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    public static Date getLastIntegralTime()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(11, 23);
        cal.set(13, 59);
        cal.set(12, 59);
        cal.set(14, 0);
        return cal.getTime();
    }

    public static Date getLastSecIntegralTime(Date d)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(d.getTime());
        cal.set(11, 23);
        cal.set(13, 59);
        cal.set(12, 59);
        cal.set(14, 0);
        return cal.getTime();
    }

    public static long getTime(String format)
    {
        long t = 0L;
        if(StringUtil.isBlank(format))
            return t;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try
        {
            Date date = sdf.parse(format);
            t = date.getTime() / 1000L;
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }
        return t;
    }

    public static String getCurrentWeekday()
    {
        int weeks = 0;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus + 6);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    private static int getMondayPlus()
    {
        Calendar cd = Calendar.getInstance();
        int dayOfWeek = cd.get(7) - 1;
        if(dayOfWeek == 1)
            return 0;
        else
            return 1 - dayOfWeek;
    }

    public static String getMondayOFWeek()
    {
        int weeks = 0;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    public static String getFirstDayOfMonth(String first)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(2, 0);
        c.set(5, 1);
        first = format.format(c.getTime());
        return first;
    }

    public static String getLastDayOfMonth(String last)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.set(5, ca.getActualMaximum(5));
        last = format.format(ca.getTime());
        return last;
    }

    public static void main(String args[])
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d = Calendar.getInstance().getTime();
            d = rollDay(d, 0);
            System.out.println(f.format(d));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try {
			System.out.println(dateStr4("1457229633"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static Date getFirstSecIntegralTime(Date d)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(d.getTime());
        cal.set(11, 0);
        cal.set(13, 0);
        cal.set(12, 0);
        cal.set(14, 0);
        return cal.getTime();
    }
}
