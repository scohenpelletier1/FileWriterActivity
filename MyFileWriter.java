import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    /**
    * Reads a text file and returns its contents as a string.
    * 
    * @param filePath the path to the file
    * @return the contents of the file as a string
    * @throws IOException if an I/O error occurs
    */
    public static String stringify(String filePath) throws IOException {
        // get the file
        BufferedReader file = new BufferedReader(new FileReader(filePath));
        String contents = "";
        String line;

        // read through the file
        while ((line = file.readLine()) != null) {
            contents += line;
            
        }

        // close the buffered reader
        file.close();
        
        // Read the file at filePath and return its contents as a String
        return contents;
    
    }

    // to string method
    public String toString() {
        return "Hello, World!";

    }
    
    private static void printFileSize(String... fileNames) {
        long totalSize = 0;
        for (String fileName : fileNames) {
            File file = new File(fileName);
            if (file.exists()) {
                totalSize += file.length();
            }
        }
        System.out.println("Total size of all files: " + totalSize + " bytes");

    }

    public static String hashFile(String filePath) {
        // catch exceptions using try catch
        try {

            // check to see if the file exists
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException("This file " + filePath + "doesn't exist.");

            }

            // read the file
            String fileContents = "";

            // catch exceptions using try catch
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    fileContents += line;

                }

            }

            // ceate sha-256 digest
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // get the hash by counting bytes
            byte[] hashBytes = digest.digest(fileContents.getBytes(StandardCharsets.UTF_8));

            // convert hash to hex string
            String hexCode = "";

            for (int i = 0; i < hashBytes.length; i++) {
                hexCode += String.format("%02x", hashBytes[i]);
            
            }

            return hexCode;

        } catch (FileNotFoundException e) {
            return "The file was not found" + e.getMessage();

        } catch (IOException e) {
            return "The file could not be read" + e.getMessage();

        } catch (NoSuchAlgorithmException e) {
            return "SHA-256 algorithm not available" + e.getMessage();

        }

    }
    
}
