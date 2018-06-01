package pucrs.s2b.tesouro.testsuite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pucrs.s2b.tesouro.framework.Report;
import pucrs.s2b.tesouro.testcase.LoginTestCase;


@RunWith(Suite.class)
@SuiteClasses({
	LoginTestCase.class,
})
public class LoginTestSuite {
	
	@BeforeClass
	public static void initTest() {
		Report.create("Tesouro Direto", "Teste de Login");
	}

	@AfterClass
	public static void endTest() {
		Report.close();
	}

}