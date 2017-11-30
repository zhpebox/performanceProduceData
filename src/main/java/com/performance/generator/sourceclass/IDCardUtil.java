package com.performance.generator.sourceclass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

/**
 * 身份证号生成工具 ============== 1、号码的结构 公民身份号码是特征组合码， 由十七位数字本体码和一位校验码组成。
 * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码 三位数字顺序码和一位数字校验码。
 * 
 * 2、地址码(前六位数） 表示编码对象常住户口所在县(市、旗、区)的行政区划代码，按GB/T2260的规定执行。
 * 
 * 3、出生日期码（第七位至十四位） 表示编码对象出生的年、月、日，按GB/T7408的规定执行，年、月、日代码之间不用分隔符。
 * 
 * 4、顺序码（第十五位至十七位） 表示在同一地址码所标识的区域范围内，对同年、同月、同日出生的人编定的顺序号，顺序码的奇数分配给男性，偶数分配给女性。
 * 
 * 5、校验码（第十八位数） （1）十七位数字本体码加权求和公式 S = Sum(Ai * Wi), i = 0, ... , 16
 * ，先对前17位数字的权求和 Ai:表示第i位置上的身份证号码数字值 Wi:表示第i位置上的加权因子 Wi: 7 9 10 5 8 4 2 1 6 3 7
 * 9 10 5 8 4 2 （2）计算模 Y = mod(S, 11) （3）通过模得到对应的校验码 Y: 0 1 2 3 4 5 6 7 8 9 10
 * 校验码: 1 0 X 9 8 7 6 5 4 3 2 ==============
 * 
 * @author zhp
 */
public class IDCardUtil {

	//生成的身份证序列号，标识一个人的 姓名 和 身份证号
	private static int index = 0;
	
	private static int areaCode = 0;
	private static int day = 0;
	private static int random = 0;
	
	//加载身份证号地区码
	private static AreaCodeUtil areaCodeUtil = new AreaCodeUtil();
	private static AreaCodeObj[] areaCodeObjArray =  areaCodeUtil.getAreaCodeObj();
	
	// verCode表示校验码对应的取值
	private static char verCode[] = new char[] { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
	// Wi表示第 i 位置上的加权因子
	private static int Wi[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

	/**
	 * 1. 地区码前六位无校验 取值范围 000000~999999
	 */
	private static String genAreaCode() {
		if (areaCode >= 6932)
			areaCode = 0;
		int temp = areaCode++;
		return areaCodeObjArray[temp].getAreaCodeNumStr();
	}
	
	private static String genAreaCode(int indexTemp) {
		int temp = indexTemp % 6932;
		return areaCodeObjArray[temp].getAreaCodeNumStr();
	}
	
	/**
	 * 顺序生成minAge到maxAge年龄段的出生年月
	 * @return
	 */
	public static String genDate(int minAge, int maxAge) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 7, 1);// 设置起始日期
		// 顺序生成前maxAge年前到minAge年前的任意一天
		if (day > 365 * (maxAge - minAge))
			day = 0;
		int numDay = 365 * minAge + day++;
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - numDay);
		return sf.format(cal.getTime());
	}
	
	public static String genDate(int minAge, int maxAge,int indexTemp) {
		int dayTemp =  0 + indexTemp;
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 7, 1);// 设置起始日期
		// 顺序生成前maxAge年前到minAge年前的任意一天
		if (dayTemp > 365 * (maxAge - minAge))
			dayTemp = dayTemp % (365 * (maxAge - minAge) +1);
		int numDay = 365 * minAge + dayTemp;
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - numDay);
		return sf.format(cal.getTime());
	}
	

	/**
	 * 顺序生成三位随机码
	 * @return
	 */
	private static String genRandom() {
		if (random > 996)  //循环限定997个
			random = 0;
		int temp = random++;
		temp += 1000;
		return (temp + "").substring(1);
	}
	
	private static String genRandom(int indexTemp) {
		int randomTemp = 0 + indexTemp;
		if (randomTemp > 996)  //循环限定997个
			randomTemp = randomTemp % 997;
		randomTemp += 1000;
		return (randomTemp + "").substring(1);
	}

	/**
	 * 生成第18位校验码
	 * 
	 * @param subIdCar
	 * @return
	 */
	public static String add18Num(String subIdCar) {
		char[] idCarChar = subIdCar.toCharArray();
		// 第18位数值依据公式∑(id_17_CharArray[i]×Wi[i])(mod 11)计算得出
		int sum = 0;
		for (int i = 0; i < 17; i++) {
			sum += (int) (idCarChar[i] - '0') * Wi[i];
			// System.out.println(id_17_CharArray[i] - '0');
		}
		char id_18 = verCode[sum % 11];
		// 拼接身份证号码
		return subIdCar + id_18;
	}

	public static void main(String[] args) {
		String nameStr = "赵钱孙";

		StringBuffer resultStr = new StringBuffer("");
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
			String idCard = nameStr + i + ":" + add18Num(genAreaCode() + genDate(18, 70) + genRandom());
			resultStr.append(idCard + "\n");
			System.out.println(idCard);
		}
		try {
			FileOutputStream fileOut = new FileOutputStream("idCard.txt");
			fileOut.write(resultStr.toString().getBytes());
			fileOut.flush();
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("OK");
	}
	
	public static String getOneIdChar() {
		String idCard = add18Num(genAreaCode() + genDate(20, 70) + genRandom());
		return idCard;
	}
	
	public static IDCardObject getOnePersonInfo(){
		return new IDCardObject("赵钱孙"+index++,add18Num(genAreaCode() + genDate(18, 70) + genRandom()));
	}
	
	/**
	 * 传入一个 index 值，返回相应的身份证号，和批量生成的身份证号 排列位置一致
	 * @param indexTemp
	 * @return
	 */
	public static IDCardObject getOnePersonInfo(int indexTemp){
		return new IDCardObject("赵钱孙"+indexTemp,add18Num(genAreaCode(indexTemp) + genDate(18, 70,indexTemp) + genRandom(indexTemp)));
	}
	
	@Test
	public void testGetOnePersonInfo(){
//		String nameStr = "赵钱孙";
//		String result = "";
//		for (int i = 0; i < 100000000; i++) {
//			if(i%1000000==0)
//			System.out.println(i);
//			String idCard = nameStr + i + ":" + add18Num(genAreaCode() + genDate(18, 70) + genRandom());
//			if(89781203<=i && i<=89781213)
//			System.out.println(idCard);
//		}
		
		
		System.out.println("*****************************");
		for(int j=89781203;j<=89781213;j++){
			IDCardObject one = getOnePersonInfo(j);
			System.out.println(one.toString());
		}
	}
	
	@SuppressWarnings("resource")
	public  IDCardObject[] getIdCardArray(String dataFile ){
		IDCardObject[] idCardObject = new IDCardObject[10000000];
		try {
			FileReader reader = new FileReader(dataFile);
			BufferedReader bfr = new BufferedReader(reader);
			String temp = "";
			while((temp=bfr.readLine())!=null){
				System.out.println(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return idCardObject;
	}

}
