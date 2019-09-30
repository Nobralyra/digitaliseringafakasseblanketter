package com.example.blanket.digitaliseringafakasseblanketter.model;

public class AR225
{
    //Troede det var sådan her: "Skal være public når blanketen bliver submittet. Getter og setter er udnødvendige"
    //Er i virkeligheden nødt til at være private, så derfor er getter og setter nødvendige!

    private String Year;

    private String SocialSecurityNumber;

    private String Name;

    private String CompanyName;

    private String FinancialYearFrom;

    private String FinancialYearTo;

    private String Revenue;

    private String CostOfSales;

    private String ContributionMargin;

    private String Work;

    private String Evaluation;

    public String getYear()
    {
        return Year;
    }

    public void setYear(String year)
    {
        Year = year;
    }


    public String getSocialSecurityNumber()
    {
        return SocialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber)
    {
        SocialSecurityNumber = socialSecurityNumber;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public String getCompanyName()
    {
        return CompanyName;
    }

    public void setCompanyName(String companyName)
    {
        CompanyName = companyName;
    }

    public String getFinancialYearFrom()
    {
        return FinancialYearFrom;
    }

    public void setFinancialYearFrom(String financialYearFrom)
    {
        FinancialYearFrom = financialYearFrom;
    }

    public String getFinancialYearTo()
    {
        return FinancialYearTo;
    }

    public void setFinancialYearTo(String financialYearTo)
    {
        FinancialYearTo = financialYearTo;
    }

    public String getRevenue()
    {
        return Revenue;
    }

    public void setRevenue(String revenue)
    {
        Revenue = revenue;
    }

    public String getCostOfSales()
    {
        return CostOfSales;
    }

    public void setCostOfSales(String costOfSales)
    {
        CostOfSales = costOfSales;
    }

    public String getContributionMargin()
    {
        return ContributionMargin;
    }

    public void setContributionMargin(String contributionMargin)
    {
        ContributionMargin = contributionMargin;
    }

    public String getWork()
    {
        return Work;
    }

    public void setWork(String work)
    {
        Work = work;
    }

    public String getEvaluation()
    {
        return Evaluation;
    }

    public void setEvaluation(String evaluation)
    {
        Evaluation = evaluation;
    }




}
