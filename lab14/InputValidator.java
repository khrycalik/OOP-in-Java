import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    

    List<String> validate(String[] args) {
        List<String> list = new ArrayList<>();

        if (args.length < 3 ) {
            list.add("Wrong number of arguments");
        } else {     
            try {
                Long.parseLong(args[3]);
            }  catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Pattern p = Pattern.compile("^(19[0-9]{2}|2[0-9]{3})-(0[1-9]|1[012])-([123]0|[012][1-9]|31)$");
            Matcher m = p.matcher(args[0]);
            if (!m.matches()) {
                list.add("Wrong data format"); 
                // return list;
            }

            p=Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9](:[0-5][0-9])?");
            if (!p.matcher(args[1]).matches()) {
                list.add("Wrong time format");
                // return list;
            }

            p = Pattern.compile("[a-zA-Z]{3}");
            if (!p.matcher(args[2]).matches()) {
                list.add("Wrong third argument type");
                // return list;
            }
            p = Pattern.compile("[0-9]{1,}");
            if (!p.matcher(args[3]).matches()) {
                list.add("Wrong fourth argument type");
                // return list;
            }
        }
        return list;

    }
}
