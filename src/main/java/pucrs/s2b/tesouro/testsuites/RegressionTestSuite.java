package pucrs.s2b.tesouro.testsuites;

import pucrs.s2b.tesouro.framework.Report;
import pucrs.s2b.tesouro.testcase.LoginTestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	LoginTestCase.class,
})
public class RegressionTestSuite {
	
	@BeforeClass
	public static void initTest() {
		Report.create("Tesouro Direto", "Suite de Regressao");
	}

	@AfterClass
	public static void endTest() {
		Report.close();
	}

}
