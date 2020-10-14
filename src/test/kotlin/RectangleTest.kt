import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


@DisplayName("A Rectangle class test case")
internal class RectangleTest {

    @Test
    fun isSquare() {

    }

    @Test
    @DisplayName("A getArea test case")
    fun getArea() {
        val myRectangle = Rectangle(3, 3)
        assertEquals(9, myRectangle.area)

    }

    @Test
    fun if_it_is_zero() {
    }

    @DisplayName("A negative value for year is not supported by the leap year computation.")
    @ParameterizedTest(name = "For example, year {0} is not supported.")
    @ValueSource(ints = [-1, -4])
    fun if_it_is_negative(year: Int) {
    }

    @ParameterizedTest
    @ValueSource(strings = ["racecar", "radar", "able was I ere I saw elba"])
    fun palindromes(candidate: String) {
        assertTrue(StringUtils.isPalindrome(candidate))
    }
}