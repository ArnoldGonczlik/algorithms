package org.pg4200.ex11;

public class Testing {
    public static void main(String[] args) {
        String teststring = "0A1F2F3C12F13B14B27A201B497A";


        int currentID;

        for (int i = 0; i < teststring.length(); i++) {
            char c = teststring.charAt(i);
            String currID = "";

            //Check if c is integer | if yes then its student ID
            if (Character.isDigit(c)) {
                currID = String.valueOf(c);


                if (Character.isDigit(teststring.charAt(i+1))) {
                    currID += teststring.charAt(i+1);

                    i++;
                    if (Character.isDigit(teststring.charAt(i+1))) {
                        currID += teststring.charAt(i+1);

                        i++;
                    }
                }
                currentID = Integer.parseInt(currID);

                System.out.println("ID: " + currentID);
            } else {

                //If not integer aka a grade
                System.out.println("Grade: " + c);
            }


        }
    }
}
