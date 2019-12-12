package com.example.msdictionary;

public class Keys {

    public static String public_keys[] = {"1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", "MPTfTL5SLmv7DivfNa1A1zP1eP5QGefi2D",
                                    "1A1zP1eP5Lmv7DivfNaQGefi2DMPTfTL5S", "1A1zP1eP5QGefNafi2DMPTfTL5SLmv7Div",
                                    "efi2DMPTfTL5SLmv7DivfejfidP1eP5QG"};
    public static String private_keys[] = {"8F72F6B29E6E225A36B68DFE333C7CE5E55D83249D3D2CD6332671FA445C4DD3",
                                    "7CE5E55D83249D3D2CD6332671FA445C4DD38F72F6B29E6E225A36B68DFE333C",
                                    "5E55D83249D3D2CD6332671FA448F72F6B29E6E225A36B68DFE333C7CE5C4DD3",
                                    "8F723C7C35D83E5E5F6B29E6E225A36B68DFE3249D3D2CD633267DSASD34DSD3",
                                    "8F723C7CE5E5F6B29E6E225A36B68DFE335D83249D3D2CD6332671FA445C4DD3"};
    public static String Users[] = {"Bank", "Car", "Glass", "SYSU", "msb"};


    public static int getIndex(String acc){
        int i = 0;
        for(String temp : Users){
            if(acc.equals(temp)){
                return i;
            }
            i ++;
        }
        return -1;
    }

    public static boolean judge(String acc, String puk, String prk){
        int pos = getIndex(acc);
        if(pos == -1) {
            return false;
        }
        else if(puk.equals(public_keys[pos]) && prk.equals(private_keys[pos])) {
            return true;
        }
        return false;
    }
}
