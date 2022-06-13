package org.pg4200.ex11;

import org.pg4200.les11.BitWriter;

public class GradeCompressorImp implements GradeCompressor {
    @Override
    public byte[] compress(String idsAndGrades) {
        BitWriter writer = new BitWriter();

        writer.write(idsAndGrades.length());


        int currentID;

        for (int i = 0; i < idsAndGrades.length(); i++) {
            char c = idsAndGrades.charAt(i);
            String currID = "";

            //Check if c is integer | if yes then its student ID
            if (Character.isDigit(c)) {
                currID = String.valueOf(c);


                if (Character.isDigit(idsAndGrades.charAt(i+1))) {
                    currID += idsAndGrades.charAt(i+1);

                    i++;
                    if (Character.isDigit(idsAndGrades.charAt(i+1))) {
                        currID += idsAndGrades.charAt(i+1);

                        i++;
                    }
                }

                //currentID now holds the int value for student,
                currentID = Integer.parseInt(currID);

                //Sets the padding on a binaryfied ID to always make it 9 bit
                String binaryID = padLeftZeros(Integer.toBinaryString(currentID), 9);

                //Simply writes the binaryfied ID to writer.
                for (char ch: binaryID.toCharArray()
                     ) {
                    if((""+ch).equals("1")) {
                        writer.write(true);
                    } else {
                        writer.write(false);
                    }
                }

            } else {
                int value = 0;
                String charchter = ""+c;
                //If not integer aka grade A-F
                switch(charchter) {
                    case "A":
                        value = 1;
                        break;
                    case "B":
                        value = 2;
                        break;
                    case "C":
                        value = 3;
                        break;
                    case "D":
                        value = 4;
                        break;
                    case "E":
                        value = 5;
                        break;
                    case "F":
                        value = 6;
                        break;
                }

                String binaryID = padLeftZeros(Integer.toBinaryString(value), 3);

                //Simply writes the binaryfied ID to writer.
                for (char ch: binaryID.toCharArray()
                ) {
                    if((""+ch).equals("1")) {
                        writer.write(true);
                    } else {
                        writer.write(false);
                    }
                }
            }
        }
        System.out.println(writer.extract());
        return writer.extract();
    }

    @Override
    public String decompress(byte[] data) {
        return null;
    }

    public static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }
}
