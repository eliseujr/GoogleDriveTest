package com.test;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

import java.io.IOException;

public class test {

	/**
	 * @param args
	 */
	 public static void main(String[] args) {
		 System.out.println("Eliseu");
	 }


	 /**
	  * Insert new file.
	  *
	  * @param service Drive API service instance.
	  * @param title Title of the file to insert, including the extension.
	  * @param description Description of the file to insert.
	  * @param parentId Optional parent folder's ID.
	  * @param mimeType MIME type of the file to insert.
	  * @param filename Filename of the file to insert.
	  * @return Inserted file metadata if successful, {@code null} otherwise.
	  */
	 private static File insertFile(Drive service, String title, String description,
			 String parentId, String mimeType, String filename) {
		 // File's metadata.
		 File body = new File();
		 body.setTitle(title);
		 body.setDescription(description);
		 body.setMimeType(mimeType);

		 // File's content.
		 java.io.File fileContent = new java.io.File(filename);
		 FileContent mediaContent = new FileContent(mimeType, fileContent);
		 try {
			 File file = service.files().insert(body, mediaContent).execute();

			 System.out.println("File ID: %s" + file.getId());

			 return file;
		 } catch (IOException e) {
			 System.out.println("An error occured: " + e);
			 return null;
		 }
	 }	

}
