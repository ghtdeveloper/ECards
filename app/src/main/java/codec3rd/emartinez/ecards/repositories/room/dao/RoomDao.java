package codec3rd.emartinez.ecards.repositories.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.Collection;
import java.util.List;

import codec3rd.emartinez.ecards.domain.Address;
import codec3rd.emartinez.ecards.domain.Employee;
import codec3rd.emartinez.ecards.domain.EmployeeWithAddress;

/**
 * ***Creado por: Edison Martinez,
 * ***Fecha:11,Monday,2022,
 * ***Hora: 9:10 PM.
 **/
@Dao
public interface RoomDao
{
    @Query("Select * from Employee")
    List<Employee> getAll();

    @Query("Select * from Address")
    List<Address> getAllAddress();

    @Insert
    void addEmployee(Employee employee);

    @Insert
    void addAddress(Address address);

    @Insert
    void addAddress(List<Address> address);

    /*@Transaction
    @Query("Select * from Employee")
    List<EmployeeWithAddress >getEmployeeWithAddress();*/

}
