package ex01;

import java.io.*;

// Writer
public class MyWriter extends BufferedWriter {

    private boolean autoFlush = false;

    public MyWriter(OutputStream stream) {
        super(new OutputStreamWriter(stream));
    }

    public MyWriter(OutputStream stream, boolean autoFlush) {
        super(new OutputStreamWriter(stream));
        this.autoFlush = autoFlush;
    }

    public void println(String msg) {
        try {
            this.write(msg);
            this.write("\n");
            if (autoFlush) {
                this.flush();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}