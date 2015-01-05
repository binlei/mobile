/**
 * Copyright©2014 www.jshuabo.com. all rights reserved.
 * 
 * @Title: DefaultMobileDataProcessServiceImpl.java
 * @Prject: mobile
 * @Package: com.jshuabo.mobile.server.service.mobile.impl
 * @author: lianghe.yuan
 * @date: May 4, 2014 1:40:13 PM
 * @version:
 * @Description:
 */
package com.jshuabo.mobile.server.service.mobile.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshuabo.frame.server.util.date.DateFormatUtils;
import com.jshuabo.mobile.server.dao.mobile.IMobileActivatedInfoMapper;
import com.jshuabo.mobile.server.dao.mobile.IMobileAppInstalledMapper;
import com.jshuabo.mobile.server.dao.mobile.IMobileAppModifyInfoMapper;
import com.jshuabo.mobile.server.dao.mobile.IMobileArrivalMapper;
import com.jshuabo.mobile.server.dao.mobile.IMobileBasicInfoMapper;
import com.jshuabo.mobile.server.dao.mobile.IMobileDataUsageMapper;
import com.jshuabo.mobile.server.dao.mobile.IMobileLocationMapper;
import com.jshuabo.mobile.server.service.mobile.IMobileDataProcessService;

/**
 * @ClassName: DefaultMobileDataProcessServiceImpl
 * @Description:
 * @author: lianghe.yuan
 * @date: May 4, 2014 1:40:13 PM
 */
@Service("mobileDataProcessService")
public class DefaultMobileDataProcessServiceImpl implements IMobileDataProcessService {
    Logger logger = LoggerFactory.getLogger(DefaultMobileDataProcessServiceImpl.class);

    private static final Long defaultProcessQtySingle = 1000L;
    private static final Long sleepms = 500L;

    @Autowired
    private IMobileArrivalMapper mobileArrivalMapper;
    @Autowired
    private IMobileBasicInfoMapper mobileBasicInfoMapper;
    @Autowired
    private IMobileAppInstalledMapper mobileAppInstalledMapper;
    @Autowired
    private IMobileAppModifyInfoMapper mobileAppModifyInfoMapper;
    @Autowired
    private IMobileActivatedInfoMapper mobileActivatedInfoMapper;
    @Autowired
    private IMobileLocationMapper mobileLocationMapper;
    @Autowired
    private IMobileDataUsageMapper mobileDataUsageMapper;

    @Override
    public void process() {
        Date[] dates = getRecordDates();
        Date beginTime = dates[0];
        Date endTime = dates[1];

        Long processCount = 0l;
        logger.info("begin to process mobile data...");
        Long t1 = System.currentTimeMillis();

        /** 手机到达数据整理 */
        processCount = processMobileArrival(beginTime, endTime);
        Long t11 = System.currentTimeMillis();
        logger.info("手机到达数据整理-记录数[{}], 耗时: [{}]毫秒", processCount, t11 - t1);

        /** 设备基础信息数据整理 */
        processCount = processMobileBasicInfo(beginTime, endTime);
        Long t12 = System.currentTimeMillis();
        logger.info("设备基础信息数据整理-记录数[{}], 耗时: [{}]毫秒", processCount, t12 - t11);

        /** 已安装app数据整理 */
        processCount = processMobileAppInstalled(beginTime, endTime);
        Long t13 = System.currentTimeMillis();
        logger.info("已安装app数据整理-记录数[{}], 耗时: [{}]毫秒", processCount, t13 - t12);

        /** app更新数据整理 */
        processCount = processMobileAppModify(beginTime, endTime);
        Long t14 = System.currentTimeMillis();
        logger.info("app更新数据整理-记录数[{}], 耗时: [{}]毫秒", processCount, t14 - t13);

        /** app激活数据整理 */
        processCount = processMobileActivated(beginTime, endTime);
        Long t15 = System.currentTimeMillis();
        logger.info("app激活数据整理-记录数[{}], 耗时: [{}]毫秒", processCount, t15 - t14);

        /** 位置信息数据整理 */
        processCount = processMobileLocation(beginTime, endTime);
        Long t16 = System.currentTimeMillis();
        logger.info("位置信息数据整理-记录数[{}], 耗时: [{}]毫秒", processCount, t16 - t15);

        /** 流量统计数据整理 */
        processCount = processMobileDataUsage(beginTime, endTime);

        Long t2 = System.currentTimeMillis();
        logger.info("流量统计数据整理-记录数[{}], 耗时: [{}]毫秒", processCount, t2 - t16);

        logger.info("总处理数据耗时: [{}]毫秒", t2 - t1);
        logger.info("end to process mobile data...");
    }

    @Override
    public void processAppUsage() {
        logger.info("begin to process appusage ...");

        Date[] dates = getRecordDates();
        Date beginTime = dates[0];
        Date endTime = dates[1];

        Long processCount = 0L;

        Long t1 = System.currentTimeMillis();
        processCount = processAppInstallUsage(beginTime, endTime);
        Long t11 = System.currentTimeMillis();
        logger.info("app使用情况-安装app-记录数[{}], 耗时: [{}]毫秒", processCount, t11 - t1);

        processCount = processAppModifyUsage(beginTime, endTime);

        Long t2 = System.currentTimeMillis();
        logger.info("app使用情况-更新app-记录数[{}], 耗时: [{}]毫秒", processCount, t2 - t11);

        logger.info("app usage 总处理数据耗时: [{}]毫秒", t2 - t1);
        logger.info("end to process appusage ...");
    }

    private Long processMobileArrival(Date beginTime, Date endTime) {
        Map<String, Long> ids = mobileArrivalMapper.getProcessRecordIds(beginTime, endTime);
        if (ids == null) return 0L;

        Long cnt = 1L;
        List<Long[]> idList = getMinMaxIdSingles(ids.get("minId"), ids.get("maxId"), 5);
        logger.info(
                "手机到达数据待整理-分批处理总记录数:[{}],开始时间:[{}], 结束时间:[{}]",
                new Object[] {idList.size(),
                        DateFormatUtils.format(beginTime, DateFormatUtils.ymd_hms),
                        DateFormatUtils.format(endTime, DateFormatUtils.ymd_hms)});

        int i = 0;
        for (Long[] id : idList) {
            logger.info("\t序号[{}]: 手机到达数据待整理-开始处理,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i++, cnt, id[0], id[1]});
            cnt += mobileArrivalMapper.processRecord(id[0], id[1]);
            logger.info("\t序号[{}]: 手机到达数据待整理-处理结束,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i, cnt, id[0], id[1]});
        }

        return cnt;
    }

    private Long processMobileBasicInfo(Date beginTime, Date endTime) {
        Map<String, Long> ids = mobileBasicInfoMapper.getProcessRecordIds(beginTime, endTime);
        if (ids == null) return 0L;

        Long cnt = 0L;
        List<Long[]> idList = getMinMaxIdSingles(ids.get("minId"), ids.get("maxId"), 5);
        logger.info(
                "设备基础信息数据待整理-分批处理总记录数:[{}],开始时间:[{}], 结束时间:[{}]",
                new Object[] {idList.size(),
                        DateFormatUtils.format(beginTime, DateFormatUtils.ymd_hms),
                        DateFormatUtils.format(endTime, DateFormatUtils.ymd_hms)});

        int i = 1;
        for (Long[] id : idList) {
            logger.info("\t序号[{}]: 设备基础信息数据待整理-开始处理,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i++, cnt, id[0], id[1]});
            cnt += mobileBasicInfoMapper.processRecord(id[0], id[1]);
            logger.info("\t序号[{}]: 设备基础信息数据待整理-处理结束,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i, cnt, id[0], id[1]});
        }
        return cnt;
    }

    private Long processMobileAppInstalled(Date beginTime, Date endTime) {
        Map<String, Long> ids = mobileAppInstalledMapper.getProcessRecordIds(beginTime, endTime);
        if (ids == null) return 0L;

        Long cnt = 0L;
        List<Long[]> idList = getMinMaxIdSingles(ids.get("minId"), ids.get("maxId"), 2);
        logger.info(
                "已安装app数据待整理-分批处理总记录数:[{}],开始时间:[{}], 结束时间:[{}]",
                new Object[] {idList.size(),
                        DateFormatUtils.format(beginTime, DateFormatUtils.ymd_hms),
                        DateFormatUtils.format(endTime, DateFormatUtils.ymd_hms)});

        int i = 1;
        for (Long[] id : idList) {
            logger.info("\t序号[{}]: 已安装app数据待整理-开始处理,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i++, cnt, id[0], id[1]});
            cnt += mobileAppInstalledMapper.processRecord(id[0], id[1]);
            logger.info("\t序号[{}]: 已安装app数据待整理-处理结束,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i, cnt, id[0], id[1]});

            try {
                Thread.sleep(sleepms);
            } catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
        return cnt;
    }

    private Long processMobileAppModify(Date beginTime, Date endTime) {
        Map<String, Long> ids = mobileAppModifyInfoMapper.getProcessRecordIds(beginTime, endTime);
        if (ids == null) return 0L;

        Long cnt = 0L;
        List<Long[]> idList = getMinMaxIdSingles(ids.get("minId"), ids.get("maxId"), 2);
        logger.info(
                "app更新数据待整理-分批处理总记录数:[{}],开始时间:[{}], 结束时间:[{}]",
                new Object[] {idList.size(),
                        DateFormatUtils.format(beginTime, DateFormatUtils.ymd_hms),
                        DateFormatUtils.format(endTime, DateFormatUtils.ymd_hms)});

        int i = 1;
        for (Long[] id : idList) {
            logger.info("\t序号[{}]: app更新数据待整理-开始处理,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i++, cnt, id[0], id[1]});
            cnt += mobileAppModifyInfoMapper.processRecord(id[0], id[1]);
            logger.info("\t序号[{}]: app更新数据待整理-处理结束,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i, cnt, id[0], id[1]});

            try {
                Thread.sleep(sleepms);
            } catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
        return cnt;
    }

    private Long processMobileActivated(Date beginTime, Date endTime) {
        Map<String, Long> ids = mobileActivatedInfoMapper.getProcessRecordIds(beginTime, endTime);
        if (ids == null) return 0L;

        Long cnt = 0L;
        List<Long[]> idList = getMinMaxIdSingles(ids.get("minId"), ids.get("maxId"), 2);
        logger.info(
                "app激活数据待整理-分批处理总记录数:[{}],开始时间:[{}], 结束时间:[{}]",
                new Object[] {idList.size(),
                        DateFormatUtils.format(beginTime, DateFormatUtils.ymd_hms),
                        DateFormatUtils.format(endTime, DateFormatUtils.ymd_hms)});

        int i = 1;
        for (Long[] id : idList) {
            logger.info("\t序号[{}]: app激活数据待整理-开始处理,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i++, cnt, id[0], id[1]});
            cnt += mobileActivatedInfoMapper.processRecord(id[0], id[1]);
            logger.info("\t序号[{}]: app激活数据待整理-处理结束,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i, cnt, id[0], id[1]});

            try {
                Thread.sleep(sleepms);
            } catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
        return cnt;
    }

    private Long processMobileLocation(Date beginTime, Date endTime) {
        Map<String, Long> ids = mobileLocationMapper.getProcessRecordIds(beginTime, endTime);
        if (ids == null) return 0L;

        Long cnt = 0L;
        List<Long[]> idList = getMinMaxIdSingles(ids.get("minId"), ids.get("maxId"), 2);
        logger.info(
                "位置信息数据待整理-分批处理总记录数:[{}],开始时间:[{}], 结束时间:[{}]",
                new Object[] {idList.size(),
                        DateFormatUtils.format(beginTime, DateFormatUtils.ymd_hms),
                        DateFormatUtils.format(endTime, DateFormatUtils.ymd_hms)});

        int i = 1;
        for (Long[] id : idList) {
            logger.info("\t序号[{}]: 位置信息数据待整理-开始处理,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i++, cnt, id[0], id[1]});
            cnt += mobileLocationMapper.processRecord(id[0], id[1]);
            logger.info("\t序号[{}]: 位置信息数据待整理-处理结束,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i, cnt, id[0], id[1]});

            try {
                Thread.sleep(sleepms);
            } catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
        return cnt;
    }

    private Long processMobileDataUsage(Date beginTime, Date endTime) {
        Map<String, Long> ids = mobileDataUsageMapper.getProcessRecordIds(beginTime, endTime);
        if (ids == null) return 0L;

        Long cnt = 0L;
        List<Long[]> idList = getMinMaxIdSingles(ids.get("minId"), ids.get("maxId"), 2);
        logger.info(
                "流量统计数据待整理-分批处理总记录数:[{}],开始时间:[{}], 结束时间:[{}]",
                new Object[] {idList.size(),
                        DateFormatUtils.format(beginTime, DateFormatUtils.ymd_hms),
                        DateFormatUtils.format(endTime, DateFormatUtils.ymd_hms)});

        int i = 1;
        for (Long[] id : idList) {
            logger.info("\t序号[{}]: 流量统计数据待整理-开始处理,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i++, cnt, id[0], id[1]});
            cnt += mobileDataUsageMapper.processRecord(id[0], id[1]);
            logger.info("\t序号[{}]: 流量统计数据待整理-处理结束,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i, cnt, id[0], id[1]});

            try {
                Thread.sleep(sleepms);
            } catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
        return cnt;
    }

    private Long processAppInstallUsage(Date beginTime, Date endTime) {
        Map<String, Long> ids = mobileAppInstalledMapper.getProcessedRecordIds(beginTime, endTime);
        if (ids == null) return 0L;

        Long cnt = 0L;
        List<Long[]> idList = getMinMaxIdSingles(ids.get("minId"), ids.get("maxId"), 2);
        logger.info(
                "app使用情况-安装app待整理-分批处理总记录数:[{}],开始时间:[{}], 结束时间:[{}]",
                new Object[] {idList.size(),
                        DateFormatUtils.format(beginTime, DateFormatUtils.ymd_hms),
                        DateFormatUtils.format(endTime, DateFormatUtils.ymd_hms)});

        int i = 1;
        for (Long[] id : idList) {
            logger.info("\t序号[{}]: app使用情况-安装app待整理-开始处理,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i++, cnt, id[0], id[1]});
            cnt += mobileAppInstalledMapper.processAppUsageRecord(id[0], id[1]);
            logger.info("\t序号[{}]: app使用情况-安装app待整理-处理结束,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i, cnt, id[0], id[1]});

            try {
                Thread.sleep(sleepms);
            } catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
        return cnt;
    }

    private Long processAppModifyUsage(Date beginTime, Date endTime) {
        Map<String, Long> ids = mobileAppModifyInfoMapper.getProcessedRecordIds(beginTime, endTime);
        if (ids == null) return 0L;

        Long cnt = 0L;
        List<Long[]> idList = getMinMaxIdSingles(ids.get("minId"), ids.get("maxId"), 2);
        logger.info(
                "app使用情况-更新app待整理-分批处理总记录数:[{}],开始时间:[{}], 结束时间:[{}]",
                new Object[] {idList.size(),
                        DateFormatUtils.format(beginTime, DateFormatUtils.ymd_hms),
                        DateFormatUtils.format(endTime, DateFormatUtils.ymd_hms)});

        int i = 1;
        for (Long[] id : idList) {
            logger.info("\t序号[{}]: app使用情况-更新app待整理-开始处理,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i++, cnt, id[0], id[1]});
            cnt += mobileAppModifyInfoMapper.processAppUsageRecord(id[0], id[1]);
            logger.info("\t序号[{}]: app使用情况-更新app待整理-处理结束,当前已处理记录数:[{}], 开始ID:[{}],结束ID:[{}]",
                    new Object[] {i, cnt, id[0], id[1]});

            try {
                Thread.sleep(sleepms);
            } catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
        return cnt;
    }


    /**
     * @Title: getMinMaxIdSingles
     * @Description: 按defaultProcessQtySingle 分组进行处理数据
     * @param minId
     * @param maxId
     * @param times
     * @return
     * @return: List<Long[]> Long[0]:minId, Long[1]:maxId
     */
    private List<Long[]> getMinMaxIdSingles(long minId, long maxId, long times) {
        List<Long[]> result = new ArrayList<Long[]>();
        long curId = minId;
        maxId++;

        while (curId != maxId) {
            long curMaxId = curId + defaultProcessQtySingle * times;

            if (curMaxId > maxId) curMaxId = maxId;

            Long[] curIds = new Long[] {curId, curMaxId};
            result.add(curIds);

            curId = curMaxId;
        }
        return result;
    }

    private Date[] getRecordDates() {
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();

        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
        Date yesterday = calendar.getTime();

        String ymdYesterday = DateFormatUtils.format(yesterday, DateFormatUtils.ymd);
        String ymdToday = DateFormatUtils.format(today, DateFormatUtils.ymd);

        Date beginTime = DateFormatUtils.parse(ymdYesterday + " 00:00:00", DateFormatUtils.ymd_hms);
        Date endTime = DateFormatUtils.parse(ymdToday + " 00:00:00", DateFormatUtils.ymd_hms);

        return new Date[] {beginTime, endTime};
    }

    public void processDeleteOldRecord() {
        Long t1 = System.currentTimeMillis();
        logger.info("begin to delete old records");
        Long cnt = 0L;
        Long totalCnt = 0L;

        cnt = mobileArrivalMapper.deleteOldRecord();
        totalCnt += (cnt == null ? 0L : cnt);
        logger.info("手机到达删除数据记录数:[{}]", cnt);

        cnt = mobileBasicInfoMapper.deleteOldRecord();
        totalCnt += (cnt == null ? 0L : cnt);
        logger.info("设备基础信息删除数据记录数:[{}]", cnt);

        cnt = mobileAppInstalledMapper.deleteOldRecord();
        totalCnt += (cnt == null ? 0L : cnt);
        logger.info("已安装app删除数据记录数:[{}]", cnt);

        cnt = mobileAppModifyInfoMapper.deleteOldRecord();
        totalCnt += (cnt == null ? 0L : cnt);
        logger.info("app更新删除数据记录数:[{}]", cnt);

        cnt = mobileActivatedInfoMapper.deleteOldRecord();
        totalCnt += (cnt == null ? 0L : cnt);
        logger.info("app激活删除数据记录数:[{}]", cnt);

        cnt = mobileDataUsageMapper.deleteOldRecord();
        totalCnt += (cnt == null ? 0L : cnt);
        logger.info("流量统计删除数据记录数:[{}]", cnt);

        cnt = mobileLocationMapper.deleteOldRecord();
        totalCnt += (cnt == null ? 0L : cnt);
        logger.info("手机位置删除数据记录数:[{}]", cnt);

        Long t2 = System.currentTimeMillis();
        logger.info("end to delete old records, 删除总记录数:[{}], 耗时:[{}]毫秒", new Object[] {totalCnt,
                t2 - t1});
    }

    @Override
    public void updateChannel() {
        Long t1 = System.currentTimeMillis();
        logger.info("begin to update channel");
        Long cnt = 0L;
        Long totalCnt = 0L;

        Date[] dates = getRecordDates();
        Date beginTime = dates[0];
        Date endTime = dates[1];

        cnt = mobileArrivalMapper.updateChannel(beginTime, endTime);
        totalCnt += (cnt == null ? 0L : cnt);
        logger.info("手机到达更新数据记录数:[{}]", cnt);

        cnt = mobileBasicInfoMapper.updateChannel(beginTime, endTime);
        totalCnt += (cnt == null ? 0L : cnt);
        logger.info("设备基础信息更新数据记录数:[{}]", cnt);

        cnt = mobileAppInstalledMapper.updateChannel(beginTime, endTime);
        totalCnt += (cnt == null ? 0L : cnt);
        logger.info("已安装app更新数据记录数:[{}]", cnt);

        cnt = mobileAppModifyInfoMapper.updateChannel(beginTime, endTime);
        totalCnt += (cnt == null ? 0L : cnt);
        logger.info("app更新更新数据记录数:[{}]", cnt);

        cnt = mobileActivatedInfoMapper.updateChannel(beginTime, endTime);
        totalCnt += (cnt == null ? 0L : cnt);
        logger.info("app激活更新数据记录数:[{}]", cnt);

        cnt = mobileDataUsageMapper.updateChannel(beginTime, endTime);
        totalCnt += (cnt == null ? 0L : cnt);
        logger.info("流量统计更新数据记录数:[{}]", cnt);

        cnt = mobileLocationMapper.updateChannel(beginTime, endTime);
        totalCnt += (cnt == null ? 0L : cnt);
        logger.info("手机位置更新数据记录数:[{}]", cnt);
        
        cnt = mobileAppModifyInfoMapper.updateAppUsageChannel(beginTime, endTime);
        totalCnt += (cnt == null ? 0L : cnt);
        logger.info("app使用情况-更新app更新数据记录数:[{}]", cnt);

        Long t2 = System.currentTimeMillis();
        logger.info("end to update channel, 更新总记录数:[{}], 耗时:[{}]毫秒", new Object[] {totalCnt,
                t2 - t1});
    }
}
