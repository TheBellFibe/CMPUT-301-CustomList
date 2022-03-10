import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    @Before
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Halifax", "NS"));
        assertEquals(listSize + 1, list.getCount());
    }

    @Test
    public void hasCityTest() {
        City newCity = new City("Calgary", "AB");
        assertFalse(list.hasCity(newCity));
        list.addCity(newCity);
        assertTrue(list.hasCity(newCity));
    }

    @Test
    public void deleteCityTest() {
        int listSize = list.getCount();
        City newCity = new City("Saskatoon", "SSK");
        assertFalse(list.hasCity(newCity));
        list.addCity(newCity);
        assertEquals(listSize + 1, list.getCount());
        assertTrue(list.hasCity(newCity));
        list.delete(newCity);
        assertFalse(list.hasCity(newCity));
        assertEquals(listSize, list.getCount());
    }

}
