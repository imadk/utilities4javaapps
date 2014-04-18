/***
 *
 *IOWires: Utilities for access to internal I/O for Eclipse RCP/e4-based
 *apps - a remedy to the known cumbersomeness
 *
 *March 2011
 *
 * @author Imad Khoury
 *
 * */


import java.io.IOException;
import java.net.URL;
import javax.inject.Named;
import org.eclipse.core.internal.runtime.InternalPlatform;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.xml.type.internal.RegEx;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;

public class IOWires {


	//set to true if you are exporting the application as a product
	final public static boolean exportedProduct = false;

	public IOWires() {

	}

	private static String applicationPath = "packagename.application";

	public static String getDInternalPath() {

		Bundle b = Platform.getBundle(applicationPath);

		URL resource;

		String location = "";
		resource = b.getEntry("/");
		try {
			location = FileLocator.resolve(resource).getFile();
		} catch (IOException e) {

			e.printStackTrace();
		}

		// extract the root directory only:
		if (exportedProduct) {
			location = location.replaceAll(
					"plugins/" + applicationPath + ".*/", "");
			location = location.replaceAll("file:/", "");
			location = location + "/" + "DInternal" + "/";
		} else {
			location = location.substring(1) + "/" + "DInternal" + "/";
		}

		return location;

	}

	public static String getDInternalPath() {

		Bundle b = Platform.getBundle(applicationPath);

		URL resource;

		String location = "";
		resource = b.getEntry("/");
		try {
			location = FileLocator.resolve(resource).getFile();
		} catch (IOException e) {

			e.printStackTrace();
		}

		// extract the root directory only:
		if (exportedProduct) {
			location = location.replaceAll(
					"plugins/" + applicationPath + ".*/", "");
			location = location.replaceAll("file:/", "");
			location = location + "/" + ".DInternal" + "/";
		} else {
			location = location.substring(1) + "/" + ".DInternal" + "/";
		}

		return location;

	}


	public static String getRootPath() {

		Bundle b = Platform.getBundle(applicationPath);

		URL resource;

		String location = "";
		resource = b.getEntry("/");
		try {
			location = FileLocator.resolve(resource).getFile();
		} catch (IOException e) {

			e.printStackTrace();
		}

		if (exportedProduct) {
			location = location.replaceAll(
					"plugins/" + applicationPath + ".*/", "");
			location = location.replaceAll("file:/", "");
			location = location + "/";
		} else {
			location = location.substring(1);
		}

		return location;

	}

	public static String getLogPath(boolean exportedProduct) {

		String location = "";

		// extract the root directory only:
		if (exportedProduct) {
			location = getRootPath(exportedProduct) + "workspace/" + ".metadata/";

		} else {
			location = getRootPath(exportedProduct) + ".metadata/";
		}
		return location;

	}

	public static String getPath(String folderName) {

		Bundle b = Platform.getBundle(applicationPath);

		URL resource;

		String location = "";
		resource = b.getEntry("/");
		try {
			location = FileLocator.resolve(resource).getFile();
		} catch (IOException e) {

			e.printStackTrace();
		}

		// extract the root directory only:
		if (exportedProduct) {
			location = location.replaceAll(
					"plugins/" + applicationPath + ".*/", "");
			location = location.replaceAll("file:/", "");
			location = location + "DInternal/" + folderName + "/";
		} else {
			location = location.substring(1) + "DInternal/" + folderName + "/";
		}

		return location;

	}

}
