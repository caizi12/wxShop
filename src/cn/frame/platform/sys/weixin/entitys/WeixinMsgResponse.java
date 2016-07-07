package cn.frame.platform.sys.weixin.entitys;

public class WeixinMsgResponse {
	//接收方帐号（收到的OpenID）
	private String ToUserName	;
	//开发者微信号 必填	
	private String FromUserName;
	//消息创建时间 （整型） 必填
	private String CreateTime	;
	//消息类型 （news 图文消息） 必填
	private String MsgType	;	
	
 
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	//图文消息个数，限制为10条以内 必填
	private String ArticleCount;
	
	
	
	/**
	 * 图文消息
	 * @author li
	 *
	 */
	public static class MsgNews{
		//非必填 图文消息标题
		private String Title;
		//非必填	图文消息描述	
		private String Description;
		//非必填	图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
		private String PicUrl;
		//点击图文消息跳转链接	
		private String Url	;
		
		public MsgNews(){}
		
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			Title = title;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		public String getPicUrl() {
			return PicUrl;
		}
		public void setPicUrl(String picUrl) {
			PicUrl = picUrl;
		}
		public String getUrl() {
			return Url;
		}
		public void setUrl(String url) {
			Url = url;
		}
	}

	public String getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(String articleCount) {
		ArticleCount = articleCount;
	}
	
}
