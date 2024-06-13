import com.database.LinkSQL;
import com.database.operatetable.DeleteTable;
import com.forms.share.forms_register;

public class Main {
    static {
        LinkSQL.setDriver("com.mysql.cj.jdbc.Driver");
        LinkSQL.setURL("jdbc:mysql://localhost:3306/sxdate");
        LinkSQL.setUsername("root");
        LinkSQL.setPassword("123456");
        DeleteTable.DeleteTemporary();
    }

    public static void main(String[] args) {
        forms_register register = new forms_register();
        register.setVisible(true);
    }
}
