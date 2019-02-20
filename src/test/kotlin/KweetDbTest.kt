import org.junit.Assert.*
import org.junit.Test

class KweetDbTest {

    @Test
    fun `database is empty`() {
        val db = KweetDb()

        assertTrue(db.all().isEmpty())
    }

    @Test
    fun `getById returns null for non existing id`() {
        val db = KweetDb()

        assertNull(db.getById(42))
    }

    @Test
    fun `added item can be retrieved by id`() {
        // given
        val db = KweetDb()

        // when
        val stored = db.add("ruxmind", "hello world")

        // then
        val kweet = db.getById(stored.id)
        assertNotNull(kweet)
        assertEquals(stored, kweet)
    }

    @Test
    fun `added item can be found via all()`() {
        // given
        val db = KweetDb()

        // when
        db.add("ruxmind", "hello world")

        // then
        val kweets = db.all()
        assertFalse(kweets.isEmpty())
        assertEquals(1, kweets.size)
        assertEquals("ruxmind", kweets.first().handle)
    }

}