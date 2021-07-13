import java.util.ArrayList;

public class ZigZagConversion {
    public static void main(String[] args){
            System.out.println(convert("PAYPALISHIRING",3));
    }
    public static String convert(String s, int numRows) {
        char[] charArray = s.toCharArray();
        if(numRows <= 1){
            return s;
        }
        if(numRows == 2){
            StringBuilder str2 = new StringBuilder(charArray.length);
            for(int x=0;x<s.length();x+=2){
                str2.append(charArray[x]);
            }
            for(int x=1;x<s.length();x+=2){
                str2.append(charArray[x]);
            }
            return str2.toString();
        }
        int outerHeight = numRows;

        int pointerOuter = 0;
        int pointerInner = numRows - 2;


        boolean outerSection = true;
        int pieceOfSection = 0;
        ArrayList<ArrayList<String>> holdLists = new ArrayList<ArrayList<String>>();
        for(int x=0;x<numRows;x++){
            holdLists.add(new ArrayList<String>());
        }
        for(int x=0;x<charArray.length;x++){
            if(outerSection){
                if(pieceOfSection == outerHeight){
                    outerSection = false;
                    pieceOfSection = pointerInner;
                }
            }else if(!outerSection){
                if(pieceOfSection < 1){
                    outerSection = true;
                    pieceOfSection = pointerOuter;
                }
            }
            holdLists.get(pieceOfSection).add(String.valueOf(charArray[x]));
            if(outerSection){
                pieceOfSection++;
            }else{
                pieceOfSection--;
            }
        }
        StringBuilder str1 = new StringBuilder(charArray.length);
        for(int x=0;x<holdLists.size();x++){
            for(int y=0;y<holdLists.get(x).size();y++){
                str1.append(holdLists.get(x).get(y));
            }
        }
        return str1.toString();
    }
}
