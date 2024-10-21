package BestGymEver;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TrainingLog {

    private String filePath;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public TrainingLog(String filePath) {
        this.filePath = filePath;
    }

    public void writeAndAddMemberTrainingLog(Member MemberTrainingLog) {

        // true (append): Keeps the existing content and adds new content at the end
        // false (default) : Overwrites the existing content with the new content.
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(filePath, true))) {

            printWriter.printf("%s, %s, %s%n",
                    MemberTrainingLog.getName(), MemberTrainingLog.getSocialSecurityNumber(),
                    formatter.format(LocalDateTime.now()));

        } catch (FileNotFoundException e) {
            System.out.println("Could not write and find training log file.");

            throw new RuntimeException(e);
        }
    }
}
