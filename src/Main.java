import com.database.*;
import com.forms.*;
public class Main {
    static {
        linksql.setDriver("com.mysql.cj.jdbc.Driver");
        linksql.setURL("jdbc:mysql://localhost:3306/sxdate");
        linksql.setUsername("root");
        linksql.setPassword("123456");
        inspection.closetemp();
    }
    public static void main(String[] args) {
//        forms_register register = new forms_register();
//        register.setVisible(true);

//        forms_administrators administrators = new forms_administrators();
//        administrators.setVisible(true);

//        forms_staff staff = new forms_staff();
//        staff.setVisible(true);

        forms_staffwork staffwork = new forms_staffwork();
        staffwork.setVisible(true);
    }

}
