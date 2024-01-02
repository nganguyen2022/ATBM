package models;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAKey {
    private KeyPair keyPair;
    private PublicKey publicKey;
    private PrivateKey privateKey;

    public KeyPair getKeyPair() {
        return keyPair;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public String getPublicKeyBase64() {
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }

    public String getPrivateKeyBase64() {
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }

    public void genKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
        keyGenerator.initialize(2048);
        keyPair = keyGenerator.generateKeyPair();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();
    }
    public boolean verify(String data, String signatureBase64, String publicKeyBase64) throws Exception {
        // Chuyển đổi chuỗi base64 của public key thành kiểu byte[]
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyBase64);

        // Tạo đối tượng PublicKey từ dữ liệu của public key
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        // Tạo đối tượng Signature với thuật toán SHA256withRSA
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);

        // Cập nhật dữ liệu cần kiểm tra
        byte[] dataBytes = data.getBytes("UTF-8");

        // Chuyển đổi chuỗi base64 của chữ ký thành kiểu byte[]
        byte[] signatureBytes = Base64.getDecoder().decode(signatureBase64);

        // Kiểm tra xem chữ ký có hợp lệ không
        signature.update(dataBytes);
        return signature.verify(signatureBytes);
    }
    public  String sign(String data, String privateKeyBase64) throws Exception {
        // Chuyển đổi chuỗi base64 của private key thành kiểu byte[]
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64);

        // Tạo đối tượng PrivateKey từ dữ liệu của private key
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        // Tạo đối tượng Signature với thuật toán SHA256withRSA
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);

        // Cập nhật dữ liệu cần ký
        byte[] dataBytes = data.getBytes("UTF-8");
        signature.update(dataBytes);

        // Ký dữ liệu và trả về chuỗi base64 của chữ ký
        byte[] signatureBytes = signature.sign();
        return Base64.getEncoder().encodeToString(signatureBytes);
    }
    public  boolean areKeyPairsMatching(String privateKeyBase64, String publicKeyBase64) {
        try {
            // Chuyển đổi chuỗi base64 của private key và public key thành kiểu byte[]
            byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64);
            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyBase64);

            // Tạo đối tượng PrivateKey từ dữ liệu của private key
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

            // Tạo đối tượng PublicKey từ dữ liệu của public key
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

            // Dữ liệu để ký và kiểm tra
            String data = "Hello, world!";
            String ck = sign(data, privateKeyBase64);

            // Nếu chữ ký hợp lệ, có thể coi chúng tương ứng
            return verify(data, ck, publicKeyBase64);
        } catch (Exception e) {
            return false;
        }
    }

}

