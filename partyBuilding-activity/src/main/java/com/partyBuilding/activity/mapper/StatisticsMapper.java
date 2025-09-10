package com.partyBuilding.activity.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface StatisticsMapper {

    List<Map<String,Object>> selectMonthlyTaskCompletion(@Param("studentId") String studentId);

    List<Map<String, Object>> MonthCompleted(LocalDateTime begin, LocalDateTime end);

    Map<String, Integer> selectTaskStatusCountByYearMonth(@Param("year")Integer year, @Param("month")Integer month);


}
