package com.example.blanket.digitaliseringafakasseblanketter.validatation;

//Beskrivelse af hvordan regex i java virker https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
public class Validation //custom valideringsklasse
{
    String _result = "";
    public void Validate(String fieldName, String value, ValidationEnum validationEnum)
    {
        String regex = "";

        switch (validationEnum)
        {
            case YEAR:
                regex = "^\\d{4}$";
                break;
            case CPR:
                //Ved faktisk ikke om den her er korret og virker som den skal. Kan ikke få den til at fejle med tal, men bogstaver fanger den
                regex = "^(?:(?:31(?:0[13578]|1[02])|(?:30|29)(?:0[13-9]|1[0-2])|(?:0[1-9]|1[0-9]|2[0-8])(?:0[1-9]|1[0-2]))[0-9]{2}-?[0-9]|290200-?[4-9]|2902(?:(?!00)[02468][048]|[13579][26])-?[0-3])[0-9]{3}|000000-?0000$"; //https://www.computerworld.dk/eksperten/spm/1012877
                break;
            case ALPHANUMERIC:
                regex = "^[a-zA-Z0-9]+$"; //https://howtodoinjava.com/regex/regex-alphanumeric-characters/
                break;
            case DATE:
                regex = "^\\d{2}-\\d{2}-\\d{4}$";//Den er blevet lavet om til EU dato format! https://stackoverflow.com/questions/2149680/regex-date-format-validation-on-java
                break;
            case MONEY:
                regex = "^[+-]?[0-9]{1,3}(?:[0-9]*(?:[.,][0-9]{2})?|(?:,[0-9]{3})*(?:\\.[0-9]{2})?|(?:\\.[0-9]{3})*(?:,[0-9]{2})?)$"; //https://stackoverflow.com/questions/354044/what-is-the-best-u-s-currency-regex?answertab=active#tab-top // https://stackoverflow.com/questions/15334422/java-regular-expression-for-money?lq=1
                //Ved ikke om det havde været bedre at udnytte javas egen inbygget methoder til at tjekke beløb... https://stackoverflow.com/questions/15586099/numberformat-parse-fails-for-some-currency-strings
                break;
        }

        //https://stackoverflow.com/questions/44584622/java-regular-expression-validation
        java.util.regex.Pattern pattern =
                java.util.regex.Pattern.compile(regex);

        java.util.regex.Matcher matcher = pattern.matcher(value);

        if (!matcher.matches())
        {
            _result += fieldName;
        }
    }

    //Metoden returnere om der er fejl i nogle af valideringerne ud fra at om _result stringen er tom eller ej.
    public boolean HasError()
    {
        if (_result.length()>0)
        {
            return true;
        }
        return false;
    }

    //retunerer alt hvad der er sket i _result stringen. Den kan være tom hvis der ikke er sket fejl eller hvis der er sket fejl, returnerer den fejl på de felter der er fejl i
    public String ErrorLog()
    {
        return _result;
    }

}
