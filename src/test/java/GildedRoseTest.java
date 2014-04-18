import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

import org.junit.Test;


public class GildedRoseTest {

    @Test
    public void shouldCreateInstance() throws Exception {
        GildedRose gd = new GildedRose();

        assertThat(gd, is(instanceOf(GildedRose.class)));
    }
}
