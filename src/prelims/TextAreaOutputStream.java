package prelims;

import javax.swing.*;
import java.io.OutputStream;

public class TextAreaOutputStream extends OutputStream {

    private final JTextArea chatTxtArea;
    private final StringBuilder stringBuilder = new StringBuilder();

    public TextAreaOutputStream(JTextArea txtArea){this.chatTxtArea = txtArea;}

    @Override
    public void write(int b) {
        if (b == '\r') {
            return;
        }
        if (b == '\n') {
            final String text = stringBuilder.toString() + "\n";

            chatTxtArea.append(text);
            stringBuilder.setLength(0);
        } else {
            stringBuilder.append((char) b);
        }
    }
}