import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
//@SelectPackages({"com.example.assertions", "com.example.conditional"})
//@SelectClasses({AssertionsTest.class, LifeCycleTest.class})
//@SelectPackages("com.example.tag")
//@IncludeTags({"insert"})

@SelectPackages("com.example")
@SuiteDisplayName("Ejemplo de Suite para todos los tests")
public class SuiteAll {
}
