import com.database.LinkSQL;
import com.database.operatetable.DeleteTable;
import com.database.operatetable.IncreaseTable;
import com.forms.administrators.forms_administrators;
import com.forms.custom.forms_custom;
import com.forms.custom.forms_customwork;
import com.forms.staff.forms_staffwork;

import java.util.Vector;

public class Main {
    static {
        LinkSQL.setDriver("com.mysql.cj.jdbc.Driver");
        LinkSQL.setURL("jdbc:mysql://localhost:3306/sxdate");
        LinkSQL.setUsername("root");
        LinkSQL.setPassword("123456");
        DeleteTable.DeleteTemporary();
    }

    public static void main(String[] args) {
        Vector<String> data = new Vector<>();
        data.add("xzx");
        data.add("123456");
        data.add("0");
        IncreaseTable.IncreaseTemporary(data);

//        forms_register register = new forms_register();
//        register.setVisible(true);

//        forms_administrators administrators = new forms_administrators();
//        administrators.setVisible(true);

//        forms_staff staff = new forms_staff(); 
//        staff.setVisible(true);

//        forms_staffwork staffwork = new forms_staffwork();
//        staffwork.setVisible(true);

//        forms_custom custom = new forms_custom();
//        custom.setVisible(true);

        forms_customwork customwork = new forms_customwork();
        customwork.setVisible(true);

//        forms_wages wages = new forms_wages();
//        wages.setVisible(true);

    }
}
