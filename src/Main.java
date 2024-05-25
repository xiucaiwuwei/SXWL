import com.database.linksql;
import com.database.operatetable.operatetemp;
import com.forms.custom.*;
import com.forms.staff.forms_staffwork;

public class Main {
    static {
        linksql.setDriver("com.mysql.cj.jdbc.Driver");
        linksql.setURL("jdbc:mysql://localhost:3306/sxdate");
        linksql.setUsername("root");
        linksql.setPassword("123456");
        //operatetemp.emptytemp();
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

//        forms_custom custom = new forms_custom();
//        custom.setVisible(true);

//        forms_customwork customwork = new forms_customwork();
//        customwork.setVisible(true);

//        forms_wages wages = new forms_wages();
//        wages.setVisible(true);

    }

}
