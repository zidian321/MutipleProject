import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import com.ibm.dk.alr.reuse.utilities.StringUtility;

public class DBCSCoding {

	public static void main(String arg[]) throws IOException {

		File fileIn = new File("D:\\eclipse\\workspace\\Testjar\\test.txt");
		File fileOut = new File("D:\\eclipse\\workspace\\Testjar\\out.txt");
		//String outString = readFileToString(fileIn);

		//writeToFile(dehexlify(outString), fileOut);
		System.out.println(dehexlify("004a00650072006e0065006a002000520061007a0062006f007201610065006b"));

	}

	private static void writeToFile(String dehexlify, File file) {
		try {

			PrintStream ps = new PrintStream(new FileOutputStream(file));
			ps.println(dehexlify);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String readFileToString(File file) {
		StringBuffer str = new StringBuffer("");

		try {

			FileReader fr = new FileReader(file);

			int ch = 0;

			while ((ch = fr.read()) != -1)

			{
				if (((char) ch) != ' ')
					// System.out.print((char)ch);
					str.append((char) ch);
			}

			fr.close();

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			System.out.println("File reader出错");

		}
		String s = str.toString().replaceAll("\r|\n", "");
		return s;
	}

	public static String dehexlify(String str) throws UnsupportedEncodingException {
		return StringUtility.dehexlify(str, "Shift_JIS");
	}
}
