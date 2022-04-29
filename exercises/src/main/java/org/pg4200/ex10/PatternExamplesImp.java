package org.pg4200.ex10;

public class PatternExamplesImp implements PatternExamples {
    @Override
    public String dnaRegex() {
        return "(A|T|C|G)+";
    }

    @Override
    public String telephoneNumberRegex() {
        return "^(((\\+|00)(47))?(\\d){8})$";
    }

    @Override
    public String emailRegex() {
        return "^(?!^\\.)\\w*(?!\\.\\.)\\.*\\w+@\\w+(\\.\\w{2,})*(\\.\\w{2,})+";
    }

    @Override
    public String isItAJoke() {
        return "^(?i)(is ).*(joke\\?)";
    }
}
