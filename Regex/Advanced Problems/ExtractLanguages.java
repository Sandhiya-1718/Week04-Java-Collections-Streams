import java.util.Scanner;
import java.util.regex.*;
public class ExtractLanguages {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a sentence that has programming languages:");
        String input=scanner.nextLine();
        String[] languages={"c", "c\\+\\+", "java", "python", "go", "golang", "rust", "c#", "swift", "kotlin", "ruby", "d", "objective-c", "zig", "v", "nim", "perl", "pascal" , "fortran", "ada", "javascript", "typescript", "php", "bash" , "powershell", "lua", "groovy", "tcl", "rexx", "haskell" ,"elixir", "erlang", "ocaml", "f#", "scheme", "lisp", "clojure" , "elm", "reasonml", "r", "julia", "matlab", "sas" , "stata", "html", "css", "sass", "scss", "less" ,"xml", "vhdl", "verilog", "brainfuck", "cobol", "piet", "sql" , "prolog", "vb\\.net", "delphi", "smalltalk", "scratch", "labview" , "logo", "gams", "whitespace", "malbolge", "befunge", "lolcode"};
        String regex="\\b("+String.join("|",languages)+")\\b";
        Pattern pattern=Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(input);
        StringBuilder result=new StringBuilder();
        while(matcher.find())
        {
            if(result.length()>0)
                result.append (", ");
            result.append(matcher.group());
        }
        if(result.length()>0)
            System.out.println(result.toString());
        else
            System.out.println("No programming languages found.");
        scanner.close();
    }
}
