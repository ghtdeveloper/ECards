package codec3rd.emartinez.ecards.domain;

import androidx.room.Embedded;
import androidx.room.Relation;
import java.util.List;

/**
 * ***Creado por: Edison Martinez,
 * ***Fecha:11,Monday,2022,
 * ***Hora: 11:54 PM.
 **/
public class EmployeeWithAddress
{
    @Embedded public Employee employee;
    @Relation(
            parentColumn = "employeeId",
            entityColumn = "addressId"
    )
    public List<Address> addressList;

}
