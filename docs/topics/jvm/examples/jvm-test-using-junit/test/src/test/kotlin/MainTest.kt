import org.example.Sample
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class SampleTest {

    private val testSample: Sample = Sample()

    @Test
    fun testSum() {
        val expected = 42
        //val expected = 44         Check that test fails, passing a wrong expected value
        assertEquals(expected, testSample.sum(40, 2))
    }
}