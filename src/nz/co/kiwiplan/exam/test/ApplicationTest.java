package nz.co.kiwiplan.exam.test;

import java.util.Collections;
import java.util.List;

import nz.co.kiwiplan.exam.Application;
import nz.co.kiwiplan.exam.util.DataUtils;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author <a href="mailto:cp.michael@icloud.com">Michael Panganiban</a>
 *
 */
public class ApplicationTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void verifyFirstExample(){
		List<String> managementTree = Application.getManagementTree(DataUtils.generateFirstExample());
		Assertions.assertThat(managementTree)
				.containsExactly(
						"->Tom",
						"->->Mickey",
						"->->Jerry",
						"->->->John",
						"->->Sarah"
				);
	}

	@Test
	public void verifySecondExample(){
		List<String> managementTree = Application.getManagementTree(DataUtils.generateSecondExample());
		Assertions.assertThat(managementTree)
				.containsExactly(
						"->Jerry",
						"->->Philip",
						"->->->David",
						"->->->->Alice",
						"->->->->->John",
						"->->->->Mike",
						"->->->Ken",
						"->->->->Peter",
						"->->->Tom",
						"->->Stacie"
				);
	}

	@Test
	public void verifyThirdExample_duplicateRootManager_throwRunTimeException() {
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Root manager should only be 1.");
		Application.getManagementTree(DataUtils.generateThirdExample());
	}

	@Test
	public void nullOrEmptyEmployeeList_throwRunTimeException() {
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("Employees should not be null");
		Application.displayManagementTree(null);
		Application.displayManagementTree(Collections.emptyList());
	}

}
