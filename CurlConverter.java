import javax.swing.*;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurlConverter {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Curl Converter");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel inputLabel = new JLabel("Input");
        inputLabel.setBounds(10, 20, 80, 25);
        panel.add(inputLabel);

        JTextField inputText = new JTextField(20);
        inputText.setBounds(100, 20, 450, 25);
        panel.add(inputText);

        JLabel outputLabel = new JLabel("Curl Command");
        outputLabel.setBounds(10, 60, 100, 25);
        panel.add(outputLabel);

        JTextArea outputText = new JTextArea();
        outputText.setBounds(100, 60, 450, 100);
        panel.add(outputText);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(10, 170, 150, 25);
        panel.add(convertButton);

        JButton copyButton = new JButton("Copy");
        copyButton.setBounds(170, 170, 150, 25);
        panel.add(copyButton);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputText.getText();
                String curlCommand = convertToCurl(input);
                if (curlCommand != null) {
                    outputText.setText(curlCommand);
                } else {
                    outputText.setText("Invalid input format");
                }
            }
        });

        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(outputText.getText());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            }
        });
    }

    private static String convertToCurl(String input) {
        try {
            Pattern methodPattern = Pattern.compile("(get|post|put|delete|patch)", Pattern.CASE_INSENSITIVE);
            Pattern urlPattern = Pattern.compile("(https://[^\\s;]+)");
            Pattern dataPattern = Pattern.compile("data: (\\{[^;]+\\})");

            Matcher methodMatcher = methodPattern.matcher(input);
            Matcher urlMatcher = urlPattern.matcher(input);
            Matcher dataMatcher = dataPattern.matcher(input);

            if (methodMatcher.find() && urlMatcher.find()) {
                String method = methodMatcher.group(1).toUpperCase();
                String url = urlMatcher.group(1);
                String data = dataMatcher.find() ? dataMatcher.group(1) : "";

                String curlCommand = String.format("curl -X %s \"%s\" -H \"Content-Type: application/json\"", method, url);
                if (!data.isEmpty()) {
                    curlCommand += String.format(" -d '%s'", data);
                }
                return curlCommand;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
