import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


//KLASA WYWOLUJACA TESTY KORZYSTAJACE Z MOCKITO
@RunWith(Categories.class)
@Categories.IncludeCategory(MockedTestSuite.class)
@Suite.SuiteClasses({AplikacjaTest.class})
public class MockedTestSuite {
}