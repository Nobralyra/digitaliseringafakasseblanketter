package com.example.blanket.digitaliseringafakasseblanketter.controller;

import com.example.blanket.digitaliseringafakasseblanketter.model.AR225;
import com.example.blanket.digitaliseringafakasseblanketter.validatation.Validation;
import com.example.blanket.digitaliseringafakasseblanketter.validatation.ValidationEnum;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AR225Controller
{
    @PostMapping("AR225/validate")
    public ResponseEntity<?> validate(AR225 form, HttpSession httpSession)
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
            return ResponseEntity.badRequest().body(validation.ErrorLog());
        }
        //Hvordan kan jeg returnere resultatet af min validering af mit view uden at reloade?
        //Hvis dataen skulle gemmes ville det blive gjort her, som selvfølgelig skulle være i en ny klasse
        return ResponseEntity.ok().body("OK!");
    }
}
