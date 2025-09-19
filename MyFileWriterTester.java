import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

public class MyFileWriterTester {
    // Tester methods
    public static String testHashFileEmptyFiles() throws IOException {
        BufferedWriter emptyFile = new BufferedWriter(new FileWriter("emptyFile.txt"));

        // close bufferedWriter
        emptyFile.close();

        // test the hash method
        return MyFileWriter.hashFile("emptyFile.txt");

    }

    public static String testHashFileLargeFiles(String filePath) {
        // test the hash method
        return MyFileWriter.hashFile(filePath);
    
    }

    public static String testHashFileSpecialChars(String filePath) {
        // test the hash method
        return MyFileWriter.hashFile(filePath);
    
    }



    public static String testHashFileNonExistent(String filePath) {
        // test the hash method
        return MyFileWriter.hashFile(filePath);
    
    }


    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
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
        MyFileWriter.secretPassword();
        MyFileWriter.confidentialPlans();
        System.out.println();

        // stringify()
        System.out.println(MyFileWriter.stringify("example.txt"));
        System.out.println(MyFileWriter.stringify(".whoNeeds2FA.txt"));
        System.out.println();

        // hashFile
        System.out.println("==hashFile()==");
        System.out.println(MyFileWriter.hashFile(fileName1)); // dffd6021bb2bd5b0af676290809ec3a53191dd81c7f70a4b28688a362182986f
        System.out.println();

        System.out.println("testHashFileEmptyFiles(): ");

        System.out.println(testHashFileEmptyFiles()); // should print out: e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855
        System.out.println(testHashFileEmptyFiles()); // should print same as above
        System.out.println();

        System.out.println("testHashFileLargeFiles(): ");
        System.out.println(testHashFileLargeFiles("theGreatGatsby.txt")); // no error
        System.out.println(testHashFileLargeFiles("theFellowshipOfTheRing.txt")); // no error
        System.out.println();

        System.out.println("testHashFileSpecialChars(): ");
        System.out.println(testHashFileSpecialChars("nonAscii1.txt")); // no error
        System.out.println(testHashFileSpecialChars("nonAscii2.txt")); // no error
        System.out.println();

        System.out.println("testHashFileNonExistent(): ");
        System.out.println(testHashFileNonExistent("HelloWorld.txt")); // FileNotFoundException
        System.out.println(testHashFileNonExistent("idkWhatToPutHere.txt")); // FileNotFoundException
        System.out.println();

    }

}
