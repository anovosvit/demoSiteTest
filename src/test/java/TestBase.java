import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import site.DemoSite;

public class TestBase {
    public static ThreadLocal<DemoSite> tlApp = new ThreadLocal<>();
    public static DemoSite demoSite;

    @BeforeAll
    public static void setUp() {
        if (tlApp.get() != null) {
            demoSite = tlApp.get();
            return;
        }

        demoSite = new DemoSite();
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
