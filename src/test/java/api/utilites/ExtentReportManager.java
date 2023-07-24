package api.utilites;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.poi.hpsf.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager extends TestListenerAdapter
{

	public ExtentSparkReporter sparkReporter ;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;

	public void onStart(ITestContext testContext)
	{
		DateFormat outputFormat = new SimpleDateFormat("MM/yyyy", Locale.US);
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.US);

		sparkReporter=new ExtentSparkReporter(".\\reports\\"+inputFormat);
		sparkReporter.config().setDocumentTitle("RestAssuredAutomationproject");
		sparkReporter.config().setReportName("Pet Store Users API");
		sparkReporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","pavan");
		extent.setSystemInfo("operating System",System.getProperty("os.name"));

	}

	public void onTestSuccess(ITestResult tr)
	{

		test=extent.createTest(tr.getName());
		test.createNode(tr.getName());
		test.assignCategory(tr.getMethod().getGroups());
		test.log(Status.PASS,"test Passed");
		
	}

	public void onTestFailure(ITestResult tr)
	{
		test=extent.createTest(tr.getName());
		test.assignCategory(tr.getMethod().getGroups());
		test.createNode(tr.getName());
		test.log(Status.FAIL,"test Failed");
		test.log(Status.FAIL,tr.getThrowable().getMessage());
	}

	public void onTestSkipped(ITestResult tr)
	{
		test=extent.createTest(tr.getName());
		test.assignCategory(tr.getMethod().getGroups());
		test.createNode(tr.getName());
		test.log(Status.FAIL,"test Failed");
		test.log(Status.FAIL,tr.getThrowable().getMessage());

	}

	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

}
