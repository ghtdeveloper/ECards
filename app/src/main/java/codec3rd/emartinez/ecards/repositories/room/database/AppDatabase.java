package codec3rd.emartinez.ecards.repositories.room.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import codec3rd.emartinez.ecards.domain.Address;
import codec3rd.emartinez.ecards.domain.Employee;
import codec3rd.emartinez.ecards.domain.EmployeeWithAddress;
import codec3rd.emartinez.ecards.repositories.room.dao.RoomDao;

/**
 * ***Creado por: Edison Martinez,
 * ***Fecha:11,Monday,2022,
 * ***Hora: 9:11 PM.
 **/
@Database(entities = {Employee.class, Address.class},version = 1)
public  abstract class AppDatabase extends RoomDatabase
{
        public abstract RoomDao employeeDao();
}
