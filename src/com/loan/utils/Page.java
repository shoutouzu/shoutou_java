// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Page.java

package com.loan.utils;


public class Page
{

    public Page()
    {
    }

    public Page(int total, int currentPage)
    {
        this(total, currentPage, ROWS);
    }

    public Page(int total, int currentPage, int pernum)
    {
        this.total = total;
        this.currentPage = currentPage != 0 ? currentPage : 1;
        this.pernum = pernum;
        pages = (int)Math.ceil(((double)total + 0.0D) / (double)pernum);
        count();
    }

    private void count()
    {
        start = pernum * (currentPage - 1);
        end = pernum * currentPage;
        if(end > total)
            end = total;
    }

    public boolean hasPreview()
    {
        return pages > 1 && currentPage > 1;
    }

    public boolean hasNext()
    {
        return pages > 1 && currentPage < pages;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    public int getPages()
    {
        return pages;
    }

    public void setPages(int pages)
    {
        this.pages = pages;
    }

    public int getPernum()
    {
        return pernum;
    }

    public void setPernum(int pernum)
    {
        this.pernum = pernum;
    }

    public int getStart()
    {
        return start;
    }

    public void setStart(int start)
    {
        this.start = start;
    }

    public int getEnd()
    {
        return end;
    }

    public void setEnd(int end)
    {
        this.end = end;
    }

    private int total;
    private int currentPage;
    private int pages;
    private int pernum;
    private int start;
    private int end;
    public static int ROWS = 10;

}
