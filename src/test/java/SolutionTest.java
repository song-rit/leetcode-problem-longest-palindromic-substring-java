import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    Solution solution = new Solution();

    static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of("babad", "bab"),
                Arguments.of("cbbd", "bb"),
                Arguments.of("a", "a"),
                Arguments.of("ac", "c")
        );
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    public void solutionTest(String testCase, String expected) {
        Assertions.assertEquals(solution.longestPalindrome(testCase), expected);
    }

}