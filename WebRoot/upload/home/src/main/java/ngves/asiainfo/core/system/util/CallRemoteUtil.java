package ngves.asiainfo.core.system.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class CallRemoteUtil {

	private static transient Log logger = LogFactory.getLog(CallRemoteUtil.class);

	private Connection conn;

	/** 远程机器IP */
	private String ip;
	/** */
	/** 用户名 */
	private String usr;
	/** */
	/** 密码 */
	private String psword;
	private String charset = Charset.defaultCharset().toString();
	private static final int TIME_OUT = 1000 * 5 * 60;

	/**
	 * 构造函数
	 * 
	 * @param ip
	 * @param usr
	 * @param ps
	 */
	public CallRemoteUtil(String ip, String usr, String ps) {
		this.ip = ip;
		this.usr = usr;
		this.psword = ps;
	}

	/**
	 * 登录
	 * 
	 * @return
	 * @throws IOException
	 */
	private boolean login() throws Exception {
		try {
			if (logger.isDebugEnabled())
				logger.debug("connect ip:= " + ip);
			conn = new Connection(ip);
			conn.connect();
			return conn.authenticateWithPassword(usr, psword);
		} catch (Exception e) {
			logger.error("can not connect to FTP server!", e);
			throw new Exception(e);
		}
	}

	/**
	 * 执行脚本 可以将outStr和outErr记录到日志中，以便维护人员查看shell的执行情况
	 * 
	 * @param cmds
	 *            : sh /home/bes/testshell/helloworld.sh zhongguorenmin ,支持参数配置。
	 * @return 一般情况下shell脚本正常执行完毕，getExitStatus方法返回0
	 * @throws Exception
	 */
	public int exec(String cmds) throws Exception {
		InputStream stdOut = null;
		InputStream stdErr = null;
		String outStr = "";
		String outErr = "";
		int ret = -1;
		try {
			if (login()) {
				Session session = conn.openSession();
				session.execCommand(cmds);
				stdOut = new StreamGobbler(session.getStdout());
				outStr = processStream(stdOut, charset);

				stdErr = new StreamGobbler(session.getStderr());
				outErr = processStream(stdErr, charset);

				session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);

				logger.info("outStr=" + outStr);
				logger.info("outErr=" + outErr);
				ret = session.getExitStatus();
			} else {
				throw new Exception("登录远程机器失败" + ip);
			}
		} finally {
			if (conn != null) {
				conn.close();
			}
			IOUtils.closeQuietly(stdOut);
			IOUtils.closeQuietly(stdErr);
		}
		return ret;
	}

	/**
	 * @param in
	 * @param charset
	 * @return
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	private String processStream(InputStream in, String charset) throws Exception {
		byte[] buf = new byte[1024];
		StringBuilder sb = new StringBuilder();
		while (in.read(buf) != -1) {
			sb.append(new String(buf, charset));
		}
		return sb.toString();
	}

}
