package ir.serajsamaneh.lms.model.barcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class BarCodeUtil {
	private static BarcodeFormat DEFAULT_BARCODE_FORMAT = BarcodeFormat.ITF;

	/**
	 * Decode method used to read image or barcode itself, and recognize the
	 * barcode, get the encoded contents and returns it.
	 * 
	 * @param whatFile
	 *            image that need to be read.
	 * @param config
	 *            configuration used when reading the barcode.
	 * @return decoded results from barcode.
	 */
	public static String decode(File whatFile, Map<DecodeHintType, Object> whatHints) throws Exception {
		// check the required parameters
		if (whatFile == null || whatFile.getName().trim().isEmpty())
			throw new IllegalArgumentException("File not found, or invalid file name.");
		BufferedImage tmpBfrImage;
		try {
			tmpBfrImage = ImageIO.read(whatFile);
		} catch (IOException tmpIoe) {
			throw new Exception(tmpIoe.getMessage());
		}
		if (tmpBfrImage == null)
			throw new IllegalArgumentException("Could not decode image.");
		LuminanceSource tmpSource = new BufferedImageLuminanceSource(tmpBfrImage);
		BinaryBitmap tmpBitmap = new BinaryBitmap(new HybridBinarizer(tmpSource));
		MultiFormatReader tmpBarcodeReader = new MultiFormatReader();
		Result tmpResult;
		String tmpFinalResult;
		try {
			if (whatHints != null && !whatHints.isEmpty())
				tmpResult = tmpBarcodeReader.decode(tmpBitmap, whatHints);
			else
				tmpResult = tmpBarcodeReader.decode(tmpBitmap);
			// setting results.
			tmpFinalResult = String.valueOf(tmpResult.getText());
		} catch (Exception tmpExcpt) {
			throw new Exception(
					"BarCodeUtil.decode Excpt err - " + tmpExcpt.toString() + " - " + tmpExcpt.getMessage());
		}
		return tmpFinalResult;
	}
}
