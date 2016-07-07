package ngves.asiainfo.core.common.util;

/**
 * 礼品类型编码枚举 1：国家大剧院 2：影院通票 3：在线选座 4:NBA 5:机场贵宾厅 6:火车站贵宾厅 7:第三方平台
 * 
 * @author liulin
 * 
 */
public enum WareTypeCodeEnum {

	WareTypeCodeTheatre(1), WareTypeCodeCinema(2), WareTypeCodeSeat(3), WareTypeCodeNBA(4), AirportVipRoom(5), TrainVipHall(
			6),ThirdPlatForm(7);

	private int value;

	private WareTypeCodeEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
