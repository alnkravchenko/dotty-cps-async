package cc

import org.junit.Test
import org.junit.Rule

class Test9Try {


  @Test
  def testCompileAndRun(): Unit = {
    DotcInvocations.checkRuns(selection = ".*m5_2".r)(
      TestRun("testdata/set9Try/m1", "cpstest.Test9m1", "Right(10)\n"),
      TestRun("testdata/set9Try/m2", "cpstest.Test9m2"),
      TestRun("testdata/set9Try/m3", "cpstest.Test9m3"),
      TestRun("testdata/set9Try/m4", "cpstest.Test9m4"),
      TestRun("testdata/set9Try/m5_0", "cpstest.Test9m5_0"),
      TestRun("testdata/set9Try/m5_1", "cpstest.Test9m5_1"),
      TestRun("testdata/set9Try/m5_1e", "cpstest.Test9m5_1e"),
      TestRun("testdata/set9Try/m5_2", "cpstest.Test9m5_2")
    )
  }


}
