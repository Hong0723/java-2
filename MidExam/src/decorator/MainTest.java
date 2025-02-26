package decorator;

public class MainTest {
	
    public MainTest() {
		// PlaneImage + Grayscale + Blur + Negative
		ImageProcessor imageProcessor = new PlaneImage("cat1.jpg");
		imageProcessor = new ImageGrayscale(imageProcessor);
		imageProcessor = new ImageBlur(imageProcessor);
		imageProcessor = new ImageNegative(imageProcessor);
		imageProcessor.process();

		// PlaneImage + Rotate + EdgeDetect
		ImageProcessor imageProcessor2 = new PlaneImage("cat2.jpg");
		imageProcessor2 = new ImageRotate(imageProcessor2, 45.0);
		imageProcessor2 = new ImageEdgeDetect(imageProcessor2);
		imageProcessor2.process();
    }
}
