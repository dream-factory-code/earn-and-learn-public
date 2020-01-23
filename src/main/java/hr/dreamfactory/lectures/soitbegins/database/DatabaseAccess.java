package hr.dreamfactory.lectures.soitbegins.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import hr.dreamfactory.lectures.soitbegins.model.users.User;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

public class DatabaseAccess {
    public static final String insert = "INSERT INTO random_users (gender, phone, " +
            "nationality) VALUES (:gender, :phone, :nationality)";
    private Sql2o sql2o;

    public HikariConfig buildConfiguration(){
        final HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setConnectionTestQuery("SELECT 1");

        config.setJdbcUrl("jdbc:postgresql://localhost:5432/random_peeps");
        config.setUsername("postgres");
        config.setPassword("frane");

        return config;

    }

    public DatabaseAccess() {
        this.sql2o =
                new Sql2o(new HikariDataSource(buildConfiguration()));
    }


    public Integer checkConnection(){
        try (Query query = sql2o.open().createQuery("SELECT 1")) {
            return query.executeScalar(Integer.class);
        }
    }

    public void insertPartial(User user){

        "INSERT" + " into random_users" + " ... values( " + user.getNationality()
        try (Query query = sql2o.open().createQuery(insert)) {
            query.bind(user);
            query.executeUpdate();
        }
    }

    public List<User> selectAll(){
        try (Query query = sql2o.open().createQuery("select gender, phone, nationality from random_users;")) {
            return query.executeAndFetch(User.class);
        }
    }
}
