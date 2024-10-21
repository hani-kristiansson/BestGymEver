package BestGymEver;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    // path that reads file
    private MemberSearch ms = new MemberSearch("src/BestGymEver/MembershipData.txt");
    // path that writes file
    private TrainingLog tl = new TrainingLog("src/BestGymEver/TrainingLog.txt");

    public static void main(String[] args) {
        Main main = new Main();
        main.handleUserInput();
    }

    private void handleUserInput() {

        try (Scanner scan = new Scanner(System.in)) {

            while (true) {

                System.out.println("Welcome! Please Enter name or Social security number. \n Type 'exit' to finish program.");
                String input = scan.nextLine();

                if (input.equals("exit")) {
                    System.out.println("Goodbye!");
                    break;
                }
                input = input.trim();
                handleAndPrintOutMemberType(input);
            }

        } catch (NoSuchElementException e) { // when type ctrl d
            System.out.println("You have exited program.");
        }
    }

    private void handleAndPrintOutMemberType(String input) {

        Member member = ms.findMember(input);

        if (member == null) {
            System.out.println(input + " does not exist in system.");

        } else if (member.isMembershipActive(LocalDate.now())) {
            System.out.printf("%s has 'active' membership until %s.%n", member.getName(), member.membershipVaildUntilDate());

            tl.writeAndAddMemberTrainingLog(member);

        } else {
            System.out.printf("%s has 'inactive' membership since %s.%n", member.getName(), member.membershipVaildUntilDate());
        }
    }
}




