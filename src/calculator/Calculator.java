/**
 * 
 * 			ECSE 428 Assignment B Test Driven Development
 * 			HUANG, Yin Jun - 260743592
 * 			LEI, Jun Yu - 260738036
 * 
 */

package calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import calculator.PostalInfo;

public class Calculator {
	
	private static DecimalFormat decimal = new DecimalFormat(".##");
	
	static String postalType[] = {"regular", "xpress", "priority"};
	static String fromPostalCode, toPostalCode;
	static float length, width, weight, height, postalRate;
	
	public static void main(String[] args){
		
		if ((args.length == 0) || (args.length < 7) || (args.length > 7)) {
			System.out.print("Usage: Calculator fromPostalCode toPostalCode postType length width height weight");
			return;
		}
		
		ArrayList<PostalInfo> postalInfos = new ArrayList<PostalInfo>();
		parseData("postal-code-data.csv",postalInfos);

		String fromData = args[0].toUpperCase();
		String toData = args[1].toUpperCase();
		String type = args[2].toLowerCase();
		try {
			length = Float.parseFloat(args[3]);
			width= Float.parseFloat(args[4]);
			height= Float.parseFloat(args[5]);
			weight = Float.parseFloat(args[6]);
		} catch (NumberFormatException e) {
			System.out.print("Invalid input: length, width, height or weight is/are invalid.");
			return;
		}
		
		if ((length <= 0) || (width <= 0) || (height <= 0) || (weight <= 0)){
			System.out.print("Your number inputs should be larger than 0");
			return;
		}
		
		if ((length > 100) || (width > 80) || (height > 50)){
			System.out.print("Over Dimensions: the maximum length is 100 cm, the maximum width is 80cm and the maximum height is 50 cm");
			return;
		}
		
		if (weight > 30) {
			System.out.print("Over Weight, the maximum weight is 30 kg");
			return;
		}
		
		if (!isValidPostalCode(fromData)) {
			System.out.print("Invalid input: From postal code is invalid.");
			return;
		} else if (!isValidPostalCode(toData)) {
			System.out.print("Invalid input: To postal code is invalid.");
			return;
		} 
		
		if (!(type.equals("regular")) && !(type.equals("xpress")) && !(type.equals("priority"))) {
			System.out.print("Invalid input: post type is invalid.");
			return;
		}
		
		Float postalPrice = 0f;
		PostalInfo tempPostalInfo = null;
		boolean noExistentFromPostalCode = true, noExistentToPostalCode = true, noMatching = false;
				
		for(PostalInfo p: postalInfos){
			if(p.getFromPostalCode().equals(fromData)) {
				noExistentFromPostalCode = false;
			}
		}
		
		for(PostalInfo p: postalInfos){
			if(p.getToPostalCode().equals(toData)) {
				noExistentToPostalCode = false;
			}
		}
		
		if(noExistentFromPostalCode){
			System.out.print("Invalid input: From postal code is non-existent in our database.");
			return;
		} else if (noExistentToPostalCode) {
			System.out.print("Invalid input: To postal code is non-existent in our database.");
			return;
		}
		
		for(PostalInfo p: postalInfos){
			if(p.getFromPostalCode().equals(fromData)) {
				if(p.getToPostalCode().equals(toData)){
					tempPostalInfo=p;
				}
				else noMatching = true;
			}
		}
		
		if (noMatching){
			System.out.print("Entered From and To postal codes do not match in our database.");
			return;
		}
		
		if(type.equals(postalType[0])){
			postalPrice = tempPostalInfo.getRegularPrice()* weight;
		}
		else if(type.equals(postalType[1])){
			postalPrice = tempPostalInfo.getXpressPrice()* weight;
		}
		else if(type.equals(postalType[2])){
			postalPrice = tempPostalInfo.getPriorityPrice()* weight;
		}
		
		System.out.print(decimal.format(postalPrice));
	}
	
	
	private static void parseData(String filename,ArrayList<PostalInfo> postalInfos) {
		File csvFile = new File(filename);
		String line = "";
		String csvSplit = ",";
		
		try (BufferedReader br = new BufferedReader (new FileReader (csvFile))) {
			
			while ((line = br.readLine()) != null){
				String[] tempInfo = line.split(csvSplit);
				PostalInfo tempPostalInfo=null;
				String fromData = tempInfo[0];
				String toData = tempInfo[1];
				String postTypeData = tempInfo[2];
				Float maxLengthData = Float.parseFloat(tempInfo[3]);
				Float maxWidthData = Float.parseFloat(tempInfo[4]);
				Float maxHeightData = Float.parseFloat(tempInfo[5]);
				Float maxWeightData = Float.parseFloat(tempInfo[6]);
				Float price =  Float.parseFloat(tempInfo[7]);

				if((tempPostalInfo=getRepetedPostalInfo(fromData,toData,postalInfos))!=null){
					if (postTypeData.equals(postalType[0])) {
						tempPostalInfo.setRegularPrice(price);
					} else if (postTypeData.equals(postalType[1])) {
						tempPostalInfo.setXpressPrice(price);
					} else if (postTypeData.equals(postalType[2])) {
						tempPostalInfo.setPriorityPrice(price);
					}
				}
				else{
					tempPostalInfo = new PostalInfo(fromData, toData, postTypeData, maxLengthData, maxWidthData,
							maxHeightData, maxWeightData, price);
					postalInfos.add(tempPostalInfo);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static PostalInfo getRepetedPostalInfo(String fromData, String toData,ArrayList<PostalInfo> postalInfos){
		for (PostalInfo p : postalInfos) {
			if (p.getFromPostalCode().equals(fromData) && p.getToPostalCode().equals(toData)) {
				return p;
			}
		}
		return null;		
	}
	
	private static boolean isValidPostalCode (String postalCode) {
		postalCode.toUpperCase();
		
		if (postalCode.length() != 6) {
			return false;
		}
		
		char letterA = postalCode.charAt(0);
		char numberA = postalCode.charAt(1);
		char letterB = postalCode.charAt(2);
		char numberB = postalCode.charAt(3);
		char letterC = postalCode.charAt(4);
		char numberC = postalCode.charAt(5);
		
		if (!Character.isLetter(letterA)) return false;
		else if (!Character.isLetter(letterB)) return false;
		else if (!Character.isLetter(letterC)) return false;
		else if (!Character.isDigit(numberA)) return false;
		else if (!Character.isDigit(numberB)) return false;
		else if (!Character.isDigit(numberC)) return false;
		
		return true;
	}
}