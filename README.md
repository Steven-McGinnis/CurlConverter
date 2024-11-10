# Curl Converter 🚀

The **Curl Converter** is a Java Swing application that simplifies the process of generating `curl` commands from structured input. It accepts user input in a custom format, extracts essential details like HTTP method, URL, and data, and generates a valid `curl` command. The application also features a "Copy" button for convenience, allowing users to copy the generated command to their clipboard.

---

## Features

- **Input Parsing**: Accepts input containing HTTP methods, URLs, and optional data.
- **Curl Command Generation**: Converts input into a valid `curl` command with appropriate headers and data payload.
- **Clipboard Copy**: Allows users to copy the generated `curl` command to their clipboard with a single click.
- **User-Friendly Interface**: Intuitive GUI built using Java Swing.

---

## How to Use

1. **Run the Application**:

   - Compile and run the `CurlConverter` class.
   - The application window will open, displaying input and output fields along with "Convert" and "Copy" buttons.

2. **Enter Input**:

   - Provide input in the following format:
     ```
     method: <http-method>; url: <url>; data: <json-data>;
     ```
   - Example:
     ```
     post; url: https://example.com/api/resource; data: {"key":"value"};
     ```

3. **Generate the Curl Command**:

   - Click the "Convert" button to generate the `curl` command based on the input.
   - The generated `curl` command will appear in the "Curl Command" field.

4. **Copy the Command**:
   - Click the "Copy" button to copy the generated `curl` command to your clipboard.

---

## Input Example and Output

### Example Input

### Generated Curl Command

```bash
curl -X POST "https://example.com/api/resource" -H "Content-Type: application/json" -d '{"key":"value"}'
```

## Installation and Running

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/your-username/Curl-Converter.git
   ```

2. **Compile the Application**:

   ```bash
   javac CurlConverter.java
   ```

3. **Run the Application**:

   ```bash
   java CurlConverter
   ```

## Dependencies

- Java Development Kit (JDK) 8 or higher.

---

## Future Enhancements

- **Enhanced Input Parsing**: Support additional HTTP headers or content types.
- **Validation Improvements**: Provide detailed error messages for invalid inputs.
- **File Input/Output**: Enable users to load input from files and save the generated `curl` commands.
- **Custom Headers**: Allow users to specify additional headers.

---

## Acknowledgments

This program was developed to address a specific need at my previous job, where backend request logs often displayed HTTP method, URL, and data. The **Curl Converter** was designed to quickly transform these logs into valid `curl` commands for use in Postman or other API testing tools. Special thanks to the Java Swing library for its ease of use in creating this intuitive GUI.

---

Feel free to explore, modify, and share feedback for the **Curl Converter** project!
