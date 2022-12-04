# Information for Assignment 6

## How it works

* For example if you run `TextToCode.java` it will ask the user for file name
  and that file name is already defined in `TextToCode.java` class named hamlet.txt.
* When you run the program just type `hamlet.txt` and it will convert the text file to `.code` file and `.huff` file
* Likewise when you run `CodeToText.java` you should type `hamlet` and it will read the `.code` and `.huff` files then decode the contents.

## Example

```
For TextToCode.java
Enter file name (should end wwith .txt): hamlet.txt
if it worked you should see two newlly created files: hamlet.code and hamlet.huff

For CodeToText.java
Enter file name (without period): hamlet
if it worked you should see the decoded test aka content of hamlet.txt
```

## Note

* if you want another file to be encoded and decoded change the file name in `TextToCode.java`.
* No changes for `CodeToText.java` is needed because it depends on `.code` and `.huff` files when they were created from `TextToCode.java`.

```java
public class TextToCode {
  
  /**
   * <p>This method ask the user for a file name, and check if the entered file
   * is valid, if not it will ask the user to enter a valid file name.</p>
   */
  public static void user_input() {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter file name (Should end with .txt): ");
    String file_name = in.nextLine();

    if (!(file_name.contains("HAMLET")) // add the file name you want to encode
            && !(file_name.contains("hamlet")) // add the file name you want to encode
            || !(file_name.contains(".txt"))) {
      System.out.println("File name is invalid please try again.");
      user_input();
    }
  }

  /**
   * <p>This method reads the file and stores the characters in a list, and
   * also check if the file is available or not</p>
   */
  public void read_file() {
    try {
      // add the file name you want to encode
      FileInputStream fis = new FileInputStream("hamlet.txt");
      while (fis.available() > 0) {
        char c = (char) fis.read();
        char_list.add(c);
        System.out.print(c);
      }
      fis.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
      // add the file name you want to encode
    TextToCode ttc = new TextToCode("hamlet.txt");
    ttc.run();
  }
} 
```
