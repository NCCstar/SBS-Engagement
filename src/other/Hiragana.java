package other;
//import java.util.*;
public class Hiragana
{
    public static void main(String[] args)
    {
        System.out.println(toHiragana("The quick brown fox jumped over the lazy dog."));
    }
    public static String toHiragana(String in)
    {
        in = in.toUpperCase();
        in = in.replace("TH","S");
        in = in.replace("CK","K");
        in = in.replace('L','R');
        in = in.replace('C','K');
        in = in.replace('Q','K');
        in = in.replace('F','H');
        in = in.replace('V','B');

        String ans = "";
        for(int i=0;i<in.length();i++)
        {
            char curr = in.charAt(i);

            if(Character.isLetter(curr))
            {
                if(isVowel(curr))
                {
                    switch(curr)
                    {
                        case 'A':
                            ans+='\u3042';
                            break;
                        case 'I':
                            ans+='\u3044';
                            break;
                        case 'U':
                            ans+='\u3046';
                            break;
                        case 'E':
                            ans+='\u3048';
                            break;
                        case 'O':
                            ans+='\u304A';
                            break;
                    }
                }
                else//consonat
                {
                    switch(curr)
                    {
                        case 'K':
                            curr = in.charAt(++i);
                            switch(curr) {
                                case 'A':
                                    ans += '\u304B';
                                    break;
                                case 'I':
                                    ans += '\u304D';
                                    break;
                                case 'U':
                                    ans += '\u304F';
                                    break;
                                case 'E':
                                    ans += '\u3051';
                                    break;
                                case 'O':
                                    ans += '\u3053';
                                    break;
                                default:
                                    i--;
                                    ans += '\u304F';
                                    break;
                            }
                            break;
                        case 'G':
                            curr = in.charAt(++i);
                            switch(curr) {
                                case 'A':
                                    ans += '\u304C';
                                    break;
                                case 'I':
                                    ans += '\u304E';
                                    break;
                                case 'U':
                                    ans += '\u3050';
                                    break;
                                case 'E':
                                    ans += '\u3052';
                                    break;
                                case 'O':
                                    ans += '\u3054';
                                    break;
                                default:
                                    i--;
                                    ans += '\u3050';
                                    break;
                            }
                            break;
                        case 'S':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'A':
                                    ans+='\u3055';
                                    break;
                                case 'H'://shi
                                    if(isVowel(in.charAt(i+1))) {
                                        i++;
                                        ans += '\u3057';//start with shi
                                        switch(in.charAt(i)){//add y-vowel
                                            case 'A':
                                                ans += '\u3083';
                                                break;
                                            //no 'i'
                                            case 'U':
                                                ans += '\u3085';
                                                break;
                                            //no 'e'??
                                            case 'O':
                                                ans += '\u3087';
                                                break;
                                        }
                                    }
                                    else {
                                        i--;
                                        ans += "sh";
                                    }
                                    break;
                                case 'I'://si -> shi
                                    ans += '\u3057';
                                    break;
                                case 'U':
                                    ans+='\u3059';
                                    break;
                                case 'E':
                                    ans+='\u305B';
                                    break;
                                case 'O':
                                    ans+='\u305D';
                                    break;
                                default:
                                    i--;
                                    ans += '\u3059';
                                    break;
                            }
                            break;
                        case 'Z':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'A':
                                    ans+='\u3056';
                                    break;
                                case 'H'://shi
                                    i++;
                                    ans+='\u3058';
                                    break;
                                case 'U':
                                    ans+='\u305A';
                                    break;
                                case 'E':
                                    ans+='\u305C';
                                    break;
                                case 'O':
                                    ans+='\u305E';
                                    break;
                                default:
                                    i--;
                                    ans += '\u305A';
                                    break;
                            }
                            break;
                        case 'T':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'A':
                                    ans+='\u305F';
                                    break;
                                case 'S'://tsu
                                    if(in.charAt(i+1)=='u') {
                                        i++;
                                        ans += '\u3064';
                                    }
                                    else
                                    {
                                        ans += "ts";
                                    }
                                    break;
                                case 'U':
                                    ans += '\u3064';
                                    break;
                                case 'E':
                                    ans+='\u3066';
                                    break;
                                case 'O':
                                    ans+='\u3068';
                                    break;
                                default:
                                    i--;
                                    ans += '\u3064';
                                    break;
                            }
                            break;
                        case 'D':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'A':
                                    ans+='\u3060';
                                    break;
                                case 'I':
                                    i++;
                                    ans+='\u3062';
                                    break;
                                case 'U':
                                    i++;
                                    ans+='\u3065';
                                    break;
                                case 'E':
                                    ans+='\u3067';
                                    break;
                                case 'O':
                                    ans+='\u3069';
                                    break;
                                default:
                                    i--;
                                    ans += '\u3065';
                                    break;
                            }
                            break;
                        case 'N':
                            if(isVowel(in.charAt(i+1)))
                            {
                                curr = in.charAt(++i);
                                switch(curr)
                                {
                                    case 'A':
                                        ans+='\u306A';
                                        break;
                                    case 'I':
                                        ans+='\u306B';
                                        break;
                                    case 'U':
                                        ans+='\u306C';
                                        break;
                                    case 'E':
                                        ans+='\u306D';
                                        break;
                                    case 'O':
                                        ans+='\u306E';
                                        break;
                                }
                            }
                            else
                                ans+='\u3093';
                            break;
                        case 'H':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'A':
                                    ans+='\u306F';
                                    break;
                                case 'I':
                                    ans+='\u3072';
                                    break;
                                case 'U':
                                    ans+='\u3075';
                                    break;
                                case 'E':
                                    ans+='\u3078';
                                    break;
                                case 'O':
                                    ans+='\u307B';
                                    break;
                                default:
                                    i--;
                                    ans += '\u3075';
                                    break;
                            }
                            break;
                        case 'B':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'A':
                                    ans+='\u3070';
                                    break;
                                case 'I':
                                    ans+='\u3073';
                                    break;
                                case 'U':
                                    ans+='\u3076';
                                    break;
                                case 'E':
                                    ans+='\u3079';
                                    break;
                                case 'O':
                                    ans+='\u307C';
                                    break;
                                default:
                                    i--;
                                    ans += '\u3076';
                                    break;
                            }
                            break;
                        case 'P':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'A':
                                    ans+='\u3071';
                                    break;
                                case 'I':
                                    ans+='\u3074';
                                    break;
                                case 'U':
                                    ans+='\u3077';
                                    break;
                                case 'E':
                                    ans+='\u307A';
                                    break;
                                case 'O':
                                    ans+='\u307D';
                                    break;
                                default:
                                    i--;
                                    ans += '\u3077';
                                    break;
                            }
                            break;
                        case 'M':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'A':
                                    ans+='\u307E';
                                    break;
                                case 'I':
                                    ans+='\u307F';
                                    break;
                                case 'U':
                                    ans+='\u3080';
                                    break;
                                case 'E':
                                    ans+='\u3081';
                                    break;
                                case 'O':
                                    ans+='\u3082';
                                    break;
                                default:
                                    i--;
                                    ans += '\u3080';
                                    break;
                            }
                            break;
                        case 'Y':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'A':
                                    ans+='\u3084';
                                    break;
                                case 'U':
                                    ans+='\u3086';
                                    break;
                                case 'O':
                                    ans+='\u3088';
                                    break;
                                default:
                                    i--;
                                    ans += '\u3086';
                                    break;
                            }
                            break;
                        case 'R':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'A':
                                    ans+='\u3089';
                                    break;
                                case 'I':
                                    ans+='\u308A';
                                    break;
                                case 'U':
                                    ans+='\u308B';
                                    break;
                                case 'E':
                                    ans+='\u308C';
                                    break;
                                case 'O':
                                    ans+='\u308D';
                                    break;
                                default:
                                    i--;
                                    ans += '\u308B';
                                    break;
                            }
                            break;
                        case 'W':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'A':
                                    ans+='\u308F';
                                    break;
                                case 'I':
                                    ans+='\u3090';
                                    break;
                                case 'E':
                                    ans+='\u3091';
                                    break;
                                case 'O':
                                    ans+='\u3092';
                                    break;
                                default:
                                    i--;
                                    ans += '\u3092';
                                    break;
                            }
                            break;
                        default:
                            ans += in.charAt(i);
                    }
                }
            }
            else {
                if(in.charAt(i)==' ')
                    ans += '_';
                else
                    ans += in.charAt(i);
            }
        }
        return ans;
    }
    public String toRoman(String in)
    {
        String ans = "";

        for(int i=0;i<ans.length();i++) {
            switch (i)
            {
                case 'あ':
                    ans+='A';
                    break;
                case 'い':
                    ans+='I';
                    break;
                case 'え':
                    ans+='E';
                    break;
                case 'お':
                    ans+='O';
                    break;
                case 'う':
                    ans+='U';
                    break;

            }
        }

        return ans;
    }
    private static boolean isVowel(char in)
    {
        return "AIEOU".indexOf(in)!=-1;
    }
}
