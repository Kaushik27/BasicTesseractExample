import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixRead;
import static org.junit.Assert.assertTrue;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;

public class TessTest {
	public static void main(String[] args) {
		 BytePointer outText;

	     TessBaseAPI api = new TessBaseAPI();
	     // Initialize tesseract-ocr with English, without specifying tessdata path
	     if (api.Init(".", "ENG") != 0) {
	         System.err.println("Could not initialize tesseract.");
	         System.exit(1);
	     }

	     // Open input image with leptonica library
	     PIX image = pixRead("C:/Users/Knight/Downloads/chequeman-cheque3.jpg");
	     api.SetImage(image);
	     // Get OCR result
	     outText = api.GetUTF8Text();
	     String string = outText.getString();
	     System.out.println("OCR output:\n" + string);

	     // Destroy used object and release memory
	     api.End();
	     outText.deallocate();
	     //pixDestroy(image);
	}
}
