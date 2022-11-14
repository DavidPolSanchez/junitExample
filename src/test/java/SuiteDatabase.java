


import org.junit.jupiter.api.DisplayName;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectPackages("com.example")
@IncludeTags({"database"})
@SuiteDisplayName("Ejemplo de Suite para base de datos")
public class SuiteDatabase {
}
