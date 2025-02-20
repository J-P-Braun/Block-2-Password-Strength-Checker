package cs3540;

import java.util.Scanner;
import java.util.regex.Pattern;
/**
 * This is a very very simple Password Strength Checker. It takes in input from the console and checks to make sure the password is at least 10 characters long
 * and it contains at least 1 capital letter, 1 number and 1 special character(`~!@#$%^&*()-_+=). This website was used for Regex reference https://www.baeldung.com/java-lowercase-uppercase-special-character-digit-regex
 * 
 * @author Jesse Braun
 * @version February 20, 2025
 * 
 */
public class PasswordStrengthChecker {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean passwordStrong = false;
		Pattern capital  = Pattern.compile(".*[A-Z].*");
		Pattern number = Pattern.compile(".*[0-9].*");
		Pattern specialChar = Pattern.compile(".*[`~!@#$%^&*()-_+=].*");
		while(passwordStrong == false) {
			System.out.println("Input the password you want to check. Enter 0 to Exit.");
			String inputStr = scan.next();
			if(inputStr.equals("0")) {
				scan.close();
				return;
			}
			int check = 4;
			if(inputStr.length()<10) {
				System.out.println("Password should be at least 10 characters long. Your password is " + inputStr.length() + " characters long.");
				check -=1;
			}
			if(!specialChar.matcher(inputStr).matches()) {
				System.out.println("Password should contain at least one special character.");
				check -=1;
			}
			if(!capital.matcher(inputStr).matches()) {
				System.out.println("Password should contain at least one capital letter.");
				check -=1;
			}
			if(!number.matcher(inputStr).matches()) {
				System.out.println("Password should contain at least one number letter.");
				check -=1;
			}
			if(check == 4) {
				passwordStrong = true;
			}
		}
		System.out.println("Your password is adequately strong. Thank you.");
		scan.close();
		return;
	}

}
