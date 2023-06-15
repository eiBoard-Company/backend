package dhbw.eiCompany;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.hibernate.engine.jdbc.BlobProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class BlobConverter {

	private final static Logger LOGGER = LoggerFactory.getLogger(BlobConverter.class);
	private BlobConverter() {

	}


	public static Blob convertFileToBlob(File f) {
		byte[] ba = null;
		try {
			ba = FileUtils.readFileToByteArray(f);

		} catch (IOException e) {
			LOGGER.error("Error while converting File to Blob\n" + e.getStackTrace().toString());
		}
		return convertByteArrayToBlob(ba);
	}

	public static Blob convertByteArrayToBlob(byte[] ba) {
		return BlobProxy.generateProxy(ba);
	}

	//to test the picture editor
	public static void convertBlobToFile(File f, Blob b) {
		try {
			InputStream is = b.getBinaryStream();
			byte[] ba = is.readAllBytes();
			FileUtils.writeByteArrayToFile(f, ba);

		} catch (SQLException | IOException e) {
			LOGGER.error("Error while converting Blob to File\n" + e.getStackTrace().toString());
		}
	}

	public static String convertBlobToBase64String(Blob b) {
		try {

			return Base64.getEncoder().encodeToString(b.getBinaryStream().readAllBytes());
		} catch (IOException | SQLException e) {
			LOGGER.error("Error while converting Blob to Base64String\n" + e.getStackTrace().toString());
		}
		return null;
	}

	public static Blob convertBase64StringToBlob(String s) {
		return convertByteArrayToBlob(Base64.getDecoder().decode(s));
	}

	public static String convertFileToBase64String(File f) {
		try {
			return Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(f));
		} catch (IOException e) {
			LOGGER.error("Error while converting File to Base64String\n" + e.getStackTrace().toString());
		}
		return null;
	}

	public static byte[] convertBlobToByteArray(Blob b) {
		try {
			return b.getBinaryStream().readAllBytes();
		} catch (IOException | SQLException e) {
			LOGGER.error("Error while converting Blob to byte[]\n" + e.getStackTrace().toString());
		}
		return null;
	}

	public static byte[] convertFileToByteArray(File f) {
		try {
			return FileUtils.readFileToByteArray(f);
		} catch (IOException e) {
			LOGGER.error("Error while converting File to byte[]\n" + e.getStackTrace().toString());
		}
		return null;
	}

	public static String convertByteArrayToBase64String(byte[] ba) {
		return Base64.getEncoder().encodeToString(ba);
	}
}
