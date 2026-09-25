package handler;

import org.apache.commons.io.input.BOMInputStream;
import validation.FileInitializer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class Filtering {
    public static File filterFile(File sourceFile) throws Exception {
        if (!FileInitializer.checkExtension(sourceFile)) {
            throw new IllegalArgumentException("No support file extension for \"" + sourceFile.getName() + "\"");
        }

        File tempFile = File.createTempFile("filtered", ".temp");
        tempFile.deleteOnExit();

        try (
                InputStream is = Files.newInputStream(sourceFile.toPath());
                BOMInputStream bis = FileFilter.createBomInputStream(is)) {

            Charset fileCharset = FileFilter.getFileEncoding(bis);

            try (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(bis, fileCharset));
                    BufferedWriter writer = Files.newBufferedWriter(tempFile.toPath(), fileCharset,
                            StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {

                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
        return tempFile;
    }
}
