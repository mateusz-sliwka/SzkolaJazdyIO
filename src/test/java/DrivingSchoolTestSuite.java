import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//KLASA WYWOLUJACA TESTY WSZYSTKIE BEZ PARAMETROW
@RunWith(Categories.class)
@Suite.SuiteClasses({AplikacjaTest.class,InstruktorTest.class,PlatnoscTest.class})
public class DrivingSchoolTestSuite {
}