package ngves.asiainfo.core.rushbuy.util;

import java.util.Comparator;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitValue;

public class ActivityTimeCompare implements Comparator<IActivityLimitValue>{
	
	public int compare(IActivityLimitValue arg0, IActivityLimitValue arg1) {
		if(arg0.getActivityEndTime().after(arg1.getActivityEndTime())) {
					
			return 0;
			
		}else {
					
			return 1;
		}
	}

}
