package nz.co.kiwiplan.exam;

import nz.co.kiwiplan.exam.util.DataUtils;

/**
 * @author <a href="mailto:cp.michael@icloud.com">Michael Panganiban</a>
 *
 */
public class Main {

	public static void main(String[] args) {

		System.out.println("*** First Example ****");
		Application.displayManagementTree(DataUtils.generateFirstExample());

		System.out.println("\n*** Second Example ****");
		Application.displayManagementTree(DataUtils.generateSecondExample());
	}

}
