package Numberguess.demo;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {

	public static void main(String[] args) {
		boolean flag = true;

		EntityManagerFactory p = Persistence.createEntityManagerFactory("numberguess");
		EntityManager m = p.createEntityManager();
		EntityTransaction t = m.getTransaction();

		Scanner sc = new Scanner(System.in);
		while (flag) {
			System.out.println();
			System.out.println("1.Play the Game \n2.Check the Result \n3.Delete the History \n4.Exit");
			System.out.println("Enter the Number : ");
			switch (sc.nextInt()) {
			case 1:
				PlayerDetails a = new PlayerDetails();
				System.out.println("Enter the Name:");
				a.setName(sc.next());
				System.out.println("Enter the Contact Number:");
				a.setContact_Number(sc.nextLong());
				System.out.println("Enter the age:");
				int age = sc.nextInt();
				if (age < 18) {
					System.out.println("Invalid Age");
					break;
				} else {
					a.setAge(age);
				}
				System.out.println("Enter the amount to Invest:");
				a.setAmount(sc.nextDouble());

				System.out.println("All the best...");

				Random r = new Random();

				int systemGeneratedValue[] = new int[3];
				for (int i = 0; i < systemGeneratedValue.length; i++) {
					systemGeneratedValue[i] = r.nextInt(9);
				}
				a.setSystemGeneratedNumber(Arrays.toString(systemGeneratedValue));
//				System.out.println("System generated values : " + Arrays.toString(systemGeneratedValue));

				int userEnteredValue[] = new int[3];
				System.out.println("Guess the Numbers ");
				double MoneyEarned = 0.0;
				for (int i = 0; i < userEnteredValue.length; i++) {
					System.out.println("Enter the " + (i + 1) + " value: ");
					userEnteredValue[i] = sc.nextInt();
					if (systemGeneratedValue[i] == userEnteredValue[i]) {
						MoneyEarned = MoneyEarned + (a.getAmount() / 3) * 2;
						System.out.println("Money Earned is " + MoneyEarned);
						System.out.println("Good guess");
						System.out.println();
						a.setTotalAmountEarned(MoneyEarned);
					} else {
						System.out.println("Opps!!! Wrong number..");
					}
				}
				System.out.println("Total Money Earned is :" + MoneyEarned);
				a.setUserEnteredNumber(Arrays.toString(userEnteredValue));

				t.begin();
				m.persist(a);
				t.commit();

				break;

			case 2:
				System.out.println("Enter the Id");
				PlayerDetails b = m.find(PlayerDetails.class, sc.nextInt());
				if (b != null) {
					System.out.println("Id:" + b.getId() + " , Name:" + b.getName() + " , Contact Number:"
							+ b.getContact_Number() + " , Age:" + b.getAge() + " , Total Amount Earned:"
							+ b.getTotalAmountEarned() + " , Date&Time:" + b.getPlayedDateAndTime()
							+ " , System Generated Values:" + b.getSystemGeneratedNumber() + " , User Entered Values:"
							+ b.getUserEnteredNumber());
				} else {
					System.out.println("Invalid Option");
				}
				break;

			case 3:
				System.out.println("Enter the Id");
				PlayerDetails c = m.find(PlayerDetails.class, sc.nextInt());
				if (c != null) {
					t.begin();
					m.remove(c);
					t.commit();
					System.err.println("Object deleted");
				} else {
					System.out.println("Invalid Id");
				}
				break;

			case 4:
				System.out.println("Thank you...Visit Again...");
				flag = false;
				break;

			default:
				System.out.println("Invalid Option");
				break;
			}
		}
	}
}
