package tallinnafotostuudiod.ee.valiItProjektBack.util;

import tallinnafotostuudiod.ee.valiItProjektBack.domain.image.Image;
import tallinnafotostuudiod.ee.valiItProjektBack.util.ImageUtil;

import java.nio.charset.StandardCharsets;

public class ImageUtil {

    public static byte[] base64ImageDataToByteArray(String imageData) {
        byte[] bytes = imageData.getBytes(StandardCharsets.UTF_8);
        return bytes;
    }

    public static String byteArrayToBase64ImageData(byte[] data) {
        String imageData = new String(data, StandardCharsets.UTF_8);
        return imageData;
    }

    public static boolean imageIsPresent(Image image) {
        return image != null;
    }
}
