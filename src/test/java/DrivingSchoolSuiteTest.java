import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Categories.class)
@Categories.IncludeCategory(DrivingSchoolSuiteTest.class)
@Suite.SuiteClasses({AplikacjaTest.class})
public class DrivingSchoolSuiteTest {
}
