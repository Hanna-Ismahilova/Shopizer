import categories.CartTests;
import categories.PurchaseTests;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.HanbagsCatalogueTest;


@RunWith(Categories.class)
@Categories.IncludeCategory({PurchaseTests.class, CartTests.class})
@Suite.SuiteClasses({HanbagsCatalogueTest.class})
public class PurchaseTestSuite {
}
