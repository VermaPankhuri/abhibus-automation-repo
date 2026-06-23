package hooks;

import base.Base;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class ScenarioHook extends Base {

    @Before
    public void start() throws Exception {

        initializeDriver();
    }

    @After
    public void end() {

        tearDown();
    }
}