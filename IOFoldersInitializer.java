/***
 *
 *IOFoldersInitializer: Creates and manages internal directories for Eclipse RCP/e4-based
 *apps - uses/integrates with IOWires.java
 *
 *March 2011
 *
 * @author Imad Khoury
 *
 * */


import java.io.File;
import java.io.IOException;

public class IOFoldersInitializer {
	public static boolean createFolders() throws IOException {
		// Create dinternal folder
		File fol_DInternal = new File(
				IOWires.getDInternalPath(IOWires.exportedProduct));
		// Create output folder
		File fol_Out = new File(IOWires.getPath(IOWires.exportedProduct,
				"OutputFiles"));
		try {
			fol_DInternal.mkdir();
			fol_Out.mkdir();
		} catch (Exception e) {
			//"An error occurred while trying to set up the I/O environment");
		}
		return true;
	}

	public static void deleteOutputFolder() throws IOException {
		// Delete output folder
		File fol_Out = new File(IOWires.getPath(IOWires.exportedProduct,
				"OutputFiles"));
		if (fol_Out.exists()) {
			try {
				if (deleteDir(fol_Out)) {
					// recreate empty folder
					File fol_Out2 = new File(IOWires.getPath(
							IOWires.exportedProduct, "OutputFiles"));
					fol_Out2.mkdir();
				} else {
					//"An error occurred while trying to delete the internal out folder.");
				}
			} catch (Exception e) {
					//"An error occurred while trying to delete the internal out folder.");
			}
		}
	}

	// Deletes all folder's files and subdirectories.
	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		return dir.delete();
	}
}
