package ngves.asiainfo.core.common.util;

import ngves.asiainfo.core.SolrConstant;
import ngves.asiainfo.core.SolrPara;
import ngves.asiainfo.util.CommonParaUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

/**
 * SolrServer
 * @author 宋鲁振
 */
public class SolrServerInstance {
	private static transient Log log = LogFactory.getLog(SolrServerInstance.class);
	private static CloudSolrServer selectSolrCloudServer = null;
	private static HttpSolrServer selectSolrServer = null;
	
	private static CloudSolrServer updateSolrCloudServer = null;
	private static HttpSolrServer updateSolrServer = null;
	
	/**
	 * 获取一个solr服务的连接
	 * 
	 * 积分配置管理工程（Memcached）中有以下属性
	 * solr_cluster  是否使用集群
	 * solr_cluster_url 集群URL
	 * 
	 * 若不使用集群 则使用Solr主从或者单例, 会从Properties文件中读取Url
	 * master_server_url
	 * 
	 * 该方法用于搜索查询
	 * 
	 * @return
	 */
	public static SolrServer getInstance() {
		try {
			if ("Y".equals(CommonParaUtil.getPara(SolrConstant.SOLR_CLUSTER))) {
				if (selectSolrCloudServer == null) {
					selectSolrCloudServer = new CloudSolrServer(CommonParaUtil.getPara(SolrConstant.SOLR_CLUSTER_URL));
					selectSolrCloudServer.setDefaultCollection("jfcore");
					selectSolrCloudServer.setZkClientTimeout(5000);
					selectSolrCloudServer.setZkConnectTimeout(5000);
				}
				return selectSolrCloudServer;
			} else {
				if (selectSolrServer == null) {
					//查询如果使用主从 所指向的solr服务url由自己下面的properties文件读取
					selectSolrServer = new HttpSolrServer(SolrPara.get(SolrConstant.MASTER_SERVER_URL)+"jfcore");
					selectSolrServer.setSoTimeout(3000);
					selectSolrServer.setConnectionTimeout(1000);
					selectSolrServer.setDefaultMaxConnectionsPerHost(1000);
					selectSolrServer.setMaxTotalConnections(10);
					selectSolrServer.setFollowRedirects(false);
					selectSolrServer.setAllowCompression(true);
					selectSolrServer.setMaxRetries(1);
				}
				return selectSolrServer;
			}
		} catch (Exception e) {
			log.error("Solr Client Init Error, please check the parameters, ", e);
		}
		return null;
	}
	
	/**
	 * 该方法用于全量重建索引 实时获取SolrServer实例
	 * 
	 * 实例类型和链接由新增配置属性控制
	 * solr_reindex_use_cluster 是否使用solr集群
	 * 
	 * solr_cluster_url SOLR集群URL Key
	 * 
	 * SOLR_MASTER_URL  SOLR主从 主URL
	 * 
	 * 重新创建索引只会手动执行 SolrServer对象无需缓存
	 * 
	 * @return
	 */
	public static SolrServer getSolrReIndexInstance() {
		try {
			if ("Y".equals(CommonParaUtil.getPara(SolrConstant.SOLR_REINDEX_USE_CLUSTER))) {
				CloudSolrServer solrCloudServer = new CloudSolrServer(CommonParaUtil.getPara(SolrConstant.SOLR_CLUSTER_URL));
				solrCloudServer.setDefaultCollection("jfcore");
				return solrCloudServer;
			} else {
				HttpSolrServer solrServer = new HttpSolrServer(CommonParaUtil.getPara(SolrConstant.SOLR_MASTER_URL)+"jfcore");
				solrServer.setSoTimeout(3000);
				solrServer.setConnectionTimeout(1000);
				solrServer.setDefaultMaxConnectionsPerHost(1000);
				solrServer.setMaxTotalConnections(10);
				solrServer.setFollowRedirects(false);
				solrServer.setAllowCompression(true);
				solrServer.setMaxRetries(1);
				return solrServer;
			}
		} catch (Exception e) {
			log.error("Solr Client Init Error, please check the parameters, ", e);
		}
		return null;
	}
	
	/**
	 * 该方法用于定时更新索引 获取SolrServer实例
	 * 
	 * 由变量以下变量控制
	 * solr_cluster 是否使用solr集群
	 * 
	 * solr_cluster_url SOLR集群URL Key
	 * 
	 * SOLR_MASTER_URL  SOLR主从 主URL
	 * 
	 * @return
	 */
	public static SolrServer getSolrUpdateInstance() {
		try {
			if ("Y".equals(CommonParaUtil.getPara(SolrConstant.SOLR_CLUSTER))) {
				if (updateSolrCloudServer == null) {
					updateSolrCloudServer = new CloudSolrServer(CommonParaUtil.getPara(SolrConstant.SOLR_CLUSTER_URL));
					updateSolrCloudServer.setDefaultCollection("jfcore");
					updateSolrCloudServer.setZkClientTimeout(5000);
					updateSolrCloudServer.setZkConnectTimeout(5000);
				}
				return updateSolrCloudServer;
			} else {
				if (updateSolrServer == null) {
					//查询如果使用主从 所指向的solr服务url由自己下面的properties文件读取
					updateSolrServer = new HttpSolrServer(CommonParaUtil.getPara(SolrConstant.SOLR_MASTER_URL)+"jfcore");
					updateSolrServer.setSoTimeout(3000);
					updateSolrServer.setConnectionTimeout(1000);
					updateSolrServer.setDefaultMaxConnectionsPerHost(1000);
					updateSolrServer.setMaxTotalConnections(10);
					updateSolrServer.setFollowRedirects(false);
					updateSolrServer.setAllowCompression(true);
					updateSolrServer.setMaxRetries(1);
				}
				return updateSolrServer;
			}
		} catch (Exception e) {
			log.error("Solr Client Init Error, please check the parameters, ", e);
		}
		return null;
	}
}
