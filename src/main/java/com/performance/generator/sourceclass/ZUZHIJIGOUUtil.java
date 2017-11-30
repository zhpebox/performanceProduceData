package com.performance.generator.sourceclass;

/**
 * @author wangchen
 * @version 创建时间:2017年8月23日上午10:15:46
 *
 */
public class ZUZHIJIGOUUtil {
	private static int ascNum;

	public static int getAsc(String st) {
		byte[] gc = st.getBytes();
		ascNum = (int) gc[0] - 55;
		return ascNum;
	}

	public static ZUZHIJIGOUObject generatorCompanyInfo(int index) {
		String comCodePre;
		String comCode;
		if (index < 100000000) {
			comCodePre = String.format("%08d", index) + "";
		} else if (index > 1000000000) {
			System.out.println("企业代码超出预订范围!");
			return null;
		} else {
			comCodePre = index + "";
		}
		comCode = proving(comCodePre);
		ZUZHIJIGOUObject zo = new ZUZHIJIGOUObject();
		zo.setCode(comCode);
		zo.setName("企业" + comCodePre);
		return zo;
	}

	public static String proving(String sd) {
		String yz = "";
		int[] in = { 3, 7, 9, 10, 5, 8, 4, 2 };
		int a = 0;
		for (int i = 0; i < in.length; i++) {
			if (sd.substring(i, i + 1).matches("[A-Z]")) {
				a += in[i] * getAsc(sd.substring(i, i + 1));
			} else {
				a += in[i] * Integer.parseInt(sd.substring(i, i + 1));
			}
		}
		int c9 = 11 - a % 11;
		if (c9 == 10) {
			yz = "X";
		} else if (c9 == 11) {
			yz = "0";
		} else {
			yz = c9 + "";
		}
		yz = sd + "" + yz;

		return yz;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZUZHIJIGOUObject zo = ZUZHIJIGOUUtil.generatorCompanyInfo(10000055);
		System.out.println(zo.getName() + "," + zo.getCode());
	}

}
