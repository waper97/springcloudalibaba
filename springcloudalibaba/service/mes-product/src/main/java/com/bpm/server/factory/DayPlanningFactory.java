package com.bpm.server.factory;

import com.bpm.common.dto.DayPlanningDTO;
import com.bpm.common.vo.DayPlanningVO;

import java.util.List;

/**
 * 日计划 工厂模式
 * @author wangpeng
 */
public interface DayPlanningFactory {

    /**
     * 列表
     * @param dayPlanning
     * @return
     */
    List<DayPlanningVO> listDayPlanning(DayPlanningDTO dayPlanning);
}
