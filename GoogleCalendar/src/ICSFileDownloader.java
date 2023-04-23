import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ICSFileDownloader {

    // create a file chooser
    public ICSFileDownloader() throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("ICS files (*.ics)", "ics"));
        fileChooser.setSelectedFile(new File("schedule.ics"));
        int result = fileChooser.showSaveDialog(null);
        if (result==JFileChooser.APPROVE_OPTION) {
            // get the selected file
            File selectedFile = fileChooser.getSelectedFile();
            File file = new File("schedule.ics");
            InputStream inputStream = new FileInputStream(file);

            // write the file to the selected location
            try (OutputStream outputStream = new FileOutputStream(selectedFile)) {
                // replace "fileData" with the byte array or InputStream of your file
                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
                outputStream.close(); 

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
