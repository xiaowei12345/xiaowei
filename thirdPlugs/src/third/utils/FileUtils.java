package third.utils;

import java.io.BufferedInputStream;  
import java.io.ByteArrayOutputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;
import java.io.IOException;  
import java.io.RandomAccessFile;  
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;  
import java.nio.MappedByteBuffer;  
import java.nio.channels.FileChannel;  
import java.nio.channels.FileChannel.MapMode; 
import org.json.JSONArray;
import org.json.JSONObject;
import com.jiuqi.dna.ui.engine.internal.EngineTools;
import com.jiuqi.dna.ui.wt.graphics.TextFileDescriptor;
import com.jiuqi.xlib.utils.io.IOUtils;

@SuppressWarnings("restriction")
public class FileUtils { 

	public static String getTxtFile(int point,String plug,String path){
		TextFileDescriptor txtFile = TextFileDescriptor.getDescriptor(plug, path);
		String content = null;
		switch(point){
		case 0:
			content = txtFile.getContent();
			break;
		case 1:
			content = txtFile.getContent("utf-8");
			break;
		}
		return content;
	}

	/**
	 * ��ȡĳ���ļ����µ������ļ�
	 * @param ·��
	 */
	public static void readfile(String filepath,JSONObject data,String key) {
		try {
			
			File file = new File(filepath);
			if (!file.isDirectory()) {
//				System.out.println("�ļ�");
//				System.out.println("path=" + file.getPath());
//				System.out.println("absolutepath=" + file.getAbsolutePath());
//				System.out.println("name=" + file.getName());
				data.put("id", key);
				data.put("text", file.getName());
//				data.put("children", new JSONArray());

			} else if (file.isDirectory()) {
//				System.out.println("�ļ���");
				data.put("id", key);
				data.put("text", file.getName());
				JSONArray childDate = new JSONArray();
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {
					File readfile = new File(filepath + File.separator + filelist[i]);
					JSONObject json = new JSONObject();
					json.put("id", key+i);
					json.put("text", readfile.getName());
					childDate.put(json);
					data.put("children", childDate);
					if (!readfile.isDirectory()) {
//						System.out.println("path=" + readfile.getPath());
//						System.out.println("absolutepath="
//								+ readfile.getAbsolutePath());
//						System.out.println("name=" + readfile.getName());	
//						data.put("id", key+i);
//						data.put("text", readfile.getName());
//						childDate.put(json);
//						data.put("children", childDate);
					} else if (readfile.isDirectory()) {
						readfile(filepath + File.separator + filelist[i],json,key+i);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("readfile()   Exception:" + e.getMessage());
		}
	}

	/**
	 * ��ȡϵͳ���ļ�<br>
	 * 	DNA�ڲ��������в�ȷ���ɿ���
	 * @param ����id
	 * @param �ļ�·��
	 * @return
	 */
	public static byte[] readSyatemFile(String pluginId,String path){
		byte[] content = null;
		URL url = EngineTools.getResource(pluginId, path);
		URLConnection conn;
		try {
			conn = url.openConnection();
			conn.connect();
			content = IOUtils.toByteArray(conn.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ϵͳ�Ҳ���ָ�����ļ�");
		}
		return content;
	}

	/**
	 * ���ɱ����ļ�
	 * @param ����Ŀ¼
	 * @param �ļ�����
	 * @param �����ֽ�����
	 */
	public static final void exportFileToPath(String filePath,String fileName,byte[] content){
		if(null==content||content.length==0) return;
		File dir = new File(filePath);
		File file = new File(filePath+File.separator+fileName);
		try{
			if (!dir.exists()) {
				dir.mkdirs();
			}
			if(file.exists()){
				file.createNewFile();
			}
			FileOutputStream fop = new FileOutputStream(file);
			fop.write(content);
			fop.flush();
			fop.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public byte[] getContent(String filePath) throws IOException {  
		File file = new File(filePath);  
		long fileSize = file.length();  
		if (fileSize > Integer.MAX_VALUE) {  
			System.out.println("file too big...");  
			return null;  
		}  
		FileInputStream fi = new FileInputStream(file);  
		byte[] buffer = new byte[(int) fileSize];  
		int offset = 0;  
		int numRead = 0;  
		while (offset < buffer.length  
				&& (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {  
			offset += numRead;  
		}  
		// ȷ���������ݾ�����ȡ  
		if (offset != buffer.length) {  
			throw new IOException("Could not completely read file "  
					+ file.getName());  
		}  
		fi.close();  
		return buffer;  
	}  

	/** 
	 * the traditional io way 
	 *  
	 * @param filename 
	 * @return 
	 * @throws IOException 
	 */  
	public static byte[] toByteArray(String filename) throws IOException {  

		File f = new File(filename);  
		if (!f.exists()) {  
			throw new FileNotFoundException(filename);  
		}  

		ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());  
		BufferedInputStream in = null;  
		try {  
			in = new BufferedInputStream(new FileInputStream(f));  
			int buf_size = 1024;  
			byte[] buffer = new byte[buf_size];  
			int len = 0;  
			while (-1 != (len = in.read(buffer, 0, buf_size))) {  
				bos.write(buffer, 0, len);  
			}  
			return bos.toByteArray();  
		} catch (IOException e) {  
			e.printStackTrace();  
			throw e;  
		} finally {  
			try {  
				in.close();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
			bos.close();  
		}  
	}  

	/** 
	 * NIO way 
	 *  
	 * @param filename 
	 * @return 
	 * @throws IOException 
	 */  
	public static byte[] toByteArray2(String filename) throws IOException {  

		File f = new File(filename);  
		if (!f.exists()) {  
			throw new FileNotFoundException(filename);  
		}  

		FileChannel channel = null;  
		FileInputStream fs = null;  
		try {  
			fs = new FileInputStream(f);  
			channel = fs.getChannel();  
			ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());  
			while ((channel.read(byteBuffer)) > 0) {  
				// do nothing  
				// System.out.println("reading");  
			}  
			return byteBuffer.array();  
		} catch (IOException e) {  
			e.printStackTrace();  
			throw e;  
		} finally {  
			try {  
				channel.close();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
			try {  
				fs.close();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
		}  
	}  

	/** 
	 * Mapped File way MappedByteBuffer �����ڴ�����ļ�ʱ���������� 
	 *  
	 * @param filename 
	 * @return 
	 * @throws IOException 
	 */  
	@SuppressWarnings("resource")
	public static byte[] toByteArray3(String filename) throws IOException {  

		FileChannel fc = null;  
		try {  
			fc = new RandomAccessFile(filename, "r").getChannel();  
			MappedByteBuffer byteBuffer = fc.map(MapMode.READ_ONLY, 0,  
					fc.size()).load();  
			System.out.println(byteBuffer.isLoaded());  
			byte[] result = new byte[(int) fc.size()];  
			if (byteBuffer.remaining() > 0) {  
				// System.out.println("remain");  
				byteBuffer.get(result, 0, byteBuffer.remaining());  
			}  
			return result;  
		} catch (IOException e) {  
			e.printStackTrace();  
			throw e;  
		} finally {  
			try {  
				fc.close();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
		}  
	} 
	/** 
	 * ɾ�������ļ� 
	 * @param   sPath    ��ɾ���ļ����ļ��� 
	 * @return �����ļ�ɾ���ɹ�����true�����򷵻�false 
	 */  
	public static boolean deleteFile(String sPath) {  
		boolean flag = false;  
		File file = new File(sPath);  
		// ·��Ϊ�ļ��Ҳ�Ϊ�������ɾ��  
		if (file.isFile() && file.exists()) {  
			file.delete();  
			flag = true;  
		}  
		return flag;  
	}  
} 