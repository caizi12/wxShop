/**
 * Copyright (c) 2009 asiainfo.com
 */
package ngves.asiainfo.core.review.ivalues;

import com.ai.appframe2.common.DataStructInterface;

/**
 * 产生id的接口
 * @author wzg
 *
 */
public interface IIdValue extends DataStructInterface {

    public long getId();

    public void setId(long id);
}
