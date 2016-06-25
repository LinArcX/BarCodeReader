package ir.serajsamaneh.lms.model.barcode;

import java.io.File;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;

/*public class BarCode {

	public static void main(String[] args) {
		InputStream barCodeInputStream = new FileInputStream("file.jpg");
		BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);

		LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Reader reader = new MultiFormatReader();
		Result result = reader.decode(bitmap);
		
		System.out.println("Barcode text is " + result.getText());

	}

}*/

public class BarCodeDecode {
	public static void main(String[] args) {
		try {
			String tmpImgFile = "C:\\Users\\salari\\Desktop\\ali.jpg";

			Map<DecodeHintType, Object> tmpHintsMap = new EnumMap<DecodeHintType, Object>(DecodeHintType.class);
			tmpHintsMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
			tmpHintsMap.put(DecodeHintType.POSSIBLE_FORMATS, EnumSet.allOf(BarcodeFormat.class));
			// tmpHintsMap.put(DecodeHintType.PURE_BARCODE, Boolean.FALSE);

			File tmpFile = new File(tmpImgFile);
			String tmpRetString = BarCodeUtil.decode(tmpFile, tmpHintsMap);

			// String tmpRetString = BarCodeUtil.decode(tmpFile, null);
			System.out.println("The National Code: " + tmpRetString);
			System.out.println("The City Is: " + JSonUtility.readFromJson(tmpRetString.substring(0, 3)));
		} catch (Exception tmpExpt) {
			System.out.println("main: " + "Excpt err! (" + tmpExpt.getMessage() + ")");
		}
		System.out.println("main: " + "Program end.");
	}
}
