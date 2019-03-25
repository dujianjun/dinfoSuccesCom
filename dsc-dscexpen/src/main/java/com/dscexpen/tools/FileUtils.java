package com.dscexpen.tools;

//import org.apache.commons.fileupload.FileItem;


public class FileUtils {
	/*private static Logger logger = Logger.getLogger(FileUtils.class);
//	public static final String defaultPath = PropertyConfig.getProperty("FILEPATH");
	public static final String defaultPath = "upFile";
	*//**
	 * 复制
	 *//*
	public static final int FILE_OPERATION_TYPE_COPY = 1;
	*//**
	 * 剪切
	 *//*
	public static final int FILE_OPERATION_TYPE_CUT = 2;
	
	*//**
	 * 剪切文件
	 * @param sourceFile
	 * @param targetFile
	 * @return
	 *//*
	public static boolean cutFile(File sourceFile, File targetFile) {
		// 如果复制成功，则删除文件就实现了剪切的功能
		if(copyFile(sourceFile, targetFile)){
			deleteFile(sourceFile);
			return true;
		}
		return false;
	}
	*//***
	 * 复制文件
	 * @param sourceFile
	 * @param targetFile
	 * @return
	 *//*
	public static boolean copyFile(File sourceFile, File targetFile) {
//		deleteFile(targetFile);
		if(!targetFile.exists()){
			targetFile.mkdir();
		}
		if(!sourceFile.exists()){
			return false;
		}
		// 顶层目录
		File topFile = new File(targetFile, sourceFile.getName());
		// 复制目录
		if (sourceFile.isDirectory()) {
			// 创建顶层目录
			topFile.mkdir();
			// 获取当前目录下的所有文件或者目录
			File[] dir = sourceFile.listFiles();
			// 逐个拷贝到顶层目录下
			for (int i = 0; i < dir.length; i++) {
				if (!copyFile(dir[i], topFile))
					return false;
			}
			// 复制成功
			return true;

		} else {
			// 复制文件
			try {
				// 文件输入输出流
				FileInputStream fis = new FileInputStream(sourceFile);
				FileOutputStream fos = new FileOutputStream(topFile);
				// 缓存
				byte[] buffer = new byte[1024];
				int c = 0;
				while ((c = fis.read(buffer)) != -1) {
					fos.write(buffer, 0, c);
				}
				// 关闭流
				fis.close();
				fos.close();
			} catch (FileNotFoundException e) {
				logger.info("文件未找到：" + e);
			} catch (IOException e) {
				logger.info("io异常：" + e);
			}
			return true;
		}
	}
	
	*//**
	 * 删除文件
	 * @param sourceFile
	 *//*
	public static void deleteFile(File sourceFile){
		if(sourceFile.isDirectory()){
			//获取当前目录下的所有文件和目录
			File [] files = sourceFile.listFiles();
			for(int i=0;i<files.length;i++){
				//对子目录或者文件进行相同的操作
				if(files[i].isDirectory()){
					deleteFile(files[i]);
				}else{
					files[i].delete();
				}
			}
			//删除父目录
			sourceFile.delete();
		}else{
			//删除源文件
			sourceFile.delete();
		}
		
	}
	
	*//**
	 * 下载文件
	 * @param path
	 * @param response
	 * @return
	 *//*
	public static HttpServletResponse download(String path,
			HttpServletResponse response) {
		try {
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();
			// 取得文件的后缀名。
			String ext = filename.substring(filename.lastIndexOf(".") + 1);
			filename = filename.replace("." + ext, "");
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			byte[] bytesStr = filename.getBytes("GBK");
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String(bytesStr, "ISO-8859-1") + "." + ext);
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(response
					.getOutputStream());
			response.setContentType("application/octet-stream");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return response;
	}
	
	
	*//**
	 * 下载文件
	 * @param path
	 * @param filename
	 * @param response
	 * @return
	 *//*
	public static HttpServletResponse download(String path,String filename,
			HttpServletResponse response) {
		try {
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			// 取得文件的后缀名。
			String ext = filename.substring(filename.lastIndexOf(".") + 1);
			filename = filename.replace("." + ext, "");
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			byte[] bytesStr = filename.getBytes("GBK");
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String(bytesStr, "ISO-8859-1") + "." + ext);
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(response
					.getOutputStream());
			response.setContentType("application/octet-stream");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return response;
	}
	
	

	*//**
	 * 文件上传操作 - 保存执行方法
	 * 
	 * @author Phoenix.zw 2011-6-25
	 * @param item
	 *            ：文件上传-页面提交的上传文件项
	 * @return
	 * @throws Exception
	 *//*
	@SuppressWarnings("unused")
	public static String saveUploadFile(HttpServletRequest request,
										FileItem item, String lastSecond) throws Exception {
		String json ="";
		// 文件原始路径
		String originalPath = item.getName();
		originalPath = originalPath.substring(
				originalPath.lastIndexOf("\\") + 1, originalPath.length());
		
		//文件名
		String fileName = originalPath.substring(0, originalPath.lastIndexOf("."));
		String ext = originalPath.substring(originalPath.lastIndexOf("."), originalPath.length());
		String filePath = fileName+"_"+lastSecond+ext;
		
		// 构造文件保存路径
		String prefixPath = defaultPath + "\\"; // 上传文件所在主目录
		String fullUploadPath = request.getRealPath(prefixPath)
				+ File.separator;
		String relativeUploadPath = prefixPath;
		File path = new File(fullUploadPath);
		if (!path.exists()) {
			path.mkdirs();
		}
		// 文件扩展名
		fullUploadPath = fullUploadPath + filePath;
		relativeUploadPath = relativeUploadPath + filePath;
		logger.info(fullUploadPath);
		// 上传的文件为网络文件，从网络读取
		if (filePath.trim().toLowerCase().startsWith("http://")) {
			File file = new File(fullUploadPath);
			// 建立网络连接
			URL url = new URL(filePath);
			logger.debug("网络文件地址：" + url.getHost() + " -- " + url.toString());
			HttpURLConnection huconn = (HttpURLConnection) url.openConnection();
			huconn.setConnectTimeout(180000);
			huconn.setReadTimeout(180000);
			// 读取并转存文件
			DataInputStream dis = new DataInputStream(huconn.getInputStream());
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buff = new byte[2048];
			int num = -1;
			while ((num = dis.read(buff)) != -1) {
				fos.write(buff, 0, num);
			}
			dis.close();
			fos.flush();
			fos.close();
		} else {
			// 上传的文件为本地文件，直接写入
			File file = new File(fullUploadPath);
			item.write(file);
			item.delete();
		}
		String fileName1= fullUploadPath;	
		json=filePath+"#"+json;
		return json;
	}
	

	
	
	public static void main(String[] args) {
		String aaa="book.sql";
		String fileName = aaa.substring(0, aaa.lastIndexOf("."));
		String ext = aaa.substring(aaa.lastIndexOf("."), aaa.length());
		String filePath = fileName+"_"+System.currentTimeMillis()+ext;
		System.out.println(fileName);
		System.out.println(ext);
		System.out.println(filePath);
		
	}
*/
}
