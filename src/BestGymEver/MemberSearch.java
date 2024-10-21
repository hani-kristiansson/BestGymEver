package BestGymEver;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberSearch {

    // object type is member in this list
    List<Member> memberList = new ArrayList<>();

    //parameter "filePath" from main
    public MemberSearch(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath));) {

            while (true) {
                String[] details = readTwoLines(br);

                if (details[0] == null || details[1] == null) {
                    break;
                }

                String[] socialSecurityNumberAndName = details[0].split(",");

                // first element, second element in first line, date from string to LocalDate data type
                // then save them in member object
                Member member = new Member(socialSecurityNumberAndName[0].trim(),
                        socialSecurityNumberAndName[1].trim(), LocalDate.parse(details[1]));
                // adding new member to the list
                memberList.add(member);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file. Please check file name again.");
            e.printStackTrace();
            /*
            System.exit(0) used when it is good code(I requested to exit without error) i.e. indicates successful termination.
            any other number used when something went wrong i.e. indicates unsuccessful termination.
             */
            System.exit(1); //turn off program as could not find any file

        } catch (IOException e) {
            System.out.println("Could not read data from file.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public String[] readTwoLines(BufferedReader br) throws IOException {
        String[] details = new String[2]; //size of array, that will fit idx nr 0,1
        details[0] = br.readLine(); //first line
        details[1] = br.readLine(); //second line

        return details;
    }

    /*
        It goes through each member in the list, and will compare the name and social security number against the
        parameter personalDetails. If we find a match then return the member instance but if we go through the whole
        list without a match we return null.
     */
    public Member findMember(String personalDetails) {
        for (Member member : memberList) {
            if (member.getName().equalsIgnoreCase(personalDetails)) {
                return member;
            } else if (member.getSocialSecurityNumber().equals(personalDetails)) {
                return member;
            }
        }
        return null;
    }
}
