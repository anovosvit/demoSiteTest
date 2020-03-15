import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import site.DemoSiteClass;

public class TestBase {
    public static ThreadLocal<DemoSiteClass> tlApp = new ThreadLocal<>();
    public static DemoSiteClass demoSite;

    @BeforeAll
    public static void setUp() {
        if (tlApp.get() != null) {
            demoSite = tlApp.get();
            return;
        }

        demoSite = new DemoSiteClass();
        tlApp.set(demoSite);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    demoSite.quit();
                    demoSite = null;
                }));
    }

    @AfterAll
    public static void tearDown() {
        if (demoSite != null) {
            demoSite.quit();
        }
    }
}
