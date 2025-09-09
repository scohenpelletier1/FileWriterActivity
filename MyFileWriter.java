import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class MyFileWriter {
    // secret password file creator
    public static void secretPassword() throws IOException {
        // make secret password
        BufferedWriter secretPassword = new BufferedWriter(new FileWriter(".whoNeeds2FA.txt"));
        secretPassword.write("My genius, impossible to break password: password123");

        // close bufferedWriter
        secretPassword.close();

    }

    public static void confidentialPlans() throws IOException {
        // get file paths
        String directory = "/Users/scp/Desktop/School/12th Grade/Honors Topics/HTCS_Projects/FileWriterActivity/.topSecret";

        // put the secret file in the .topSecret file
        File secretFile = new File(directory, "plansForWorldDomination.dat");

        // make secret plans
        BufferedWriter secretPlans = new BufferedWriter(new FileWriter(secretFile));
        secretPlans.write("Step 1: Eat breakfast \nStep 2: Discover the meaning of life \nStep 3: ??? \nStep 4: Profit");

        // close bufferedWriter
        secretPlans.close();

    }

    // Calculate and print the file size using the File class
    private static void printFileSize(String fileName) {
        // get the file
        File file = new File(fileName);

        // print out the length
        System.out.println(file.length());

    }

    public static void main(String[] args) throws IOException {
        String data = "Hello, World!";
        String fileName1 = "example.txt";
        String fileName2 = "example2.txt";
        String fileName3 = "example3.txt";
        String fileName4 = "example4.txt";
        String fileName5 = "example5.txt";

        // 1. Using FileWriter
        try (FileWriter writer = new FileWriter(fileName1)) {
            writer.write(data);
            
        } catch (IOException e) {
            e.printStackTrace();

        }

        // 2. Using BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {
            bufferedWriter.write(data);

        } catch (IOException e) {
            e.printStackTrace();

        }

        // 3. Using FileOutputStream
        try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
            outputStream.write(data.getBytes());

        } catch (IOException e) {
            e.printStackTrace();

        }

        // 4. Using BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName4))) {
            bufferedOutputStream.write(data.getBytes());

        } catch (IOException e) {
            e.printStackTrace();

        }

        // 5. Using Files (java.nio.file)
        try {
            Files.write(Paths.get(fileName5), data.getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();

        }

        // SEE IF THE SECRET PLAN STUFF WORKS
        secretPassword();
        confidentialPlans();

        printFileSize("example.txt"); // 13
        printFileSize(".whoNeeds2FA.txt"); // 52

    }
    
}
