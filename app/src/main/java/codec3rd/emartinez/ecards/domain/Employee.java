package codec3rd.emartinez.ecards.domain;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/**
 * ***Creado por: Edison Martinez,
 * ***Fecha:11,Monday,2022,
 * ***Hora: 9:03 PM.
 **/

@Entity(tableName = "Employee",foreignKeys = {@ForeignKey(entity = Employee.class, parentColumns = "employeeId", childColumns =   "address_id", onDelete = CASCADE)})
public class Employee
{
    @PrimaryKey(autoGenerate = true)
    public int employeeId;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "personal_id")
    public String personalID;

    @ColumnInfo(name = "job_title")
    public String jobTitle;

    @ColumnInfo(name = "address_id")
    public int address_id;

    public Employee(){}

    public Employee(String firstName,String lastName, String personalID, String jobTitle,int address_id)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalID = personalID;
        this.jobTitle = jobTitle;
        this.address_id = address_id;
    }

}
