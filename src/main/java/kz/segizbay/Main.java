package kz.segizbay;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("MyFS 1.0 команды:");
        MyFile.help();

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] tokens = input.split(" ", 3);

            String command = tokens[0];
            String path = tokens.length > 1 ? tokens[1] : "";
            String additionalArg = tokens.length > 2 ? tokens[2] : "";

            switch (command) {
                case "ls":
                    MyFile.listDirectory(path);
                    break;
                case "ls_py":
                    MyFile.listPythonFiles(path);
                    break;
                case "is_dir":
                    MyFile.isDirectory(path);
                    break;
                case "define":
                    MyFile.define(path);
                    break;
                case "readmod":
                    MyFile.printPermissions(path);
                    break;
                case "setmod":
                    MyFile.setPermissions(path, additionalArg);
                    break;
                case "cat":
                    MyFile.printContent(path);
                    break;
                case "append":
                    MyFile.appendFooter(path);
                    break;
                case "bc":
                    MyFile.createBackup(path);
                    break;
                case "greplong":
                    MyFile.printLongestWord(path);
                    break;
                case "help":
                    MyFile.help();
                    break;
                case "exit":
                    MyFile.exit();
                    return;
                default:
                    System.out.println("Неизвестная команда. Используйте 'help' для получения списка команд.");
            }
        }
    }
}
