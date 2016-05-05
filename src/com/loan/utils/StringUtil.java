
package com.loan.utils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class StringUtil extends StringUtils
{

    public StringUtil()
    {
    }

    public static String isNull(String str)
    {
        if(str == null)
            return "";
        else
            return str;
    }

    public static String isNull(Object o)
    {
        if(o == null)
            return "";
        String str = "";
        if(o instanceof String)
            str = (String)o;
        else
            str = o.toString();
        return str;
    }

    public static boolean isPhone(String phone)
    {
        phone = isNull(phone);
        Pattern regex = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher matcher = regex.matcher(phone);
        boolean isMatched = matcher.matches();
        return isMatched;
    }

    public static boolean isEmail(String email)
    {
        email = isNull(email);
        Pattern regex = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher matcher = regex.matcher(email);
        boolean isMatched = matcher.matches();
        return isMatched;
    }

    public static boolean isCard(String cardId)
    {
        cardId = isNull(cardId);
        Pattern isIDCard1 = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
        Pattern isIDCard2 = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$");
        Matcher matcher1 = isIDCard1.matcher(cardId);
        Matcher matcher2 = isIDCard2.matcher(cardId);
        boolean isMatched = matcher1.matches() || matcher2.matches();
        return isMatched;
    }

    public static boolean isInteger(String str)
    {
        if(isEmpty(str))
        {
            return false;
        } else
        {
            Pattern regex = Pattern.compile("\\d*");
            Matcher matcher = regex.matcher(str);
            boolean isMatched = matcher.matches();
            return isMatched;
        }
    }

    public static boolean isNumber(String str)
    {
        if(isEmpty(str))
        {
            return false;
        } else
        {
            Pattern regex = Pattern.compile("\\d*(.\\d*)?");
            Matcher matcher = regex.matcher(str);
            boolean isMatched = matcher.matches();
            return isMatched;
        }
    }

    public static boolean isEmpty(String str)
    {
        return str == null || "".equals(str);
    }

    public static String firstCharUpperCase(String s)
    {
        StringBuffer sb = new StringBuffer(s.substring(0, 1).toUpperCase());
        sb.append(s.substring(1, s.length()));
        return sb.toString();
    }

    public static String hideChar(String str, int len)
    {
        if(str == null)
            return null;
        char chars[] = str.toCharArray();
        for(int i = 1; i > chars.length - 1; i++)
            if(i < len)
                chars[i] = '*';

        str = new String(chars);
        return str;
    }

    public static String hideFirstChar(String str, int len)
    {
        if(str == null)
            return null;
        char chars[] = str.toCharArray();
        if(str.length() <= len)
        {
            for(int i = 0; i < chars.length; i++)
                chars[i] = '*';

        } else
        {
            for(int i = 0; i < 1; i++)
                chars[i] = '*';

        }
        str = new String(chars);
        return str;
    }

    public static String hideLastChar(String str, int len)
    {
        if(str == null)
            return null;
        char chars[] = str.toCharArray();
        if(str.length() <= len)
        {
            for(int i = 0; i < chars.length; i++)
                chars[i] = '*';

        } else
        {
            for(int i = chars.length - 1; i > chars.length - len - 1; i--)
                chars[i] = '*';

        }
        str = new String(chars);
        return str;
    }

    public static String format(String str, int len)
    {
        if(str == null)
            return "-";
        if(str.length() <= len)
        {
            int pushlen = len - str.length();
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < pushlen; i++)
                sb.append("0");

            sb.append(str);
            str = sb.toString();
        } else
        {
            String newStr = str.substring(0, len);
            str = newStr;
        }
        return str;
    }

    public static String contact(Object args[])
    {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < args.length; i++)
        {
            sb.append(args[i]);
            if(i < args.length - 1)
                sb.append(",");
        }

        return sb.toString();
    }

    public static boolean isInSplit(String s, String type)
    {
        if(isNull(s).equals(""))
            return false;
        List list = Arrays.asList(s.split(","));
        return list.contains(type);
    }

    public static boolean isBlank(String str)
    {
        return isNull(str).equals("");
    }

    public static synchronized String generateTradeNO(long userid, String type)
    {
        String s = (new StringBuilder(String.valueOf(type))).append(userid).append(getFullTimeStr()).toString();
        return s;
    }

    public static String getFullTimeStr()
    {
        String s = DateUtils.dateStr3(Calendar.getInstance().getTime());
        return s;
    }

    public static String array2Str(Object arr[])
    {
        StringBuffer s = new StringBuffer();
        for(int i = 0; i < arr.length; i++)
        {
            s.append(arr[i]);
            if(i < arr.length - 1)
                s.append(",");
        }

        return s.toString();
    }

    public static String array2Str(int arr[])
    {
        StringBuffer s = new StringBuffer();
        for(int i = 0; i < arr.length; i++)
        {
            s.append(arr[i]);
            if(i < arr.length - 1)
                s.append(",");
        }

        return s.toString();
    }

    public static String hideStr(String str, int index1, int index2)
    {
        if(str == null)
            return null;
        String str1 = str.substring(index1, index2);
        String str2 = str.substring(index2);
        String str3 = "";
        if(index1 > 0)
        {
            str1 = str.substring(0, index1);
            str2 = str.substring(index1, index2);
            str3 = str.substring(index2);
        }
        char chars[] = str2.toCharArray();
        for(int i = 0; i < chars.length; i++)
            chars[i] = '*';

        str2 = new String(chars);
        String str4 = (new StringBuilder(String.valueOf(str1))).append(str2).append(str3).toString();
        return str4;
    }

    public static String SetNumberFractionDigits(String str)
    {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        return nf.format(Float.valueOf(str));
    }

    public static String getMonday(String the_rq)
    {
        int n = getXC_days(the_rq);
        System.out.println((new StringBuilder("n=")).append(n).toString());
        n *= -1;
        return Q_N_Day(n, the_rq);
    }

    public static String getSunday(String the_rq)
    {
        int n = getXC_days(the_rq);
        System.out.println((new StringBuilder("n=")).append(n).toString());
        n = (6 - n * -1) * -1;
        return Q_N_Day(n, the_rq);
    }

    public static int getXC_days(String rq)
    {
        SimpleDateFormat formatYMD = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatD = new SimpleDateFormat("E");
        Date d = null;
        String weekDay = "";
        int xcrq = 0;
        try
        {
            d = formatYMD.parse(rq);
            weekDay = formatD.format(d);
            if(weekDay.equals("\u661F\u671F\u4E00"))
                xcrq = 0;
            else
            if(weekDay.equals("\u661F\u671F\u4E8C"))
                xcrq = -1;
            else
            if(weekDay.equals("\u661F\u671F\u4E09"))
                xcrq = -2;
            else
            if(weekDay.equals("\u661F\u671F\u56DB"))
                xcrq = -3;
            else
            if(weekDay.equals("\u661F\u671F\u4E94"))
                xcrq = -4;
            else
            if(weekDay.equals("\u661F\u671F\u516D"))
                xcrq = -5;
            else
            if(weekDay.equals("\u661F\u671F\u65E5"))
                xcrq = -6;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return xcrq;
    }

    public static String Q_N_Day(int N, String d1)
    {
        String d2[] = d1.split("-");
        int year = Integer.parseInt(d2[0]);
        int month = Integer.parseInt(d2[1]);
        int day = Integer.parseInt(d2[2]);
        if(day - N <= 0)
        {
            if(month == 1)
            {
                year--;
                month = 12;
                day = (day + 31) - N;
            } else
            if(--month == 2)
            {
                if(year % 4 == 0)
                    day = (day + 29) - N;
                else
                    day = (day + 28) - N;
            } else
            if(month == 4 || month == 6 || month == 9 || month == 11)
                day = (day + 30) - N;
            else
                day = (day + 31) - N;
        } else
        if(month == 12)
        {
            if(day - N > 31)
            {
                year++;
                month = 1;
                day = day - N - 31;
            } else
            {
                day -= N;
            }
        } else
        if(month == 2)
        {
            if(year % 4 == 0)
            {
                if(day - N > 29)
                {
                    month++;
                    day = day - N - 29;
                } else
                {
                    day -= N;
                }
            } else
            if(day - N > 28)
            {
                month++;
                day = day - N - 28;
            } else
            {
                day -= N;
            }
        } else
        if(month == 4 || month == 6 || month == 9 || month == 11)
        {
            if(day - N > 30)
            {
                month++;
                day = day - N - 30;
            } else
            {
                day -= N;
            }
        } else
        if(day - N > 31)
        {
            month++;
            day = day - N - 31;
        } else
        {
            day -= N;
        }
        String str = String.valueOf(year);
        if(month < 10)
            str = (new StringBuilder(String.valueOf(str))).append("-0").append(String.valueOf(month)).toString();
        else
            str = (new StringBuilder(String.valueOf(str))).append("-").append(String.valueOf(month)).toString();
        if(day < 10)
            str = (new StringBuilder(String.valueOf(str))).append("-0").append(String.valueOf(day)).toString();
        else
            str = (new StringBuilder(String.valueOf(str))).append("-").append(String.valueOf(day)).toString();
        return str;
    }

    public static void main(String args[])
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String mondayString = (new StringBuilder(String.valueOf(getMonday(df.format(new Date()))))).append(" 00:00:00").toString();
        String sumdayString = (new StringBuilder(String.valueOf(getSunday(df.format(new Date()))))).append(" 23:59:59").toString();
        String monday = (new StringBuilder(String.valueOf(DateUtils.getTime(mondayString)))).toString();
        String sumday = (new StringBuilder(String.valueOf(DateUtils.getTime(sumdayString)))).toString();
        System.out.println(monday);
        System.out.println(sumday);
    }

    public static String fillTemplet(String templet, String phstr, String paras[])
    {
        StringBuffer templetSB = new StringBuffer(templet);
        for(int i = 0; templetSB.indexOf(phstr) >= 0 && i < paras.length; i++)
            templetSB.replace(templetSB.indexOf(phstr), templetSB.indexOf(phstr) + phstr.length(), paras[i]);

        return templetSB.toString();
    }

    public static int[] strarr2intarr(String strarr[])
    {
        int result[] = new int[strarr.length];
        for(int i = 0; i < strarr.length; i++)
            result[i] = Integer.parseInt(strarr[i]);

        return result;
    }

    public static String KillNull(String s)
    {
      return StringUtils.trimToEmpty(s);
    }

    public static String KillNull(String s, String d)
    {
      if (isEmpty(s)) {
        return d;
      }
      return s;
    }
}
