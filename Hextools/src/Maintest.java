

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Maintest {
	
	public static void main(String args[]) throws IOException{
		File fil = new File("123.txt");
		System.out.println(Maintest.class.getProtectionDomain().getCodeSource().getLocation().getFile());
//		FileReader fr = new FileReader(fil);
//		BufferedReader br = new BufferedReader (fr);
//		String temp;
//		while((temp=br.readLine())!=null){
//			System.out.print(temp);
//			
//		}
		
		String test = "Reporting Period,\"2 Sep, 2016 - 1 Oct, 2016 inclusive(31 days)";
		//System.out.println(replaceStr(test));
	}
	
	public static String replaceStr(String str,String dest){
	     if(str!=null && !"".equals(str)) {      
	         Pattern pattern = Pattern.compile("\\d{1,2} [a-zA-Z]{3},? \\d{4} (to)?-? \\d{1,2} [a-zA-Z]{3},? \\d{4} inclusive.*"); //去掉空格符合换行符     
	         Matcher matcher = pattern.matcher(str);      
	         String result = matcher.replaceAll(dest);      
	         return result;      
	     }else {      
	         return str;      
	     }
		
	}
    private static String recreateReportPeriod(String fileContent) {

        //		save report period
        String period = "Reporting Period";
        String str2 = fileContent;
        int per = str2.indexOf(period);
        int end = str2.indexOf("\n", per);
        StringBuffer tmpBuf = new StringBuffer();
        while (true) {
            String str3 = str2.substring(per, end);
            
            String str4 = null;
            if (str3.indexOf(';') > -1){
                str4 = str3.replaceAll(";",",");
                 
                str4 = str4.replaceAll(",", "\",\"");
                
                str4 = str4.substring(0,str4.indexOf(')')+1);
                
                str3 = "\"" + str4 + "\n\r";
            } else {
                return fileContent;
            }    
             
            
            
            StringTokenizer strtok = new StringTokenizer(str3, "\"\n\r");
            tmpBuf.setLength(0);
            StringBuffer buf = new StringBuffer();
            // remove all " from period
            while (strtok.hasMoreTokens()) {
                tmpBuf.append((String) strtok.nextElement());
                buf.append(tmpBuf);
                tmpBuf.setLength(0);
            }

            strtok = new StringTokenizer(buf.toString(), ",");
            tmpBuf = new StringBuffer();
            buf = new StringBuffer();
            boolean comma = false;
            while (strtok.hasMoreTokens()) {
                tmpBuf.append((String) strtok.nextElement());
                buf.append(tmpBuf);
                if (!comma) {
                    buf.append("\",\"");
                    comma = true;
                } else {
                    buf.append(",");
                }

                tmpBuf.setLength(0);
            }
            buf.deleteCharAt(buf.length() - 1);
            buf.append("\"");
            tmpBuf.append(str2);
            tmpBuf.replace(per, end,"\"" + buf.toString());
            str2 = tmpBuf.toString();
            per = str2.indexOf(period, end);
            end = str2.indexOf("\n", per);
            if (per < 1)
                break;
            str2 = tmpBuf.toString();
        }
        return tmpBuf.toString();

    }

}
