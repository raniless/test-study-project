package part1.ch2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// 스위트의 스위트
@RunWith(value=Suite.class)
@SuiteClasses(value={TestSuiteA.class, TestSuiteB.class})
public class MasterTestSuite {
}
