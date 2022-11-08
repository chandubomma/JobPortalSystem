package DATABASE;

import java.sql.SQLException;

import USER.ADMINISTRATOR.Administrator;

public class AdministratorDb extends UserDb {
    public boolean addAdministratorRecord(Administrator administrator) throws SQLException{
        String Query = "insert into administrator values('"+administrator.getEmail()+"','"+administrator.getAdministratorKey()+"')";
        return statement.execute(Query);
    }

    public boolean deleteAdministratorRecord(Administrator administrator) throws SQLException{
        String Query = "delete from administrator where email="+administrator.getEmail();
        return statement.execute(Query);
    }
}
