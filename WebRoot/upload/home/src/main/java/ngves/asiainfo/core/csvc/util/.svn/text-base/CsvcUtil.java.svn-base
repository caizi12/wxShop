package ngves.asiainfo.core.csvc.util;

public class CsvcUtil {
    //csvcBrandCode默认为05 - 他网
    private static CodeMapper brandMapper = new CodeMapper("05", null);

    static {
        //name, csvcBrandCode, ngvesBrandCode
        brandMapper.register("全球通", "01", "0");
        brandMapper.register("动感地带", "02", "2");
        brandMapper.register("神州行", "03", "1");
        brandMapper.register("外省移动客户", "04", null);
        brandMapper.register("他网", "05", null);
    }

    /**
     * 将csvc的用户品牌编码映射成积分平台的品牌编码
     *
     * @param csvcBrandCode csvc的品牌编码
     * @return 积分平台的品牌编码
     */
    public static String getBrandCodeFromCsvcToNgves(String csvcBrandCode) {
        return brandMapper.getBCodeByACode(csvcBrandCode);
    }

    /**
     * 将积分平台的用户品牌编码映射成一级客服(csvc)的品牌编码
     *
     * @param ngvesBrandCode 积分平台的品牌编码
     * @return csvc的品牌编码
     */
    public static String getBrandCodeFromNgvesToCsvc(String ngvesBrandCode) {
        return brandMapper.getACodeByBCode(ngvesBrandCode);
    }

    //---------------------
    //用户级别对照关系
    //分别为csvcUserLevelCode, ngvesUserLevelCode
    //csvcUserLevelCode默认为04 - 普通客户
    //ngvesUserLevelCode默认为100 - 普通客户
    private static CodeMapper userLevelMapper = new CodeMapper("04", "100");

    static {
        userLevelMapper.register("普通客户", "04", "100");
        userLevelMapper.register("重要客户", null, "200");
        userLevelMapper.register("党政机关客户", null, "201");
        userLevelMapper.register("军、警、安全机关客户", null, "202");
        userLevelMapper.register("联通合作伙伴客户", null, "203");
        userLevelMapper.register("英雄、模范、名星类客户", null, "204");
        userLevelMapper.register("普通大客户", null, "300");
        userLevelMapper.register("钻石卡大客户", "01", "301");
        userLevelMapper.register("金卡大客户", "02", "302");
        userLevelMapper.register("银卡大客户", "03", "303");
        userLevelMapper.register("贵宾卡大客户", null, "304");
    }

    /**
     * 将csvc的用户级别编码映射成积分平台的用户级别编码
     *
     * @param csvcUserLevelCode csvc的用户级别编码
     * @return 积分平台的用户级别编码
     */
    public static String getUserLevelFromCsvcToNgves(String csvcUserLevelCode) {
        return userLevelMapper.getBCodeByACode(csvcUserLevelCode);
    }

    /**
     * 将积分平台的用户级别编码映射成一级客服(csvc)的级别编码
     *
     * @param ngvesUserLevelCode 积分平台的用户级别编码
     * @return csvc的级别编码
     */
    public static String getUserLevelFromNgvesToCsvc(String ngvesUserLevelCode) {
        return userLevelMapper.getACodeByBCode(ngvesUserLevelCode);
    }

}
