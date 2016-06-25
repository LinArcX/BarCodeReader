package model.barcode;

import java.io.File;
import java.io.FileOutputStream;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.QRCodeWriter;

public class BarCodeCreator {

	public static void main(String[] args) {
		String text = "alireza"; // this is the text that we want to encode
		String path = "C:\\Users\\salari\\Desktop";

		int width = 500;
		int height = 300; 

		// (ImageIO.getWriterFormatNames() returns a list of supported formats)
		String imageFormat = "png"; // could be "gif", "tiff", "jpeg"

		try {
			//code_128 Format
			BitMatrix bitMatrix = new Code128Writer().encode(text, BarcodeFormat.CODE_128, width, height);
			//QRCode Format
			// BitMatrix bitMatrix = new QRCodeWriter().encode(text,BarcodeFormat.CODE_128, width, height);
			MatrixToImageWriter.writeToStream(bitMatrix, imageFormat,new FileOutputStream(new File(path + "\\QRcode_" + text + ".png")));
			System.out.println("Your " + "BAR-Code_" + text + ".png" + " Is Ready In:\n" + '"' + path + '"');
			System.out.println(bitMatrix.toString());

		} catch (Exception e) {
			System.out.println("Exception Occured!");
		}

	}

}
