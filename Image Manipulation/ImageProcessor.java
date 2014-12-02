public class ImageProcessor {

    private Pic img;

    public ImageProcessor(String aPicture) {
        img = new Pic(aPicture);
    }

    public static void main(String[] args) {
        ImageProcessor processor = new ImageProcessor(args[0]);
        processor.greyscale().show();
        processor.invert().show();
        processor.noRed().show();
        processor.noBlue().show();
        processor.noGreen().show();
        processor.maximize().show();

        if (args.length == 2) {
            Pic secondImage = new Pic(args[1]);
            processor.overlay(secondImage).show();
        }
    }

    public Pic greyscale() {
        Pic greyImg = img.deepCopy();
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Pixel pix = new Pixel(0, 0, 0, 0);
                pix = greyImg.getPixel(y, x);
                int red = pix.getRed();
                int green = pix.getGreen();
                int blue = pix.getBlue();
                int average = (red + green + blue) / 3;
                pix.setRed(average);
                pix.setGreen(average);
                pix.setBlue(average);
            }
        }
        return greyImg;

    }

    public Pic invert() {
        Pic invertImg = img.deepCopy();
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Pixel pix = new Pixel(0, 0, 0, 0);
                pix = invertImg.getPixel(y, x);
                int red = pix.getRed();
                int green = pix.getGreen();
                int blue = pix.getBlue();
                pix.setRed(255 - red);
                pix.setGreen(255 - green);
                pix.setBlue(255 - blue);
            }
        }
        return invertImg;
    }


    public Pic noRed() {
        Pic noRedImg = img.deepCopy();
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Pixel pix = new Pixel(0, 0, 0, 0);
                pix = noRedImg.getPixel(y, x);
                int red = pix.getRed();
                int green = pix.getGreen();
                int blue = pix.getBlue();
                pix.setRed(0);
                pix.setGreen(green);
                pix.setBlue(blue);
            }
        }
        return noRedImg;
    }

    public Pic noBlue() {
        Pic noBlueImg = img.deepCopy();
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Pixel pix = new Pixel(0, 0, 0, 0);
                pix = noBlueImg.getPixel(y, x);
                int red = pix.getRed();
                int green = pix.getGreen();
                int blue = pix.getBlue();
                pix.setRed(red);
                pix.setGreen(green);
                pix.setBlue(0);
            }
        }
        return noBlueImg;
    }

    public Pic noGreen() {
        Pic noGreenImg = img.deepCopy();
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Pixel pix = new Pixel(0, 0, 0, 0);
                pix = noGreenImg.getPixel(y, x);
                int red = pix.getRed();
                int green = pix.getGreen();
                int blue = pix.getBlue();
                pix.setRed(red);
                pix.setGreen(0);
                pix.setBlue(blue);
            }
        }
        return noGreenImg;
    }

    public Pic maximize() {
        Pic maximizeImg = img.deepCopy();
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Pixel pix = new Pixel(0, 0, 0, 0);
                pix = maximizeImg.getPixel(y, x);
                int red = pix.getRed();
                int green = pix.getGreen();
                int blue = pix.getBlue();

                if (red < green || red < blue) {
                    red = 0;
                }
                if (green < blue || green < red) {
                    green = 0;
                }
                if (blue < red || blue < green) {
                    blue = 0;
                }

                pix.setRed(red);
                pix.setGreen(green);
                pix.setBlue(blue);
            }
        }
        return maximizeImg;
    }

    public Pic overlay(Pic other) {
        Pic overlayImg = img.deepCopy();
        int width = other.getWidth();
        int height = other.getHeight();
        Pic image = overlayImg;
        Pic image2 = other;
        if (overlayImg.getWidth() < width) {
            width = overlayImg.getWidth();
        }
        if (overlayImg.getHeight() < height) {
            height = overlayImg.getHeight();
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Pixel pix = new Pixel(0, 0, 0, 0);
                pix = image.getPixel(y, x);
                int red = pix.getRed();
                int green = pix.getGreen();
                int blue = pix.getBlue();

                Pixel pix1 = new Pixel(0, 0, 0, 0);
                pix1 = image2.getPixel(y, x);
                int red1 = pix1.getRed();
                int green1 = pix1.getGreen();
                int blue1 = pix1.getBlue();

                pix.setRed((red + red1) / 2);
                pix.setGreen((green + green1) / 2);
                pix.setBlue((blue + blue1) / 2);
            }
        }
        return image;
    }

}