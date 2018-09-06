package ftl.run

import ftl.args.AndroidArgs
import ftl.args.IosArgs
import ftl.test.util.FlankTestRunner
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import java.nio.file.Paths

@RunWith(FlankTestRunner::class)
class TestRunnerTest {

    @Test
    fun mockedAndroidTestRun() {
        val localConfig = AndroidArgs.load(Paths.get("src/test/kotlin/ftl/fixtures/flank.local.yml"))
        val gcsConfig = AndroidArgs.load(Paths.get("src/test/kotlin/ftl/fixtures/flank.gcs.yml"))
        runBlocking {
            TestRunner.newRun(localConfig)
            TestRunner.newRun(gcsConfig)
        }
    }

    @Test
    fun mockedIosTestRun() {
        val config = IosArgs.load(Paths.get("src/test/kotlin/ftl/fixtures/flank.ios.yml"))
        runBlocking {
            TestRunner.newRun(config)
        }
    }
}
