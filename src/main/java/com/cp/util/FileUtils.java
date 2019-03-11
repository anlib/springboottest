package com.cp.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import net.coobird.thumbnailator.Thumbnails;

/**
 * 文件操作工具类
 *
 */
public class FileUtils {
	/**
	 * 获取文件扩展名
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtend(String filename) {
		return getExtend(filename, "");
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtend(String filename, String defExt) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');

			if ((i > 0) && (i < (filename.length() - 1))) {
				return (filename.substring(i + 1)).toLowerCase();
			}
		}
		return defExt.toLowerCase();
	}

	/**
	 * 获取文件名称[不含后缀名]
	 * 
	 * @param
	 * @return String
	 */
	public static String getFilePrefix(String fileName) {
		int splitIndex = fileName.lastIndexOf(".");
		return fileName.substring(0, splitIndex).replaceAll("\\s*", "");
	}

	/**
	 * 获取文件名称[不含后缀名] 不去掉文件目录的空格
	 * 
	 * @param
	 * @return String
	 */
	public static String getFilePrefix2(String fileName) {
		int splitIndex = fileName.lastIndexOf(".");
		return fileName.substring(0, splitIndex);
	}

	/**
	 * 文件复制
	 * 
	 * @param
	 * @return void
	 */
	public static void copyFile(String inputFile, String outputFile) throws FileNotFoundException {
		File sFile = new File(inputFile);
		File tFile = new File(outputFile);
		FileInputStream fis = new FileInputStream(sFile);
		FileOutputStream fos = new FileOutputStream(tFile);
		int temp = 0;
		byte[] buf = new byte[10240];
		try {
			while ((temp = fis.read(buf)) != -1) {
				fos.write(buf, 0, temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 判断文件是否为图片<br>
	 * <br>
	 * 
	 * @param filename
	 *            文件名
	 * @return 检查后的结果<br>
	 * @throws Exception
	 */
	public static boolean isPicture(String filename) {
		// 文件名称为空的场合
		if (filename != null && !"".equals(filename)) {
			// 返回不和合法
			return false;
		}
		// 获得文件后缀名
		// String tmpName = getExtend(filename);
		String tmpName = filename;
		// 声明图片后缀名数组
		String imgeArray[][] = { { "bmp", "0" }, { "dib", "1" }, { "gif", "2" }, { "jfif", "3" }, { "jpe", "4" },
				{ "jpeg", "5" }, { "jpg", "6" }, { "png", "7" }, { "tif", "8" }, { "tiff", "9" }, { "ico", "10" } };
		// 遍历名称数组
		for (int i = 0; i < imgeArray.length; i++) {
			// 判断单个类型文件的场合
			if (imgeArray[i][0].equals(tmpName.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断文件是否为DWG
	 * 
	 * @param filename
	 *            文件名<br>
	 *            判断具体文件类型<br>
	 * @return 检查后的结果<br>
	 * @throws Exception
	 */
	public static boolean isDwg(String filename) {
		// 文件名称为空的场合
		if (filename != null && !"".equals(filename)) {
			// 返回不和合法
			return false;
		}
		// 获得文件后缀名
		String tmpName = getExtend(filename);
		// 声明图片后缀名数组
		if (tmpName.equals("dwg")) {
			return true;
		}
		return false;
	}

	/**
	 * 删除指定的文件
	 * 
	 * @param strFileName
	 *            指定绝对路径的文件名
	 * @return 如果删除成功true否则false
	 */
	public static boolean delete(String strFileName) {
		File fileDelete = new File(strFileName);
		if (!fileDelete.exists() || !fileDelete.isFile()) {
			// LogUtil.info("错误: " + strFileName + "不存在!");
			return false;
		}
		// LogUtil.info("--------成功删除文件---------"+strFileName);
		return fileDelete.delete();
	}

	/**
	 * 
	 * @Title: encodingFileName 2015-11-26 huangzq add @Description:
	 *         防止文件名中文乱码含有空格时%20 @param @param fileName @param @return
	 *         设定文件 @return String 返回类型 @throws
	 */
	public static String encodingFileName(String fileName) {
		String returnFileName = "";
		try {
			returnFileName = URLEncoder.encode(fileName, "UTF-8");
			returnFileName = StringUtils.replace(returnFileName, "+", "%20");
			if (returnFileName.length() > 150) {
				returnFileName = new String(fileName.getBytes("GB2312"), "ISO8859-1");
				returnFileName = StringUtils.replace(returnFileName, " ", "%20");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			// LogUtil.info("Don't support this encoding ...");
		}
		return returnFileName;
	}

	/**
	 * 根据现有路径获取SWF文件名称
	 * 
	 * @author taoYan
	 * @since 2018年7月26日
	 */
	public static String getSwfPath(String path) {
		String leftSlash = "/";
		if (!File.separator.equals(leftSlash)) {
			path = path.replace(File.separator, leftSlash);
		}
		String fileDir = path.substring(0, path.lastIndexOf(leftSlash) + 1);// 文件目录带/
		int pointPosition = path.lastIndexOf(".");
		String fileName = path.substring(path.lastIndexOf(leftSlash) + 1, pointPosition);// 文件名不带后缀
		String swfName = "";// 取文件名首字母作为SWF文件名
		return fileDir + swfName + ".swf";
	}

	/**
	 * 上传txt文件，防止乱码
	 * 
	 * @author taoYan
	 * @since 2018年7月26日
	 */
	public static void uploadTxtFile(MultipartFile mf, String savePath) throws IOException {
		// 利用utf-8字符集的固定首行隐藏编码原理
		// Unicode:FF FE UTF-8:EF BB
		byte[] allbytes = mf.getBytes();
		try {
			String head1 = toHexString(allbytes[0]);
			// System.out.println(head1);
			String head2 = toHexString(allbytes[1]);
			// System.out.println(head2);
			if ("ef".equals(head1) && "bb".equals(head2)) {
				// UTF-8
				String contents = new String(mf.getBytes(), "UTF-8");
				if (StringUtils.isNotBlank(contents)) {
					OutputStream out = new FileOutputStream(savePath);
					out.write(contents.getBytes());
					out.close();
				}
			} else {

				// GBK
				String contents = new String(mf.getBytes(), "GBK");
				OutputStream out = new FileOutputStream(savePath);
				out.write(contents.getBytes());
				out.close();

			}
		} catch (Exception e) {
			String contents = new String(mf.getBytes(), "UTF-8");
			if (StringUtils.isNotBlank(contents)) {
				OutputStream out = new FileOutputStream(savePath);
				out.write(contents.getBytes());
				out.close();
			}
		}
	}

	public static String toHexString(int index) {
		String hexString = Integer.toHexString(index);
		// 1个byte变成16进制的，只需要2位就可以表示了，取后面两位，去掉前面的符号填充
		hexString = hexString.substring(hexString.length() - 2);
		return hexString;
	}

	/**
	 * 获取图片宽度
	 * 
	 * @param file
	 *            图片文件
	 * @return 宽度
	 */
	public static int getImgWidth(File file) {
		InputStream is = null;
		BufferedImage src = null;
		int ret = -1;
		try {
			is = new FileInputStream(file);
			src = javax.imageio.ImageIO.read(is);
			ret = src.getWidth(null); // 得到源图宽
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * 获取图片高度
	 * 
	 * @param file
	 *            图片文件
	 * @return 高度
	 */
	public static int getImgHeight(File file) {
		InputStream is = null;
		BufferedImage src = null;
		int ret = -1;
		try {
			is = new FileInputStream(file);
			src = javax.imageio.ImageIO.read(is);
			ret = src.getHeight(null); // 得到源图高
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * 获取和判断文件头信息
	 */
	public static String getFileTypeByStream(byte[] b) {
		String filetypeHex = String.valueOf(getFileHexString(b));
		//System.out.println(filetypeHex);
		Iterator<Entry<String, String>> entryiterator = FILE_TYPE_MAP.entrySet().iterator();
		while (entryiterator.hasNext()) {
			Entry<String, String> entry = entryiterator.next();
			String fileTypeHexValue = entry.getValue().toUpperCase();
			if (filetypeHex.toUpperCase().startsWith(fileTypeHexValue)) {
				return entry.getKey();
			}
		}
		return null;
	}

	public static String getFileHexString(byte[] b) {
		StringBuilder stringBuilder = new StringBuilder();
		if (b == null || b.length <= 0) {
			return null;
		}
		for (int i = 0; i < b.length; i++) {
			int v = b[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	public static Map<String, String> FILE_TYPE_MAP = new HashMap<String, String>();

	public void getVideoFileType() {
		FILE_TYPE_MAP.put("ram", "2E7261FD"); // Real Audio (ram)
		FILE_TYPE_MAP.put("rm", "2E524D46"); // Real Media (rm)
		FILE_TYPE_MAP.put("mov", "00000014667479707174"); // Quicktime (mov)
		FILE_TYPE_MAP.put("rmvb", "2e524d46000000120001"); // rmvb
		FILE_TYPE_MAP.put("avi", "41564920");
		FILE_TYPE_MAP.put("avi", "52494646b440c02b4156");
		FILE_TYPE_MAP.put("flv", "464C5601050000000900");
		FILE_TYPE_MAP.put("mp4", "00000020667479706d70");
		FILE_TYPE_MAP.put("wmv", "3026b2758e66CF11a6d9");
		FILE_TYPE_MAP.put("3gp", "00000014667479703367");
		FILE_TYPE_MAP.put("mkv", "1a45dfa3010000000000");
	}

	public static void getPicFileType() {
		FILE_TYPE_MAP.put("jpg", "FFD8FF"); // JPEG (jpg)
		FILE_TYPE_MAP.put("png", "89504E47"); // PNG (png)
		FILE_TYPE_MAP.put("gif", "47494638"); // GIF (gif)
		FILE_TYPE_MAP.put("bmp", "424D"); // Windows Bitmap (bmp)
		FILE_TYPE_MAP.put("png", "89504E470D0a1a0a0000"); // PNG (png)
		FILE_TYPE_MAP.put("bmp", "424d228c010000000000"); // 16色位图(bmp)
		FILE_TYPE_MAP.put("bmp", "424d8240090000000000"); // 24位位图(bmp)
		FILE_TYPE_MAP.put("bmp", "424d8e1b030000000000"); // 256色位图(bmp
	}

	public void getAudioFileType() {
		FILE_TYPE_MAP.put("wav", "57415645"); // Wave (wav)
		FILE_TYPE_MAP.put("mid", "4D546864"); // MIDI (mid)
		FILE_TYPE_MAP.put("mp3", "49443303000000002176");
		FILE_TYPE_MAP.put("wav", "52494646e27807005741");
		FILE_TYPE_MAP.put("aac", "fff1508003fffcda004c");
		FILE_TYPE_MAP.put("wv", "7776706ba22100000704");
		FILE_TYPE_MAP.put("flac", "664c6143800000221200");
	}

	public void MultipartFileUpLoad() {
		FILE_TYPE_MAP.put("ffd8ffe000104a464946", "jpg"); // JPEG (jpg)
		FILE_TYPE_MAP.put("89504e470d0a1a0a0000", "png"); // PNG (png)
		FILE_TYPE_MAP.put("47494638396126026f01", "gif"); // GIF (gif)
		FILE_TYPE_MAP.put("49492a00227105008037", "tif"); // TIFF (tif)
		FILE_TYPE_MAP.put("424d228c010000000000", "bmp"); // 16色位图(bmp)
		FILE_TYPE_MAP.put("424d8240090000000000", "bmp"); // 24位位图(bmp)
		FILE_TYPE_MAP.put("424d8e1b030000000000", "bmp"); // 256色位图(bmp)
		FILE_TYPE_MAP.put("41433130313500000000", "dwg"); // CAD (dwg)
		FILE_TYPE_MAP.put("3c21444f435459504520", "html"); // HTML (html)
		FILE_TYPE_MAP.put("3c21646f637479706520", "htm"); // HTM (htm)
		FILE_TYPE_MAP.put("48544d4c207b0d0a0942", "css"); // css
		FILE_TYPE_MAP.put("696b2e71623d696b2e71", "js"); // js
		FILE_TYPE_MAP.put("7b5c727466315c616e73", "rtf"); // Rich Text Format
															// (rtf)
		FILE_TYPE_MAP.put("38425053000100000000", "psd"); // Photoshop (psd)
		FILE_TYPE_MAP.put("46726f6d3a203d3f6762", "eml"); // Email [Outlook
															// Express 6] (eml)
		FILE_TYPE_MAP.put("d0cf11e0a1b11ae10000", "doc"); // MS Excel
															// 注意：word、msi 和
															// excel的文件头一样
		FILE_TYPE_MAP.put("d0cf11e0a1b11ae10000", "vsd"); // Visio 绘图
		FILE_TYPE_MAP.put("5374616E64617264204A", "mdb"); // MS Access (mdb)
		FILE_TYPE_MAP.put("252150532D41646F6265", "ps");
		FILE_TYPE_MAP.put("255044462d312e350d0a", "pdf"); // AdobeAcrobat (pdf)
		FILE_TYPE_MAP.put("2e524d46000000120001", "rmvb"); // rmvb/rm相同
		FILE_TYPE_MAP.put("464c5601050000000900", "flv"); // flv与f4v相同
		FILE_TYPE_MAP.put("00000020667479706d70", "mp4");
		FILE_TYPE_MAP.put("49443303000000002176", "mp3");
		FILE_TYPE_MAP.put("000001ba210001000180", "mpg"); //
		FILE_TYPE_MAP.put("3026b2758e66cf11a6d9", "wmv"); // wmv与asf相同
		FILE_TYPE_MAP.put("52494646e27807005741", "wav"); // Wave (wav)
		FILE_TYPE_MAP.put("52494646d07d60074156", "avi");
		FILE_TYPE_MAP.put("4d546864000000060001", "mid"); // MIDI (mid)
		FILE_TYPE_MAP.put("504b0304140000000800", "zip");
		FILE_TYPE_MAP.put("526172211a0700cf9073", "rar");
		FILE_TYPE_MAP.put("235468697320636f6e66", "ini");
		FILE_TYPE_MAP.put("504b03040a0000000000", "jar");
		FILE_TYPE_MAP.put("4d5a9000030000000400", "exe");// 可执行文件
		FILE_TYPE_MAP.put("3c25402070616765206c", "jsp");// jsp文件
		FILE_TYPE_MAP.put("4d616e69666573742d56", "mf");// MF文件
		FILE_TYPE_MAP.put("3c3f786d6c2076657273", "xml");// xml文件
		FILE_TYPE_MAP.put("494e5345525420494e54", "sql");// xml文件
		FILE_TYPE_MAP.put("7061636b616765207765", "java");// java文件
		FILE_TYPE_MAP.put("406563686f206f66660d", "bat");// bat文件
		FILE_TYPE_MAP.put("1f8b0800000000000000", "gz");// gz文件
		FILE_TYPE_MAP.put("6c6f67346a2e726f6f74", "properties");// bat文件
		FILE_TYPE_MAP.put("cafebabe0000002e0041", "class");// bat文件
		FILE_TYPE_MAP.put("49545346030000006000", "chm");// bat文件
		FILE_TYPE_MAP.put("04000000010000001300", "mxp");// bat文件
		FILE_TYPE_MAP.put("504b0304140006000800", "docx");// docx文件
		FILE_TYPE_MAP.put("d0cf11e0a1b11ae10000", "wps");// WPS文字wps、表格et、演示dps都是一样的
		FILE_TYPE_MAP.put("6431303a637265617465", "torrent");
		FILE_TYPE_MAP.put("6D6F6F76", "mov"); // Quicktime (mov)
		FILE_TYPE_MAP.put("FF575043", "wpd"); // WordPerfect (wpd)
		FILE_TYPE_MAP.put("CFAD12FEC5FD746F", "dbx"); // Outlook Express (dbx)
		FILE_TYPE_MAP.put("2142444E", "pst"); // Outlook (pst)
		FILE_TYPE_MAP.put("AC9EBD8F", "qdf"); // Quicken (qdf)
		FILE_TYPE_MAP.put("E3828596", "pwl"); // Windows Password (pwl)
		FILE_TYPE_MAP.put("2E7261FD", "ram"); // Real Audio (ram)
	}

	public static boolean MultipartFileType(List<MultipartFile> files) {
		for (int i = 0; i < files.size(); i++) {
			MultipartFile file = files.get(i);
			FILE_TYPE_MAP.clear();
			getPicFileType();
			InputStream is = null;
			try {
				is = file.getInputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
			for (int j = 0; j < 10; j++) {
				int a = 0;
				try {
					a = is.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				bytestream.write(a);
			}
			byte imgdata[] = bytestream.toByteArray();
			if (getFileTypeByStream(imgdata) == null) {
				try {
					System.out.println("--文件类型---------");
					System.out.println(getFileTypeByStream(imgdata));
					throw new Exception("不是指定类型文件！");
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
		}
		return true;
	}

	/*
	 * 多个文件上传
	 */
	public static Map<Integer, String> multiUpload(HttpServletRequest request, String formFileName, String savePath,
			String servPath) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		System.out.println("------------------------------------------multiUpload");
		// long start = System.currentTimeMillis();
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles(formFileName);
		//不是指定类型文件！
		if (!MultipartFileType(files)) {
			return null;
		}
		// 得到上传文件的保存目录，可以将上传的文件存放于WEB-INF或者不允许外界直接访问目录下，保证上传文件的安全
		// String filePath = request.getServletContext().getRealPath("") +
		// File.separator + "/";
		// String savePath =
		// request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMM");// 定义到毫秒
		String nowStr = dateformat.format(date);
		String SaveFilePath = servPath + savePath + "/" + nowStr + "/";
		File filePath = new File(SaveFilePath);
		// 判断上传文件的保存目录是否存在
		if (!filePath.exists() && !filePath.isDirectory()) {
			System.out.println(SaveFilePath + "目录不存在，需要创建");
			// 创建目录
			filePath.mkdir();
		}
		System.out.println(files.size());
		for (int i = 0; i < files.size(); i++) {
			MultipartFile file = files.get(i);
			String fileName = FileUtils.fileNameNew(file.getOriginalFilename());
			if (file.isEmpty()) {
				System.out.println("上传第" + (i++) + "个文件失败" + SaveFilePath + fileName);
			}
			File dest = new File(SaveFilePath + fileName);
			try {
				file.transferTo(dest);
				map.put(i, savePath + "/" + nowStr + "/" + fileName);
				System.out.println("第" + (i + 1) + "个文件上传成功" + SaveFilePath + fileName);
				// 缩略图
				Thumbnails.of(SaveFilePath + fileName).size(120, 90).keepAspectRatio(false)
						.toFile(SaveFilePath + fileName + ".jpg");

			} catch (IOException e) {
				System.out.println("上传第" + (i++) + "个文件失败" + SaveFilePath + fileName);
				System.out.printf(e.toString(), e);
			}
		}
		// System.out.println("IO cost:" + (System.currentTimeMillis() - start)
		// + "ms");
		// "上传成功" + savePath;
		return map;
	}

	/**
	 * 生成一个长串以最大保证文件名存储唯一
	 * 
	 * @param fileName
	 * @return 新文件名
	 */
	public static String fileNameNew(String fileName) {
		String fileNameNew = null;
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddhhmmssSSS");// 定义到毫秒
		String nowStr = dateformat.format(date);
		String filenameStr = fileName.substring(0, fileName.lastIndexOf("."));// 去掉后缀的文件名
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);// 后缀
		if (fileName.trim() != "") {// 如果名称不为"",说明该文件存在，否则说明该文件不存在
			fileNameNew = nowStr + (int) (Math.random() * 1000) + "." + suffix;// 定义上传路径
		}
		return fileNameNew;
	}
}