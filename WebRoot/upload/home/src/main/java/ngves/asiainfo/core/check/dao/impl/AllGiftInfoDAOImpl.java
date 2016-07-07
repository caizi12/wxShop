package ngves.asiainfo.core.check.dao.impl;


import com.ai.appframe2.common.ServiceManager;
import ngves.asiainfo.core.check.bo.AllGiftInfoBean;
import ngves.asiainfo.core.check.bo.AllGiftInfoEngine;
import ngves.asiainfo.core.check.dao.interfaces.IAllGiftInfoDAO;
import ngves.asiainfo.core.check.ivalues.IAllGiftInfoValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 实现考核礼品下线操作
 *
 *  shenfl
 */
@SuppressWarnings("unchecked")
public class AllGiftInfoDAOImpl implements IAllGiftInfoDAO {



    public IAllGiftInfoValue[] queryAllGiftInfo(String condition, Map<String, String> map) throws Exception {
        return AllGiftInfoEngine.getBeans(condition,map);
    }


    /**
     *  islbtsl 兑换量
     *                      按礼品小类别维度排序
     * @param bigKindName
     * @return
     * @throws Exception
     */
     public IAllGiftInfoValue[]  queryAllGiftInfo(String bigKindName,String startTime,String endTime) throws Exception {


            String sql = " select WARE_CODE,WARE_NAME,PARTNER_CODE,PARTNER_NAME,BIG_KIND_NAME,MID_KIND_NAME,SML_KIND_NAME,BAL_FEE,MART_FEE,FEE_DC,WAMOUNT,ALLWA_FEE,AVG_ALL_CT,AVG_BIG_CT,AVG_MID_CT,AVG_SML_CT,AVG_DSC,TS_COUNT,TS_RATE , " +

                 " IS_DCDHL  ," +//--是否档次兑换量原因下线(IS_DCDHL)
                 " IS_LBDHL  ," +  //--是否类别兑换量原因下线(IS_LBDHL)
                 " IS_LBDHJE ," + //--是否类别兑换金额原因下线(IS_LBDHJE)
                 " IS_DCTSL  ," + //- -是否档次投诉率原因下线(IS_DCTSL)
                 " IS_LBTSL  " + //--是否类别投诉率原因下线(IS_LBTSL)                                                  // 按照兑换量进行降序排序操作
              " from allgift_info t  where t.big_kind_name = ?  and  start_time= ? and end_time = ?   order by t.big_kind_name,t.mid_kind_name,t.sml_kind_name ,t.WAMOUNT  desc ";

          Connection conn = null;
          ResultSet rs = null;
          PreparedStatement preparedStatement = null;
          IAllGiftInfoValue value = null;

          List allGiftInfoValueList = new ArrayList();

          try {
                  // 取得数据库连接
              conn = ServiceManager.getSession().getConnection();
              preparedStatement =   conn.prepareStatement(sql);
              preparedStatement.setString(1,bigKindName);
              preparedStatement.setString(2,startTime);
              preparedStatement.setString(3,endTime);
              //执行sql获取对应的信息
              rs = preparedStatement.executeQuery();
              while (rs.next()) {


                  value = new AllGiftInfoBean();

                  String wareCode = rs.getString("WARE_CODE");//取得礼品编码
                  value.setWareCode(wareCode);

                  String wareName = rs.getString("WARE_NAME");//礼品名称
                  value.setWareName(wareName);

                  String partnerCode = rs.getString("PARTNER_CODE");//合作商编码
                  value.setPartnerCode(partnerCode);

                  String partnerName  = rs.getString("PARTNER_NAME");//合作商名称
                  value.setPartnerName(partnerName);

                  String _bigKindName = rs.getString("BIG_KIND_NAME");//大类名称
                  value.setBigKindName(_bigKindName);

                  String mdKindName = rs.getString("MID_KIND_NAME");//中类名称
                  value.setMidKindName(mdKindName);

                  String smlKindName = rs.getString("SML_KIND_NAME");//小类名称
                  value.setSmlKindName(smlKindName);

                  // 解决类型显示错误
                  String balFee = rs.getString("BAL_FEE");
                  value.setBalFee(new Double(balFee));

                  String martFee = rs.getString("MART_FEE");
                  value.setMartFee(new Double(martFee));

                  String FEE_DC = rs.getString("FEE_DC");
                  value.setFeeDc(FEE_DC);

                  String WAMOUNT = rs.getString("WAMOUNT");
                  value.setWamount(new Integer(WAMOUNT));

                  String  ALLWA_FEE = rs.getString("ALLWA_FEE");
                  value.setAllwaFee(new Integer(ALLWA_FEE));

                  String AVG_ALL_CT = rs.getString("AVG_ALL_CT");
                  value.setAvgDsc(AVG_ALL_CT);

                  String AVG_BIG_CT = rs.getString("AVG_BIG_CT");
                  value.setAvgBigCt(new Integer(AVG_BIG_CT));


                  String AVG_MID_CT = rs.getString("AVG_MID_CT");
                  value.setAvgMidCt(new Integer(AVG_MID_CT));

                  String AVG_SML_CT = rs.getString("AVG_SML_CT");
                  value.setAvgSmlCt(new Integer(AVG_SML_CT));

                  String AVG_DSC = rs.getString("AVG_DSC");
                  value.setAvgDsc(AVG_DSC);

                  String TS_COUNT = rs.getString("TS_COUNT");
                  value.setTsCount(new Integer(TS_COUNT));

                  // 增加投诉率字段
                  String rs_rate = rs.getString("TS_RATE") ;
                  value.setTsRate(new Double(rs_rate));

    //          " IS_DCDHL  ," +//--是否档次兑换量原因下线(IS_DCDHL)
    //              " IS_LBDHL  ," +  //--是否类别兑换量原因下线(IS_LBDHL)
    //         " IS_LBDHJE ," + //--是否类别兑换金额原因下线(IS_LBDHJE)
    //         " IS_DCTSL  ," + //- -是否档次投诉率原因下线(IS_DCTSL)
    //         " IS_LBTSL  " + //--是否类别投诉率原因下线(IS_LBTSL)

                   String isDcdhl = rs.getString("IS_DCDHL");
                   value.setIsDcdhl(isDcdhl);

                   String IS_LBDHL = rs.getString("IS_LBDHL");
                   value.setIsLbdhl(IS_LBDHL);

                   String   IS_LBDHJE = rs.getString("IS_LBDHJE");
                   value.setIsLbdhje(IS_LBDHJE);

                   String IS_DCTSL = rs.getString("IS_DCTSL");
                   value.setIsDctsl(IS_DCTSL);

                   String IS_LBTSL = rs.getString("IS_LBTSL") ;
                   value.setIsLbtsl(IS_LBTSL);


                  allGiftInfoValueList.add(value);

              }

               AllGiftInfoBean[] result = new AllGiftInfoBean[allGiftInfoValueList.size()];
               System.arraycopy(allGiftInfoValueList.toArray(),0,result,0,allGiftInfoValueList.size());

               return /*(IAllGiftInfoValue[]) allGiftInfoValueList.toArray()*/result;
          }catch(Exception e){
                  throw e;
          }finally{
              if(rs!=null){
                  rs.close();
              }

              if(preparedStatement!=null) {
                  preparedStatement.close();
              }
              if (conn != null){
                  conn.close();
              }

          }
     }
     
     
     /**
      *  islbtsl 兑换量
      *                      按礼品小类别维度排序
      * @param bigKindName
      * @return
      * @throws Exception
      */
      public IAllGiftInfoValue[]  queryAllGiftInfoBySortAllWaFee(String bigKindName,String startTime,String endTime) throws Exception {


             String sql = " select WARE_CODE,WARE_NAME,PARTNER_CODE,PARTNER_NAME,BIG_KIND_NAME,MID_KIND_NAME,SML_KIND_NAME,BAL_FEE,MART_FEE,FEE_DC,WAMOUNT,ALLWA_FEE,AVG_ALL_CT,AVG_BIG_CT,AVG_MID_CT,AVG_SML_CT,AVG_DSC,TS_COUNT,TS_RATE , " +

                  " IS_DCDHL  ," +//--是否档次兑换量原因下线(IS_DCDHL)
                  " IS_LBDHL  ," +  //--是否类别兑换量原因下线(IS_LBDHL)
                  " IS_LBDHJE ," + //--是否类别兑换金额原因下线(IS_LBDHJE)
                  " IS_DCTSL  ," + //- -是否档次投诉率原因下线(IS_DCTSL)
                  " IS_LBTSL  " + //--是否类别投诉率原因下线(IS_LBTSL)                                                  // 按照兑换量进行降序排序操作
               " from allgift_info t  where t.big_kind_name = ?  and  start_time= ? and end_time = ?   order by t.big_kind_name,t.mid_kind_name,t.sml_kind_name ,t.ALLWA_FEE  desc ";

           Connection conn = null;
           ResultSet rs = null;
           PreparedStatement preparedStatement = null;
           IAllGiftInfoValue value = null;

           List allGiftInfoValueList = new ArrayList();

           try {
                   // 取得数据库连接
               conn = ServiceManager.getSession().getConnection();
               preparedStatement =   conn.prepareStatement(sql);
               preparedStatement.setString(1,bigKindName);
               preparedStatement.setString(2,startTime);
               preparedStatement.setString(3,endTime);
               //执行sql获取对应的信息
               rs = preparedStatement.executeQuery();
               while (rs.next()) {


                   value = new AllGiftInfoBean();

                   String wareCode = rs.getString("WARE_CODE");//取得礼品编码
                   value.setWareCode(wareCode);

                   String wareName = rs.getString("WARE_NAME");//礼品名称
                   value.setWareName(wareName);

                   String partnerCode = rs.getString("PARTNER_CODE");//合作商编码
                   value.setPartnerCode(partnerCode);

                   String partnerName  = rs.getString("PARTNER_NAME");//合作商名称
                   value.setPartnerName(partnerName);

                   String _bigKindName = rs.getString("BIG_KIND_NAME");//大类名称
                   value.setBigKindName(_bigKindName);

                   String mdKindName = rs.getString("MID_KIND_NAME");//中类名称
                   value.setMidKindName(mdKindName);

                   String smlKindName = rs.getString("SML_KIND_NAME");//小类名称
                   value.setSmlKindName(smlKindName);

                   // 解决类型显示错误
                   String balFee = rs.getString("BAL_FEE");
                   value.setBalFee(new Double(balFee));

                   String martFee = rs.getString("MART_FEE");
                   value.setMartFee(new Double(martFee));

                   String FEE_DC = rs.getString("FEE_DC");
                   value.setFeeDc(FEE_DC);

                   String WAMOUNT = rs.getString("WAMOUNT");
                   value.setWamount(new Integer(WAMOUNT));

                   String  ALLWA_FEE = rs.getString("ALLWA_FEE");
                   value.setAllwaFee(new Integer(ALLWA_FEE));

                   String AVG_ALL_CT = rs.getString("AVG_ALL_CT");
                   value.setAvgDsc(AVG_ALL_CT);

                   String AVG_BIG_CT = rs.getString("AVG_BIG_CT");
                   value.setAvgBigCt(new Integer(AVG_BIG_CT));


                   String AVG_MID_CT = rs.getString("AVG_MID_CT");
                   value.setAvgMidCt(new Integer(AVG_MID_CT));

                   String AVG_SML_CT = rs.getString("AVG_SML_CT");
                   value.setAvgSmlCt(new Integer(AVG_SML_CT));

                   String AVG_DSC = rs.getString("AVG_DSC");
                   value.setAvgDsc(AVG_DSC);

                   String TS_COUNT = rs.getString("TS_COUNT");
                   value.setTsCount(new Integer(TS_COUNT));

                   // 增加投诉率字段
                   String rs_rate = rs.getString("TS_RATE") ;
                   value.setTsRate(new Double(rs_rate));

     //          " IS_DCDHL  ," +//--是否档次兑换量原因下线(IS_DCDHL)
     //              " IS_LBDHL  ," +  //--是否类别兑换量原因下线(IS_LBDHL)
     //         " IS_LBDHJE ," + //--是否类别兑换金额原因下线(IS_LBDHJE)
     //         " IS_DCTSL  ," + //- -是否档次投诉率原因下线(IS_DCTSL)
     //         " IS_LBTSL  " + //--是否类别投诉率原因下线(IS_LBTSL)

                    String isDcdhl = rs.getString("IS_DCDHL");
                    value.setIsDcdhl(isDcdhl);

                    String IS_LBDHL = rs.getString("IS_LBDHL");
                    value.setIsLbdhl(IS_LBDHL);

                    String   IS_LBDHJE = rs.getString("IS_LBDHJE");
                    value.setIsLbdhje(IS_LBDHJE);

                    String IS_DCTSL = rs.getString("IS_DCTSL");
                    value.setIsDctsl(IS_DCTSL);

                    String IS_LBTSL = rs.getString("IS_LBTSL") ;
                    value.setIsLbtsl(IS_LBTSL);


                   allGiftInfoValueList.add(value);

               }

                AllGiftInfoBean[] result = new AllGiftInfoBean[allGiftInfoValueList.size()];
                System.arraycopy(allGiftInfoValueList.toArray(),0,result,0,allGiftInfoValueList.size());

                return /*(IAllGiftInfoValue[]) allGiftInfoValueList.toArray()*/result;
           }catch(Exception e){
                   throw e;
           }finally{
               if(rs!=null){
                   rs.close();
               }

               if(preparedStatement!=null) {
                   preparedStatement.close();
               }
               if (conn != null){
                   conn.close();
               }

           }
      }


      public IAllGiftInfoValue[]  queryAllGiftInfoRsRate(String bigKindName,String startTime,String endTime) throws Exception {


            String sql = " select WARE_CODE,WARE_NAME,PARTNER_CODE,PARTNER_NAME,BIG_KIND_NAME,MID_KIND_NAME,SML_KIND_NAME,BAL_FEE,MART_FEE,FEE_DC,WAMOUNT,ALLWA_FEE,AVG_ALL_CT,AVG_BIG_CT,AVG_MID_CT,AVG_SML_CT,AVG_DSC,TS_COUNT,TS_RATE , " +

                 " IS_DCDHL  ," +//--是否档次兑换量原因下线(IS_DCDHL)
                 " IS_LBDHL  ," +  //--是否类别兑换量原因下线(IS_LBDHL)
                 " IS_LBDHJE ," + //--是否类别兑换金额原因下线(IS_LBDHJE)
                 " IS_DCTSL  ," + //- -是否档次投诉率原因下线(IS_DCTSL)
                 " IS_LBTSL  " + //--是否类别投诉率原因下线(IS_LBTSL)                                                  // 按照兑换量进行降序排序操作-大类，中类，小类排序后，直接按照投诉率进行升序排序
              " from allgift_info t  where t.big_kind_name = ?  and  start_time= ? and end_time = ?   order by  t.BIG_KIND_NAME, t.MID_KIND_NAME ,t.sml_kind_name, t.TS_RATE";

          Connection conn = null;
          ResultSet rs = null;
          PreparedStatement preparedStatement = null;
          IAllGiftInfoValue value = null;

          List allGiftInfoValueList = new ArrayList();

          try {
                  // 取得数据库连接
              conn = ServiceManager.getSession().getConnection();
              preparedStatement =   conn.prepareStatement(sql);
              preparedStatement.setString(1,bigKindName);
              preparedStatement.setString(2,startTime);
              preparedStatement.setString(3,endTime);
              //执行sql获取对应的信息
              rs = preparedStatement.executeQuery();
              while (rs.next()) {


                  value = new AllGiftInfoBean();

                  String wareCode = rs.getString("WARE_CODE");//取得礼品编码
                  value.setWareCode(wareCode);

                  String wareName = rs.getString("WARE_NAME");//礼品名称
                  value.setWareName(wareName);

                  String partnerCode = rs.getString("PARTNER_CODE");//合作商编码
                  value.setPartnerCode(partnerCode);

                  String partnerName  = rs.getString("PARTNER_NAME");//合作商名称
                  value.setPartnerName(partnerName);

                  String _bigKindName = rs.getString("BIG_KIND_NAME");//大类名称
                  value.setBigKindName(_bigKindName);

                  String mdKindName = rs.getString("MID_KIND_NAME");//中类名称
                  value.setMidKindName(mdKindName);

                  String smlKindName = rs.getString("SML_KIND_NAME");//小类名称
                  value.setSmlKindName(smlKindName);

                  // 解决类型显示错误
                  String balFee = rs.getString("BAL_FEE");
                  value.setBalFee(new Double(balFee));

                  String martFee = rs.getString("MART_FEE");
                  value.setMartFee(new Double(martFee));

                  String FEE_DC = rs.getString("FEE_DC");
                  value.setFeeDc(FEE_DC);

                  String WAMOUNT = rs.getString("WAMOUNT");
                  value.setWamount(new Integer(WAMOUNT));

                  String  ALLWA_FEE = rs.getString("ALLWA_FEE");
                  value.setAllwaFee(new Integer(ALLWA_FEE));

                  String AVG_ALL_CT = rs.getString("AVG_ALL_CT");
                  value.setAvgDsc(AVG_ALL_CT);

                  String AVG_BIG_CT = rs.getString("AVG_BIG_CT");
                  value.setAvgBigCt(new Integer(AVG_BIG_CT));


                  String AVG_MID_CT = rs.getString("AVG_MID_CT");
                  value.setAvgMidCt(new Integer(AVG_MID_CT));

                  String AVG_SML_CT = rs.getString("AVG_SML_CT");
                  value.setAvgSmlCt(new Integer(AVG_SML_CT));

                  String AVG_DSC = rs.getString("AVG_DSC");
                  value.setAvgDsc(AVG_DSC);

                  String TS_COUNT = rs.getString("TS_COUNT");
                  value.setTsCount(new Integer(TS_COUNT));

                  // 增加投诉率字段
                  String rs_rate = rs.getString("TS_RATE") ;
                  value.setTsRate(new Double(rs_rate));

    //          " IS_DCDHL  ," +//--是否档次兑换量原因下线(IS_DCDHL)
    //              " IS_LBDHL  ," +  //--是否类别兑换量原因下线(IS_LBDHL)
    //         " IS_LBDHJE ," + //--是否类别兑换金额原因下线(IS_LBDHJE)
    //         " IS_DCTSL  ," + //- -是否档次投诉率原因下线(IS_DCTSL)
    //         " IS_LBTSL  " + //--是否类别投诉率原因下线(IS_LBTSL)

                   String isDcdhl = rs.getString("IS_DCDHL");
                   value.setIsDcdhl(isDcdhl);

                   String IS_LBDHL = rs.getString("IS_LBDHL");
                   value.setIsLbdhl(IS_LBDHL);

                   String   IS_LBDHJE = rs.getString("IS_LBDHJE");
                   value.setIsLbdhje(IS_LBDHJE);

                   String IS_DCTSL = rs.getString("IS_DCTSL");
                   value.setIsDctsl(IS_DCTSL);

                   String IS_LBTSL = rs.getString("IS_LBTSL") ;
                   value.setIsLbtsl(IS_LBTSL);


                  allGiftInfoValueList.add(value);

              }

               AllGiftInfoBean[] result = new AllGiftInfoBean[allGiftInfoValueList.size()];
               System.arraycopy(allGiftInfoValueList.toArray(),0,result,0,allGiftInfoValueList.size());

               return /*(IAllGiftInfoValue[]) allGiftInfoValueList.toArray()*/result;
          }catch(Exception e){
                  throw e;
          }finally{
              if(rs!=null){
                  rs.close();
              }

              if(preparedStatement!=null) {
                  preparedStatement.close();
              }
              if (conn != null){
                  conn.close();
              }

          }
     }
     /**
      * 根据小类名称 查询小类对应记录集合
      * @param
      * @return
      * @throws Exception
      */
     public IAllGiftInfoValue[] queryAllGiftInfoBySmlKindName(String smlKindName,String startTime,String endTime) throws Exception{
    	 String sql = " select WARE_CODE,WARE_NAME,PARTNER_CODE,PARTNER_NAME,BIG_KIND_NAME,MID_KIND_NAME,SML_KIND_NAME,BAL_FEE,MART_FEE,FEE_DC,WAMOUNT,ALLWA_FEE,AVG_ALL_CT,AVG_BIG_CT,AVG_MID_CT,AVG_SML_CT,AVG_DSC,TS_COUNT,TS_RATE , " +

         " IS_DCDHL  ," +//--是否档次兑换量原因下线(IS_DCDHL)
         " IS_LBDHL  ," +  //--是否类别兑换量原因下线(IS_LBDHL)
         " IS_LBDHJE ," + //--是否类别兑换金额原因下线(IS_LBDHJE)
         " IS_DCTSL  ," + //- -是否档次投诉率原因下线(IS_DCTSL)
         " IS_LBTSL  " + //--是否类别投诉率原因下线(IS_LBTSL)                                                  // 按照兑换量进行降序排序操作
      " from allgift_info t  where t.SML_KIND_NAME = ?  and  start_time= ? and end_time = ? order by  t.mid_kind_name ,t.sml_kind_name , t.allwa_fee desc";

  Connection conn = null;
  ResultSet rs = null;
  PreparedStatement preparedStatement = null;
  IAllGiftInfoValue value = null;

  List allGiftInfoValueList = new ArrayList();

  try {
          // 取得数据库连接
      conn = ServiceManager.getSession().getConnection();
      preparedStatement =   conn.prepareStatement(sql);
      preparedStatement.setString(1,smlKindName);
      preparedStatement.setString(2,startTime);
      preparedStatement.setString(3,endTime);
      //执行sql获取对应的信息
      rs = preparedStatement.executeQuery();
      while (rs.next()) {


          value = new AllGiftInfoBean();

          String wareCode = rs.getString("WARE_CODE");//取得礼品编码
          value.setWareCode(wareCode);

          String wareName = rs.getString("WARE_NAME");//礼品名称
          value.setWareName(wareName);

          String partnerCode = rs.getString("PARTNER_CODE");//合作商编码
          value.setPartnerCode(partnerCode);

          String partnerName  = rs.getString("PARTNER_NAME");//合作商名称
          value.setPartnerName(partnerName);

          String _bigKindName = rs.getString("BIG_KIND_NAME");//大类名称
          value.setBigKindName(_bigKindName);

          String mdKindName = rs.getString("MID_KIND_NAME");//中类名称
          value.setMidKindName(mdKindName);

          //String smlKindName = rs.getString("SML_KIND_NAME");//小类名称
          value.setSmlKindName(smlKindName);

          // 解决类型显示错误
          String balFee = rs.getString("BAL_FEE");
          value.setBalFee(new Double(balFee));

          String martFee = rs.getString("MART_FEE");
          value.setMartFee(new Double(martFee));

          String FEE_DC = rs.getString("FEE_DC");
          value.setFeeDc(FEE_DC);

          String WAMOUNT = rs.getString("WAMOUNT");
          value.setWamount(new Integer(WAMOUNT));

          String  ALLWA_FEE = rs.getString("ALLWA_FEE");
          value.setAllwaFee(new Integer(ALLWA_FEE));

          String AVG_ALL_CT = rs.getString("AVG_ALL_CT");
          value.setAvgDsc(AVG_ALL_CT);

          String AVG_BIG_CT = rs.getString("AVG_BIG_CT");
          value.setAvgBigCt(new Integer(AVG_BIG_CT));


          String AVG_MID_CT = rs.getString("AVG_MID_CT");
          value.setAvgMidCt(new Integer(AVG_MID_CT));

          String AVG_SML_CT = rs.getString("AVG_SML_CT");
          value.setAvgSmlCt(new Integer(AVG_SML_CT));

          String AVG_DSC = rs.getString("AVG_DSC");
          value.setAvgDsc(AVG_DSC);

          String TS_COUNT = rs.getString("TS_COUNT");
          value.setTsCount(new Integer(TS_COUNT));

          // 增加投诉率字段
          String rs_rate = rs.getString("TS_RATE") ;
          value.setTsRate(new Double(rs_rate));

//          " IS_DCDHL  ," +//--是否档次兑换量原因下线(IS_DCDHL)
//              " IS_LBDHL  ," +  //--是否类别兑换量原因下线(IS_LBDHL)
//         " IS_LBDHJE ," + //--是否类别兑换金额原因下线(IS_LBDHJE)
//         " IS_DCTSL  ," + //- -是否档次投诉率原因下线(IS_DCTSL)
//         " IS_LBTSL  " + //--是否类别投诉率原因下线(IS_LBTSL)

           String isDcdhl = rs.getString("IS_DCDHL");
           value.setIsDcdhl(isDcdhl);

           String IS_LBDHL = rs.getString("IS_LBDHL");
           value.setIsLbdhl(IS_LBDHL);

           String   IS_LBDHJE = rs.getString("IS_LBDHJE");
           value.setIsLbdhje(IS_LBDHJE);

           String IS_DCTSL = rs.getString("IS_DCTSL");
           value.setIsDctsl(IS_DCTSL);

           String IS_LBTSL = rs.getString("IS_LBTSL") ;
           value.setIsLbtsl(IS_LBTSL);


          allGiftInfoValueList.add(value);

      }

       AllGiftInfoBean[] result = new AllGiftInfoBean[allGiftInfoValueList.size()];
       System.arraycopy(allGiftInfoValueList.toArray(),0,result,0,allGiftInfoValueList.size());

       return /*(IAllGiftInfoValue[]) allGiftInfoValueList.toArray()*/result;
  }catch(Exception e){
          throw e;
  }finally{
      if(rs!=null){
          rs.close();
      }

      if(preparedStatement!=null) {
          preparedStatement.close();
      }
      if (conn != null){
          conn.close();
      }

  }
     }


     /**
      * 通过大类获得该大类下的所有小类
      * @param bigKindName
      * @param startTime
      * @param endTime
      * @return
      * @throws Exception
      */
     public IAllGiftInfoValue[] queryAllGiftInfoByBigKindName(String bigKindName,String startTime,String endTime) throws Exception{
    	 String sql = " select WARE_CODE,WARE_NAME,PARTNER_CODE,PARTNER_NAME,BIG_KIND_NAME,MID_KIND_NAME,SML_KIND_NAME,BAL_FEE,MART_FEE,FEE_DC,WAMOUNT,ALLWA_FEE,AVG_ALL_CT,AVG_BIG_CT,AVG_MID_CT,AVG_SML_CT,AVG_DSC,TS_COUNT,TS_RATE , " +

         " IS_DCDHL  ," +//--是否档次兑换量原因下线(IS_DCDHL)
         " IS_LBDHL  ," +  //--是否类别兑换量原因下线(IS_LBDHL)
         " IS_LBDHJE ," + //--是否类别兑换金额原因下线(IS_LBDHJE)
         " IS_DCTSL  ," + //- -是否档次投诉率原因下线(IS_DCTSL)
         " IS_LBTSL  " + //--是否类别投诉率原因下线(IS_LBTSL)                                                  // 按照兑换量进行降序排序操作
      " from allgift_info t  where t.BIG_KIND_NAME = ?  and  start_time= ? and end_time = ?  order by  t.TS_RATE ,t.sml_kind_name";

  Connection conn = null;
  ResultSet rs = null;
  PreparedStatement preparedStatement = null;
  IAllGiftInfoValue value = null;

  List allGiftInfoValueList = new ArrayList();

  try {
          // 取得数据库连接
      conn = ServiceManager.getSession().getConnection();
      preparedStatement =   conn.prepareStatement(sql);
      preparedStatement.setString(1,bigKindName);
      preparedStatement.setString(2,startTime);
      preparedStatement.setString(3,endTime);
      //执行sql获取对应的信息
      rs = preparedStatement.executeQuery();
      while (rs.next()) {


          value = new AllGiftInfoBean();

          String wareCode = rs.getString("WARE_CODE");//取得礼品编码
          value.setWareCode(wareCode);

          String wareName = rs.getString("WARE_NAME");//礼品名称
          value.setWareName(wareName);

          String partnerCode = rs.getString("PARTNER_CODE");//合作商编码
          value.setPartnerCode(partnerCode);

          String partnerName  = rs.getString("PARTNER_NAME");//合作商名称
          value.setPartnerName(partnerName);

          //String _bigKindName = rs.getString("BIG_KIND_NAME");//大类名称
          value.setBigKindName(bigKindName);

          String mdKindName = rs.getString("MID_KIND_NAME");//中类名称
          value.setMidKindName(mdKindName);

          String smlKindName = rs.getString("SML_KIND_NAME");//小类名称
          value.setSmlKindName(smlKindName);

          // 解决类型显示错误
          String balFee = rs.getString("BAL_FEE");
          value.setBalFee(new Double(balFee));

          String martFee = rs.getString("MART_FEE");
          value.setMartFee(new Double(martFee));

          String FEE_DC = rs.getString("FEE_DC");
          value.setFeeDc(FEE_DC);

          String WAMOUNT = rs.getString("WAMOUNT");
          value.setWamount(new Integer(WAMOUNT));

          String  ALLWA_FEE = rs.getString("ALLWA_FEE");
          value.setAllwaFee(new Integer(ALLWA_FEE));

          String AVG_ALL_CT = rs.getString("AVG_ALL_CT");
          value.setAvgDsc(AVG_ALL_CT);

          String AVG_BIG_CT = rs.getString("AVG_BIG_CT");
          value.setAvgBigCt(new Integer(AVG_BIG_CT));


          String AVG_MID_CT = rs.getString("AVG_MID_CT");
          value.setAvgMidCt(new Integer(AVG_MID_CT));

          String AVG_SML_CT = rs.getString("AVG_SML_CT");
          value.setAvgSmlCt(new Integer(AVG_SML_CT));

          String AVG_DSC = rs.getString("AVG_DSC");
          value.setAvgDsc(AVG_DSC);

          String TS_COUNT = rs.getString("TS_COUNT");
          value.setTsCount(new Integer(TS_COUNT));

          // 增加投诉率字段
          String rs_rate = rs.getString("TS_RATE") ;
          value.setTsRate(new Double(rs_rate));

//          " IS_DCDHL  ," +//--是否档次兑换量原因下线(IS_DCDHL)
//              " IS_LBDHL  ," +  //--是否类别兑换量原因下线(IS_LBDHL)
//         " IS_LBDHJE ," + //--是否类别兑换金额原因下线(IS_LBDHJE)
//         " IS_DCTSL  ," + //- -是否档次投诉率原因下线(IS_DCTSL)
//         " IS_LBTSL  " + //--是否类别投诉率原因下线(IS_LBTSL)

           String isDcdhl = rs.getString("IS_DCDHL");
           value.setIsDcdhl(isDcdhl);

           String IS_LBDHL = rs.getString("IS_LBDHL");
           value.setIsLbdhl(IS_LBDHL);

           String   IS_LBDHJE = rs.getString("IS_LBDHJE");
           value.setIsLbdhje(IS_LBDHJE);

           String IS_DCTSL = rs.getString("IS_DCTSL");
           value.setIsDctsl(IS_DCTSL);

           String IS_LBTSL = rs.getString("IS_LBTSL") ;
           value.setIsLbtsl(IS_LBTSL);


          allGiftInfoValueList.add(value);

      }

       AllGiftInfoBean[] result = new AllGiftInfoBean[allGiftInfoValueList.size()];
       System.arraycopy(allGiftInfoValueList.toArray(),0,result,0,allGiftInfoValueList.size());

       return /*(IAllGiftInfoValue[]) allGiftInfoValueList.toArray()*/result;
  }catch(Exception e){
          throw e;
  }finally{
      if(rs!=null){
          rs.close();
      }

      if(preparedStatement!=null) {
          preparedStatement.close();
      }
      if (conn != null){
          conn.close();
      }

  }
     }
     
     
    /**
     * 投诉率过高-结算价格
     * @param feeDC
     * @return
     * @throws Exception
     */
     public IAllGiftInfoValue[]  queryAllGiftInfoByFeeDC(String feeDC,String startTime,String endTime) throws Exception {


         String sql = " select WARE_CODE,WARE_NAME,PARTNER_CODE,PARTNER_NAME,BIG_KIND_NAME,MID_KIND_NAME,SML_KIND_NAME,BAL_FEE,MART_FEE,FEE_DC,WAMOUNT,ALLWA_FEE,AVG_ALL_CT,AVG_BIG_CT,AVG_MID_CT,AVG_SML_CT,AVG_DSC,TS_COUNT ,TS_RATE ," +
         " IS_DCDHL  ," +//--是否档次兑换量原因下线(IS_DCDHL)
         " IS_LBDHL  ," +  //--是否类别兑换量原因下线(IS_LBDHL)
         " IS_LBDHJE ," + //--是否类别兑换金额原因下线(IS_LBDHJE)
         " IS_DCTSL  ," + //- -是否档次投诉率原因下线(IS_DCTSL)
         " IS_LBTSL  " + //--是否类别投诉率原因下线(IS_LBTSL)
                 // modified by shenfl  按照投诉率过高进行升序排序   at  2011-07-11
          " from allgift_info t  where t.FEE_DC = ?   and  start_time = ? and end_time = ?   order by t.FEE_DC ,t.TS_RATE ";

       Connection conn = null;
       ResultSet rs = null;
       PreparedStatement preparedStatement = null;
       IAllGiftInfoValue value = null;

       List allGiftInfoValueList = new ArrayList();

       try {
               // 取得数据库连接
           conn = ServiceManager.getSession().getConnection();
           preparedStatement =   conn.prepareStatement(sql);
           preparedStatement.setString(1,feeDC);
           preparedStatement.setString(2,startTime);
           preparedStatement.setString(3,endTime);

           //执行sql获取对应的信息
           rs = preparedStatement.executeQuery();
           while (rs.next()) {


               value = new AllGiftInfoBean();

               String wareCode = rs.getString("WARE_CODE");//取得礼品编码
               value.setWareCode(wareCode);

               String wareName = rs.getString("WARE_NAME");//礼品名称
               value.setWareName(wareName);

               String partnerCode = rs.getString("PARTNER_CODE");//合作商编码
               value.setPartnerCode(partnerCode);

               String partnerName  = rs.getString("PARTNER_NAME");//合作商名称
               value.setPartnerName(partnerName);

               String _bigKindName = rs.getString("BIG_KIND_NAME");//大类名称
               value.setBigKindName(_bigKindName);

               String mdKindName = rs.getString("MID_KIND_NAME");//中类名称
               value.setMidKindName(mdKindName);

               String smlKindName = rs.getString("SML_KIND_NAME");//小类名称
               value.setSmlKindName(smlKindName);


                  // 解决类型显示错误
                  String balFee = rs.getString("BAL_FEE");
                  value.setBalFee(new Double(balFee));

                  String martFee = rs.getString("MART_FEE");
                  value.setMartFee(new Double(martFee));

               String FEE_DC = rs.getString("FEE_DC");
               value.setFeeDc(FEE_DC);

               String WAMOUNT = rs.getString("WAMOUNT");
               value.setWamount(new Integer(WAMOUNT));

               String  ALLWA_FEE = rs.getString("ALLWA_FEE");
               value.setAllwaFee(new Integer(ALLWA_FEE));

               String AVG_ALL_CT = rs.getString("AVG_ALL_CT");
               value.setAvgDsc(AVG_ALL_CT);

               String AVG_BIG_CT = rs.getString("AVG_BIG_CT");
               value.setAvgBigCt(new Integer(AVG_BIG_CT));


               String AVG_MID_CT = rs.getString("AVG_MID_CT");
               value.setAvgMidCt(new Integer(AVG_MID_CT));

               String AVG_SML_CT = rs.getString("AVG_SML_CT");
               value.setAvgSmlCt(new Integer(AVG_SML_CT));

               String AVG_DSC = rs.getString("AVG_DSC");
               value.setAvgDsc(AVG_DSC);

               String TS_COUNT = rs.getString("TS_COUNT");
               value.setTsCount(new Integer(TS_COUNT));

               // 投诉率修改
               String TS_RATE = rs.getString("TS_RATE");
               value.setTsRate(new Double(TS_RATE));

               String isDcdhl = rs.getString("IS_DCDHL");
               value.setIsDcdhl(isDcdhl);

               String IS_LBDHL = rs.getString("IS_LBDHL");
               value.setIsLbdhl(IS_LBDHL);

               String   IS_LBDHJE = rs.getString("IS_LBDHJE");
               value.setIsLbdhje(IS_LBDHJE);

               String IS_DCTSL = rs.getString("IS_DCTSL");
               value.setIsDctsl(IS_DCTSL);

               String IS_LBTSL = rs.getString("IS_LBTSL") ;
               value.setIsLbtsl(IS_LBTSL);


               allGiftInfoValueList.add(value);

           }

            AllGiftInfoBean[] result = new AllGiftInfoBean[allGiftInfoValueList.size()];
            System.arraycopy(allGiftInfoValueList.toArray(),0,result,0,allGiftInfoValueList.size());

            return /*(IAllGiftInfoValue[]) allGiftInfoValueList.toArray()*/result;
       }catch(Exception e){
               throw e;
       }finally{
           if(rs!=null){
               rs.close();
           }

           if(preparedStatement!=null) {
               preparedStatement.close();
           }
           if (conn != null){
               conn.close();
           }

       }
  }


    /**
     * 兑换量过低 sheet0-兑换量降序排序
     * @param feeDC
     * @return
     * @throws Exception
     */
     public IAllGiftInfoValue[]  queryAllGiftInfoByFeeDCWAMount(String feeDC,String startTime ,String endTime) throws Exception {


         String sql = " select WARE_CODE,WARE_NAME,PARTNER_CODE,PARTNER_NAME,BIG_KIND_NAME,MID_KIND_NAME,SML_KIND_NAME,BAL_FEE,MART_FEE,FEE_DC,WAMOUNT,ALLWA_FEE,AVG_ALL_CT,AVG_BIG_CT,AVG_MID_CT,AVG_SML_CT,AVG_DSC,TS_COUNT ,TS_RATE ," +
         " IS_DCDHL  ," +//--是否档次兑换量原因下线(IS_DCDHL)
         " IS_LBDHL  ," +  //--是否类别兑换量原因下线(IS_LBDHL)
         " IS_LBDHJE ," + //--是否类别兑换金额原因下线(IS_LBDHJE)
         " IS_DCTSL  ," + //- -是否档次投诉率原因下线(IS_DCTSL)
         " IS_LBTSL  " + //--是否类别投诉率原因下线(IS_LBTSL)
                 // modified by shenfl  按照投诉率过高进行升序排序   at  2011-07-11
          " from allgift_info t  where t.FEE_DC = ?  and  start_time = ? and end_time = ?  order by t.FEE_DC  asc ,t.WAMOUNT desc ";

       Connection conn = null;
       ResultSet rs = null;
       PreparedStatement preparedStatement = null;
       IAllGiftInfoValue value = null;

       List allGiftInfoValueList = new ArrayList();

       try {
               // 取得数据库连接
           conn = ServiceManager.getSession().getConnection();
           preparedStatement =   conn.prepareStatement(sql);
           preparedStatement.setString(1,feeDC);
           // 添加时间操作 shenfl at 2011-07-11
           preparedStatement.setString(2,startTime);
           preparedStatement.setString(3,endTime);
           //执行sql获取对应的信息
           rs = preparedStatement.executeQuery();
           while (rs.next()) {


               value = new AllGiftInfoBean();

               String wareCode = rs.getString("WARE_CODE");//取得礼品编码
               value.setWareCode(wareCode);

               String wareName = rs.getString("WARE_NAME");//礼品名称
               value.setWareName(wareName);

               String partnerCode = rs.getString("PARTNER_CODE");//合作商编码
               value.setPartnerCode(partnerCode);

               String partnerName  = rs.getString("PARTNER_NAME");//合作商名称
               value.setPartnerName(partnerName);

               String _bigKindName = rs.getString("BIG_KIND_NAME");//大类名称
               value.setBigKindName(_bigKindName);

               String mdKindName = rs.getString("MID_KIND_NAME");//中类名称
               value.setMidKindName(mdKindName);

               String smlKindName = rs.getString("SML_KIND_NAME");//小类名称
               value.setSmlKindName(smlKindName);


                  // 解决类型显示错误
                  String balFee = rs.getString("BAL_FEE");
                  value.setBalFee(new Double(balFee));

                  String martFee = rs.getString("MART_FEE");
                  value.setMartFee(new Double(martFee));

               String FEE_DC = rs.getString("FEE_DC");
               value.setFeeDc(FEE_DC);

               String WAMOUNT = rs.getString("WAMOUNT");
               value.setWamount(new Integer(WAMOUNT));

               String  ALLWA_FEE = rs.getString("ALLWA_FEE");
               value.setAllwaFee(new Integer(ALLWA_FEE));

               String AVG_ALL_CT = rs.getString("AVG_ALL_CT");
               value.setAvgDsc(AVG_ALL_CT);

               String AVG_BIG_CT = rs.getString("AVG_BIG_CT");
               value.setAvgBigCt(new Integer(AVG_BIG_CT));


               String AVG_MID_CT = rs.getString("AVG_MID_CT");
               value.setAvgMidCt(new Integer(AVG_MID_CT));

               String AVG_SML_CT = rs.getString("AVG_SML_CT");
               value.setAvgSmlCt(new Integer(AVG_SML_CT));

               String AVG_DSC = rs.getString("AVG_DSC");
               value.setAvgDsc(AVG_DSC);

               String TS_COUNT = rs.getString("TS_COUNT");
               value.setTsCount(new Integer(TS_COUNT));

               // 投诉率修改
               String TS_RATE = rs.getString("TS_RATE");
               value.setTsRate(new Double(TS_RATE));

               String isDcdhl = rs.getString("IS_DCDHL");
               value.setIsDcdhl(isDcdhl);

               String IS_LBDHL = rs.getString("IS_LBDHL");
               value.setIsLbdhl(IS_LBDHL);

               String   IS_LBDHJE = rs.getString("IS_LBDHJE");
               value.setIsLbdhje(IS_LBDHJE);

               String IS_DCTSL = rs.getString("IS_DCTSL");
               value.setIsDctsl(IS_DCTSL);

               String IS_LBTSL = rs.getString("IS_LBTSL") ;
               value.setIsLbtsl(IS_LBTSL);


               allGiftInfoValueList.add(value);

           }

            AllGiftInfoBean[] result = new AllGiftInfoBean[allGiftInfoValueList.size()];
            System.arraycopy(allGiftInfoValueList.toArray(),0,result,0,allGiftInfoValueList.size());

            return /*(IAllGiftInfoValue[]) allGiftInfoValueList.toArray()*/result;
       }catch(Exception e){
               throw e;
       }finally{
           if(rs!=null){
               rs.close();
           }

           if(preparedStatement!=null) {
               preparedStatement.close();
           }
           if (conn != null){
               conn.close();
           }

       }
  }

     /**
      * 兑换量过高建议下线礼品 
      */
     public IAllGiftInfoValue[] queryAllProposalOfflineGift(String startTime,String endTime) throws Exception{

    	 String sql = " select ware_code, ware_name, partner_code, partner_name, big_kind_name, mid_kind_name, sml_kind_name" +
                 // wamount 兑换量 ，只有兑换量为0的情况下 标记出对应的蓝色还是绿色显示
         ", bal_fee, mart_fee, fee_dc, wamount, allwa_fee, avg_dsc, ts_count, ts_rate,AVG_ALL_CT,AVG_BIG_CT,AVG_SML_CT ,AVG_MID_CT " +
         ", is_dcdhl+is_lbdhl+is_lbdhje as ls_status " +
                 //TODO 数据库确认 2是否是申请申请永久下线的礼品
                 // 礼品当前的状态和下线的原因  status_cause 为2表示 申请永久下线
         ", ware_status, status_cause " +
                 // 兑换量降序进行处理
         ", row_number() over(partition by 1 order by wamount desc) seq from allgift_info" +
                 // ls_status表示建议下线的礼品
         " where  (is_dcdhl + is_lbdhl + is_lbdhje)='3' and start_time =? and end_time = ?";
    	
    	 
     Connection conn = null;
     ResultSet rs = null;
     PreparedStatement preparedStatement = null;
     IAllGiftInfoValue value = null;

     List allGiftInfoValueList = new ArrayList();

     try {
         // 取得数据库连接
         conn = ServiceManager.getSession().getConnection();
         preparedStatement =   conn.prepareStatement(sql);
         preparedStatement.setString(1, startTime);
         preparedStatement.setString(2, endTime);
         //执行sql获取对应的信息
         rs = preparedStatement.executeQuery();
         while (rs.next()) {


             value = new AllGiftInfoBean();

             String wareCode = rs.getString("WARE_CODE");//取得礼品编码
             value.setWareCode(wareCode);

             String wareName = rs.getString("WARE_NAME");//礼品名称
             value.setWareName(wareName);

             String partnerCode = rs.getString("PARTNER_CODE");//合作商编码
             value.setPartnerCode(partnerCode);

             String partnerName  = rs.getString("PARTNER_NAME");//合作商名称
             value.setPartnerName(partnerName);

             String _bigKindName = rs.getString("BIG_KIND_NAME");//大类名称
             value.setBigKindName(_bigKindName);

             String mdKindName = rs.getString("MID_KIND_NAME");//中类名称
             value.setMidKindName(mdKindName);

             String smlKindName = rs.getString("SML_KIND_NAME");//小类名称
             value.setSmlKindName(smlKindName);

                  // 解决类型显示错误
                  String balFee = rs.getString("BAL_FEE");
                  value.setBalFee(new Double(balFee));

                  String martFee = rs.getString("MART_FEE");
                  value.setMartFee(new Double(martFee));

             String FEE_DC = rs.getString("FEE_DC");
             value.setFeeDc(FEE_DC);

             String WAMOUNT = rs.getString("WAMOUNT");
             value.setWamount(new Integer(WAMOUNT));

             String  ALLWA_FEE = rs.getString("ALLWA_FEE");
             value.setAllwaFee(new Integer(ALLWA_FEE));

             String AVG_ALL_CT = rs.getString("AVG_ALL_CT");
             value.setAvgAllCt(new Long(AVG_ALL_CT));


             String AVG_BIG_CT = rs.getString("AVG_BIG_CT");
             value.setAvgBigCt(new Integer(AVG_BIG_CT));


             String AVG_MID_CT = rs.getString("AVG_MID_CT");
             value.setAvgMidCt(new Integer(AVG_MID_CT));

             String AVG_SML_CT = rs.getString("AVG_SML_CT");
             value.setAvgSmlCt(new Integer(AVG_SML_CT));

             String AVG_DSC = rs.getString("AVG_DSC");
             value.setAvgDsc(AVG_DSC);

             String TS_COUNT = rs.getString("TS_COUNT");
             value.setTsCount(new Integer(TS_COUNT));
             
           // 投诉率修改
           String TS_RATE = rs.getString("TS_RATE");
           value.setTsRate(new Double(TS_RATE));

             // 增加礼品下线的原因
             String status_cause = rs.getString("STATUS_CAUSE");
             value.setStatusCause(status_cause);
             
             // 增加礼品人工礼品下线
             String wareStatus = rs.getString("WARE_STATUS");
             value.setWareStatus(wareStatus);

             allGiftInfoValueList.add(value);

         }

          AllGiftInfoBean[] result = new AllGiftInfoBean[allGiftInfoValueList.size()];
          System.arraycopy(allGiftInfoValueList.toArray(),0,result,0,allGiftInfoValueList.size());

          return /*(IAllGiftInfoValue[]) allGiftInfoValueList.toArray()*/result;
     }catch(Exception e){
             throw e;
     }finally{
         if(rs!=null){
             rs.close();
         }

         if(preparedStatement!=null) {
             preparedStatement.close();
         }
         if (conn != null){
             conn.close();
         }

     }
     }
     
    
     /**
      * 投诉率过高建议下线礼品 
      * @return
      * @throws Exception
      *         是否档次投诉率原因下线(IS_DCTSL)、 是否类别投诉率原因下线(IS_LBTSL)
      *             shenfl 
      */
     public IAllGiftInfoValue[] queryAllProposalOfflineGiftByAllegeRate(String startTime,String endTime) throws Exception{

         String sql = " select ware_code, ware_name, partner_code, partner_name, big_kind_name, mid_kind_name, sml_kind_name" +
         ", bal_fee, mart_fee, fee_dc, wamount, allwa_fee, avg_dsc, ts_count, ts_rate,AVG_ALL_CT,AVG_BIG_CT,AVG_SML_CT ,AVG_MID_CT " +
         ", IS_DCTSL+IS_LBTSL as  ls_status " +
         ", ware_status, status_cause " +
         // 投诉率升序排序       
         ", row_number() over(partition by 1 order by ts_rate ) seq from allgift_info" +
                 // ls_status表示建议下线的礼品=2 标识
         " where  (IS_DCTSL+IS_LBTSL)='2' and start_time =? and end_time = ?";
        
         
     Connection conn = null;
     ResultSet rs = null;
     PreparedStatement preparedStatement = null;
     IAllGiftInfoValue value = null;

     List allGiftInfoValueList = new ArrayList();

     try {
         // 取得数据库连接
         conn = ServiceManager.getSession().getConnection();
         preparedStatement =   conn.prepareStatement(sql);
         preparedStatement.setString(1, startTime);
         preparedStatement.setString(2, endTime);
         //执行sql获取对应的信息
         rs = preparedStatement.executeQuery();
         while (rs.next()) {


             value = new AllGiftInfoBean();

             String wareCode = rs.getString("WARE_CODE");//取得礼品编码
             value.setWareCode(wareCode);

             String wareName = rs.getString("WARE_NAME");//礼品名称
             value.setWareName(wareName);

             String partnerCode = rs.getString("PARTNER_CODE");//合作商编码
             value.setPartnerCode(partnerCode);

             String partnerName  = rs.getString("PARTNER_NAME");//合作商名称
             value.setPartnerName(partnerName);

             String _bigKindName = rs.getString("BIG_KIND_NAME");//大类名称
             value.setBigKindName(_bigKindName);

             String mdKindName = rs.getString("MID_KIND_NAME");//中类名称
             value.setMidKindName(mdKindName);

             String smlKindName = rs.getString("SML_KIND_NAME");//小类名称
             value.setSmlKindName(smlKindName);

                  // 解决类型显示错误
                  String balFee = rs.getString("BAL_FEE");
                  value.setBalFee(new Double(balFee));

                  String martFee = rs.getString("MART_FEE");
                  value.setMartFee(new Double(martFee));

             String FEE_DC = rs.getString("FEE_DC");
             value.setFeeDc(FEE_DC);

             String WAMOUNT = rs.getString("WAMOUNT");
             value.setWamount(new Integer(WAMOUNT));

             String  ALLWA_FEE = rs.getString("ALLWA_FEE");
             value.setAllwaFee(new Integer(ALLWA_FEE));

             String AVG_ALL_CT = rs.getString("AVG_ALL_CT");
             value.setAvgAllCt(new Long(AVG_ALL_CT));


             String AVG_BIG_CT = rs.getString("AVG_BIG_CT");
             value.setAvgBigCt(new Integer(AVG_BIG_CT));


             String AVG_MID_CT = rs.getString("AVG_MID_CT");
             value.setAvgMidCt(new Integer(AVG_MID_CT));

             String AVG_SML_CT = rs.getString("AVG_SML_CT");
             value.setAvgSmlCt(new Integer(AVG_SML_CT));

             String AVG_DSC = rs.getString("AVG_DSC");
             value.setAvgDsc(AVG_DSC);

             String TS_COUNT = rs.getString("TS_COUNT");
             value.setTsCount(new Integer(TS_COUNT));
             
           // 投诉率修改
           String TS_RATE = rs.getString("TS_RATE");
           value.setTsRate(new Double(TS_RATE));

             // 增加礼品下线的原因
             String status_cause = rs.getString("STATUS_CAUSE");
             value.setStatusCause(status_cause);
             
            
             allGiftInfoValueList.add(value);

         }

          AllGiftInfoBean[] result = new AllGiftInfoBean[allGiftInfoValueList.size()];
          System.arraycopy(allGiftInfoValueList.toArray(),0,result,0,allGiftInfoValueList.size());

          return /*(IAllGiftInfoValue[]) allGiftInfoValueList.toArray()*/result;
     }catch(Exception e){
             throw e;
     }finally{
         if(rs!=null){
             rs.close();
         }

         if(preparedStatement!=null) {
             preparedStatement.close();
         }
         if (conn != null){
             conn.close();
         }

     }
     }

}
