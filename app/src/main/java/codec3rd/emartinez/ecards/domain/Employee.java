package codec3rd.emartinez.ecards.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * ***Creado por: Edison Martinez,
 * ***Fecha:11,Monday,2022,
 * ***Hora: 9:03 PM.
 **/

@Entity (tableName = "Employee")
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


    public Employee(String firstName,String lastName, String personalID, String jobTitle)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalID = personalID;
        this.jobTitle = jobTitle;
    }

}
