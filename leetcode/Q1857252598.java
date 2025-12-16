class Solution {
    public String intToRoman(int num) {
        if(num>=1000){
            int fact = num/1000;
            String s = "";
            for(int i=0; i<fact; i++){
                s += "M";
            }
            return s+intToRoman(num%1000);
        }
        if(num>=100){
            int fact = num/100;
            if(fact == 9){
                return "CM"+intToRoman(num%100);
            }
            if(fact >= 5){
                return "D" + intToRoman(num - 500);
            }
            if(fact == 4){
                return "CD" + intToRoman(num%100);
            }
            String s = "";
            for(int i=0; i<fact; i++){
                s += "C";
            }
            return s+intToRoman(num%100);
        }
        if(num>=10){
            int fact = num/10;
            if(fact == 9){
                return "XC"+intToRoman(num%10);
            }
            if(fact >= 5){
                return "L" + intToRoman(num - 50);
            }
            if(fact == 4){
                return "XL" + intToRoman(num%10);
            }
            String s = "";
            for(int i=0; i<fact; i++){
                s += "X";
            }
            return s+intToRoman(num%10);
        }
        int fact = num/100;
        if(num == 9){
            return "IX";
        }
        if(num >= 5){
            return "V" + intToRoman(num - 5);
        }
        if(num == 4){
            return "IV";
        }
        String s = "";
        for(int i=0; i<num; i++){
            s += "I";
        }
        return s;
    }
}