package BestGymEver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TrainingLogTest {

    TrainingLog tl = new TrainingLog("Test/BestGymEver/TrainingLogTest.txt");

    @Test
    void writeAndAddMemberTrainingLogTest() {

        Member member1 = new Member
                ("7703021234", "Alhambra Aromes", LocalDate.parse("2024-07-01"));
        Member member2 = new Member
                ("7512166544", "Greger Ganache", LocalDate.parse("2024-03-23"));


        tl.writeAndAddMemberTrainingLog(member1);
        tl.writeAndAddMemberTrainingLog(member2);

        // check if TrainingLogTest has two NEW text lines. It returns 2 when there is no existing file
        assertEquals(2,countNumberOFRowsInFile("Test/BestGymEver/TrainingLogTest.txt"));

        File file = new File("Test/BestGymEver/TrainingLogTest.txt");
        assertTrue(file.exists()); // check if there is file in the directory
        // after creating TrainingLogtest.txt file, it will be deleted so test will be running next time without a problem
        file.delete();
    }

    // calculate number of lines
    private int countNumberOFRowsInFile(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            int count = 0;
            while (reader.readLine() != null) {
                count++;
            }
            return count;

        } catch (IOException e) {
            System.out.println("Error occurred when counting lines in file ");
            e.printStackTrace();
            // this will help to exit the test
            throw new RuntimeException("Error occurred when counting lines in file " + fileName);
        }
    }
}
