# [Scanner](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html)
* Simple text scanner


```
public class MyMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.print("Enter something: ");
            String line = scanner.nextLine();
            System.out.println(line);

        }

    }

}
```
