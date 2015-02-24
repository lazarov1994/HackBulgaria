/**
 * @author Lazar Lazarov
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {

	public static boolean CompareFilesbyByte(String file1, String file2)
			throws IOException {
		File f1 = new File(file1);
		File f2 = new File(file2);
		
			FileInputStream fis1 = new FileInputStream(f1);
			FileInputStream fis2 = new FileInputStream(f2);
			if (f1.length() == f2.length()) {
				int n = 0;
				byte[] b1;
				byte[] b2;
				while ((n = fis1.available()) > 0) {
					if (n > 4096)
						n = 4096;
					b1 = new byte[n];
					b2 = new byte[n];
					int res1 = fis1.read(b1);
					int res2 = fis2.read(b2);
					if (Arrays.equals(b1, b2) == false) {
						System.out.println(file1 + " :\n\n " + new String(b1));
						System.out.println();
						System.out.println(file2 + " : \n\n" + new String(b2));
						return false;
					}
				}
			} else {
				return false;
			}
		
			return true;
		}
	
	static ArrayList<String> name = new ArrayList<String>();

	public static void walk(String path) throws Exception {

		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			return;

		for (int i = 0; i < list.length; i++) {

			if (list[i].isDirectory()) {

				walk(list[i].getAbsolutePath());
				// System.out.println("Directory :" +
				// list[i].getAbsolutePath());
			} else {
				// System.out.println("File :" + list[i].getAbsolutePath());

				name.add(list[i].getAbsolutePath());

			}

		}
	}

	public static void main(String[] args) throws Exception {

		long start = System.currentTimeMillis();
		walk("d:\\TEST2");
		for (int i = 0; i < name.size(); i++) {

			for (int j = 0; j < name.size(); j++) {

				if ((i != j) && (CompareFilesbyByte(name.get(i), name.get(j)))) {

					name.remove(i);
				}

			}

		}

		System.out.println(name);
		System.out.println("The program was execfuted for: "
				+ (System.currentTimeMillis() - start) + " milliseconds.");
	}

}
