import java.util.HashSet;
import java.util.Set;

public class DBCSValidation {
	public static Set<Character.UnicodeBlock> CJKUnicodeBlocks = new HashSet<Character.UnicodeBlock>()
    {{  //Chinese block
    	add( Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
        add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS);
        add( Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
        add( Character.UnicodeBlock.GENERAL_PUNCTUATION);
        add( Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION);
        add(Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
        // Japan block
        add(Character.UnicodeBlock.HIRAGANA);
        add(Character.UnicodeBlock.KATAKANA);
        //Korean block
        add(Character.UnicodeBlock.HANGUL_JAMO);
        add(Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO);
        add(Character.UnicodeBlock.HANGUL_SYLLABLES);
        add(Character.UnicodeBlock.HANGUL_JAMO_EXTENDED_A);
        }};
    public static void main(String[] args) {  
        String str = "きくくくくすつつ的sdfwe1212)fdsjfhdshffdfds$%$#%#(*(&(&^T{}JHULBGVGHDU(&%@#!@#$%^&";  
        String mixed = "안녕하세요This is a Japanese newspaper headline: ラドクリフ、マラソン五輪代表に1万m出場にも含み我爱北京天安门；";
        String pure="dshfsdhfjdhsjfhjshfjseh^&%^$%$%$%$99898989d{}{P{PJIHI";
        String chinese="dshfsdhfjdhsjfhjshfjseh^&%^$%$%$%$99898989d{}{P{PJIHI飞";
        String japanese="dshfsdhfjdhsjfhjshfjseh^&%^$%$%$%$99898989d{}{P{PJIHIきくくくくすつつ";
       System.out.println( checkForSpecialChars(mixed));
       System.out.println( checkForSpecialChars(str));
       System.out.println( checkForSpecialChars(pure));
       System.out.println( checkForSpecialChars(chinese));
       System.out.println( checkForSpecialChars(japanese));
 
    } 

    public static boolean checkForSpecialChars(String str){
 
        for (char c : str.toCharArray())
        {
            if (CJKUnicodeBlocks.contains(Character.UnicodeBlock.of(c)))
            {
                System.out.println(c + " is a DBCS character"); 
                return true;
            }
        }
        System.out.println("No DBCS character"); 
        return false;
    }
    }

