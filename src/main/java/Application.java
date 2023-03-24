import dao.UserAndRoleDao;
import dao.impl.UserAndRoleDaoImpl;
import hibernate.HibernateSessionFactoryUtil;
import model.Role;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Application {
    public static void main(String[] args) {
        UserAndRoleDao userAndRoleDao = new UserAndRoleDaoImpl();
        // Добавили роль с новыми пользователями
//        try (Session session = HibernateSessionFactoryUtil.getFactory().openSession()) {
//            Role role = new Role("главная");
//            User user1 = new User("Tina", "tina", "6574357237srtghb");
//            User user2 = new User("Rita", "rita", "76465hbn7srtghb");
//            User user3 = new User("Lida", "lida", "op[;uoisrtghb");
//            role.addUserToRole(user1);
//            role.addUserToRole(user2);
//            role.addUserToRole(user3);
//            Transaction transaction = session.beginTransaction();
//            session.persist(role);
//            transaction.commit();
//        }
        //****************************************************************************************

        //Добавили нового пользователя с ролями в БД.
//        try (Session session = HibernateSessionFactoryUtil.getFactory().openSession()) {
//            User user = new User("Andrey", "andrey", "dsgfe5315");
//            Role role1 = new Role("Второстепенная");
//            Role role2 = new Role("Эпизодическая");
//            Role role3 = new Role("Разноплановая");
//            Role role4 = new Role("Массовка");
//
//            user.addUserToRole(role1);
//            user.addUserToRole(role2);
//            user.addUserToRole(role3);
//            user.addUserToRole(role4);
//            Transaction transaction = session.beginTransaction();
//            session.persist(user);
//            transaction.commit();
//        }
        //******************************************************************************************
        // Получили список пользователей из БД (без ролей)
//        userAndRoleDao.readAll();

        //*******************************************************************************************
        //Удалили пользователя в БД
//        userAndRoleDao.deleteUser(6);

        //*******************************************************************************************
        //Отредактировали существующего пользователя в БД.
//        userAndRoleDao.updateUser(user1);

        //*******************************************************************************************
        //Получили конкретного пользователя (с его ролями) из БД
//        userAndRoleDao.getByRole(4);

        //*******************************************************************************************
        //Получили список пользователей по конкретной роли
        userAndRoleDao.getByRole(1);
    }

}
