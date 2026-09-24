package handler;

import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.input.BOMInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileFilter {
     public static BOMInputStream createBomInputStream(InputStream is) throws IOException {
          return BOMInputStream.builder()
                  .setInputStream(is)
                  .setInclude(false)
                  .setByteOrderMarks(
                       ByteOrderMark.UTF_8,
                       ByteOrderMark.UTF_16LE,
                       ByteOrderMark.UTF_16BE,
                       ByteOrderMark.UTF_32LE,
                       ByteOrderMark.UTF_32BE
                  )
                  .get();
     }
     public static Charset getFileEncoding(BOMInputStream bis) throws IOException {
         String bomCharset = bis.getBOMCharsetName();

         return (bomCharset != null) ? Charset.forName(bomCharset) : StandardCharsets.UTF_8;
     }

}
