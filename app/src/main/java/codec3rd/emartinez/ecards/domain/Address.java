package codec3rd.emartinez.ecards.domain;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/**
 * ***Creado por: Edison Martinez,
 * ***Fecha:11,Monday,2022,
 * ***Hora: 11:46 PM.
 **/
@Entity(tableName = "Address")
public class Address
{
    @PrimaryKey(autoGenerate = true)
    public int addressId;

    @ColumnInfo(name = "AddressLine1")
    public String addressLine1;

    @ColumnInfo(name = "City")
    public String city;

    @ColumnInfo(name = "State")
    public String state;

    @ColumnInfo(name = "Country")
    public String country;



    public Address(String addressLine1, String city, String state, String country)
    {
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.country = country;
    }

}
