package mykitchen.util;

/**
 * Helper class for check arguments state.
 * 
 * @author Asparuh Vitkinov
 */
public class ArgumentHelper {

	/**
	 * Determines if given parameter is initialized.
	 * 
	 * @param object
	 *            Object to check
	 * @return <code>true</code> if it is initialized, otherwise
	 *         <code>false</code>.
	 */
	public static boolean isArgumentInitialized(Object object) {
		return (object != null);
	}
}
