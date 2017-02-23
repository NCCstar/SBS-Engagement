package other;
//import java.util.*;
public class Hiragana
{
    public static String toHiragana(String in)
    {
        in = in.toLowerCase();
        in = in.replace('l','r');
        in = in.replace('c','k');
        in = in.replace('f','h');

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
                        case 'a':
                            ans+='\u3042';
                            break;
                        case 'i':
                            ans+='\u3044';
                            break;
                        case 'u':
                            ans+='\u3046';
                            break;
                        case 'e':
                            ans+='\u3048';
                            break;
                        case 'o':
                            ans+='\u304A';
                            break;
                    }
                }
                else//consonat
                {
                    switch(curr)
                    {
                        case 'k':
                            curr = in.charAt(++i);
                            switch(curr) {
                                case 'a':
                                    ans += '\u304B';
                                    break;
                                case 'i':
                                    ans += '\u304D';
                                    break;
                                case 'u':
                                    ans += '\u304F';
                                    break;
                                case 'e':
                                    ans += '\u3051';
                                    break;
                                case 'o':
                                    ans += '\u3053';
                                    break;
                                default:
                                    i--;
                                    ans += 'k';
                                    break;
                            }
                            break;
                        case 'g':
                            curr = in.charAt(++i);
                            switch(curr) {
                                case 'a':
                                    ans += '\u304C';
                                    break;
                                case 'i':
                                    ans += '\u304E';
                                    break;
                                case 'u':
                                    ans += '\u3050';
                                    break;
                                case 'e':
                                    ans += '\u3052';
                                    break;
                                case 'o':
                                    ans += '\u3054';
                                    break;
                                default:
                                    i--;
                                    ans += 'g';
                                    break;
                            }
                            break;
                        case 's':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'a':
                                    ans+='\u3055';
                                    break;
                                case 'h'://shi
                                    if(isVowel(in.charAt(i+1))) {
                                        i++;
                                        ans += '\u3057';//start with shi
                                        switch(in.charAt(i)){//add y-vowel
                                            case 'a':
                                                ans += '\u3083';
                                                break;
                                            //no 'i'
                                            case 'u':
                                                ans += '\u3085';
                                                break;
                                            //no 'e'??
                                            case 'o':
                                                ans += '\u3087';
                                                break;
                                        }
                                    }
                                    else {
                                        i--;
                                        ans += "sh";
                                    }
                                    break;
                                case 'i'://si -> shi
                                    ans += '\u3057';
                                    break;
                                case 'u':
                                    ans+='\u3059';
                                    break;
                                case 'e':
                                    ans+='\u305B';
                                    break;
                                case 'o':
                                    ans+='\u305D';
                                    break;
                                default:
                                    i--;
                                    ans += 's';
                                    break;
                            }
                            break;
                        case 'z':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'a':
                                    ans+='\u3056';
                                    break;
                                case 'h'://shi
                                    i++;
                                    ans+='\u3058';
                                    break;
                                case 'u':
                                    ans+='\u305A';
                                    break;
                                case 'e':
                                    ans+='\u305C';
                                    break;
                                case 'o':
                                    ans+='\u305E';
                                    break;
                                default:
                                    i--;
                                    ans += 'z';
                                    break;
                            }
                            break;
                        case 't':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'a':
                                    ans+='\u305F';
                                    break;
                                case 'h'://chi
                                    i++;
                                    ans+='\u3061';
                                    break;
                                case 's'://tsu
                                    if(in.charAt(i+1)=='u') {
                                        i++;
                                        ans += '\u3064';
                                    }
                                    else
                                    {
                                        ans += "ts";
                                    }
                                    break;
                                case 'u':
                                    ans += '\u3064';
                                    break;
                                case 'e':
                                    ans+='\u3066';
                                    break;
                                case 'o':
                                    ans+='\u3068';
                                    break;
                                default:
                                    i--;
                                    ans += 't';
                                    break;
                            }
                            break;
                        case 'd':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'a':
                                    ans+='\u3060';
                                    break;
                                case 'i':
                                    i++;
                                    ans+='\u3062';
                                    break;
                                case 'u'://tsu
                                    i++;
                                    ans+='\u3065';
                                    break;
                                case 'e':
                                    ans+='\u3067';
                                    break;
                                case 'o':
                                    ans+='\u3069';
                                    break;
                                default:
                                    i--;
                                    ans += 'd';
                                    break;
                            }
                            break;
                        case 'n':
                            if(isVowel(in.charAt(i+1)))
                            {
                                curr = in.charAt(++i);
                                switch(curr)
                                {
                                    case 'a':
                                        ans+='\u306A';
                                        break;
                                    case 'i':
                                        ans+='\u306B';
                                        break;
                                    case 'u':
                                        ans+='\u306C';
                                        break;
                                    case 'e':
                                        ans+='\u306D';
                                        break;
                                    case 'o':
                                        ans+='\u306E';
                                        break;
                                }
                            }
                            else
                                ans+='\u3093';
                            break;
                        case 'h':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'a':
                                    ans+='\u306F';
                                    break;
                                case 'i':
                                    ans+='\u3072';
                                    break;
                                case 'u':
                                    ans+='\u3075';
                                    break;
                                case 'e':
                                    ans+='\u3078';
                                    break;
                                case 'o':
                                    ans+='\u307B';
                                    break;
                                default:
                                    i--;
                                    ans += 'h';
                                    break;
                            }
                            break;
                        case 'b':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'a':
                                    ans+='\u3070';
                                    break;
                                case 'i':
                                    ans+='\u3073';
                                    break;
                                case 'u':
                                    ans+='\u3076';
                                    break;
                                case 'e':
                                    ans+='\u3079';
                                    break;
                                case 'o':
                                    ans+='\u307C';
                                    break;
                                default:
                                    i--;
                                    ans += 'b';
                                    break;
                            }
                            break;
                        case 'p':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'a':
                                    ans+='\u3071';
                                    break;
                                case 'i':
                                    ans+='\u3074';
                                    break;
                                case 'u':
                                    ans+='\u3077';
                                    break;
                                case 'e':
                                    ans+='\u307A';
                                    break;
                                case 'o':
                                    ans+='\u307D';
                                    break;
                                default:
                                    i--;
                                    ans += 'p';
                                    break;
                            }
                            break;
                        case 'm':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'a':
                                    ans+='\u307E';
                                    break;
                                case 'i':
                                    ans+='\u307F';
                                    break;
                                case 'u':
                                    ans+='\u3080';
                                    break;
                                case 'e':
                                    ans+='\u3081';
                                    break;
                                case 'o':
                                    ans+='\u3082';
                                    break;
                                default:
                                    i--;
                                    ans += 'm';
                                    break;
                            }
                            break;
                        case 'y':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'a':
                                    ans+='\u3084';
                                    break;
                                case 'u':
                                    ans+='\u3086';
                                    break;
                                case 'o':
                                    ans+='\u3088';
                                    break;
                                default:
                                    i--;
                                    ans += 'y';
                                    break;
                            }
                            break;
                        case 'r':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'a':
                                    ans+='\u3089';
                                    break;
                                case 'i':
                                    ans+='\u308A';
                                    break;
                                case 'u':
                                    ans+='\u308B';
                                    break;
                                case 'e':
                                    ans+='\u308C';
                                    break;
                                case 'o':
                                    ans+='\u308D';
                                    break;
                                default:
                                    i--;
                                    ans += 'r';
                                    break;
                            }
                            break;
                        case 'w':
                            curr = in.charAt(++i);
                            switch(curr)
                            {
                                case 'a':
                                    ans+='\u308F';
                                    break;
                                case 'i':
                                    ans+='\u3090';
                                    break;
                                case 'e':
                                    ans+='\u3091';
                                    break;
                                case 'o':
                                    ans+='\u3092';
                                    break;
                                default:
                                    i--;
                                    ans += 'w';
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
                    ans+='a';
                    break;
                case 'い':
                    ans+='i';
                    break;
                case 'え':
                    ans+='e';
                    break;
                case 'お':
                    ans+='o';
                    break;
                case 'う':
                    ans+='u';
                    break;
            }
        }

        return ans;
    }
    private static boolean isVowel(char in)
    {
        return "aeiou".indexOf(in)!=-1;
    }
}
