package vn.t3h.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;
//
//import model.Mail;

public class Helper {

//	public static boolean send(Mail obj) {
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(obj.getEmail());
//		message.setSubject(obj.getSubject());
//		message.setText(obj.getContent());
//		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//		Properties prop = new Properties();
//		prop.put("mail.smtp.auth", true);
//		prop.put("mail.smtp.socketFactory.port", 465);
//		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		prop.put("mail.smtp.port", 587);
//		prop.put("mail.transport.protocol", "smtp");
//		prop.put("mail.smtp.starttls.enable", true);
//		mailSender.setJavaMailProperties(prop);
//		mailSender.setHost("smtp.gmail.com");
//		mailSender.setUsername("finance2k16@gmail.com");
//		mailSender.setPassword("cse.net.vn");
//		mailSender.setPort(465);
//		mailSender.send(message);
//		return true;
//	}

	public static List<String> upload(String path, MultipartFile[] parts) throws IOException {
		List<String> files = new ArrayList<String>(parts.length);
		for (MultipartFile part : parts) {
			String file = upload(path, part);
			files.add(file);
		}
		return files;
	}

	public static String upload(String path, MultipartFile part) throws IOException {
		String fileName = part.getOriginalFilename().replaceAll("\\s", "_");
		try (InputStream is = part.getInputStream()) {
			try (OutputStream os = new FileOutputStream(new File(path + fileName))) {
				int len = 0;
				byte[] bytes = new byte[1024];
				while ((len = is.read(bytes, 0, 1024)) > 0) {
					os.write(bytes, 0, len);
				}
			}
		}
		return fileName;
	}

	public static byte[] sha256(String plaintext) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			return digest.digest(plaintext.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
			return null;
		}
	}

	public static String bcrypt(String plaintext) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(plaintext);
	}

	public static long randomLong() {
		Random rand = new Random();
		return Math.abs(rand.nextLong());
	}

	public static String randomString(int n) {
		final String pattern = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		final Random rnd = new Random();
		int len = pattern.length();
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			sb.append(pattern.charAt(rnd.nextInt(len)));
		}
		return sb.toString();
	}
}
