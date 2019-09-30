package com.example.blanket.digitaliseringafakasseblanketter.controller;

import com.example.blanket.digitaliseringafakasseblanketter.model.AR225;
import com.example.blanket.digitaliseringafakasseblanketter.validatation.Validation;
import com.example.blanket.digitaliseringafakasseblanketter.validatation.ValidationEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController
{
    @GetMapping("/")
    public String index()
    {
        return "home/index";
    }

    @PostMapping("/")
    public String index(AR225 form, HttpSession httpSession)
    {
        Validation validation = new Validation ();

        validation.Validate("Year", form.getYear(), ValidationEnum.YEAR);
        validation.Validate("SocialSecurityNumber", form.getSocialSecurityNumber(), ValidationEnum.CPR);
        validation.Validate("Name", form.getName(), ValidationEnum.ALPHANUMERIC);
        validation.Validate("CompanyName", form.getCompanyName(), ValidationEnum.ALPHANUMERIC);
        validation.Validate("FinancialYearFrom", form.getFinancialYearFrom(), ValidationEnum.DATE);
        validation.Validate("FinancialYearTo", form.getFinancialYearTo(), ValidationEnum.DATE);
        validation.Validate("Revenue", form.getRevenue(), ValidationEnum.MONEY);
        validation.Validate("CostOfSales", form.getCostOfSales(), ValidationEnum.MONEY);
        validation.Validate("ContributionMargin", form.getContributionMargin(), ValidationEnum.MONEY);

        if(validation.HasError())
        {
            System.out.println("Bang FAILED! " + validation.ErrorLog());
        }
        //Hvordan kan jeg returnere resultatet af min validering af mit view uden at reloade?
        return "home/index";
    }

}
