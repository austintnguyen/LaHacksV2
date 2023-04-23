import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import net.fortuna.ical4j.validate.ValidationException;

public class Main {
    public static void main(String arg[]) throws ValidationException, ParseException, IOException {

        AutoScheduler as = new AutoScheduler();
        as.pack();
        as.setVisible(true);

    }
}
