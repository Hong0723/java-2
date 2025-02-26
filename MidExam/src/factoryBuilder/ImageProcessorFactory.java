package factoryBuilder;

// ImageProcessorFactory 클래스: 다양한 IProcessor 인스턴스를 생성하는 팩토리 클래스
public class ImageProcessorFactory {

    // createInstance 메서드: 입력된 타입에 따라 IProcessor 인스턴스를 생성하여 반환
    public static IProcessor createInstance(String type, double... params) {
        switch (type) {
            case "ImageGrayscale":
                return new ImageGrayscale();
            case "ImageBlur":
                return new ImageBlur();
            case "ImageNegative":
                return new ImageNegative();
            case "ImageEdgeDetect":
                return new ImageEdgeDetect();
            case "ImageRotate":
                if (params.length < 1) {
                    throw new IllegalArgumentException("ImageRotate requires an angle parameter.");
                }
                return new ImageRotate(params[0]); // 회전 각도를 매개변수로 받아 생성
            default:
                throw new IllegalArgumentException("UNKNOWN Image Process: " + type);
        }
    }
}
