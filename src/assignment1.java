import java.io.*;

public class assignment1 {
    public static void main(String [] args) throws FileNotFoundException, IOException {

        // The name of the file to open.
        String fileName = "YourName.txt";
        String filelast =  "last.txt";
        
        String line = null;
        
        try {
            // Create YourName.txt
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write("Name: Nor Adil Ali,");
            bufferedWriter.newLine();
            bufferedWriter.write("Student Id: 2014988363,");
            bufferedWriter.newLine();
            bufferedWriter.write("Address: Jalan AU3/16, Taman Desa Keramat.");
            
            // Always close files.
            bufferedWriter.close();
            
            // Read file a YourName.txt and write to file yourName.bin
            
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            } 
            bufferedReader.close();
            
            FileInputStream dis = new FileInputStream (new File
            ("YourName.txt"));
            FileOutputStream out = new FileOutputStream (new File
            ("yourname.bin"));
            
            Integer c;
             
            //continue reading till the end of the file
            while ((c = dis.read()) != -1) {
             
                //writes to the output Stream
                out.write(c);
            }
         }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
        }
            //Read from file yourname.bin file & write to last.txt
            
            try {
            // Use this for reading the data.
            byte[] buffer = new byte[1000];

            FileInputStream inputStream = 
                new FileInputStream (new File ("yourname.bin"));
            
            // read fills buffer with data and returns
            // the number of bytes read (which of course
            // may be less than the buffer size, but
            // it will never be more).
            int total = 0;
            int nRead = 0;
            while((nRead = inputStream.read(buffer)) != -1) {
                // Convert to String so we can display it.
                // Of course you wouldn't want to do this with
                // a 'real' binary file.
                System.out.println();
                System.out.println("The following Data is from "
                        + "File yourname.bin :");
                System.out.println();
                System.out.println(new String(buffer));
                total += nRead;
                
                //Write Data to File last.txt
                
                FileWriter writelast =  new FileWriter(new File ("last.txt"));
                BufferedWriter bufferedWriter =
                new BufferedWriter(writelast);
                bufferedWriter.write(new String(buffer));
                
                bufferedWriter.close();
            }   

            // Always close files.
            inputStream.close();        
            System.out.println("It has " + total + " bytes.");
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        }
}
