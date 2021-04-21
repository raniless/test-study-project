package part1.ch2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;

import part1.ch1.Calculator;

import java.util.Arrays;
import java.util.Collection;

// 파라미터화 테스트
@RunWith(value=Parameterized.class) // 파라미터화 테스트 러너
public class ParameterizedTest {
    //테스트 파라미터 선언
    private double expected;
    private double valueOne;
    private double valueTwo;

    // 메서드 시그니처는 반드시 아래와 같이 정의
    // Collection의 원소는 배열, 길이는 모두 같아야 한다.
    // 테스트 횟수는 아래 배열 길이에 의해 결정
    @Parameters
    public static Collection<Integer[]> getTestParameters() {
        // 길이는 생성자 파라미터 수와 일치해야 함
        return Arrays.asList(new Integer[][]{
                {2, 1, 1},  //예상 값, 값1, 값2
                {3, 2, 1},  //예상 값, 값1, 값2
                {4, 3, 1}   //예상 값, 값1, 값2
        });
    }

    // 파라미터를 받는 생성자로 사용
    public ParameterizedTest(double expected, double valueOne, double valueTwo) {
        this.expected = expected;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    @Test
    public void sum() {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.add(valueOne, valueTwo), 0);
    }
}
